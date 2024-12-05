package com.doosane.study01.week03.day02;

import java.util.*;
/*
    백준 문제 2309번 : 일곱 난쟁이
    문제 분석:
        아홉 난쟁이의 키가 주어졌을 때, 키의 합이 100이 되는 일곱 난쟁이를 찾기
        주어진 난쟁이들의 키를 입력받아 합이 100이 되는 일곱 난쟁이를 찾아서 그들의 키를 오름차순으로 출력

    의사 결정:
       1. Scanner를 사용하여 아홉 난쟁이의 키를 입력받고, 합을 계산
       2. Arrays.sort()를 사용하여 난쟁이들의 키를 오름차순으로 정렬
       3. 이중 for문을 사용하여 두 난쟁이를 선택하고, 이들을 제외한 키의 합이 100이 되는지를 확인
       4, 합이 100이 되는 두 난쟁이를 찾으면 exclude1과 exclude2에 그 인덱스를 저장

    결과 출력:
       정렬된 난쟁이들의 키에서 제외할 두 난쟁이를 제외하고 나머지 일곱 난쟁이의 키를 출력
 */

public class BOJ2309 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heights = new int[9]; // 아홉 난쟁이의 키를 저장할 배열
        int sum = 0; // 아홉 난쟁이의 키의 합을 저장할 변수

        // 아홉 난쟁이의 키 입력받기
        for (int i = 0; i < 9; i++) {
            heights[i] = sc.nextInt();
            sum += heights[i]; // 키의 합 계산
        }

        // 난쟁이들의 키를 오름차순으로 정렬
        Arrays.sort(heights);
        int exclude1 = -1, exclude2 = -1; // 제외할 두 난쟁이의 인덱스를 저장할 변수

        // 합이 100이 되도록 두 난쟁이를 찾기
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                // 두 난쟁이의 키를 뺀 합이 100인 경우 찾기
                if (sum - heights[i] - heights[j] == 100) {
                    exclude1 = i; // 첫 번째 제외할 난쟁이의 인덱스 저장
                    exclude2 = j; // 두 번째 제외할 난쟁이의 인덱스 저장
                    break;
                }
            }
            if (exclude1 != -1) break; // 두 난쟁이를 찾았으면 더 이상 반복할 필요 없음
        }

        // 결과를 출력
        for (int i = 0; i < 9; i++) {
            if (i != exclude1 && i != exclude2) {
                System.out.println(heights[i]); // 제외할 두 난쟁이를 제외하고 출력
            }
        }
    }
}