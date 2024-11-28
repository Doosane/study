package com.doosane.study01.week02.day02.eight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 백준 1158번 - 요세푸스 문제

문제 분석 :
    주어진 N명의 사람이 원형 구조로 앉아 있으며, K번째 사람을 순차적으로 제거
    제거된 사람은 다시 원에 포함되지 않고, 남은 사람들로 다시 원을 이루어 K번째 사람을 제거하는 방식으로 계속.
    이 과정을 모든 사람이 제거될 때까지 반복하며, 제거된 사람들의 순서를 구한다.

제약 조건 :
    N (1 ≤ N ≤ 5000): 사람의 수는 1명 이상 5000명 이하
    K (1 ≤ K ≤ N): K는 1 이상 N 이하의 양의 정수로, K번째 사람을 순차적으로 제거

의사 결정 :
    1. 메모리 효율, 성능에 더 좋은 BufferedReader , InputStreamReader를 사용해서 두 정수 N과 K를 입력으로 받는다.
    2. 사람들을 순서대로 큐에 저장, 큐는 순서를 유지하면서도 효율적으로 원형 순회를 할 수 있게 한다.
    3. 각 사람을 큐에서 꺼내 K번째 사람을 제거하는 방식으로 진행
    4. 큐에서 K번째 사람을 제거하는데, 큐는 순서대로 처리되므로 실제로 K번째 사람을 찾기 위해서 K-1번 만큼 큐에서 pop한 후, K번째 사람을 pop
    5. 제거된 사람은 결과 리스트에 추가하고, 해당 사람이 제거된 이후에는 남은 사람들로 다시 원을 이루어 반복
    6. 최종적으로 제거된 사람들의 순서를 출력

 */
import java.io.*;
import java.util.*;

public class BOJ1158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]); // 사람의 수
        int K = Integer.parseInt(input[1]); // K번째 사람을 제거

        // 큐 초기화 (1부터 N까지 사람을 큐에 넣음)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        // 결과를 담을 리스트
        List<Integer> result = new ArrayList<>();

        // K번째 사람을 제거하는 과정
        while (!queue.isEmpty()) {

            // K-1번 만큼 큐에서 사람을 뒤로 보내기
            for (int i = 0; i < K - 1; i++) {
                queue.offer(queue.poll());
            }

            // K번째 사람을 제거하고 결과에 추가
            result.add(queue.poll());
        }

        // StringBuilder를 사용하여 결과 문자열을 구성
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        // 리스트의 첫 번째 요소를 제외한 나머지 요소들에 대해서는 앞에 ", "을 추가
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i));
            if (i < result.size() - 1) {
                sb.append(", ");
            }
        }

        sb.append(">");

        // 최종 결과 출력
        System.out.println(sb.toString());
    }
}