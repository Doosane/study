package com.doosane.study01.week03.day04.ex03;

import java.io.*;
import java.util.*;

/*
 * 백준 문제 2805번 : 나무자르기
 *
 * 문제 분석:
 *    적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 구하는 프로그램을 작성
 *
 * 제약 조건:
 *    첫째 줄에 나무의 수 N과 상근이가 집으로 가져가려고 하는 나무의 길이 M이 주어진다.
 *     (1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000)
 *    둘째 줄에는 나무의 높이가 주어진다.
 *    나무의 높이의 합은 항상 M보다 크거나 같기 때문에,
 *    상근이는 집에 필요한 나무를 항상 가져갈 수 있다.
 *    높이는 1,000,000,000보다 작거나 같은 길이의 정수 또는 0이다.
 *
 * 의사 결정:
 *    적어도 M미터의 나무를 집에 가져가기 위해서 절단기에 설정할 수 있는 높이의 최댓값을 출력
 */
public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 나무의 수
        int M = sc.nextInt(); // 상근이가 집으로 가져가려는 나무의 길이
        int[] trees = new int[N]; // 나무 높이를 저장할 배열

        for (int i = 0; i < N; i++) {
            trees[i] = sc.nextInt();
        }

        long start = 0; // 이분 탐색의 시작점
        long end = 0; // 이분 탐색의 종료점

        for (int i = 0; i < N; i++) {
            if (trees[i] > end) {
                end = trees[i]; // 나무의 최대 높이로 설정
            }
        }

        long result = 0;
        while (start <= end) {
            long mid = (start + end) / 2; // 중간 높이 설정
            long total = 0;

            for (int i = 0; i < N; i++) {
                if (trees[i] > mid) {
                    total += trees[i] - mid; // 절단기로 잘라서 가져갈 수 있는 나무의 길이 계산
                }
            }

            if (total >= M) { // 가져갈 나무의 길이이 충분한 경우
                result = mid; // 절단기 높이 최댓값을 갱신
                start = mid + 1; // 더 높은 절단기 높이 탐색
            } else { // 가져갈 나무의 길이이 부족한 경우
                end = mid - 1; // 더 낮은 절단기 높이 탐색
            }
        }

        System.out.println(result); // 절단기에 설정할 수 있는 높이의 최댓값 출력
    }
}
