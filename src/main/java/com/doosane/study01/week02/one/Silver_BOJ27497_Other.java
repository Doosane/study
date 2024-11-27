package com.doosane.study01.week02.one;

import java.io.*;
import java.util.ArrayList;

public class Silver_BOJ27497_Other {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 버튼을 누른 횟수
        int N = Integer.parseInt(br.readLine());

        // ArrayList 사용
        ArrayList<Character> list = new ArrayList<>();

        // 연산 처리
        while (N-- > 0) {
            String input = br.readLine();
            char op = input.charAt(0);

            if (op == '1') {
                // 문자열 맨 뒤에 c가 적힌 블록 추가
                list.add(input.charAt(2));

            } else if (op == '2') {
                // 문자열 맨 앞에 c가 적힌 블록 추가
                list.add(0, input.charAt(2));

            } else if (op == '3' && !list.isEmpty()) {
                // 가장 나중에 추가된 블록 제거
                list.remove(list.size() - 1);
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        bw.write(sb.length() > 0 ? sb.toString() : "0");
        bw.flush();
    }
}

