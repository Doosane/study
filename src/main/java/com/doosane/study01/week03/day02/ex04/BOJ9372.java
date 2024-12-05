package com.doosane.study01.week03.day02.ex04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
백준 문제 9372번 : 상근이의 여행

문제 분석:
    상근이가 모든 국가를 방문하기 위해 필요한 최소 비행기 수를 구하는 프로그램 작성.

제약 조건:
    첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,
    각 테스트 케이스마다 다음과 같은 정보가 주어진다.
    첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1000)과 비행기의 종류 M(1 ≤ M ≤ 10000) 가 주어진다.
    이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ N; a ≠ b)
    주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.

의사 결정:
    1. 테스트 케이스의 수 T를 BufferedReader를 이용해서 입력받고
    2. 각 테스트 케이스마다 국가의 수 N과 비행기의 종류 M을 입력받고
    3. 최소 신장 트리(MST)를 이용해 모든 국가를 방문하기 위해 필요한 최소 비행기 수는 N - 1임을 이용
 */

public class BOJ9372 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 국가의 수
            int M = Integer.parseInt(st.nextToken()); // 비행기의 수

            // 국가의 수가 N개라면, 최소 N-1개의 비행기가 필요
            // 입력된 비행기 정보는 실제로는 사용하지 않음
            for (int i = 0; i < M; i++) {
                br.readLine();
            }
            sb.append(N - 1).append("\n");
        }
        System.out.print(sb);
    }
}
