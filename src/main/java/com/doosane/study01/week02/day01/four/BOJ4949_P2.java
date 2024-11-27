package com.doosane.study01.week02.day01.four;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ4949_P2 {
    public static void main(String[] args) throws IOException {
        // bufferedReader 로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // while 문에서 조건 문 설정
        while (true) {
            // bufferedReader 의 readLine() 으로 읽어온 문자열 선언
            String S = br.readLine();

            // 읽어 온 문자가 "." 과 같으면 break;
            if( S.equals(".")) {
                break;
            }

            // 괄호 균형 검사 결과 출력
            if(checkResult(S)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }

        }
    }

    // 괄호 균형 검사 메서드
    private static boolean checkResult(String S) {
        // 스택 사용
        Stack<Character> stack = new Stack<Character>();
        // 반목문을 통해 조건 확인
        for(int i = 0; i < S.length(); i++) {
            // charAt으로 한글자씩 확인
            char ch = S.charAt(i);

            // '(' or '[' 처럼, 여는 괄호인 경우
            if( ch == '(' || ch == '[') {

                // 스택에 푸시
                stack.push(ch);

            // ')' or ']' 처럼 닫는 괄호인 경우
            } else if (ch == ')' || ch == ']') {

                // 닫는 괄호가 있지만 여는 괄호가 없으면 (stack.isEmpty()) 이면 false 리턴
                if(stack.isEmpty()) {
                    return false;
                }

                // 스택의 가장 위 문자와 비교해서
                char top = stack.pop();

                // ')'  '(' or ']' '[' 처럼 짝맞지 않으면 불균형, false 리턴
                if((ch == ')' && top != '(') || (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        // 스택이 비어 있으면 균형이 맞는 것
        return stack.isEmpty();
    }
}