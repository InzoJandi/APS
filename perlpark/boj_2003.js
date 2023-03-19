/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 2003
 * Level: Silver IV
 * Algorithm: Bruteforcing / Two-pointer
 */

/* Pseudocode *
start = 0, end = 0에서 시작
처음에 arr[start]를 sum에 저장

반복문에서 sum이 N보다 작으면 end를 증가, arr[end]를 sum에 합산
sum이 N과 같으면 count를 증가,
sum이 N보다 크거나 같으면 start를 증가, sum을 arr.slice(start, end+1)의 합산으로 변경
*/

{
    const [_, N, ...numbers] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\s/).map(Number);
  
    let start = 0;
    let end = 0;
  
    let sum = numbers[start];
    let count = 0;
  
    while (true) {
      if (sum === N) {
        count += 1;
      }
  
      if (sum >= N) {
        start += 1;
        if (!numbers[start]) break;
  
        sum = numbers.slice(start, end + 1).reduce((p, c) => p + c, 0);
      } else {
        end += 1;
        if (!numbers[end]) break;
  
        sum += numbers[end];
      }
    }
  
    console.log(count);
  }
  
  {
    const [_, N, ...numbers] = `${require('fs').readFileSync('/dev/stdin')}`.trim().split(/\s/).map(Number);
  
    let start = 0;
    let end = 0;
  
    let sum = numbers[start];
    let count = 0;
  
    do {
      sum = numbers.slice(start, end + 1).reduce((p, c) => p + c, 0);
  
      if (sum === N) {
        count += 1;
      }
      if (sum >= N) {
        start += 1;
      } else {
        end += 1;
      }
    } while (numbers[start] && numbers[end]);
  
    console.log(count);
  }
  