/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 150369
 * Level: 2
 * Algorithm: Greedy / Implementation
 */

/* Pseudocode *
for n - 1 to 0
    if 현재 배달/수거가 가능한지 확인, 불가능한 경우 가용량 및 거리 업데이트
        거리 업데이트
        가능한 배달량과 수거량을 업데이트
    배달/수거(
 */


public class CourierDeliveryAndCollection {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long distance = 0;
        int availablePickup = 0;
        int availableDelivery = 0;

        // 최소로 움직이기 위해 제일 끝에 있는 집을 최우선으로 배달/수거
        for (int i = n - 1; i >= 0; i--) {
            if (deliveries[i] > availableDelivery || pickups[i] > availablePickup) { // 배달/수거가 가능한지 확인, 불가능한 경우 가용량 및 거리 업데이트
                // 필요한 픽업/배달 횟수를 계산(배달 / 수거 중 더 많은 횟수를 필요로 함)
                double countOfPoint = getCountOfPoint(cap, Math.max(deliveries[i] - availableDelivery, pickups[i] - availablePickup));
                distance += getDistance(i, (long) countOfPoint); // 거리 계산
                // 가능한 배달량과 수거량을 업데이트
                availableDelivery += cap * countOfPoint;
                availablePickup += cap * countOfPoint;
            }
            // 배달/수거, 위에서 available을 업데이트 했으므로 음수가 되는 경우는 없음
            availableDelivery -= deliveries[i];
            availablePickup -= pickups[i];
        }

        return distance;
    }
    private double getCountOfPoint(int cap, double need) {
        return Math.ceil(need / cap);
    }

    private static long getDistance(int i, long countOfPoint) {
        return countOfPoint * (i + 1) * 2;
    }
}
