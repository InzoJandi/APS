package implementation.balancedN;


import java.io.BufferedReader;
import java.io.InputStreamReader;

//밸런스드 N빵
//
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int totalAmount = Integer.parseInt(split[1]);
        int totalFine = 0;
        String[] nameArr = new String[N];
        int[] fineArr = new int[N];
        for (int i = 0; i < N; i++) {
            String[] person = br.readLine().split(" ");
            nameArr[i] = person[0];
            int fine = Integer.parseInt(person[1]);
            fineArr[i] = fine;
            totalFine += fine;
        }
        int nPay = (totalAmount-totalFine)/N;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(nameArr[i]).append(" ").append(nPay+fineArr[i]).append("\n");
        }
        System.out.println(sb);
    }

}

