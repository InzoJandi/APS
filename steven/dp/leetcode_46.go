/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 46
 * Level: Medium
 * Algorithm: Backtracking
 */

/* Pseudocode *
// 49 [0 0]
// 50 [0 0]
// 51 [2 3]
// 49 [0]
// 50 [0]
// 51 [3]
// 52 [[3]]
// [[2 3]]
// 49 [0]
// 50 [2]
// 51 [2]
// 52 [[2]]
// [[2 3] [3 2]]
// 52 [[2 3] [3 2]]
// [[1 2 3]]
// [[1 2 3] [1 3 2]]
// 49 [0 0]
// 50 [1 0]
// 51 [1 3]
// 49 [0]
// 50 [0]
// 51 [3]
// 52 [[3]]
// [[1 3]]
// 49 [0]
// 50 [1]
// 51 [1]
// 52 [[1]]
// [[1 3] [3 1]]
// 52 [[1 3] [3 1]]
// [[1 2 3] [1 3 2] [2 1 3]]
// [[1 2 3] [1 3 2] [2 1 3] [2 3 1]]
// 49 [0 0]
// 50 [1 2]
// 51 [1 2]
// 49 [0]
// 50 [0]
// 51 [2]
// 52 [[2]]
// [[1 2]]
// 49 [0]
// 50 [1]
// 51 [1]
// 52 [[1]]
// [[1 2] [2 1]]
// 52 [[1 2] [2 1]]
// [[1 2 3] [1 3 2] [2 1 3] [2 3 1] [3 1 2]]
// [[1 2 3] [1 3 2] [2 1 3] [2 3 1] [3 1 2] [3 2 1]]
*/

package dp

func Permute(nums []int) [][]int {
	// 길이가 1이라면 그대로 retrun
	if len(nums) == 1 {
		return [][]int{{nums[0]}}
	}

	res := [][]int{}
	for i, num := range nums {
		// 특정 수를 제외한 배열 생성
		remain := make([]int, len(nums)-1)
		copy(remain[:i], nums[:i])
		copy(remain[i:], nums[i+1:])
		// 해당 배열을 재귀
		subperms := Permute(remain)
		// res에 추가
		for _, subperm := range subperms {
			res = append(res, append([]int{num}, subperm...))
		}
	}
	return res
}
