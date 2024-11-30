package com.doosane.study01.week02.day04.prac;

import java.io.*;
import java.util.*;
/*
백준 문제 16466번 : 콘서트

문제 분석:
    1차 티켓팅에서 팔린 티켓 번호 목록이 주어졌을 때, 2차 티켓팅에서 구매할 수 있는 가장 작은 티켓 번호를 찾기
    주어진 번호 목록에 없는 가장 작은 양의 정수를 찾기

제약 조건:
    첫째 줄에 1차 티켓팅에서 팔린 티켓들의 수인 정수 N이 주어진다. (1 ≤ N ≤ 1,000,000)
    둘째 줄에는 1차 티켓팅에서 팔린 티켓들의 번호 정수 Ai가 주어진다. (1 ≤ Ai ≤ 231 − 1)

의사결정:
    1. 대량의 입력을 효율적으로 처리하기 위해 BufferedReader와 StringTokenizer를 사용
    2. 팔린 티켓 번호를 저장하고 빠르게 검색하기 위해 HashSet을 선택
    3. HashSet은 검색, 삽입, 삭제 연산이 평균적으로 O(1) 시간 복잡도를 가지므로, 대량의 데이터를 처리하는 데 적합
    4. 1부터 시작하여 순차적으로 번호를 증가시키면서 HashSet에 없는 첫 번째 번호를 찾는 방식을 사용

 */
public class BOJ16466 {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 효율적으로 입력을 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1차 티켓팅에서 팔린 티켓의 수 N을 입력받음
        int N = Integer.parseInt(br.readLine());

        // HashSet을 사용하여 팔린 티켓 번호를 저장
        // HashSet은 검색 연산이 O(1)의 시간 복잡도를 가져 효율적
        Set<Integer> soldTickets = new HashSet<>();

        // StringTokenizer를 사용하여 두 번째 줄의 입력을 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 팔린 티켓 번호를 HashSet에 추가
        for (int i = 0; i < N; i++) {
            soldTickets.add(Integer.parseInt(st.nextToken()));
        }

        // 티켓 번호 1부터 시작하여, HashSet에 없는 가장 작은 번호를 찾음
        int ticketNumber = 1;
        while (soldTickets.contains(ticketNumber)) {
            ticketNumber++;
        }

        // 찾은 번호를 출력
        System.out.println(ticketNumber);
    }
}