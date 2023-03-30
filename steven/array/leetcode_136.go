/*
 * LeetCode
 * https://leetcode.com/problems/single-number/
 * Problem Number: 136
 * Level: Easy
 * Algorithm: Array
 */

/* Pseudocode *
 * XOR(배타적 논리합) 연산을 사용. 두 개의 비트를 XOR하면, 
 * 두 비트 중 하나만 1일 경우에만 결과가 1. 
 * 어떤 수와 자기 자신을 XOR하면 결과는 0. 
 * 배열의 모든 숫자를 XOR하면, 한 번만 나타나는 수가 결과 출력
 */


package array

import "fmt"

func SingleNumber(nums []int) int {
	result := 0
	for _, num := range nums {
		result ^= num
	}
	fmt.Println(result)
	return result
}
