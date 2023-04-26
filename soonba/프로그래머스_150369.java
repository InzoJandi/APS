
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150369
 * Problem Number: 150369
 */

/*
key point >> 최소로 움직이려면, 제일 끝에서부터 배송과 회수를 해야함
delivery, pickup 변수는 각 집에 배송, 회수하고 남은 양을 저장(다음 집에서 사용)
각 집을 for 문으로 끝에서부터 순회하며, delivery 와 pickup 변수가 해당 집의 배송과 회수 각각보다 클 때까지 cap을 더한다.
해당 집에 필요한 방문은 끝났으므로 해당 집의 delivery 와 pickup 을 빼고 다음 집 순회
결과를 출력한다.
*/
public class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {

        int delivery = 0, pickup = 0;
        long moveCount = 0;
        for (int i = n-1; i > -1 ; i--) {
            int cnt = 0;
            while(deliveries[i] > delivery || pickups[i] > pickup) {
                delivery += cap;
                pickup += cap;
                cnt++;
            }
            moveCount += 2L * cnt * (i+1);
            delivery -= deliveries[i];
            pickup -= pickups[i];
        }

        return moveCount;
    }
}


