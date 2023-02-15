/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 20
 * Level: Easy
 * Algorithm: Stack
 */

/* Pseudocode *
 * 스택 배열의 길이가 0이 아니면서 스택 배열의 마지막이 값이 짝이 맞다면 배열의 마지막 값 제거
 * 그 외의 경우에는 스택 배열에 삽입
 * 최종적으로 스택 배열의 길이가 0이라면 true, 아니라면 false 출력
 */

package stack

import "fmt"

func IsValid(s string) bool {
	// 괄호 객체 생성
	bracketMap := map[string]string{
		")": "(",
		"]": "[",
		"}": "{",
	}

	// 스택 배열 선언
	var stack []string

	// for문 진행 
	for _, n := range s {
		// 아스키 코드 형태 -> string 형태로 변경
		str := string(n)

		// 스택 배열의 길이가 0이 아니면서 스택 배열의 마지막이 값이 짝이 맞다면 배열의 마지막 값 제거
		if len(stack) != 0 && bracketMap[str] == stack[len(stack)-1] {
			stack = stack[:len(stack)-1]
		// 그 외의 경우에는 스택 배열에 삽입
		} else {
			stack = append(stack, str)
		}
	}

	// 최종적으로 스택 배열의 길이가 0이라면 true, 아니라면 false 출력
	if len(stack) == 0 {
		fmt.Println(true)
		return true
	}
	fmt.Println(false)
	return false
}
