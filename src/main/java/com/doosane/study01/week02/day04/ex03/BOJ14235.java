package com.doosane.study01.week02.day04.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 백준 문제 14235 : 크리스마스 선물

 문제 분석:
    차례대로 방문한 아이들과 거점지의 정보들이 주어졌을 때,
    아이들이 준 선물들의 가치들을 출력, 만약 아이들에게 줄 선물이 없다면 -1을 출력

 제약 조건:
     방문한 횟수 n , (1≤n≤5,000)

 의사 결정:
    1. BufferedReader 로 입력받고
    2. 가장 가치가 큰 선물을 출력 -> 우선순위 큐의 개념을 활용 , 아이들에게 가장 큰 값의 선물을 주는데 a개를 준다.
    3. 반복문을 통해 우선순위 큐에서 , 가장 큰 값의 선물을 꺼내주고, 선물을 주는 횟수를  a 가 0 일때마다 카운트한 값을 출력한다.
 */
public class BOJ14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위 큐
        int n = Integer.parseInt(br.readLine()); // 방문한 횟수 n
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            //StringTokenizer 사용 , BufferedReader의 readLine() 메서드로 읽어온 값을 토큰화해서
            int a = Integer.parseInt(st.nextToken()); // 선물 개수 , 문자열로 받은 내용을 Integer.parseInt로 형변환 해서 a 에 선물 개수 할당하고
            // 만약 a가 0 ( 선물개수가 0 이라면)
            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append(-1).append("\n"); // -1 출력하고
                } else {
                    sb.append(pq.poll()).append("\n"); // 가장 큰 값(최대치) 선물 , pq.poll로 가져와서 출력
                }
            } else { // a가 0 이아니면 , 선물 줘야지 , 선물준거 출력하려면
                for(int j= 0; j < a; j++) {
                    int count = Integer.parseInt(st.nextToken());
                    pq.offer(count); // 선물 주는 횟수 우선순위큐에 넣어주고
                }
            }
        }
        System.out.println(sb); // StringBuilder로 한번에 모았다가 출력
    }
}