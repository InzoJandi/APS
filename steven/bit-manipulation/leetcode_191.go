/*
 * LeetCode
 * https://leetcode.com/problems/number-of-1-bits/
 * Problem Number: 191
 * Level: Easy
 * Algorithm: Divide and Conquer / Bit Manipulation
 */

/* Pseudocode *
 * 가장 오른쪽 비트 추출 후 1인지 확인
 * 오른쪽으로 1비트씩 이동
 */

package bitmanipulation

import "fmt"

func HammingWeight(num uint32) int {
	count := 0
	for num > 0 {
		// 가장 오른쪽 비트 추출 후 1인지 확인
		// &는 이진 표현에서 가장 오른쪽 비트를 추출하는 비트 연산
		if num&1 == 1 {
			count++
		}
		// 오른쪽으로 1비트씩 이동
		// ex) 128 -> 64 -> 32 -> 16
		num >>= 1
	}
	fmt.Println(count)
	return count
}
