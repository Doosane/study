package com.doosane.lec.week01.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ5752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(numbers);

        // 출력
        System.out.println(numbers[0] + " " + numbers[1] + " " + numbers[2]);

        br.close();
    }
}
