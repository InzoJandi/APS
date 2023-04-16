/*
 * PROGRAMMERS SCHOOL
 * https://school.programmers.co.kr
 * Problem Number: 150368
 * Level: 2
 * Algorithm: Implementation
 */

/* Pseudocode *
모든 경우의 수를 탐색하여 최대값을 찾음
 */

import java.util.*;

public class EmoticonDiscountEvent {

    static final int[] RATE_LIST = {10, 20, 30, 40};
    static final int SIZE = RATE_LIST.length;
    static int maxUser = 0;
    static int maxAcc = 0;

    public int[] solution(int[][] users, int[] emoticons) {
        maxUser = 0;
        maxAcc = 0;
        dfs(new int[emoticons.length], 0, emoticons.length, users, emoticons);

        return new int[]{maxUser, maxAcc};
    }


    public void dfs(int[] selectedEmoDis, int n, int selectedEmoDisSize, int[][] users, int[] emoticons) {
        if (n == selectedEmoDisSize) {
            int totalUser = 0;
            int totalAcc = 0;

            for (int[] user : users) {
                int userDiscount = user[0];
                int userLimit = user[1];

                int amount = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    int selectedEmoDiscount = selectedEmoDis[j];
                    if (selectedEmoDiscount >= userDiscount) {
                        amount += getAmount(selectedEmoDiscount, emoticons[j]);
                    }
                }
                if (amount >= userLimit) totalUser++;
                else totalAcc += amount;
            }

            updateMax(totalUser, totalAcc);
            return;
        }
        for (int i = 0; i < SIZE; i++) {
            selectedEmoDis[n] = RATE_LIST[i];
            dfs(selectedEmoDis, n + 1, selectedEmoDisSize, users, emoticons);
        }
    }

    private static double getAmount(int selectedEmoDiscount, int emoticons) {
        return emoticons * (1 - selectedEmoDiscount / 100.0);
    }

    private static void updateMax(int totalUser, int totalAcc) {
        if (totalUser > maxUser) {
            maxUser = totalUser;
            maxAcc = totalAcc;
        } else if (totalUser == maxUser && totalAcc > maxAcc) {
            maxAcc = totalAcc;
        }
    }
}
