/*
 * LeetCode
 * https://leetcode.com/problems/count-and-say/
 * Problem Number: 38
 * Level: Medium
 * Algorithm: String
 */

/* Pseudocode *
1
11 (1이 1개)
21 (1이 2개)
1211 (2가 1개, 1이 1개)
111221 (1이 1개, 2가 1개, 1이 2개)

n이 1인 경우 문자열 "1"을 반환
n이 1이 아닌 경우, 이전 항의 값을 구하기 위해 countAndSay(n - 1)을 호출
이전 항을 읽어가며 개수와 해당 숫자를 세어 이어붙여 반환

prev[i] != prev[i-1] 조건은 현재 숫자와 이전 숫자가 다른 경우
이 경우에는 이전 숫자의 개수와 숫자 자체를 결과 문자열에 추가하고, 개수를 1로 초기화
else는 현재 숫자와 이전 숫자가 같은 경우, 이 경우 개수를 증가
반복문이 끝나면, 마지막 숫자의 개수와 숫자 자체를 결과 문자열에 추가
*/

package string

import (
	"fmt"
	"strconv"
	"strings"
)

func CountAndSay(n int) string {
	if n == 1 {
		return "1"
	}
	prev := CountAndSay(n - 1)
	var result strings.Builder
	count := 1
	for i := 1; i < len(prev); i++ {
		if prev[i] != prev[i-1] {
			result.WriteString(strconv.Itoa(count))
			result.WriteByte(prev[i-1])
			count = 1
		} else {
			count++
		}
	}
	result.WriteString(strconv.Itoa(count))
	result.WriteByte(prev[len(prev)-1])
	fmt.Println(result.String())
	return result.String()
}
