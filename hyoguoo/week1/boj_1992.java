/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1049
 * Level: Silver IV
 * Algorithm: Greedy
 */

/* Pseudocode *
for 브랜드 갯수
    낱개와 패키지 가격 중 최저 가격으로 갱신

while 부러진 갯수만큼 구매할 때까지
    if 구매해야 할 남은 갯수가 6개 이하면서 낱개로 구매하는게 이득일 경우
        price += 낱개 * 갯수
        count -= 갯수
    else 그 외
        price += 패키지
        count -= 6
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class GuitarStrings {

    static int sixStringMinPrice = Integer.MAX_VALUE;
    static int singleStringMinPrice = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int brokenCount = info[0];
        int brandCount = info[1];

        // 입력을 받으면서 낱개와 패키지의 가장 작은 값의 가격으로 갱신
        for (int i = 0; i < brandCount; i++) {
            int[] prices = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (sixStringMinPrice > prices[0]) sixStringMinPrice = prices[0];
            if (singleStringMinPrice > prices[1]) singleStringMinPrice = prices[1];
        }
        // 패키지의 가격이 낱개의 6배보다 비쌀 경우 전부 낱개로 사는 것이 저렴하므로 패키지 가격을 낱개 6배의 가격으로 갱신
        if (sixStringMinPrice > singleStringMinPrice * 6) sixStringMinPrice = singleStringMinPrice * 6;

        System.out.println(calculatePrice(brokenCount));
    }

    private static int calculatePrice(int brokenCount) {
        int price = 0;

        while (brokenCount > 0) {
            // 구매해야 할 남은 갯수가 6개 이하면서 낱개로 구매하는게 이득일 경우
            if (brokenCount * singleStringMinPrice < sixStringMinPrice) {
                price += brokenCount * singleStringMinPrice;
                brokenCount = 0;
            // 그 외 경우
            } else {
                price += sixStringMinPrice;
                brokenCount -= 6;
            }
        }
        return price;
    }
}