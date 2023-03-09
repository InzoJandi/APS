/*
 * LeetCode
 * https://leetcode.com/problems/implement-stack-using-queues/
 * Problem Number: 225
 * Level: Easy
 * Algorithm: Stack
 */

/* Pseudocode *
 *
 */

package stack

type MyStack struct {
	q1 []int
	q2 []int
}

func Constructor() MyStack {
	return MyStack{
		q1: []int{},
		q2: []int{},
	}
}

func (this *MyStack) Push(x int) {
	// q1에 추가
	this.q1 = append(this.q1, x)
}

func (this *MyStack) Pop() int {
	// 비어 있으면 통과
	if this.Empty() {
		return -1
	}
	// 1보다 길면 q2에 q1 값 복사. 이때, 마지막 인덱스 값은 복사되지 않는다.
	for len(this.q1) > 1 {
		this.q2 = append(this.q2, this.q1[0])
		this.q1 = this.q1[1:]
	}
	// 마지막 인덱스 값은 x에 할당
	x := this.q1[0]
	// q1의 값과 q2의 값을 교체
	this.q1, this.q2 = this.q2, this.q1
	// q2의 값은 초기화
	this.q2 = this.q2[:0]
	return x
}

func (this *MyStack) Top() int {
	// 비어 있으면 통과
	if this.Empty() {
		return -1
	}
	// 1보다 길면 q2에 q1 값 복사. 이때, 마지막 인덱스 값은 복사되지 않는다.
	for len(this.q1) > 1 {
		this.q2 = append(this.q2, this.q1[0])
		this.q1 = this.q1[1:]
	}
	// 마지막 인덱스 값은 x에 할당
	x := this.q1[0]
	// pop과 다르게 삭제되지 않기 때문에 할당한 뒤에 다시 추가
	this.q2 = append(this.q2, x)
	// q1의 값과 q2의 값을 교체
	this.q1, this.q2 = this.q2, this.q1
	// q2의 값은 초기화
	this.q2 = this.q2[:0]
	return x
}

func (this *MyStack) Empty() bool {
	return len(this.q1) == 0
}
