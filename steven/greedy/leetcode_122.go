/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 122
 * Level: Medium
 * Algorithm: Greedy
 */

/* Pseudocode *
 * 오늘과 내일의 가격을 비교
 * 내일의 가격이 더 높으면 결과 값 +
 * 결과 값 출력
 */

package greedy

import (
	"fmt"
)

func MaxProfit(prices []int) int {
	result := 0

	for i := 0; i < len(prices)-1; i++ {
		cur := prices[i]
		next := prices[i+1]

		if cur < next {
			result += next - cur
		}
	}

	fmt.Println(result)
	return result
}
