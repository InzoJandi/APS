/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 997
 * Level: Easy
 * Algorithm: Graph
 */

/* Pseudocode *
 * 다른 누군가를 믿는 사람들을 담은 배열과 특정 누군가를 믿는 사람들의 수를 담은 배열을 생성한다.
 * 다른 누구도 믿지 않으면서 모두가 믿는 사람이 있다면 그 사람을 출력하고
 * 그렇지 않다면 -1을 출력한다.
 */

package graph

import "fmt"

func FindJudge(n int, trust [][]int) int {
	// 배열 생성
	trusts := make([]int, n+1)
	trustCounts := make([]int, n+1)

	for _, rel := range trust {
		// 다른 누군가를 믿는 사람들을 담은 배열
		trusts[rel[0]]++
		// 특정 누군가를 믿는 사람들의 수를 담은 배열
		trustCounts[rel[1]]++
	}

	for i := 1; i < n+1; i++ {
		// 어떤 누구도 믿지 않으면서 모두가 믿는 사람이 있다면 그 사람을 출력
		if trusts[i] == 0 && trustCounts[i] == n-1 {
			fmt.Println(i)
			return i
		}
	}
	fmt.Println(-1)
	return -1
}
