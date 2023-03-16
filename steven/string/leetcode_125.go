/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 125
 * Level: Easy
 * Algorithm: String
 */

/* Pseudocode *
 * 문자열을 정제한 다음 Palindrome인지 확인
 */

package string

import (
	"fmt"
	"unicode"
)

func IsPalindrome(s string) bool {
	// 문자열 정제
	var cleanString string
	for _, c := range s {
		if unicode.IsLetter(c) || unicode.IsDigit(c) {
			cleanString += string(unicode.ToLower(c))
		}
	}

	// Palindrome인지 확인
	for i := 0; i < len(cleanString)/2; i++ {
		// 아니라면 false 출력
		if cleanString[i] != cleanString[len(cleanString)-i-1] {
			fmt.Println(false)
			return false
		}
	}

	// 맞다면 true 출력
	fmt.Println(true)
	return true
}
