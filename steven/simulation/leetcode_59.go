/*
 * LeetCode
 * https://leetcode.com/problems/spiral-matrix-ii/
 * Problem Number: 58
 * Level: Medium
 * Algorithm: Simulation
 */

/* Pseudocode *
 * 코드 참고
 */

package simulation

import "fmt"

func GenerateMatrix(n int) [][]int {
	// n x n 크기의 행렬 생성
	matrix := make([][]int, n)
	for i := 0; i < n; i++ {
		matrix[i] = make([]int, n)
	}

	// 행렬의 경계를 나타내는 변수 초기화
	top, bottom, left, right := 0, n-1, 0, n-1
	// 채울 값의 초기값 설정
	num := 1

	// 시계 방향으로 행렬 채우기
	for top <= bottom && left <= right {
		// 왼쪽에서 오른쪽으로 이동하면서 값을 채움
		for i := left; i <= right; i++ {
			matrix[top][i] = num
			num++
		}
		top++

		// 위에서 아래로 이동하면서 값을 채움
		for i := top; i <= bottom; i++ {
			matrix[i][right] = num
			num++
		}
		right--

		// 오른쪽에서 왼쪽으로 이동하면서 값을 채움
		if top <= bottom {
			for i := right; i >= left; i-- {
				matrix[bottom][i] = num
				num++
			}
			bottom--
		}

		// 아래에서 위로 이동하면서 값을 채움
		if left <= right {
			for i := bottom; i >= top; i-- {
				matrix[i][left] = num
				num++
			}
			left++
		}
	}

	// 완성된 행렬 반환
	fmt.Println(matrix)
	return matrix
}
