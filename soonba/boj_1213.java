/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1213
 * Level: Silver III
 * Algorithm: String
 */

/*
입력값 분리
솔팅하여 queue 에 담는다.
queue 에서 poll()하며 element()와 일치하지 않을 때까지 개수를 센다.
count 의 홀짝에 따라 string 배열을 채워간다.
count 홀수는 없거나 1개만 존재해야하므로, boolean 으로 판단하여 불가능한 경우를 체크한다.
string 배열을 모두 채우면, 최종 문자열을 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();
        String[] split = string.split("");

        List<String> strList = new ArrayList<>(List.of(split));
        Collections.sort(strList);
        Queue<String> queue = new LinkedList<>(strList);

        boolean middleStr = false;
        boolean isBreak = false;

        int len = split.length;
        String[] sbArray = new String[len];
        int totalIndex = 0;
        while(!queue.isEmpty()) {
            String temp = queue.poll();
            int count = 1;
            if(!queue.isEmpty()){
                while(queue.size()-1 >= 0 && queue.element().equals(temp)) {
                    queue.poll();
                    count++;
                }
            }
            int i1 = count / 2;
            for (int i = 0; i < i1; i++) {
                sbArray[totalIndex] = temp;
                sbArray[len-1-totalIndex] = temp;
                totalIndex++;
            }
            if(count%2 ==1) {
                if(middleStr) {
                    isBreak = true;
                    System.out.println("I'm Sorry Hansoo");
                    break;
                }
                sbArray[(len/2)] = temp;
                middleStr = true;
            }
        }
        StringBuilder sb = new StringBuilder();

        if(!isBreak) {
            for (String s : sbArray) {
                sb.append(s);
            }
        }
        System.out.println(sb);
    }

}

