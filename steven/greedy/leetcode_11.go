/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 11
 * Level: Medium
 * Algorithm: Greedy
 */

 /* Pseudocode *
max, left, right 선언
left가 right보다 작을 경우 for문 진행
가로 * 세로 값 계산. 
계산 결과와 max 값을 비교 한 다음 계산 결과가 max 보다 크면 재할당
left 값과 rigth 값을 비교한 뒤
left 값이 더 크면 right를 왼쪽으로 한칸
right 값이 더 크면 left를 오른쪽으로 한칸
 */

package greedy

import "fmt"

func MaxArea(height []int) int {
	max := 0
	left, right := 0, len(height)-1

	// left가 right보다 작을 경우 for문 진행
	for left < right {
		// res = 가로 * 세로; res와 max 비교 후 res가 max 보다 크면 재할당
		if res := (right - left) * min(height[left], height[right]); res > max {
			max = res
		}

		// left 값과 rigth 값을 비교한 뒤
		// left 값이 더 크면 right를 왼쪽으로 한칸
		// right 값이 더 크면 left를 오른쪽으로 한칸
		if height[left] > height[right] {
			right--
		} else {
			left++
		}
	}
	fmt.Println(max)
	return max
}

// 값을 비교한 다음 더 작은 수 출력
func min(a, b int) int {
	if a < b {
		return a
	}
	return b
}
