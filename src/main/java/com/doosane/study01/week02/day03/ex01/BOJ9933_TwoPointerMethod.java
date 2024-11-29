package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
/*
투 포인터 방식
성능: O(N * M) 시간 복잡도 (M은 단어 길이), O(1) 추가 공간 복잡도
장점: 메모리 효율적, 팰린드롬 빠르게 확인
단점: 역순 단어 쌍 확인 불가
 */
public class BOJ9933_TwoPointerMethod {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> words = new HashSet<>();
        String password = "";

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String reversed = new StringBuilder(word).reverse().toString();

            if (words.contains(reversed) || word.equals(reversed)) {
                password = word;
                break;
            }

            words.add(word);
        }

        System.out.println(password.length() + " " + password.charAt(password.length() / 2));
    }
}