/*
 * LeetCode
 * https://leetcode.com/problems/happy-number/description/
 * Problem Number: 202
 * Level: Easy
 * Algorithm: Math
 */

/* Pseudocode *
 * 현재 값이 1이 아니고 해당 값이 반복되지 않았을 경우 반복문 실행
 * 현재 값 표시를 위해 true로 상태 값을 변경하고 각 값을 제곱해 더하기
 * 더한 값을 현재 값에 재할당하고 반복문 재실행
 * 현재 값이 1이면 true, 중복되면 false 출력
 */

package math

import "fmt"

func IsHappy(n int) bool {
	// 값 중복 확인을 위한 객체
	visited := make(map[int]bool)
	// 현재 값
	cur := n

	// 현재 값이 1이거나 해당 값이 반복될 경우 STOP
	for cur != 1 && !visited[cur] {
		// 현재 값 표시를 위해 true로 상태 값 변경
		visited[cur] = true
		// 배열 생성
		arrNums := getArrNums(cur)
		// 0으로 초기화
		sum := 0
		// 각 값을 제곱해 더하기
		for _, num := range arrNums {
			sum += num * num
		}
		// 현재 값에 재할당
		cur = sum
	}
	// cur == 1이면 true, 아니면 false
	fmt.Println(cur == 1)
	return cur == 1
}

func getArrNums(n int) []int {
	arrNums := []int{}
	for n > 0 {
		num := n % 10
		arrNums = append(arrNums, num)
		n /= 10
	}
	return arrNums
}
