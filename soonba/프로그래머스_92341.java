import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/92341
 * Problem Number: 92341
 */

/*
입력값을 파싱한다.
주차 요금 정보를 초기화한다.
입-출차 시간을 기록할 map, 총 시간 계산을 위한 map 초기화한다.
- 동시성 제어를 위해 구현체로 ConcurrentHashMap 을 사용한다.
records 를 순회하면서 각 map 에 적절한 값을 갱신한다.
순회가 끝나고 아직 나가지 않은 차를 23:59 를 기준으로 출차시킨다.
요금을 계산한다.
정렬하여 출력한다.
*/
public class Solution {

    private static int BASIC_TIME;
    private static int BASIC_FEE;
    private static int UNIT_TIME;
    private static int UNIT_FEE;

    private static final int END_MINUTE = (60 * 24) - 1;
    private static final Map<Integer,Integer> parkingCarTimeMap = new ConcurrentHashMap<>();
    private static final Map<Integer,Integer> parkingTotalMinuteMap = new ConcurrentHashMap<>();


    public int[] solution(int[] fees, String[] records) {
        //주차장 관련 정보 초기화
        initParkingLotInformation(fees);

        for (String record : records) {
            String[] split = record.split(" ");

            // 모든 시간은 분(minute)으로 변환
            int minute = timeConvertToMinute(split[0]);
            int carNumber = Integer.parseInt(split[1]);
            String inAndOut = split[2];

            //입/출차에 따른 메서드 분리
            if (inAndOut.equals("IN")) carIn(carNumber, minute);
            if (inAndOut.equals("OUT")) carOut(carNumber, minute);
        }

        //모두 돌고 나왔을 때, 아직 남은 key는 출차되지 않은 차 -> 23:59 기준으로 출차시킴
        parkingCarTimeMap.keySet().forEach(restCar -> carOut(restCar,END_MINUTE));
        List<Integer> result = new ArrayList<>();
        //값을 계산하고 정렬하여 리스트에 담아 출력
        parkingTotalMinuteMap.keySet().stream().sorted().forEach(car -> result.add(calculateFee(car)));
        return result.stream().mapToInt(i->i).toArray();

    }

    private Integer calculateFee(Integer car) {
        Integer totalMinute = parkingTotalMinuteMap.get(car);
        if(totalMinute <= BASIC_TIME) return BASIC_FEE;
        int overTime = totalMinute - BASIC_TIME;
        int calcFee = (int) Math.ceil((double) overTime / UNIT_TIME) * UNIT_FEE;
        return BASIC_FEE + calcFee;
    }

    private void carIn(Integer carNumber, int minute) {
        parkingCarTimeMap.put(carNumber,minute);
    }

    private void carOut(Integer carNumber, int endMinute) {
        //출차 시키면서 누적 시간 갱신
        Integer startMinute = parkingCarTimeMap.get(carNumber);
        parkingCarTimeMap.remove(carNumber);
        Integer originMinute = parkingTotalMinuteMap.getOrDefault(carNumber, 0);
        parkingTotalMinuteMap.put(carNumber,originMinute + endMinute-startMinute);
    }

    private int timeConvertToMinute(String s) {
        String[] split = s.split(":");
        int hour = Integer.parseInt(split[0]);
        int minute = Integer.parseInt(split[1]);
        return hour * 60 + minute;
    }

    private void initParkingLotInformation(int[] fees) {
        BASIC_TIME = fees[0];
        BASIC_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];
    }

}