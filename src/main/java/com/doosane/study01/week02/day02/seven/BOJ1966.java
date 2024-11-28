package com.doosane.study01.week02.day02.seven;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
백준 문제 1966번 : 프린터 큐

문제 분석:
    중요도의 값의 역순으로 프린터를 출력한다.
    각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력

제약 조건:
    문서의 개수 N(1 ≤ N ≤ 100)
    문서가 현재 Queue에서 몇 번째에 놓여 있는지를 나타내는 정수 M(0 ≤ M < N)

의사 결정:
    1. BufferedReader , InputStreamReader 사용하여 입력을 받는다.
    2. 문서의 개수가 N일때, 입력받은 문서의 개수에서
    3. 각 테스트 케이스에 대해 문서가 몇 번째로 인쇄되는지 출력 한다.
*/

public class BOJ1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]); // 문서의 개수
            int M = Integer.parseInt(input[1]); // 궁금한 문서의 위치

            // 문서와 중요도를 저장할 큐
            Queue<int[]> queue = new LinkedList<>();
            // 중요도 리스트 (내림차순으로 처리)
            PriorityQueue<Integer> priorities = new PriorityQueue<>(Collections.reverseOrder());

            // 문서 중요도를 입력받고 큐와 우선순위 큐에 저장
            String[] prioritiesInput = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(prioritiesInput[i]);
                queue.offer(new int[] {priority, i});  // 큐에 문서와 인덱스 저장
                priorities.offer(priority);  // 우선순위 큐에 중요도 저장
            }

            int printOrder = 0; // 문서가 인쇄된 순서
            while (!queue.isEmpty()) {
                int[] front = queue.poll(); // 큐에서 맨 앞의 문서를 꺼냄
                int priority = front[0];

                // 우선순위 큐에서 가장 큰 중요도를 가진 값과 비교
                if (priority < priorities.peek()) {
                    queue.offer(front); // 중요도가 더 큰 문서가 있으므로 뒤로 재배치
                } else {
                    printOrder++; // 해당 문서 인쇄
                    priorities.poll(); // 인쇄한 문서의 중요도 제거
                    if (front[1] == M) {
                        System.out.println(printOrder); // M번째 문서가 인쇄된 순서를 출력
                        break;
                    }
                }
            }
        }
    }
}
