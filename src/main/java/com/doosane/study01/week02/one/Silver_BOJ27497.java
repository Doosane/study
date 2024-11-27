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

 * 제약 조건 :
 * 첫째줄에 버튼을 누른 횟수 N이 주어진다( 1<= N <=1000000)
 * 둘째줄에 N개의 줄에
 * 1 c : 문자열 맨 뒤에 c가 적힌 블록 추가
 * 2 c : 문자열 맨 앞에 c가 적힌 블록 추가
 * 3 : 문자열을 구성하는 블록 중 가장 나중에 추가된 블록 제거
 * c는 알파벳 대문자 또는 소문자로 주어진다.

 * 의사 결정 :
 * 1. BufferedReader 로 문자열 입력 받기
 * 2. 입력 받은 문자열을 누른 횟수에 따라 바꾸는 메서드 실행
 * 3. 완성된 문자열 출력
 */
public class Silver_BOJ27497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 버튼을 누른 횟수
        int N = Integer.parseInt(br.readLine());

        // deque 와 stack 이용
        Deque<Character> deque = new ArrayDeque<>();
        Stack<Boolean> stack = new Stack<>();

        while (N-- > 0) {
            String input = br.readLine(); // 입력받은 값
            char op = input.charAt(0);

            if (op == '1') {
                deque.offerLast(input.charAt(2));
                stack.push(true);

            } else if (op == '2') {
                deque.offerFirst(input.charAt(2));
                stack.push(false);

            } else if (!deque.isEmpty()) {
                if (stack.pop()) deque.removeLast();
                else deque.removeFirst();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : deque)
            sb.append(c);

        bw.write(sb.length() > 0 ? sb.toString() : "0");
        bw.flush();
    }
}

