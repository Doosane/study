package com.doosane.study01.week02.day04.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
 백준 문제 1927 번 : 최소 힙

 문제 분석 :
    최소 힙을 이용하여 다음과 같은 연산을 지원하는 프로그램을 작성
    배열에 자연수 x를 넣는다.
    배열에서 가장 작은 값을 출력하고, 그 값을 배열에서 제거

 제약 조건 :
    연산의 개수 N(1 ≤ N ≤ 100,000)
    x는 231보다 작은 자연수 또는 0 , 음의 정수는 입력으로 주어지지 않는다.

 의사 결정 :
    1. BufferedReader , InputStreamReader를 함께 사용, 입력을 받는다.
    2. 입력에서 0이 주어진 횟수만큼 답을 출력한다.
    3. 만약 배열이 비어 있는 경우인데 가장 작은 값을 출력하라고 한 경우에는 0을 출력하면 된다.
 */

public class BOJ1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받고
        StringBuilder sb = new StringBuilder(); // StringBuiler로 한번에 모아서 출력
        int N = Integer.parseInt(br.readLine()); // 연산의 개수 N

        PriorityQueue<Integer> pq = new PriorityQueue(); // 우선순위 큐 사용 , 디폴트가 최소 힙

        int x = Integer.parseInt(br.readLine()); // BufferedReader로 읽어온 값에서 Integer.parseInt로 직접 형변환 해서 x에 할당 불필요한 객체 생성되지 않도록
        if (x == 0) { // x 가 0일 경우
            if(pq.isEmpty()) { // 우선순위큐가 비어있으면
                sb.append("0\n"); // StringBUilder 로 0 출력
            } else {
                sb.append(pq.poll()).append("\n"); // 우선순위큐에서 가장 작은 값을 가져와서 출력 ( pq.poll() 은 가져오고 그 값을 배열에서 제거 )
            }

        } else { // x가 0 이 아닐 경우
            pq.offer(x);  // pq.offer() 사용해서 큐에  x를 넣어준다.
        }
        System.out.println(sb); // 출력
    }
}

