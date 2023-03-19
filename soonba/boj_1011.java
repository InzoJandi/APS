
import java.util.Scanner;
/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1011
 * Level: Gold V
 * Algorithm: Math
 */

/*
시작점 0을 기준으로

도착점 -> 작동의 최소값
1 -> 1
2 -> 2
3 -> 3
4 -> 3
5 -> 4
6 -> 4
7 -> 5
 ...  쓰다 보면 다음과 같은 규칙을 발견할 수 있다.

 작동의 최소값 = count
 1. 거리 n에 대하여 n이 자연수의 제곱일 때마다 1회 작동 최대값이 증가한다. 그리고 그 때의 count 는 2 * sqrt(n) -1 번이다. ((예) 거리 4의 경우 3번, 거리 9의 경우 5번)
 2. 자연수의 제곱인 n의 바로 다음 수인 n+1은, 최대로 갈 수 있는 거리에서 무조건 count+1이 되는 형태다 ((예) 9의경우 (1,2,3,2,1) -> 10의 경우 (1,2,3,2,1,1))
    -> 따라서 무조건 count 가 1 증가한다.
 3. 자연수의 제곱이 아닌 거리 n은 sqrt(n)의 버림(=n보다 크지 않은 가장 큰 제곱수의 루트, =f)에서 f * (f+1) 을 기점으로 count가 증가한다.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            double x = in.nextDouble();
            double y = in.nextDouble();

            double target = y - x;
            double sqrt = Math.sqrt(target);
            int floor = (int) Math.floor(sqrt);

            //기본적으로 floor * 2 번이 필요
            int count = floor * 2;

            //제곱수라면 -1
            if (target == floor * floor) {
                count--;
            }
            //f * (f+1) 보다 큰 거리라면 +1
            if (target > (floor * (floor + 1))) {
                count++;
            }
            System.out.println(count);
        }
    }
}

