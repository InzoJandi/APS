import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1182
 * Level: Silver 2
 * Algorithm: Back tracking
 */

/*
수열을 배열로 초기화한다.
'수를 더하거나' '안 더하거나' 의 경우의 수로 n에 대해 모든 부분집합 2^n 의 경우의수를 계산한다.
5 0
-7 -3 -2 5 8

예제의 경우 아래와 같이 나눠진다.
               0                    0
        -7           0             -7
   -10     -7     -3    0          -3
 -12 -10 -9 -7  -5 -3  -2 0        -2
 ...
 */

public class Main {
    static int T;
    static int target;
    static int total = 0;

    static int[] sequenceNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        T = Integer.parseInt(S[0]);
        target = Integer.parseInt(S[1]);
        sequenceNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        dfs(0,0);

        int result = target == 0 ? total-1 : total;
        System.out.println(result);
    }

    static void dfs(int count, int temp) {
        if(count == T) {
            if(temp == target) total++;
            return;
        }
        dfs(count+1, temp+sequenceNum[count]);
        dfs(count+1, temp);

    }
}
