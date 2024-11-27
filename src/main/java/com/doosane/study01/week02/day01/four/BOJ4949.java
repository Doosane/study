package com.doosane.study01.week02.day01.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * 백준 문제 : 4949번
 * 균형잡힌 세상
 *
 * 문제 분석:
 * 어떤 문자열이 주어졌을 때, 괄호들의 균형이 잘 맞춰져 있는지 판단하는 프로그램
 *
 * 제약 조건:
 * 각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며,
 * 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
 * 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.
 *
 * 의사 결정:
 * 1. BufferedReader 로 문자열을 입력 받는다.
 * 2. readLine() 으로 읽어온 값을 S 에 할당하고
 * 3. 온점 . 이 나오면 입력이 끝난것으로 간주하고 종료
 * 4. 괄호 균형 검사 메서드 실행 후, 결과 값 리턴에 따라 yes / no 출력
 *
 * 괄호 균형 검사 메서드 :
 * 스택 사용, 여는 괄호인 경우 스택에 넣음
 * 닫는 괄호인 경우,
 * 1) 여는 괄호가 없으면 불균형으로 false return
 * 2) 스택의 가장 위 문자와 비교해서 짝이 맞지 않으면 불균형, false 리턴
 *
 *
 */
public class BOJ4949 {
    public static void main(String[] args) throws IOException {

        // bufferedReader 로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // while 문에서 조건 문 설정
        while (true) {

            // bufferedReader 의 readLine() 으로 읽어온 문자열 선언
            String S = br.readLine();

            // 입력이 끝나면 온점('.')이 나오기 때문에, 이를 처리하고 종료
            if (S.equals(".")) {
                break;
            }

            // 괄호 균형 검사 결과 출력
            if (checkResult(S)) {
                // "yes" 출력
                System.out.println("yes");
            } else {
                // "no" 출력
                System.out.println("no");
            }
        }
    }

    // 괄호 균형 검사 메서드
    private static Boolean checkResult(String S) {

        // 스택 사용
        Stack<Character> stack = new Stack<>();

        // 반목문을 통해 조건 확인
        for (int i = 0; i < S.length(); i++) {

            // charAt으로 한글자씩 확인
            char ch = S.charAt(i);

            // 여는 괄호인 경우 스택에 넣음
            if (ch == '(' || ch == '[') {

                // stack에 push
                stack.push(ch);

            // 닫는 괄호인 경우
            } else if (ch == ')' || ch == ']') {

                // 닫는 괄호가 있지만 여는 괄호가 없으면 불균형, false 리턴
                if (stack.isEmpty()) {
                    return false;
                }

                // 스택의 가장 위 문자와 비교해서
                char top = stack.pop();

                // 짝이 맞지 않으면 불균형, false 리턴
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 스택이 비어 있으면 균형이 맞는 것
        return stack.isEmpty();
    }
}
