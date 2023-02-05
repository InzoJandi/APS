/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 12919
 * Level: GOLD V
 * Algorithm: Brute Force
 */

/* Pseudocode *
문자열을 A에서 B로 만드는 것이 아닌 아래의 규칙을 반대로 적용
- 문자열의 뒤에 A를 추가한다.
- 문자열의 뒤에 B를 추가하고 문자열을 뒤집는다.
규칙을 역순으로 적용하여 B에서 A로 만드는 방법으로 접근

문자열 A와 B를 입력받음(A -> dist, B -> src)
src를 dist와 같게 만들 수 있는지 확인하는 재귀함수를 호출
    if src == dist
        1 출력
        종료
    else if src의 길이 < dist의 길이
        해당 재귀 종료
    else
        if src의 마지막 문자 ==  A
            src 마지막 문자를 삭제
            재귀
            src 마지막 문자를 다시 추가
        if A의 첫번째 문자 == B
            src 첫번째 문자를 삭제하고 A를 뒤집음
            재귀
            src 첫번째 문자를 다시 추가하고 A를 뒤집음
못 만들면 0 출력
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AAndB2 {

    static StringBuilder src;
    static String dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // 첫 번째 문자열을 목적 문자열로 설정
        dist = bufferedReader.readLine();
        // 두 번째 문자열을 소스 문자열로 설정
        src = new StringBuilder(bufferedReader.readLine());

        solution();
        // 모든 재귀가 종료 되었는데도 못 만들었으면 0 출력
        System.out.println(0);
    }

    private static void solution() {
        // 소스 문자열이 목적 문자열과 같으면 1 출력
        if (src.toString().equals(dist)) {
            System.out.println(1);
            System.exit(0); // 나머지 재귀 호출을 실행하지 않고 종료
        }
        // 소스 문자열의 길이가 목적 문자열의 길이보다 짧으면 이미 목적 문자열을 만들 수 없으므로 종료
        else if (src.length() < dist.length()) return;

        // 소스 문자열의 마지막 문자가 A이면 A를 삭제하고 재귀
        if (src.charAt(src.length() - 1) == 'A') {
            src.deleteCharAt(src.length() - 1);
            solution();
            src.append("A");
        }
        // 소스 문자열의 첫번째 문자가 B이면 B를 삭제하고 A를 뒤집은 후 재귀
        if (src.charAt(0) == 'B') {
            src.deleteCharAt(0).reverse();
            solution();
            src.append("B").reverse();
        }
    }
}
