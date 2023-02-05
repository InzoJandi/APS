/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: https://leetcode.com/problems/reverse-integer/
 * Level: Medium
 * Algorithm: Math
 */

/* Pseudocode *
 * 양수인지 음수인지 확인한다. 양수면 "p", 음수면 "n"으로 표시
 * for문을 활용해 x를 뒤집는다.
 * 음수라면 결과값에 -1를 곱해준다.
 * 범위가 -2 ** 31 <= x <= 2 ** 31 - 1이기 때문에 추가적인 예외 처리를 해준다.
 */

package math

import (
	"fmt"
	"math"
)

func Reverse(x int) int {
	var res int
	sign := "p"

	if x < 0 {
		sign = "n"
	}

	x = int(math.Abs(float64(x)))

	for x > 0 {
		res *= 10
		remain := x % 10
		res += remain
		x /= 10
	}

	if sign == "n" {
		res = res * -1
	}

	if math.Pow(float64(2), float64(31))-1 < float64(res) || math.Pow(float64(2), float64(31))*-1 > float64(res) {
		fmt.Println(0)
		return 0
	}

	fmt.Println(res)
	return res
}
