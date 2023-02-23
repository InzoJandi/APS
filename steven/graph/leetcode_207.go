/*
 * LeetCode
 * https://leetcode.com
 * Problem Number: 207
 * Level: Easy
 * Algorithm: Graph
 */

/* Pseudocode *
 * node가 서로 연결되어 있다면 각 노드의 값 ++
 * 가장 연결이 많이 되어 있는 node 출력
 */

package graph

import "fmt"

func FindCenter(edges [][]int) int {
	// Map 생성
	degrees := make(map[int]int)
	// node가 서로 연결되어 있다면 각 노드의 값 ++
	for _, edge := range edges {
		for _, node := range edge {
			degrees[node]++
		}
	}

	// 가장 연결이 많이 되어 있는 node 출력
	maxDegree := 0
	center := 0
	for node, degree := range degrees {
		if degree > maxDegree {
			maxDegree = degree
			center = node
		}
	}

	fmt.Println(center)
	return center
}
