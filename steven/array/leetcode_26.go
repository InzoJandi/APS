/*
 * LeetCode
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 * Problem Number: 26
 * Level: Easy
 * Algorithm: Array
 */

/* Pseudocode *
 * num의 0번째 값을 가진 상태로 배열을 생성하고 flag를 0으로 할당
 * for문을 돌면서 값이 일치하면 continue, 일치하지 않으면 배열에 추가한 뒤 flag 값에 +1을 한다.
 */

package array

import "fmt"

func RemoveDuplicates(nums []int) int {
	// num의 0번째 값을 가진 상태로 배열 생성
	expectedNums := []int{nums[0]}
	flag := 0

	for i := 1; i < len(nums); i++ {
		// 값이 일치하면 continue
		if expectedNums[flag] == nums[i] {
			continue
		// 일치하지 않으면 배열에 추가 및 flag + 1
		} else {
			expectedNums = append(expectedNums, nums[i])
			flag++
		}
	}

	fmt.Println(len(expectedNums))
	return len(expectedNums)
}
