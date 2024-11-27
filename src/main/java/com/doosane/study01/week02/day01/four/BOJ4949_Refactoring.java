package com.doosane.study01.week02.day01.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949_Refactoring {
    public static void main(String[] args) throws IOException {

        // bufferedReader 로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S;
        // 입력이 끝날 때까지 반복
        while (!(S = br.readLine()).equals(".")) {

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
    private static boolean checkResult(String S) {

        // 스택 사용
        Stack<Character> stack = new Stack<>();

        // 반목문을 통해 조건 확인
        for (int i = 0; i < S.length(); i++) {

            // charAt으로 한글자씩 확인
            char ch = S.charAt(i);

            // 여는 괄호인 경우 스택에 넣음
            if (ch == '(' || ch == '[') {
                stack.push(ch);
            }
            // 닫는 괄호인 경우
            else if (ch == ')' || ch == ']') {
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

