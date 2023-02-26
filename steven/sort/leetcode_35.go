/*
 * LeetCode
 * https://leetcode.com/problems/search-insert-position/
 * Problem Number: 35
 * Level: Easy
 * Algorithm: Sort
 */

/* Pseudocode *
 * 왼쪽 인덱스가 오른쪽 인덱스 보다 작으면 반복문 실행
 * 중간 인덱스의 값이 타겟이라면 중간 인덱스 출력
 * 타겟이 더 크다면 오른쪽 탐색, 반대라면 왼쪽 탐색
 */

package sort

import "fmt"

func SearchInsert(nums []int, target int) int {
	// 가장 왼쪽 인덱스와 오른쪽 인덱스로 초기화
	left, right := 0, len(nums)-1

	// 왼쪽 인덱스가 오른쪽 인덱스와 같거나 커지면 STOP
	for left <= right {
		// 중간 인덱스
		mid := (left + right) / 2

		// 중간 인덱스 값이 타겟과 같으면 해당 인덱스 출력
		if nums[mid] == target {
			fmt.Println(mid)
			return mid
			// 중간 값이 타겟보다 작다면 오른쪽 탐색
		} else if nums[mid] < target {
			left = mid + 1
			// 반대라면 왼쪽 탐색
		} else {
			right = mid - 1
		}
	}
	fmt.Println(left)
	return left
}
