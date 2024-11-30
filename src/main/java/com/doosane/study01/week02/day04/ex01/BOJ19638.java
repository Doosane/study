package com.doosane.study01.week02.day04.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
 백준 문제 19638번 : 센티와 마법의 뿅망치
 문제 분석:
  센티의 망치  맞으면 키가 /2 로 변한다.
  단, 키가 1인경우 더 줄어들지 않는다.
  매번, 가장 키가 큰 거인 중 하나를 때린다.
  -> 순서대로 뽑는것이 아니라, 매번 가장 키가 큰 값을 가져와야 하므로 우선순위 큐의 개념을 적용한다.

 제약 조건 :
  인구수 N , ( 1<= N <= 10^5 )
  센티의 키 Hcenti ( 1 <= Hcenti <= 2 x 10^9 )
  망치 횟수 제한 ( 1 <= T <= 10^5 )
  거인의 키 ( 1<= H <= 2 x 10^9 )

 의사 결정 :
   1. BufferedReader , InputStreamReader 함께 사용, 입력을 받는다.
   2. 매번 가장 키가 큰 거인을 골라야 하므로 우선순위 큐의 개념을 사용한다.
   3. 반복문을 통해, 키가 가장큰 거인의 값을 가져와서 /2 하고 다시 우선순위 큐에 넣고 , 센티보다 키가 같거나 크지 않는 조건이 올때 까지 반복한다.
   4. 센티의 전략대로 반복하고, 모든 거인이 센티보다 키가 작도록 할 수 있는 경우, YES를 출력하고, 망치를 최소로 사용한 횟수를 출력한다.
   5. 센티의 전략대로 반복하고도, 센티보다 키가 크거나, 같은 거인이 있으면 NO를 출력하고, 가장 키가 큰 거인의 키를 출력한다.
 */
public class BOJ19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 한번에 모아서 출력하기 위해, StringBuilder 사용
        String[] firstLine = br.readLine().split(" "); // 빈칸을 사이에 두고 주어진다. -> split 으로 " " 공백을 기준으로 나눠지도록
        int N = Integer.parseInt(firstLine[0]); // 거인의 나라 인구수 -> 첫번째 줄, 첫번째 공백 인덱스 0,
        int hCenti = Integer.parseInt(firstLine[1]); // 센티의 키 -> 첫번째 줄, 두번째 공백 인덱스 1
        int limit = Integer.parseInt(firstLine[2]); //  망치 횟수 제한 -> 첫번째 줄, 세번째 공백 인덱스 2
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙, Collections.reversOrder() 사용
        for(int i = 0 ; i < N; i++) { // 거인 인구 우선순위 큐에 넣고
            pq.offer(N);
        }
        int count = 0; // 횟수
        while (pq.isEmpty() && pq.peek() >= hCenti && count < limit  ) {  // 우선순위큐가 빈 값이 아니고, pq.peek()으로 가져온값 , 제일 큰 값이 센티의 키보다 크거나 같은 조건에서
            for ( int i = 0; i < N; i++ ) { // 반복문으로 계속 과정 반복
                int max = pq.poll(); // pq.poll() 가장 큰 거인의 키를 가져와서 max 에 할당
                if( max > 1) {
                    pq.offer(max/2); // 거인의 키를 /2 해서 다시 우선순위 큐에 넣는다.
                } else {
                    pq.offer(1); // 키가 1인경우 줄어들지 않는다.
                }
                count++; // 횟수 증가
            }
        }
        // 센티의 전략대로 반복하고, 모든 거인이 센티보다 키가 작도록 할 수 있는 경우, YES를 출력하고, 망치를 최소로 사용한 횟수를 출력한다.
        if(pq.isEmpty() || pq.peek() < hCenti ) {
           sb.append("YES\n").append(count);
        } else {
        // 센티의 전략대로 반복하고도, 센티보다 키가 크거나, 같은 거인이 있으면 NO를 출력하고, 가장 키가 큰 거인의 키를 출력한다.
            sb.append("NO\n").append(count);
        }
        System.out.println(sb); // StringBuilder로 한번에 모았다가 출력한다.
        br.close(); // 메모리 누수 방지를 위해 BufferedReader를 종료한다.
    }
}