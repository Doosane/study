package com.doosane.study01.week02.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ10866_D {
    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력을 받기 위해 준비
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 번째 입력은 명령의 개수 N
        int N = Integer.parseInt(br.readLine());

        // 결과를 한 번에 출력할 StringBuilder
        StringBuilder sb = new StringBuilder();

        // 덱(Deque) 선언 (양쪽에서 원소 추가, 제거가 가능한 자료구조)
        Deque<Integer> deq = new ArrayDeque<>();

        // N개의 명령을 처리
        for (int i = 0; i < N; i++) {
            // 각 명령을 공백으로 구분하여 토큰화
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 첫 번째 토큰은 명령어
            String command = st.nextToken();

            // 명령어에 따라 해당 작업 수행
            switch (command) {
                case "push_front":
                    pushFront(deq, st, sb); // 덱 앞에 값 추가
                    break;
                case "push_back":
                    pushBack(deq, st, sb);  // 덱 뒤에 값 추가
                    break;
                case "pop_front":
                    popFront(deq, sb); // 덱 앞에서 값 제거
                    break;
                case "pop_back":
                    popBack(deq, sb);  // 덱 뒤에서 값 제거
                    break;
                case "size":
                    sb.append(deq.size()).append("\n"); // 덱의 크기 출력
                    break;
                case "empty":
                    sb.append(deq.isEmpty() ? 1 : 0).append("\n"); // 덱이 비었으면 1, 아니면 0 출력
                    break;
                case "front":
                    front(deq, sb); // 덱 앞의 값 출력
                    break;
                case "back":
                    back(deq, sb); // 덱 뒤의 값 출력
                    break;
            }
        }
        // 모든 명령 처리 후 결과 출력
        System.out.println(sb);
    }

    // 덱 앞에 값을 추가하는 함수
    private static void pushFront(Deque<Integer> deq, StringTokenizer st, StringBuilder sb) {
        // "push_front" 명령이므로 첫 번째 토큰을 덱 앞에 추가
        deq.addFirst(Integer.parseInt(st.nextToken()));
    }

    // 덱 뒤에 값을 추가하는 함수
    private static void pushBack(Deque<Integer> deq, StringTokenizer st, StringBuilder sb) {
        // "push_back" 명령이므로 첫 번째 토큰을 덱 뒤에 추가
        deq.addLast(Integer.parseInt(st.nextToken()));
    }

    // 덱 앞에서 값을 제거하는 함수
    private static void popFront(Deque<Integer> deq, StringBuilder sb) {
        // 덱이 비었으면 -1을 출력하고, 비어 있지 않으면 덱 앞에서 값을 제거
        if (deq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(deq.pollFirst()).append("\n"); // 덱 앞에서 값을 꺼내고 제거
        }
    }

    // 덱 뒤에서 값을 제거하는 함수
    private static void popBack(Deque<Integer> deq, StringBuilder sb) {
        // 덱이 비었으면 -1을 출력하고, 비어 있지 않으면 덱 뒤에서 값을 제거
        if (deq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(deq.pollLast()).append("\n"); // 덱 뒤에서 값을 꺼내고 제거
        }
    }

    // 덱 앞의 값을 출력하는 함수
    private static void front(Deque<Integer> deq, StringBuilder sb) {
        // 덱이 비었으면 -1을 출력하고, 비어 있지 않으면 덱 앞의 값을 출력
        if (deq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(deq.peekFirst()).append("\n"); // 덱 앞의 값을 확인만 (제거 안 함)
        }
    }

    // 덱 뒤의 값을 출력하는 함수
    private static void back(Deque<Integer> deq, StringBuilder sb) {
        // 덱이 비었으면 -1을 출력하고, 비어 있지 않으면 덱 뒤의 값을 출력
        if (deq.isEmpty()) {
            sb.append(-1).append("\n");
        } else {
            sb.append(deq.peekLast()).append("\n"); // 덱 뒤의 값을 확인만 (제거 안 함)
        }
    }
}
