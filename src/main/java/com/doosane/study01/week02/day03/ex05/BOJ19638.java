package com.doosane.study01.week02.day03.ex05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
/*
 백준 19638번 : 센티와 마법의 뿅망치

 문제 분석 :
 센티는 마법의 뿅망치를 이용하여 거인들의 키를 줄이려고 한다.
 뿅망치로 거인을 때리면 거인의 키가 절반으로 줄어든다 (소수점 버림).
 거인의 키가 1이면 더 이상 줄어들지 않는다.

 제약 조건 :
 - 거인의 나라 인구수 N (1 ≤ N ≤ 10^5)
 - 센티의 키 Hcenti (1 ≤ Hcenti ≤ 2 × 10^9)
 - 마법의 뿅망치 사용 횟수 제한 T (1 ≤ T ≤ 10^5)
 - 각 거인의 키 H (1 ≤ H ≤ 2 × 10^9)

 의사 결정 :
 1. 메모리 효율, 빠르게 입력값을 읽어 오기 위해 BufferedReader로 입력 받고 InputStreamReader를 함께 사용한다.
 2. 불필요한 객체 생성을 막기 위해서 Integer.parseInt 로 직접 숫자로 형변환을 해준다.
 3. 문제의 조건에서 순서대로 빼는것이 아닌, 특정 큰 숫자를 지정해서 빼내야 하므로 우선순위 큐를 사용한다.
    이 때, Collections.reverseOrder를 사용하여 ,최대 힙을 구현한다.
 4. 거인과 키를 비교 하기 위해 while 조건문에서 우선순위 큐가 비어있지 않고 !isEmpty && 가장 큰 값을 가져올때 peek() 센티의 키와 비교하여
    크거나 같아야 하고 , 이 조건에서 사용횟수가 제한을 넘지 않을때까지 반복한다.
 5. 가장 큰 거인의 키를 max 라 할때, max 가 1보트 크면 절반으로 줄이기 위해 2로 나눈 후 , 다시 반복한다.
    키가 1 이면 그대로 유지 한다.
 6. 최종적으로 출력할 때, 센티보다 키가 작으면 "YES"와 사용한 횟수 출력하고,
    센티보다 키가 크거나 같은 거인이 있으면 "NO"와 가장 큰 거인의 키를 출력한다.
*/

public class BOJ19638 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // 결과를 저장할 StringBuilder

        // 첫 번째 줄 입력 처리
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);      // 거인의 수
        int hCenti = Integer.parseInt(firstLine[1]); // 센티의 키
        int tLimit = Integer.parseInt(firstLine[2]); // 뿅망치 사용 제한 횟수

        // 최대 힙(Max Heap)을 구현하기 위한 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // 거인들의 키 입력 받기
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int count = 0; // 뿅망치 사용 횟수

        // 가장 큰 거인의 키가 센티보다 크거나 같고, 사용 횟수가 제한을 넘지 않을 때까지 반복
        while (!pq.isEmpty() && pq.peek() >= hCenti && count < tLimit) {
            int max = pq.poll(); // 가장 큰 거인의 키
            if (max > 1) {
                pq.offer(max / 2); // 키를 절반으로 줄임 (소수점 버림)
            } else {
                pq.offer(1); // 키가 1이면 그대로 유지
            }
            count++;
        }

        // 결과 출력
        if (pq.isEmpty() || pq.peek() < hCenti) {
            sb.append("YES\n").append(count);
        } else {
            sb.append("NO\n").append(pq.peek());
        }

        System.out.println(sb); // 최종 결과 출력
        br.close(); // 입력 스트림 닫기
    }
}
