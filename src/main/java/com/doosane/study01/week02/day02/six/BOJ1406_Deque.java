package com.doosane.study01.week02.day02.six;
/*
 백준 문제 1406번 : 에디터
  Deque 사용해서 문제 풀이
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ1406_Deque {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 초기 문자열 입력 받기
        String str = br.readLine();
        int M = Integer.parseInt(br.readLine());  // 명령어의 개수

        // Deque 사용: 왼쪽 부분과 오른쪽 부분을 분리하여 관리
        Deque<Character> leftDeque = new ArrayDeque<>();
        Deque<Character> rightDeque = new ArrayDeque<>();

        // 문자열을 leftDeque에 모두 넣기
        for (char c : str.toCharArray()) {
            leftDeque.addLast(c);
        }

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char cmd = command.charAt(0);  // 명령어의 첫 글자

            switch (cmd) {
                case 'L':  // 커서를 왼쪽으로 한 칸 이동
                    if (!leftDeque.isEmpty()) {
                        rightDeque.addFirst(leftDeque.pollLast());  // leftDeque의 마지막 문자를 오른쪽 deque의 앞에 추가
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 한 칸 이동
                    if (!rightDeque.isEmpty()) {
                        leftDeque.addLast(rightDeque.pollFirst());  // rightDeque의 첫 문자를 왼쪽 deque의 뒤에 추가
                    }
                    break;
                case 'B':  // 커서 왼쪽에 있는 문자 삭제
                    if (!leftDeque.isEmpty()) {
                        leftDeque.pollLast();  // 왼쪽 deque의 마지막 문자 삭제
                    }
                    break;
                case 'P':  // 문자를 삽입
                    char ch = command.charAt(2);  // 삽입할 문자
                    leftDeque.addLast(ch);  // 커서 위치에 문자를 추가 (leftDeque에 삽입)
                    break;
                default:
                    break;
            }
        }

        // 최종적으로 leftDeque와 rightDeque의 문자들을 합쳐서 출력
        StringBuilder result = new StringBuilder();

        // leftDeque의 모든 문자를 result에 추가
        while (!leftDeque.isEmpty()) {
            result.append(leftDeque.pollFirst());
        }

        // rightDeque의 모든 문자를 result에 추가
        while (!rightDeque.isEmpty()) {
            result.append(rightDeque.pollFirst());
        }

        System.out.println(result.toString());
    }
}

