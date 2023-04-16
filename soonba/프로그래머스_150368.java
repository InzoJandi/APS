
/*
 * https://school.programmers.co.kr/learn/courses/30/lessons/150368
 * Problem Number: 150368
 */

/*
변수를 초기화한다.
모든 이모티콘별 모든 할인율을 적용하여 dfs 로 최대 값을 갱신한다.
출력한다.
*/
public class Solution {
    static final int[] DISCOUNT_RATE = {10, 20, 30, 40};
    int[] emoticonArr;
    int[][] userArr;
    int join, sale;

    public int[] solution(int[][] users, int[] emoticons) {
        //변수 초기화
        initVar(users,emoticons);
        dfs(0, new int[emoticons.length]);
        return new int[]{join,sale};
    }

    void dfs(int count, int[] temp) {
        if (count == temp.length) {
            //모든 rate가 세팅된 경우, 계산
            calculate(temp);
            return;
        }
        //아니라면 모든 할인율에 대해 재귀호출
        for (int j : DISCOUNT_RATE) {
            temp[count] = j;
            dfs(count + 1, temp);
        }
    }

    void calculate(int[] discountArr) {
        int nowJoin = 0, nowSale = 0;
        for (int[] user : userArr) {
            //유저별 가격, 유저의 최소 할인율, 유저의 최대 구매 가능 금액 초기화
            int totalSalePerUser = 0, minDiscountRate = user[0], maxPurchaseAmount = user[1];
            //할인정보(discountArr)와 유저 최소 할인율(minDiscountRate)로 이모티콘별 판매금액 갱신
            totalSalePerUser = getTotalSalePerUser(discountArr, totalSalePerUser, minDiscountRate);
            //총 판매액이 최대 구매 가능 금액보다 높은 경우 join 그 외엔 판매금액 갱신
            if (maxPurchaseAmount <= totalSalePerUser) {
                nowJoin++;
            } else {
                nowSale += totalSalePerUser;
            }
        }
        updateValue(nowJoin, nowSale);
    }

    private int getTotalSalePerUser(int[] discountArr, int totalSalePerUser, int minDiscountRate) {
        for (int j = 0; j < discountArr.length; j++) {
            if (discountArr[j] < minDiscountRate) continue;
            totalSalePerUser += (100- discountArr[j]) * emoticonArr[j] / 100;
        }
        return totalSalePerUser;
    }

    private void initVar(int[][] users, int[] emoticons) {
        userArr = users;
        emoticonArr = emoticons;
        join = 0;
        sale = 0;
    }

    private void updateValue(int nowJoin, int nowSale) {
        // 판매전략 우선순위에 따른 값 갱신
        if (nowJoin > join || (nowJoin == join && nowSale > sale)) {
            join = nowJoin;
            sale = nowSale;
        }
    }
}
