/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 58
 * Level: Easy
 * Algorithm: String
 */

/* Pseudocode *
공백을 제거한 배열 생성
배열 마지막 단어 추출
마지막 단어의 길이 출력
 */

package string

import (
	"fmt"
	"strings"
)

func LengthOfLastWord(s string) int {
	// 공백을 제거한 배열 생성
	arr := strings.Fields(s)
	// 배열 마지막 단어 추출
	lastWord := arr[len(arr)-1]
	// 마지막 단어의 길이 출력
	fmt.Println(len(lastWord))
	return len(lastWord)
}
