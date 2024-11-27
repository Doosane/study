package com.doosane.study01.week02.five;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
백준 2504번
문제 괄호의 값

문제 분석
 주어진 괄호열을 읽고 그 괄호값을 앞에서 정의한대로 계산하여 출력

제약 조건
 첫째 줄에 괄호열을 나타내는 문자열(스트링)이 주어진다. 단 그 길이는 1 이상, 30 이하이다.
 첫째 줄에 그 괄호열의 값을 나타내는 정수를 출력한다. 만일 입력이 올바르지 못한 괄호열이면 반드시 0을 출력해야 한다.

의사 결정
 입력 받기: BufferedReader를 사용하여 괄호열 문자열을 입력받는다.

괄호열 계산:
 여는 괄호 (, [를 만나면 스택에 추가하고, 각각 2와 3의 값을 곱해 currentMultiplier에 저장.
 닫는 괄호 ), ]를 만나면:
 스택이 비어있거나 예상되는 여는 괄호가 없으면 0을 반환.
 바로 전 문자가 여는 괄호이면 해당 currentMultiplier를 result에 더함.
 스택에서 짝을 맞춘 여는 괄호를 제거하고 currentMultiplier를 해당 값으로 나눔.
 결과 출력: 스택이 비어있으면 최종 result 값을 출력, 아니면 0을 출력.

핵심 메서드:
 isOpeningBracket: 여는 괄호인지 확인.
 isClosingBracket: 닫는 괄호인지 확인.
 getExpectedOpeningBracket: 닫는 괄호에 맞는 여는 괄호 반환.
 getBracketMultiplier: 괄호 종류에 맞는 값 반환 (2 또는 3).
 processClosingBracket: 닫는 괄호 처리, 스택에서 짝을 맞춘 여는 괄호를 제거.

전체 흐름:
 문자열을 읽고,
 괄호를 처리하여 result에 값을 더하며,
 결과를 출력.
 *
 */

public class BOJ2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        System.out.println(calculateBracketValue(N));
    }

    private static int calculateBracketValue(String N) {
        Stack<Character> stack = new Stack<>();
        int result = 0;        // 전체 결과 값
        int currentMultiplier = 1;  // 현재 괄호의 곱셈 값

        for (int i = 0; i < N.length(); i++) {
            char current = N.charAt(i);

            if (isOpeningBracket(current)) {
                stack.push(current);  // 여는 괄호 스택에 추가
                currentMultiplier *= getBracketMultiplier(current);  // 곱셈 값 업데이트

            } else if (isClosingBracket(current)) {
                if (!processClosingBracket(stack, current)) {
                    return 0;  // 괄호가 올바르지 않으면 0 반환
                }

                // 바로 이전이 여는 괄호일 경우, 해당 값 추가
                if (i > 0 && N.charAt(i - 1) == getExpectedOpeningBracket(current)) {
                    result += currentMultiplier;
                }

                // 해당 괄호에 맞는 곱셈 값 나누기
                currentMultiplier /= getBracketMultiplier(getExpectedOpeningBracket(current));
            }
        }

        // 스택이 비어있으면 올바른 괄호열, 아니면 잘못된 괄호열
        return stack.isEmpty() ? result : 0;
    }

    // 여는 괄호인지 확인
    private static boolean isOpeningBracket(char bracket) {
        return bracket == '(' || bracket == '[';
    }

    // 닫는 괄호인지 확인
    private static boolean isClosingBracket(char bracket) {
        return bracket == ')' || bracket == ']';
    }

    // 닫는 괄호에 맞는 여는 괄호 반환
    private static char getExpectedOpeningBracket(char closing) {
        return (closing == ')') ? '(' : '[';
    }

    // 괄호 종류에 맞는 값 반환
    private static int getBracketMultiplier(char bracket) {
        if (bracket == '(') return 2;
        if (bracket == '[') return 3;
        return 1;  // 닫는 괄호에는 값이 없으므로 반환하지 않음
    }

    // 닫는 괄호 처리
    private static boolean processClosingBracket(Stack<Character> stack, char closingBracket) {
        char expected = getExpectedOpeningBracket(closingBracket);

        if (stack.isEmpty() || stack.peek() != expected) {
            return false;  // 스택이 비어있거나 예상한 괄호가 아님
        }

        stack.pop();  // 괄호 매칭이 되면 제거
        return true;
    }
}






