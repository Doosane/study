package com.doosane.study01.week01.day4.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
문제 분석 :
- 학생들이 한 줄로 선 후, 첫번째 학생부터 차례로 번호를 뽑는다.
- 첫 번째로 줄을 선 학생은 무조건 0번 번호를 받아 제일 앞에 줄을 선다.
- 두 번째로 줄을 선 학생은 0번 또는 1번 둘 중 하나의 번호를 뽑는다.
- 0번을 뽑으면 그자리에 있고, 1번을 뽑으면 바로 앞의 학생 앞으로 가서 줄을 선다.
- 세 번째로 줄을 선 학생은 0,1 또는 2 중 하나의 번호를 뽑는다.
- 각자 뽑은 번호는 자신이 처음에 선 순서보다는 작은 수이다.
- 줄을 선 학생들이 차례로 뽑은 번호가 주어질 때 학생들이 최종적으로 줄을 선 순서를 출력

제약 조건
- 학생의 수가 100 이하이고, 학생들이 뽑는 번호는 0 또는 자연수이며
- 학생들이 뽑은 번호 사이에는 빈 칸이 하나씩 있다.
- 각자 뽑은 번호는 자신이 처음에 선 순서보다는 작은 수이다.

의사 결정
- BufferedReader, readLine() 를 통해 입력을 받는다
- 입력 받은 학생 수와, 뽑은 번호를 계산한다.
- StringBuilder를 사용, 줄을 선 순서를 번호를 출력한다.
 */

/*
메모리 14240 KB
시간 108 ms
 */

public class BOJ2605_BufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 학생 수 입력 받기
        String[] input = br.readLine().split(" "); // 학생이 뽑은 번호 입력 받기

        int[] selectedNum = new int[n];
        for (int i = 0; i < n; i++) {
            selectedNum[i] = Integer.parseInt(input[i]);
        }

        List<Integer> studentLineOrder = new ArrayList<>(); // 학생들이 줄을 서는 순서 저장할 리스트
        for (int i = 0; i < n; i++) {
            int num = selectedNum[i]; // i번째 학생이 뽑은 번호

            studentLineOrder.add(studentLineOrder.size() - num, i + 1);
            // 학생들이 줄을 서는 순서 - i 번째 학생이 뽑은 번호

        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int student : studentLineOrder) {
            sb.append(student).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

}


