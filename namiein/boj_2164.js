/*
 *  BAEKJOON ONLINE JUDGE
 *  https://www.acmicpc.net
 *  Problem Number: 2164
 *  Level: Silver IV
 *  Algorithm: 자료 구조, 큐
 */

const N = require('fs')
    .readFileSync(process.platform === 'linux' ? '/dev/stdin' : '../../input.txt')
    .toString()
    .trim()
    .split('\n')
    .map(Number)[0];

/* Pseudocode *
    제일 마지막에 남게 되는 카드 구하기
1.  Linked Node와 Linked List 구현
    1-1. push, pop, shift 등을 사용하면 시간 초과 / 메모리 초과...
2.  메소드 구현
    2-1. append : 새로운 값 추가
    2-2. getHead : 현재 head 가져오기
    2-3. deleteHead : 헤드 삭제
    2-4. size : size
3. 마지막에 남은 카드 출력하기
 */

// doubly linked list
// in order to iterate backward & forward
class ListNode {
    constructor(data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList {
    constructor() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    // head: [0]
    // tail: [length-1]
    append(value) {
        const newNode = new ListNode(value);
        // if head is empty, assign newNode to head
        if (!this.head) {
            this.head = newNode;
        } else {
            newNode.prev = this.tail;
            this.tail.next = newNode;
        }

        this.tail = newNode;
        this.length++;

        return newNode;
    }

    getHead() {
        return this.head.data;
    }

    deleteHead() {
        this.head = this.head.next;
        this.head.prev = null;
        this.length--;
    }

    size() {
        return this.length;
    }
}

const cards = new LinkedList();
Array.from({ length: N }).forEach((_, i) => cards.append(i + 1));

/** 예시
 *  카드 : 1234
 *  1 카드 버리기
 *  2를 제일 아래로 옮기기 -> 342
 */
while (cards.size() > 1) {
    cards.deleteHead();
    cards.append(cards.getHead());
    cards.deleteHead();
}

console.log(cards.getHead());
