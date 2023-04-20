
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 11050
 * Level: 브론즈 1
 * Algorithm: Math
 */

/*
입력값을 받아 팩토리얼을 계산하고, 조합 공식을 이용해 최종 결과값을 계산한다.
*/
public class Main {
    static final int MAXIMUM_N = 10;
    static final int[] factorialArr = new int[MAXIMUM_N+1];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        int nF = factorial(n);
        int kF = factorial(k);
        int nkF = factorial(n - k);
        System.out.println(combination(nF, kF, nkF));
    }

    private static int combination(int nF, int kF, int nkF) {
        return nF / (kF * nkF);
    }

    private static int factorial(int n) {
        if(factorialArr[n] != 0) return factorialArr[n];
        if(n==0) {
            factorialArr[0] = 1;
            return 1;
        }
        if(n<=2) {
            factorialArr[n] = n;
            return n;
        }
        int temp = 1;
        for (int i = 2; i <= n; i++) {
            temp *= i;
            factorialArr[i] = temp;
        }
        return temp;
    }
}
