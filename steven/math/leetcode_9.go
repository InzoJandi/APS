/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 9
 * Level: Easy
 * Algorithm: Math
 */

/* Pseudocode *
 * x를 10으로 나누고 나머지를 구한다.
 * 현재 값 sum에 10을 곱하고 위에서 구한 나머지를 더한다.
 * x를 10으로 나누어 x가 0보다 작아질 때까지 반복문을 실행한다.
 */

package math

import "fmt"

func IsPalindrome(x int) bool {
	sum := 0
	compare := x

	for x > 0 {
		r := x % 10
		sum = sum*10 + r
		x /= 10
	}

	fmt.Println(sum == compare)
	return sum == compare
}
