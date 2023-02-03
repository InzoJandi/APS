/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 18258
 * Level: Silver IV
 * Algorithm: Queue
 */

/* Pseudocode *
js 내장 함수로만 구현했을 때에는 당연하게도 시간초과되어, class로 Queue를 구현하여 풀었다.
입력값을 저장하는 storage, 시작점인 start, 끝점인 end를 사용해 주어진 command에 따라 적절히 변경하여 결과값을 출력한다.
  1. size: storage에 end 인덱스의 값이 존재하지 않을 경우 0, 이외의 경우에는 end - start + 1을 반환한다.
  2. push: size가 0일 경우 0번에 값을 넣어주고, 이외의 경우에는 end에 1을 더해준 후 storage의 end번에 값을 넣어준다.
  3. pop: size가 0일 경우 -1을, 이외의 경우에는 storage의 start 인덱스의 값을 storage에서 삭제 후 반환한다. 
          이 때, start와 end의 값이 같다면 pop 한 후 storage가 비기 때문에 각각을 초기화해준다.
          이외의 경우에는 start에 1을 더해준다.
  4. empty: size가 0일 경우 1을, 이외의 경우에는 0을 반환한다.
  5. front: size가 0일 경우 -1을, 이외의 경우에는 storage의 start 인덱스의 값을 반환한다.
  6. back: size가 0일 경우 -1을, 이외의 경우에는 storage의 end 인덱스의 값을 반환한다.
total만큼 반복하며 switch문을 실행하여 반환된 값들을 배열 answer에 push한다.
반복문이 끝난 후, 배열 answer을 join하여 출력한다.
*/

const [total, ...input] = require("fs")
  .readFileSync(process.platform === "linux" ? "/dev/stdin" : "example.txt")
  .toString()
  .trim()
  .split("\n");

class Queue {
  constructor() {
    this.storage = {};
    this.start = 0;
    this.end = 0;
  }

  size() {
    if (this.storage[this.end] === undefined) {
      return 0;
    } else {
      return this.end - this.start + 1;
    }
  }

  push(item) {
    if (this.size() === 0) {
      this.storage["0"] = item;
    } else {
      this.end += 1;
      this.storage[this.end] = item;
    }
  }

  pop() {
    if (this.size() === 0) {
      return -1;
    } else {
      const number = this.storage[this.start];
      delete this.storage[this.start];
      if (this.start === this.end) {
        this.start = 0;
        this.end = 0;
      } else {
        this.start += 1;
      }
      return number;
    }
  }

  empty() {
    if (this.size() === 0) return 1;
    else return 0;
  }

  front() {
    if (this.size() === 0) return -1;
    else return this.storage[this.start];
  }

  back() {
    if (this.size() === 0) return -1;
    else return this.storage[this.end];
  }

  print() {
    return this.storage;
  }
}

const queue = new Queue();
const answer = [];

for (let i = 0; i < total; i++) {
  const [command, number] = input[i].split(" ");
  switch (command) {
    case "push":
      queue.push(number);
      break;

    case "pop":
      answer.push(queue.pop());
      break;

    case "size":
      answer.push(queue.size());
      break;

    case "empty":
      answer.push(queue.empty());
      break;

    case "front":
      answer.push(queue.front());
      break;

    case "back":
      answer.push(queue.back());
      break;
  }
}

console.log(answer.join("\n"));
