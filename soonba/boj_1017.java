import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1017
 * Level: Gold IV
 * Algorithm: Brute Force
 */

/*
building 의 y 좌표에 해당하는 static 변수 세팅
기준 빌딩[b1, (x1,y1)] 에서 보이는지 판독할 빌딩[b2, (x2,y2)] 좌표에 선을 긋는 방정식 f(x)를 세우고(*)
b1과 b2 사이의 모든 빌딩들[b3, (x3,y3)]에 대해 f(x3) 와 y3를 비교하여 보이는지 여부를 반환.
보이는 빌딩의 개수를 세어 결과를 List 에 담는다. 모든 빌딩에 해당 과정을 수행하여 최대값을 출력한다.

(*) f(x) = (x2-x1)/(y2-y1) * (x-x1) + y1
 */
public class Main {
    static double[] buildings;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String[] B = br.readLine().split(" ");
        buildings = new double[T];
        for (int i = 0; i < T; i++) {
            buildings[i] = Double.parseDouble(B[i]);
        }

        List<Integer> visibleCount = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            //빌딩 하나 선택
            visibleCount.add(countVisible(i, buildings[i]));
        }

        System.out.println(Collections.max(visibleCount));
    }

    private static int countVisible(int x1, double y1) {
        int count = 0;
        for (int x2 = 0; x2 < buildings.length; x2++) {
            //선을 이을 빌딩
            double y2 = buildings[x2];

            //같은 빌딩은 점프
            if (x1 == x2) {
                continue;
            }
            //방정식을 구하고 그 사이에서 걸리는 게 없는지 여부
            if (makeEquationAndIsVisible(x1, x2, y1, y2)) {
                count++;
            }
        }
        return count;
    }
    private static boolean makeEquationAndIsVisible(int x1, int x2, double y1, double y2) {
        double inclination = (y2 - y1) / (x2 - x1);
        //대상 빌딩이 왼쪽에 있는지 오른쪽에 있는지에 따라 분기처리
        return x1 < x2
                ? check(x1 + 1, x2, inclination, y1, x1)
                : check(x2 + 1, x1, inclination, y1, x1);
    }
    private static boolean check(int first, int second, double inclination, double yConstant, int x1) {
        for (int i = first; i < second; i++) {
            double y = inclination * (i - x1) + yConstant;
            if (y <= buildings[i]) {
                return false;
            }
        }
        return true;
    }
}