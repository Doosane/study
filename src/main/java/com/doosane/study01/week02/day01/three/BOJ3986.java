package com.doosane.study01.week02.day01.three;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ3986 {
    public static void main(String[] args) throws IOException {
        // BufferedReader 로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int goodWordCount = 0;

        // 여러 개의 단어를 처리
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                goodWordCount++;
            }
        }

        System.out.print(goodWordCount); // 좋은단어 개수 출력
    }


    // 좋은 단어인지 체크하는 메서드
    static boolean isGoodWord(String word) {
        // 문자열 길이가 홀수이면 좋은 단어가 아님
        if (word.length() % 2 == 1) {
            return false;
        }

        // 스택을 사용하여 좋은 단어인지 확인
        Stack<Character> stack = new Stack<>();

        // 단어를 순차적으로 처리
        for (char ch : word.toCharArray()) {

            // stack.isEmpty()는 스택이 비어 있는지를 확인 스택이 비어 있지 않으면
            // stack.peek()이 실행되어 스택의 가장 위에 있는 원소를 확인
            if (!stack.isEmpty() && stack.peek() == ch) {

                // 짝이 맞으면 stack.pop()을 호출하여 해당 문자를 제거
                // 짝이 맞는 경우, 스택의 가장 위에 있는 문자를 제거
                // 이는 두 문자가 짝을 이루었음을 의미, 그 문자를 더 이상 저장할 필요가 없기 때문
                stack.pop();

                // 스택이 비어 있거나 현재 문자가 스택의 가장 위에 있는 문자와 다른 경우
                // -> 짝이 맞지 않는 경우
            } else {

                // 짝이 맞지 않는 경우 현재 문자를 스택에 push
                // 이 문자는 아직 짝을 이루지 않았기 때문에 스택에 저장하고,
                // 나중에 다른 문자가 이를 짝지어 줄 수 있도록 함
                stack.push(ch);
            }
        }

        // 스택이 비어 있으면 좋은 단어
        return stack.isEmpty();
    }
}
