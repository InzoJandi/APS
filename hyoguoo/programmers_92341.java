/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 42888
 * Level: 2
 * Algorithm: Implementation
 */

/* Pseudocode *
Map 자료구조를 두 개 사용하여 각 차량별 최근 주차 시간과 누적 주차 시간을 저장
주차장에 남아있는 경우(주차 Map에 아직 남아있는 경우) 23:59 분으로 강제로 출차 시간을 설정
누적 주차 시간에 따라 요금 계산
 */

import java.util.*;

public class ParkingFeeCalculation {

    final static String IN = "IN";
    final static String OUT = "OUT";
    final static int END_OF_DAY = 60 * 23 + 59;
    static int BASE_TIME, BASE_FEE, UNIT_TIME, UNIT_FEE;

    public int[] solution(int[] fees, String[] records) {
        init(fees);
        Map<String, Integer> cumulativeMinuteMap = getCumulativeMinuteMap(records); // 각 차량별 주차 시간 계산
        List<ParkingCar> answerList = calculateFeeEachCar(cumulativeMinuteMap); // 각 차량별 주차 요금 계산

        return getAnswer(answerList);
    }

    private Map<String, Integer> getCumulativeMinuteMap(String[] records) {
        Map<String, Integer> parkingRecordMap = new HashMap<>(); // 주차장에 들어온 차량의 입차 시간 기록
        Map<String, Integer> cumulativeMinuteMap = new HashMap<>(); // 각 차량별 주차 시간 기록

        for (String record : records) {
            String[] recordArray = record.split(" ");
            int minute = getMinute(recordArray[0]);
            String carNumber = recordArray[1];
            String action = recordArray[2];

            if (action.equals(IN)) {
                parkingRecordMap.put(carNumber, minute); // 주차장에 들어온 차량의 입차 시간 기록
            } else if (action.equals(OUT)) {
                int inMinute = parkingRecordMap.get(carNumber); // 주차장에 들어온 차량의 입차 시간 기록
                parkingRecordMap.remove(carNumber); // 주차장에 들어온 차량의 입차 시간 기록 삭제
                int cumulativeMinute = cumulativeMinuteMap.getOrDefault(carNumber, 0);
                int parkingTime = minute - inMinute;
                cumulativeMinuteMap.put(carNumber, cumulativeMinute + parkingTime); // 주차 시간 누적시킨 후 저장
            }
        }
        // 주차장에 남아있는 차량의 경우, 23:59에 주차장을 나간 것으로 간주
        for (String carNumber : parkingRecordMap.keySet()) {
            int inMinute = parkingRecordMap.get(carNumber);
            int cumulativeMinute = cumulativeMinuteMap.getOrDefault(carNumber, 0);
            int parkingTime = END_OF_DAY - inMinute;
            cumulativeMinuteMap.put(carNumber, cumulativeMinute + parkingTime);
        }

        return cumulativeMinuteMap;
    }


    private int getMinute(String timeString) {
        String[] timeStringArray = timeString.split(":");
        int hour = Integer.parseInt(timeStringArray[0]);
        int minute = Integer.parseInt(timeStringArray[1]);

        return hour * 60 + minute;
    }

    private List<ParkingCar> calculateFeeEachCar(Map<String, Integer> cumulativeMinuteMap) {
        List<ParkingCar> answerList = new ArrayList<>();
        for (String carNumber : cumulativeMinuteMap.keySet()) {
            answerList.add(new ParkingCar(carNumber, calculateFee(cumulativeMinuteMap.get(carNumber))));
        }
        return answerList;
    }

    private int calculateFee(int minute) {
        // 1. 기본 시간 이내인 경우
        if (minute <= BASE_TIME) return BASE_FEE;
        // 2. 기본 시간 이후인 경우
        return BASE_FEE + (int) Math.ceil(((double) minute - (double) BASE_TIME) / (double) UNIT_TIME) * UNIT_FEE;
    }

    private static int[] getAnswer(List<ParkingCar> answerList) {
        Collections.sort(answerList);
        return answerList.stream().mapToInt(ParkingCar::getFee).toArray();
    }

    private void init(int[] fees) {
        BASE_TIME = fees[0];
        BASE_FEE = fees[1];
        UNIT_TIME = fees[2];
        UNIT_FEE = fees[3];
    }

    static class ParkingCar implements Comparable<ParkingCar> {
        String carNumber;
        int fee;

        public ParkingCar(String carNumber, int fee) {
            this.carNumber = carNumber;
            this.fee = fee;
        }


        public int getFee() {
            return fee;
        }

        // 차량 번호 오름차순 정렬
        @Override
        public int compareTo(ParkingCar other) {
            return this.carNumber.compareTo(other.carNumber);
        }
    }
}