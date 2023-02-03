import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1005
 * Level: Gold III
 * Algorithm: Dynamic Programming
 */

/*
입력값 파싱하여 적절한 변수 세팅
 - 모든 건물 번호는 -1 하여 index 와 일치시킨다. (추후 int[] 등에서 유리)
 - 더이상 분기가 없는 번호 DP 초기화 시켜준다.

dfs 와 DP를 혼용하여 초기 시작점부터 DP를 업데이트한다.
 - 한 node 에 연결된 모든 DP 값을 list 에 담고 그 [list 의 최대 값 + 해당 node 의 건설시간] 을 해당 node 의 DP로 할당

결과를 출력한다.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String[] buildingInformation = br.readLine().split(" ");
            int buildingCount = Integer.parseInt(buildingInformation[0]);
            int arrowRuleCount = Integer.parseInt(buildingInformation[1]);

            int[] DP = new int[buildingCount];

            //건설시간 0인경우도 존재하므로 -1로 채움
            Arrays.fill(DP, -1);

            String[] timeStr = br.readLine().split(" ");
            int[] timesArr = new int[timeStr.length];

            Map<Integer, List<Integer>> arrowMap = new HashMap<>();
            for (int j = 0; j < arrowRuleCount; j++) {
                String[] arrowStr = br.readLine().split(" ");
                int startIndex = Integer.parseInt(arrowStr[0])-1;
                int endIndex = Integer.parseInt(arrowStr[1])-1;

                List<Integer> arrows = arrowMap.get(endIndex);
                if(arrows == null) {
                    arrowMap.put(endIndex, new ArrayList<>(List.of(startIndex)));
                } else {
                    arrows.add(startIndex);
                }
            }

            for (int j = 0; j < buildingCount; j++) {
                timesArr[j] = Integer.parseInt(timeStr[j]);
                if(arrowMap.get(j) == null) {
                    DP[j] = timesArr[j];
                }
            }
            int target = Integer.parseInt(br.readLine())-1;
            dp(target,DP,timesArr,arrowMap);
            System.out.println(DP[target]);
        }
    }
    static Integer dp(Integer now, int[] DP,int[] timeArr, Map<Integer, List<Integer>> arrowMap) {
        List<Integer> timeList = new ArrayList<>();
        List<Integer> arrows = arrowMap.get(now);
        if(DP[now] != -1) {
            return DP[now];
        }
        for (Integer arrow : arrows) {
            timeList.add(dp(arrow, DP, timeArr, arrowMap));
        }
        DP[now] = Collections.max(timeList)+ timeArr[now];
        return DP[now];
    }
}