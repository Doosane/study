package com.doosane.lec.week01.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 백준 BOJ2800
 * 괄호제거
 * 문제 분석 : 어떤 수식이 주어졌을 때, 괄호를 제거해서 나올 수 있는 서로 다른 식의 개수를 계산하는 프로그램 작성

 * 제약 조건 :
 첫째 줄에 음이 아닌 정수로 이루어진 수식 입력
 수식 길이 최대 200, 괄호 쌍은 적어도 1개, 많아야 10개
 숫자, '+', '*', '-', '/', '(', ')'로만 이루어져 있다.

 * 의사 결정 :

 */
public class BOJ7490 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int number;

        for (int i=0; i<n; i++) {
            number = Integer.parseInt(br.readLine());
            dfs(number, 1, 1, 1, 0, "1");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    // DFS로 내려갈 때마다 각각의 String을 가져야해서 StringBuilder가 아닌 String사용
    static void dfs(int max, int now, int num, int sign, int sum, String str) {
        if(max == now) {
            sum = sum + (num * sign);
            if (sum == 0) {
                sb.append(str +"\n");
            }
            return;
        }
        dfs(max, now+1, num*10+(now+1), sign, sum, str+ " " +String.valueOf(now+1));
        // 빈칸인 경우 뒤의 수와 이어야 하기에 sign은 그대로 가져간다.
        dfs(max, now+1, now+1, 1, sum + (num*sign), str+ "+" +String.valueOf(now+1));
        dfs(max, now+1, now+1, -1, sum + (num*sign), str+ "-" +String.valueOf(now+1));


    }



}