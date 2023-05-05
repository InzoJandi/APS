import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;
//https://school.programmers.co.kr/learn/courses/30/lessons/118667
// 각 큐의 합을 구한다.
// 전체 합이 홀수면 -1을 리턴한다.
// 짝수면 2로 나눈 값을 목표(target)으로 설정한다.
// q1, q2, q1 을 붙인 concat 배열을 만든다.
// concat 배열의 인덱스 끝까지 while을 돌며 target보다 현재의 합이 크고 작음에 따라 더해주고 뺴주고를 반복한다.
// 같아지는 경우가 있으면 해당 카운트를 리턴한다.

// <<참고>>
// 1. q1, q2를 concat하는게 아닌 뒤에 q1을 한 번 더 붙인 형태인 q1, a2, q1인 이유
// 1-반례
// q1 = [1,1,1,8,10,9], q2 = [1,1,1,1,1,1]

// 2. sum1,sum2 가 long인 이유
// 2-반례 (TC 19,20 23~27)
// **주의: 언어에 따라 합 계산 과정 중 산술 오버플로우 발생 가능성이 있으므로 long type 고려가 필요합니다.**
public class Solution {

    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        int[] concatArray = Stream.of(queue1, queue2, queue1).flatMapToInt(IntStream::of).toArray();

        long total = sum1 + sum2;
        //홀수라면 -1
        if (isOdd(total)) return -1;
        long target = total / 2;
        int p1 = 0, p2 = queue1.length, counter = 0;

        //p1, p2 두 포인터 중 하나라도 끝까지 갔다면 탈출
        while (p1 < concatArray.length && p2 < concatArray.length) {
            if (sum1 == target) break;
            // 첫번째 큐로만 비교
            // target 보다 크면 왼->오 로 옮김, 작으면 반대. 인덱스 ++
            sum1 = sum1 > target ? sum1 - concatArray[p1++] : sum1 + concatArray[p2++];
            counter++;
        }
        if (sum1 != target) return -1;
        return counter;
    }

    private boolean isOdd(long total) {
        return total % 2 == 1;
    }
}