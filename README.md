# Algorithm Study

| 기수  |    기간     |
|:---:|:---------:|
| 1기  | ~23/01/02 | 
| 2기  | 23/01/16~ |

## 일정

- 문제 공통 주제 선정: 매주 화요일
- 문제 PR 마감: 매주 일요일 23:59:59
- 코드리뷰 마감: 매주 수요일 23:59:59

## 진행 목표

- 기업 코딩테스트에서 요구하는 알고리즘 학습
- 다양한 문제 및 풀이 경험

## 진행 방법

- `문제 공통 주제 선정` 후 각자 공통 주제 1문제, 개인 문제 1문제 풀이(총 2문제)
    - 문제 사이트([백준](https://www.acmicpc.net) / [프로그래머스](https://programmers.co.kr) / [LeetCode](https://leetcode.com))
- `수도 코드` + `문제 정보` + `풀이 코드` 업로드
    - 원활한 코드리뷰 및 학습 목적
- `문제 PR 마감 전` 문제를 풀고 해당 주차의 마감 시간 내에 PR 제출
    - 문제 풀이를 완료하지 못 했을 경우에도 과정 등을 포함하여 제출
- `코드 리뷰 마감 전`까지 모든 인원은 각 PR에 대해 간단한 리뷰와 함께 Approve(Merge X)

## 벌금

- 1문제: 1,000원
- 2문제: 3,000원
- 리뷰 불참: 1,000원

## Convention

1. Fork 하지 않고 본인 Github 계정 이름으로 브랜치 생성
2. 문제 풀이 코드 커밋
    - 파일 형식: `{문제플랫폼}_{문제번호 || 이름}` (플랫폼에서 따로 부여하는 번호가 없을 경우에만 문제 이름)
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