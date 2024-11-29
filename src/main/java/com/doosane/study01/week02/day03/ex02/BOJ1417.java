package com.doosane.study01.week02.day03.ex02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
백준 문제 1417번 : 국회의원 선거
 문제 분석:
    다솜이가 매수해야 하는 사람의 최솟값을 작성

 제약 조건:
    첫째 줄에 후보의 수 N이 주어진다.
    둘째 줄부터 차례대로 기호 1번을 찍으려고 하는 사람의 수,
    기호 2번을 찍으려고 하는 수, 이렇게 총 N개의 줄에 걸쳐 입력
    N은 50보다 작거나 같은 자연수이고, 득표수는 100보다 작거나 같은 자연수

 의사 결정:
    1. 메모리 효율, 읽어오는 속도 향상을 위해 BufferedReader ,InputStreamReader로 입력을 받는다.
    2. 다솜이 득표 수를 BufferedReader 의 readLine 메소드로 읽어와서 Integer.parseInt로 타입 변환하여 dasom에 할당
    3. 순서대로가 아닌 다솜이가 표를 가져올 가장 많은 득표 후보를 골라야 하므로 우선순위 큐의 최대 힙 메모리를 사용한다.
    4. 먼저, 반복문을 통해 , 다솜이를 제외한 모든 후보의 득표 수 저장하고,
    5. 매수 횟수를 선언하고, while 문에서 다솜이의 득표수가 가장 많아 질때까지
       가장 많은 득표를 한 후보의 표를 하나 가져다 다솜의 득표 수, 매수 카운트를 1 증가시키고, 표를 잃은 후보 득표수는 1감소시키고
       다시 큐에 넣는 과정을 반복한다.
    6. 최종적으로 매수한 사람의 수(count)를 출력한다.
 */
public class BOJ1417 {
    public static void main(String[] args) throws IOException {
        // BufferedReader , InputStreamReader를 사용하여 메모리 효율과 입력 시 읽어 오는 속도 개선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 읽어온 문자열을 Integer.parseInt로 타입을 변환하여 int N에 할당
        int N = Integer.parseInt(br.readLine());
        // 다솜이의 득표 수
        int dasom = Integer.parseInt(br.readLine());
        // 우선 순위 큐 최대 힙 메모리를 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // 다솜이를 제외한 나머지 후보들의 득표 수를 입력받아 우선순위 큐에 저장하는 과정
        for (int i = 1; i < N; i++) {
            //  i가 1부터 시작하는 이유는 다솜이(0번 인덱스)의 득표 수를 이미 별도로 입력받았기 때문
            pq.offer(Integer.parseInt(br.readLine()));
            // 변환된 정수(득표 수)를 우선순위 큐에 추가
            // 반복이 끝나면 우선순위 큐에는 다솜이를 제외한 모든 후보의 득표 수 저장
            // 최대 힙으로 구현되었으므로, 가장 많은 득표를 한 후보의 표 수가 큐의 최상단에 위치
        }
        int count = 0;                               // 매수 횟수
        while (!pq.isEmpty() && pq.peek() >= dasom) { //  다솜이의 득표 수가 가장 많아질 때까지 다음 과정을 반복
            int max = pq.poll();                     // 가장 많은 득표를 한 후보의 표를 하나 가져다
            dasom++;                                // 다솜이의 득표 수를 1 증가
            count++;                                 // 매수 횟수(count)를 1 증가
            pq.offer(max - 1);                   // 표를 잃은 후보의 득표 수를 1 감소시키고 다시 큐에 넣는다
        }
        System.out.println(count);                  // 최종적으로 매수한 사람의 수(count)를 출력
    }
}
