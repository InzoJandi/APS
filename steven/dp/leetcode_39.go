/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 39
 * Level: Medium
 * Algorithm: Backtracking
 */

/* Pseudocode *
 * 재귀 함수 생성 
 * - Base Case: target을 candidates의 각 요소 값으로 뺀 수가 0으로 맞아 떨어진다면 결과 값에 추가.
 * - Recursive Case: 뺐을 때 0보다 작아진다면 continue. 재귀 함수를 호출한 뒤에 유효하지 않다면 되돌리기.
 */

package dp

import "fmt"

func CombinationSum(candidates []int, target int) [][]int {
	var res [][]int

	// 재귀 함수
	var backtrack func([]int, int, int)
	backtrack = func(comb []int, start, remain int) {
		if remain == 0 {
			// Base Case, 유효하다면 배열에 추가
			tmp := make([]int, len(comb))
            copy(tmp, comb)
            res = append(res, tmp)
			return
		}
		for i := start; i < len(candidates); i++ {
			// Recursive Case
			// 뺐을 때 0보다 작아진다면
			if candidates[i] > remain {
				continue
			}

			// 배열에 포함
			comb = append(comb, candidates[i])
			// 재귀 함수 호출
			backtrack(comb, i, remain-candidates[i])
			// 유효하지 않다면 추가된 값 되돌리기
			comb = comb[:len(comb)-1]
		}
	}

	// 재귀 함수 호출
	backtrack([]int{}, 0, target)

	fmt.Println(res)
	return res
}
