/*
 * BAEKJOON ONLINE JUDGE
 * https://www.acmicpc.net
 * Problem Number: 9935
 * Level: GOLD IV
 * Algorithm: String / Stack
 */

/* Pseudocode *
stack에 문자열을 하나씩 넣음
stack의 크기가 폭탄 문자열의 크기보다 크거나 같을 때
stack의 맨 뒤부터 폭탄 문자열의 크기만큼의 문자열이 폭탄 문자열과 같은지 확인
같으면 stack에서 폭탄 문자열의 크기만큼 pop
인
stack = new stack
for c : src.length
    stack.push(c)
    while bomb.length <= stack.size
        if isBomb(stack, bomb)
            popStack(stack, bomb)
        else break
if stack.isEmpty
    return EMPTY
return stack to reverse
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StringExplosion {


    // 정답이 비었을 경우 출력할 문자열
    final static String EMPTY = "FRULA";

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String src = bufferedReader.readLine();
        String bomb = bufferedReader.readLine();

        System.out.println(solution(src, bomb));
    }

    private static String solution(String src, String bomb) {
        Stack<Character> stack = new Stack<>();

        // 원본 문자열 처음부터 끝까지 stack에 삽입
        for (int i = 0; i < src.length(); i++) {
            stack.push(src.charAt(i));
            // stack의 크기가 폭탄 문자열의 크기보다 크거나 같을 경우(반복)
            while (bomb.length() <= stack.size()) {
                // bomb 문자열과 같은 경우 stack에서 폭탄 문자열만큼 pop
                if (isBomb(stack, bomb)) popStack(stack, bomb);
                else break;
            }
        }


        // stack이 비었을 경우 빈 정답, 아닐 경우 stack을 reverse한 문자열 반환
        if (stack.isEmpty()) return EMPTY;
        return getAnswer(stack);
    }

    private static void popStack(Stack<Character> stack, String bomb) {
        for (int j = 0; j < bomb.length(); j++) stack.pop();
    }

    private static boolean isBomb(Stack<Character> stack, String bomb) {
        for (int i = 0; i < bomb.length(); i++) {
            if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) return false;
        }
        return true;
    }

    private static String getAnswer(Stack<Character> stack) {
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) answer.append(stack.pop());
        return answer.reverse().toString();
    }
}
