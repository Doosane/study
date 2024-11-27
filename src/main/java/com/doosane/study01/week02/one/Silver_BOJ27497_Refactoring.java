package com.doosane.study01.week02.one;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 백준 문제 27497번
 * 알파벳 블록
 * 문제 분석 :
 * 알파벳 블록을 조립해서, 버튼을 누른 횟수와 누른 버튼이 순서대로 주어질 때 완성된 문자열 출력하기
 * 의사 결정 :
 * 1. BufferedReader 로 문자열 입력 받기
 * 2. 입력 받은 문자열을 누른 횟수에 따라 바꾸는 메서드 실행 ( deque 와 stack 개념 이용 )
 * 3. 완성된 문자열 출력
 */
public class Silver_BOJ27497_Refactoring {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 버튼을 누른 횟수
        int N = Integer.parseInt(br.readLine());

        // deque 와 stack 이용
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Boolean> stack = new Stack<>();

        // 연산 처리 메서드 호출
        for (int i = 0; i < N; i++) {
            String input = br.readLine(); // 입력받은 값
            buttonPush(deque, stack, input); // 버튼 누른 연산 처리
        }

        // 결과 출력 메서드 호출
        printResult(deque, bw);

        // 버퍼를 통해 출력한 내용을 실제로 flush
        bw.flush();
    }

    // 버튼을 누를 때마다 연산을 처리하는 메서드
    private static void buttonPush(Deque<Character> deque, Stack<Boolean> stack, String input) {
        char op = input.charAt(0);

        if (op == '1') {
            deque.offerLast(input.charAt(2));
            stack.push(true);

        } else if (op == '2') {
            deque.offerFirst(input.charAt(2));
            stack.push(false);

        } else if (!deque.isEmpty()) {
            if (stack.pop()) {
                deque.removeLast();
            } else {
                deque.removeFirst();
            }
        }
    }

    // 완성된 문자열을 출력하는 메서드
    private static void printResult(Deque<Character> deque, BufferedWriter bw) throws IOException {
        StringBuilder sb = new StringBuilder();

        for (char c : deque) {
            sb.append(c);
        }

        // 문자열이 비어 있으면 "0"을 출력, 아니면 완성된 문자열을 출력
        bw.write(sb.length() > 0 ? sb.toString() : "0");
    }
}

