package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    이중 반복문 사용
    성능: O(N^2) 시간 복잡도, O(N) 공간 복잡도
    장점: 간단한 구현, 적은 메모리 사용
    단점: 큰 입력에 대해 느림
 */
public class BOJ9933_DoubleRepeatStatement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String word = words[i];
            String reversed = new StringBuilder(word).reverse().toString();
            for (int j = i; j < N; j++) {
                if (word.equals(reversed) || words[j].equals(reversed)) {
                    System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                    return;
                }
            }
        }
    }
}