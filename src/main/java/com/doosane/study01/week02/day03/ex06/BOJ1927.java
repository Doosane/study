package com.doosane.study01.week02.day03.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 백준 문제 1927 번 : 최소 힙

 문제 분석 :
    최소 힙을 구현하여 두 가지 연산을 계산
       1. 배열에 자연수 x를 넣는 연산
       2. 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 연산

 제약 조건 :
     첫째 줄에 연산의 개수 N(1 ≤ N ≤ 100,000)이 주어진다.
     다음 N개의 줄에는 연산에 대한 정보를 나타내는 정수 x가 주어진다.
     만약 x가 자연수라면 배열에 x라는 값을 넣는(추가하는) 연산이고,
      x가 0이라면 배열에서 가장 작은 값을 출력하고 그 값을 배열에서 제거하는 경우이다.
      x는 231보다 작은 자연수 또는 0이고, 음의 정수는 입력으로 주어지지 않는다.

 의사 결정 :
    1. BufferedReader 를 사용하여 입력을 받고 ,InputStreamReader를 함께 사용하여 메모리 효율과 빠르게 읽어 올 수 있도록 한다.
    2. 연산의 개수 N 을, BufferedReader로 읽어온 값을 Integer.parseInt 로 직접 형변환하여 불필요한 객체 생성을 막고 , 문자열을 정수로 형변환해서 N에 할당한다.
    3. 우선순위 큐 PriorityQueue를 사용해서, 배열에서 특정 가장 작은 값을 골라 낼 수 있도록 한다.
    4. StringBuilder 를 사용해서 모았다가 한번에 출력하여 효율을 높인다.
 */
public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        // 입력을 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 위한 StringBuilder 초기화
        StringBuilder sb = new StringBuilder();

        // 연산의 개수 N 입력 받기
        int N = Integer.parseInt(br.readLine());

        // 최소 힙을 구현하기 위한 PriorityQueue 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // N번의 연산 수행
        for (int i = 0; i < N; i++) {
            // 각 연산에 대한 정수 x 입력 받기
            int x = Integer.parseInt(br.readLine());

            if (x == 0) {
                // x가 0인 경우: 최소값 출력 및 제거 연산
                if (pq.isEmpty()) {
                    // 큐가 비어있으면 0 출력
                    sb.append("0\n");
                } else {
                    // 큐에서 최소값을 꺼내어 출력
                    sb.append(pq.poll()).append("\n");
                }
            } else {
                // x가 0이 아닌 경우: x를 큐에 추가
                pq.offer(x);
            }
        }

        // 모든 결과를 한 번에 출력
        System.out.print(sb);
    }
}