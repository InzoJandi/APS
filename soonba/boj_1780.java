import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1780
 * Level: Silver II
 * Algorithm: Divide and Conquer
 */

/*
static 인 3가지 가능한 수(-1,0,1)를 초기화한다.
(3^n x 3^n) 크기의 2차원 배열을 생성한다.
행, 열, 사이즈를 파라미터로 갖는 calculate() 메서드를 초기값으로 실행한다.
calculate() 는 아래와 같은 작업을 수행한다.
사이즈가 1 이거나, 모두 같은 번호라면 해당 행열의 첫번째 수와 일치하는 static 변수에 더해준다.
아니면 9개로 나누어 적절한 보정값을 준 후 재귀호출한다.
결국 사이즈와 시작점 행렬로 분할하여 값을 더해주며 제일 작은단위인 1의 경우 해당 유일값이 static 변수에 더해질 것이다.
 */
public class Main {
    static int minusOne = 0;
    static int zero = 0;
    static int one = 0;

    static int[][] matrix;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        matrix = new int[T][T];
        for (int i = 0; i < T; i++) {
            int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            System.arraycopy(s, 0, matrix[i], 0, T);
        }
        calculate(0, 0, T);

        System.out.println(minusOne);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void calculate(int row, int col, int size) {
        if (isOnePoint(size) || isAllSameNumber(row, col, size)) {
            increase(matrix[row][col]);
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int newSize = size / 3;
                int xWeight = i * newSize;
                int yWeight = j * newSize;
                calculate(row + xWeight, col + yWeight, newSize);
            }
        }
    }

    private static boolean isOnePoint(int size) {
        return size == 1;
    }

    private static void increase(int target) {
        if (target == -1) minusOne++;
        if (target == 0) zero++;
        if (target == 1) one++;
    }

    private static boolean isAllSameNumber(int row, int col, int size) {
        int first = matrix[row][col];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (first != matrix[i + row][j + col]) return false;
            }
        }
        return true;
    }
}
