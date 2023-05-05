# Algorithm Study

| 기수 |        기간         |
|:--:|:-----------------:|
| 1기 |     ~23/01/02     |
| 2기 | 23/01/16~23/05/03 |

## 일정표

| 주차 |                                    공통 주제 및 문제                                    |
|:--:|:--------------------------------------------------------------------------------:|
| 1  |                                   문자열(String)                                    |
| 2  |                                   탐욕법(Greedy)                                    |
| 3  |                                완전탐색(Brute Force)                                 |
| 4  |                            동적계획법(Dynamic Programming)                            |
| 5  |                                    그래프(Graph)                                    |
| 6  |                                 수학(Mathematics)                                  |
| 7  |                                    스택(Stack)                                     |
| 8  |                                백트래킹(Backtracking)                                |
| 9  |                                투 포인터(Two Pointer)                                |
| 10 |                                시뮬레이션(Simulation)                                 |
| 11 |     [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888)     |
| 12 |   [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341)    |
| 13 |  [이모티콘 할인행사](https://school.programmers.co.kr/learn/courses/30/lessons/150368)   |
| 14 | [택배 배달과 수거하기](https://school.programmers.co.kr/learn/courses/30/lessons/150369)  |
| 15 | [두 큐 합 같게 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/118667) |

## 일정 및 진행 방법

- `문제 공통 주제 선정`: 매주 일요일
    - 각자 공통 주제 1문제, 개인 문제 1문제 풀이(총 2문제)
    - 문제 사이트([백준](https://www.acmicpc.net) / [프로그래머스](https://programmers.co.kr) / [LeetCode](https://leetcode.com))
    - 수도 코드 + 문제 정보 + 풀이 코드를 포함한 파일 작성
- `문제 PR 마감 전`: 매주 일요일 23:59:59
    - 문제를 풀고 해당 주차의 마감 시간 내에 PR 제출
    - 문제 풀이를 완료하지 못 했을 경우에도 과정 등을 포함하여 제출
- `코드 리뷰 마감 전`: 매주 수요일 23:59:59
    - 모든 인원이 각 PR에 대해 간단한 리뷰와 함께 Approve(Merge X)

## 벌금

- 1문제: 1,000원
- 2문제: 3,000원
- 리뷰 불참: 1,000원

## Convention

1. Fork 하지 않고 본인 Github 계정 이름으로 브랜치 생성
2. 문제 풀이 코드 커밋
    - 경로: `./닉네임/`
    - 파일 형식: `{문제플랫폼}_{문제번호 || 이름}` (플랫폼에서 따로 부여하는 문제 번호가 없을 경우에만 문제 이름)
    - 커밋 형식: `solve: N주차_공통` or `solve: N주차_개인`
3. Main 브랜치로 PR
    - 제목 형식: `[{nickname}] N주차 문제 제출`
    - 본인 언어 라벨 추가
4. Merge는 코드 리뷰 마감 시간 이후 일괄 수행

- 코드

```java
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1000
 * Level: Bronze V
 * Algorithm: Implementation
 */

/* Pseudocode *
입력 받은 값을 공백으로 분리
분리된 값을 정수로 변환
더한 값 출력
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" "); // 입력을 받아 공백으로 분리

        // 분리 된 문자열을 정수로 변환
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        System.out.println(a + b);
    }
}
```

- [PR 예시](https://github.com/InzoJandi/APS/pull/2)
