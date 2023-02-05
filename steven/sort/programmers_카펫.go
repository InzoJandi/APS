/*
 * Programmers
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842?language=go
 * Problem: 카펫
 * Level: 2
 * Algorithm: Brute Force
 */

/*
 * 세 가지 조건이 중요
 * 1번째 조건: 세로 길이(sum % i)가 정수여야 한다.
 * 2번째 조건: 가로 길이 + 세로 길이가 brown 타일의 갯수 / 2 + 2와 같아야 한다.
 * 3번째 조건: 가로 길이가 세로 길이보다 길거나 같아야 한다.
 */

package sort

import "fmt"

func Solution(brown int, yellow int) []int {
	var res []int

	// 총 타일의 갯수
	sum := brown + yellow

	// i는 가로 길이, sum / i는 세로 길이
	for i := sum; i > 0; i-- {
		if isDivisor(sum, i) && i+sum/i == brown/2+2 && i >= sum/i {
			res = append(res, i)
			res = append(res, sum/i)
		}
	}
	fmt.Println(res)
	return res
}

// 세로 길이가 정수인지 확인
func isDivisor(n int, m int) bool {
	if n%m == 0 {
		return true
	}
	return false
}
