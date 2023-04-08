import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11650
 * Level: 실버 V
 * Algorithm: Sorting
 */

/*
입력값을 받아 Arrays.sort() 에 두번째 인자로 Comparator를 익명클래스로 구현해주어 리턴한다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] coordinateArr = new int[T][2];

        for (int i = 0; i < T; i++) {
            String[] S = br.readLine().split(" ");
            coordinateArr[i][0] = Integer.parseInt(S[0]);
            coordinateArr[i][1] = Integer.parseInt(S[1]);
        }

        Arrays.sort(coordinateArr, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        StringBuilder sb = new StringBuilder();
        Arrays.stream(coordinateArr).forEach(i-> sb.append(i[0]).append(" ").append(i[1]).append("\n"));
        System.out.println(sb);

    }
}
