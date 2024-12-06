package com.doosane.study01.week03.day03.ex01;

import java.util.*;

/*
    백준 문제 13116번 : 30번

    문제 분석:
        두 정수 A와 B가 주어졌을 때, 두 수의 최소 공통 조상을 구하고, 결과로 해당 조상을 10배 한 값을 출력

    제약 조건:
        두 정수 A와 B는 서로 다르다.
        여러 테스트 케이스가 주어질 수 있다.

    의사 결정:
        1. 두 수 A와 B의 부모를 계속해서 구하여 최소 공통 조상을 찾고
        2. 최소 공통 조상을 찾으면 그 값을 10배하여 출력
 */
public class BOJ13116 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스의 수를 입력받음

        for (int i = 1; i <= T; i++) {
            int A = 0;
            int B = 0;
            StringTokenizer st;
            st = new StringTokenizer(sc.nextLine()); // 테스트 케이스의 입력
            A = sc.nextInt(); // 첫 번째 수 A 입력
            B = sc.nextInt(); // 두 번째 수 B 입력
            int minNum = Math.min(A, B); // A와 B 중 작은 값을 찾음

            // 두 수 A와 B의 부모를 계속해서 구하여 최소 공통 조상을 찾는 과정
            if (minNum == A) {
                while (true) {
                    if (B - A < A) break; // A가 B의 부모 노드보다 작으면 반복 종료
                    B /= 2; // B를 부모 노드로 이동
                }
            } else {
                while (true) {
                    if (A - B < B) break; // B가 A의 부모 노드보다 작으면 반복 종료
                    A /= 2; // A를 부모 노드로 이동
                }
            }

            // A와 B가 같아질 때까지 부모를 계속 구함
            while (A != B) {
                if (A > B) {
                    A /= 2; // A를 부모 노드로 이동
                    if (A == B) break; // A와 B가 같으면 반복 종료
                    B /= 2; // B를 부모 노드로 이동
                } else {
                    B /= 2; // B를 부모 노드로 이동
                    if (A == B) break; // A와 B가 같으면 반복 종료
                    A /= 2; // A를 부모 노드로 이동
                }
            }

            // 최소 공통 조상을 10배 한 값을 출력
            System.out.print((A * 10) + "\n");
        }
    }
}
