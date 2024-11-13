package com.doosane.study01.week01.silver;

import java.util.Scanner;

/* 연습문제 6번 돌려 막기  */
public class week01_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 행렬 A와 B 초기화
        int[][] A = new int[5][5];
        int[][] B = new int[5][5];

        // 행렬 A 입력받기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 행렬 B 입력받기
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        sc.close();

        // 사람의 이름 목록
        String[] names = {"Inseo", "Junsuk", "Jungwoo", "Jinwoo", "Youngki"};

        int[] workloads = new int[5];

        // 각 사람의 최종 일량 계산
        for (int x = 0; x < 5; x++) {
            for (int y = 0; y < 5; y++) {
                int workAmount = 0;

                for (int i = 0; i < 5; i++) {
                    workAmount += A[x][i] * B[i][y];
                }
                workloads[x] += workAmount;
            }
        }

        // 최종 일량이 가장 작은 사람 찾기
        int minIndex = 0;
        for (int i = 1; i < 5; i++) {

            if (workloads[i] < workloads[minIndex]) {
                minIndex = i;

            } else if (workloads[i] == workloads[minIndex]) {
                // 최종 일량이 같은 경우, 우선 순위 조사

                // "Youngki", "Jinwoo", "Jungwoo", "Junsuk", "Inseo" 순으로 우선순위
                if (names[i].compareTo(names[minIndex]) < 0) {
                    minIndex = i;
                }
            }

        }

        // 가장 일이 바쁘지 않은 사람 출력
        System.out.println(names[minIndex]);
    }
}
