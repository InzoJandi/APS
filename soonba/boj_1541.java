import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 1541
 * Level: SILVER II
 * Algorithm: Greedy
 */

/*
입력 문자열을 StringBuilder 에 세팅한다. (일반 String 클래스에는 위치기반 replace 가 없는 것 같다.)
replacePlusToMinusAfterMinus 메서드
 - 표현식에서 첫 번째 '-' 이후 부호는 모두 '-' 로 바꾼다.
 - '-' 가 한번이라도 등장하면 이후 모든 덧셈은 '적절한 괄호'를 통해 전체 식을 뺄셈으로 계산할 수 있다.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        StringBuilder express = new StringBuilder();
        express.append(target);
        String replacedExpress = replacePlusToMinusAfterMinus(express);
        int cal = calculate(replacedExpress);
        System.out.println(cal);
    }

    private static String replacePlusToMinusAfterMinus(StringBuilder express) {
        boolean flag = false;
        for (int i = 0; i < express.length(); i++) {
            String target = express.substring(i, i + 1);
            //-가 나온 이후 +는 모두 -로 변경
            if (target.equals("+") && flag) {
                express.replace(i, i + 1, "-");
            } else if (target.equals("-")) {
                flag = true;
            }
        }
        return express.toString();
    }

    private static int calculate(String replacedExpress) {
        int sum = 0;
        int startIndex = 0;

        // 파싱된 숫자를 더할 지 뺄 지 나타내는 bool
        boolean symbol = true;

        for (int i = 0; i < replacedExpress.length(); i++) {
            String target = replacedExpress.substring(i, i + 1);
            if (target.equals("+") || target.equals("-")) {
                int num = Integer.parseInt(replacedExpress.substring(startIndex, i));
                startIndex = i + 1;
                sum += symbol ? num : (-1) * num;

                //다음 파싱된 숫자에 쓰일 boolean 값 세팅
                symbol = target.equals("+");
            }
        }

        //마지막 숫자
        int lastNum = Integer.parseInt(replacedExpress.substring(startIndex));
        sum += symbol ? lastNum : (-1) * lastNum;
        return sum;
    }

}

