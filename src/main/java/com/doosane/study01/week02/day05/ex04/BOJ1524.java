package com.doosane.study01.week02.day05.ex04;

/*
 백준 문제 1524번 세준세비

 문제 분석 :
    각 테스트 케이스에 대해서 한 줄에 하나씩 차례대로 승자를 출력한다.
    세준이가 이기면 S를 세비가 이기면 B를 둘다 아닐 경우에는 C를 출력한다.

 제약 조건 :
 1 ≤ N, M ≤ 1,000,000
 병사들의 힘은 300,000,000보다 작거나 같은 자연수이다.

 의사 결정 :
   1. Scanner로 입력 받고
   2. 세준이와 세비의 병사들 힘 입력 한뒤
   3. 세준이와 세비 병사들의 최소값을 찾아서, 최소값 비교해서 결과 결정하고 출력
 */

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ1524 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in); // scanner 객체 사용해서 입력을 받고

        // 테스트 케이스 수 T 읽어와서
        int T = sc.nextInt();

        // 케이스 마다 반복
        while (T-- > 0) {
            // 세준이의 병사 수 N 과
            int N = sc.nextInt();
            int M = sc.nextInt();// 세비 병사 M

            int[] sejun = new int[N];// 세준 병사들의 힘 배열 저장
            for (int i = 0; i < N; i++) { // 세준 병사 힘 입력 받아서
                sejun[i] = sc.nextInt();
            }

            int[] sevi = new int[M]; // 세비 병사들의 힘 배열 저장
            for (int i = 0; i < M; i++) { // 세비 병사들 힘 이볅 받아서
                sevi[i] = sc.nextInt();
            }
            Arrays.sort(sejun); // 병사들의 힘 오름차순 정렬
            Arrays.sort(sevi);
            int i = 0,j = 0; // i 세준 j 세비
            // 두 군대 병사 있을 동안 전투 진행
            while (i < N && j < M) {
                // 세준 병사보다 세비 병사가 약하면 세비 병사 죽고
                if (sejun[i] < sevi[j]) {
                    j++;// 세비 병사 죽음
                } else {
                    i++; // 세준 병사 죽음
                }
            }
            // 전투 끝나고 남은 병사 수로 승자 결정
            if (i == N && j == M) { // i == N 이면, 세준 병사 모드 죽음, 세비 승리 ,  j == M 이면, 세비 병사 모두 즉으므로 세준 승리
                System.out.println("C"); // 두 군대 모두 병사 남지 않으면 'C'
            } else if (i == N) {
                System.out.println("B"); // 세준이 병사 모두 죽으면 'B'
            } else {
                System.out.println("S"); // 세비 병사 모두 죽었으면 'S'
            }
        }
        sc.close(); // 메모리 누수 방지위해 scanner 종료
    }
}
