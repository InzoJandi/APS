/*
 * LeetCode
 * https://leetcode.com/problems/subsets/
 * Problem Number: 78
 * Level: Medium
 * Algorithm: Array
 */

/* Pseudocode *
1. res []
1. res []
1. res []
2. subsets [[]]
2. subset []
3. res [[]]
4. res [[]]
2. subsets [[] [3]]
2. subset []
3. res [[] [3]]
4. res [[] [3]]
2. subset [3]
3. res [[] [3]]
4. res [[] [3]]
2. subsets [[] [2] [3] [2 3]]
2. subset []
3. res [[] [2] [3] [2 3]]
4. res [[] [2] [3] [2 3]]
2. subset [2]
3. res [[] [2] [3] [2 3]]
4. res [[] [2] [3] [2 3]]
2. subset [3]
3. res [[] [2] [3] [2 3]]
4. res [[] [2] [3] [2 3]]
2. subset [2 3]
3. res [[] [2] [3] [2 3]]
4. res [[] [2] [3] [2 3]]
*/

package dp

func Subsets(nums []int) [][]int {
	if len(nums) == 0 {
		return [][]int{{}}
	}
	res := [][]int{}
	subsets := Subsets(nums[1:])
	for _, subset := range subsets {
		res = append(res, subset)
		res = append(res, append([]int{nums[0]}, subset...))
	}
	return res
}
