package com.doosane.study01.week03.day04.practice;

import java.io.*;
import java.util.*;

/*
    백준 문제 6603번 : 로또

    문제 분석:
        집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성

    제약 조건:
        입력은 여러 개의 테스트 케이스로 이루어져 있다.
        각 테스트 케이스는 한 줄로 이루어져 있다.
        첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
        S의 원소는 오름차순으로 주어진다.
        입력의 마지막 줄에는 0이 하나 주어진다.

    의사 결정:
        각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다.
        각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
 */
public class BOJ6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("0")) { // 마지막 줄에 0이 들어오면 종료
            StringTokenizer st = new StringTokenizer(line);
            int k = Integer.parseInt(st.nextToken());
            int[] S = new int[k];

            for (int i = 0; i < k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            List<List<Integer>> combinations = new ArrayList<>();
            generateCombinations(S, new ArrayList<>(), 0, combinations);

            for (List<Integer> combo : combinations) {
                for (int num : combo) {
                    sb.append(num).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n"); // 각 테스트 케이스 사이에 빈 줄 추가
        }

        System.out.print(sb.toString());
    }

    private static void generateCombinations(int[] S, List<Integer> current, int index, List<List<Integer>> combinations) {
        if (current.size() == 6) { // 6개의 숫자를 선택하면 조합을 저장
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < S.length; i++) {
            current.add(S[i]);
            generateCombinations(S, current, i + 1, combinations);
            current.remove(current.size() - 1);
        }
    }
}