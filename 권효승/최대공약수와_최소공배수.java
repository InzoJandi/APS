import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GcdAndLcm {
    private static int gcd;
    private static int lcm;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] numberArray = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sortArray(numberArray);
        getGcdAndLcm(numberArray[0], numberArray[1]);
        printResult();
    }

    public static void sortArray(int[] numberArray) {
        Arrays.sort(numberArray);
    }

    public static void printResult() {
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int getGcdAndLcm(int x, int y) {
        getGcd(x, y);
        return lcm = x * y / gcd;
    }

    public static int getGcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return gcd = x;
    }
}
