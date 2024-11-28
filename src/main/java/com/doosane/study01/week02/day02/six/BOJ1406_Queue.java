package com.doosane.study01.week02.day02.six;
/*
 백준 문제 1406번 : 에디터
 Queue를 이용한 풀이

 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ1406_Queue {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());  // 초기 문자열
        int M = Integer.parseInt(br.readLine());  // 명령어의 개수

        Queue<Character> leftQueue = new LinkedList<>();  // 커서 왼쪽에 있는 문자들
        Queue<Character> rightQueue = new LinkedList<>();  // 커서 오른쪽에 있는 문자들

        // 처음 문자열을 왼쪽 큐에 모두 넣기
        for (int i = 0; i < sb.length(); i++) {
            leftQueue.offer(sb.charAt(i));
        }

        // 명령어 처리
        for (int i = 0; i < M; i++) {
            String command = br.readLine();
            char c = command.charAt(0);  // 명령어의 첫 글자

            switch (c) {
                case 'L':  // 커서를 왼쪽으로 한 칸 이동
                    if (!leftQueue.isEmpty()) {
                        rightQueue.offer(leftQueue.poll());  // 왼쪽 큐에서 빼서 오른쪽 큐로 이동
                    }
                    break;
                case 'D':  // 커서를 오른쪽으로 한 칸 이동
                    if (!rightQueue.isEmpty()) {
                        leftQueue.offer(rightQueue.poll());  // 오른쪽 큐에서 빼서 왼쪽 큐로 이동
                    }
                    break;
                case 'B':  // 커서 왼쪽에 있는 문자 삭제
                    if (!leftQueue.isEmpty()) {
                        leftQueue.poll();  // 왼쪽 큐에서 문자 하나 삭제
                    }
                    break;
                case 'P':  // 문자를 삽입
                    char ch = command.charAt(2);  // 삽입할 문자
                    leftQueue.offer(ch);  // 왼쪽 큐에 문자 삽입
                    break;
                default:
                    break;
            }
        }

        // 왼쪽 큐에 있는 문자들을 오른쪽 큐로 옮기기
        while (!leftQueue.isEmpty()) {
            rightQueue.offer(leftQueue.poll());
        }

        // 오른쪽 큐에 있는 문자들을 모두 출력
        StringBuilder result = new StringBuilder();
        while (!rightQueue.isEmpty()) {
            result.append(rightQueue.poll());
        }

        System.out.println(result.toString());
    }
}

