package com.doosane.study01.week02.day06.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
백준 문제 13975 : 파일 합치기
 */
public class BOJ13975 {
    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력 받아서
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 마다 처리
        for(int t=0; t< T; t++) { // 각 테스트 케이스에서 처리할 숫자의 개수 K
            int K = Integer.parseInt(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>(); // 우선순위 큐 생성

            // 공백을 기준으로 읽어오고
            String[] numbers = br.readLine().split(" ");

            // 우선순위 큐에 넣고
            for(int i= 0; i <K ; i++) {
                pq.offer(Integer.parseInt(numbers[i]));
            }
            // 최소 비용을 계산
            int totalCost = 0;

            // 큐에 숫자가 2개 이상 남을 때까지 합치기
            while (pq.size() > 1) {
                // 가장 작은 두 숫자를 pq.poll()로 꺼내서
                int first = pq.poll();
                int second = pq.poll();
                // 두숫자의 합 구해서, 비용에 추가
                int cost = first + second;
                totalCost += cost;
                // 큐에 넣고
                pq.offer(cost);
            }
            // 최종 비용을 출력
            System.out.println(totalCost);
        }
    }
}