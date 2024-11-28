package com.doosane.study01.week02.day02.six;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
 백준 문제 1406번
 에디터

 문제 분석 :
초기에 편집기에 입력되어 있는 문자열이 주어지고, 그 이후 입력한 명령어가 차례로 주어졌을 때, 모든 명령어를 수행하고 난 후 편집기에 입력되어 있는 문자열을 구하는 프로그램을 작성

 제약 조건 :
 문자열은 길이가 N이고, 영어 소문자로만 이루어져 있으며, 길이는 100,000을 넘지 않는다.
 정수 M(1 ≤ M ≤ 500,000)

 의사 결정 :
  1. BufferedReader , InputStreamReader 를 이용하여 입력을 받는다.
  2.

 */

public class BOJ1406_Stack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());  // 초기 문자열
        int M = Integer.parseInt(br.readLine());  // 명령어의 개수

        Stack<Character> leftStack = new Stack<>();  // 왼쪽에 있는 문자들
        Stack<Character> rightStack = new Stack<>();  // 오른쪽에 있는 문자들

        // 처음 문자열을 왼쪽 스택에 모두 넣기
        for (int i = 0; i < sb.length(); i++) {
            leftStack.push(sb.charAt(i));
        }

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);  // 명령어의 첫 글자

            switch (c) {
                case 'L':  // 커서를 왼쪽으로 한 칸 이동
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 한 칸 이동
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':  // 커서 왼쪽의 문자 삭제
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':  // 문자를 삽입
                    char ch = command.charAt(2);  // 삽입할 문자
                    leftStack.push(ch);
                    break;
                default:
                    break;
            }
        }

        // 왼쪽 스택에 있는 문자들을 모두 오른쪽 스택으로 이동
        while (!leftStack.isEmpty()) {
            rightStack.push(leftStack.pop());
        }

        // 오른쪽 스택에 있는 문자들을 모두 출력
        StringBuilder result = new StringBuilder();
        while (!rightStack.isEmpty()) {
            result.append(rightStack.pop());
        }

        System.out.println(result.toString());
    }
}
