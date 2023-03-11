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
모든 크기에 대해 모든 수열의 경우의 수를 dfs로 다 더하여 목표값과 같다면 count를 더해준다.
 */

public class Main {
    static int target;
    static int total = 0;

    static int[] sequenceNum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] S = br.readLine().split(" ");
        int T = Integer.parseInt(S[0]);
        target = Integer.parseInt(S[1]);
        sequenceNum = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 1; i <= T; i++) {
            dfs(0,i,0,0);
        }

        System.out.println(total);
    }

    static void dfs(int count, int sequenceSize, int temp, int nowIdx) {
        if(count == sequenceSize) {
            if(temp == target) {
                total++;
            }
            return;
        }

        for (int i = nowIdx; i < sequenceNum.length; i++) {
            dfs(count + 1, sequenceSize, temp + sequenceNum[i],i+1);
        }
    }
}
