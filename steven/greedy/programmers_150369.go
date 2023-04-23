/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 150369
 * Level: 2
 * Algorithm: Greedy / Implementation
 */

/* Pseudocode *
 * 가장 먼 곳부터 탐색한다. 
 * 배달하거나 수거할 것이 있는지 확인한 뒤에 있다면 이동하고
 * 연산의 결과가 0 또는 0보다 작다면 추가적인 배달 또는 수거가 가능하다는 의미이므로 이동이 필요하지 않다.
 * 거리는 왕복이기 때문에 * 2를 해서 더해준다.
 */

package greedy

func solution(cap int, n int, deliveries []int, pickups []int) int64 {
	var answer int64
	deliveryBoxes := 0
	pickupBoxes := 0

	// 가장 먼 곳부터 탐색
	for i := n - 1; i >= 0; i-- {
		// 배달하거나 수거할 것이 있는지 확인
		deliveryBoxes += deliveries[i]
		pickupBoxes += pickups[i]

		// 있다면 이동
		for deliveryBoxes > 0 || pickupBoxes > 0 {
			// 연산의 결과가 0 또는 0보다 작다면 추가적으로 배달 또는 수거가 가능하다는 의미
			deliveryBoxes -= cap
			pickupBoxes -= cap
			// 왕복이기 때문에 * 2
			answer += (int64(i) + 1) * 2
		}
	}
	// 출력
	return answer
}
