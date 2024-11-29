package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
/*
 정렬 후 비교
    성능: O(N log N) 시간 복잡도, O(N) 공간 복잡도
    장점: 정렬을 통한 효율적인 비교
    단점: 추가 메모리 사용, 정렬 오버헤드
 */
public class BOJ9933_SortAndCompare {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            words.add(word);
            words.add(new StringBuilder(word).reverse().toString());
        }

        Collections.sort(words);
        for (int i = 1; i < words.size(); i++) {
            if (words.get(i).equals(words.get(i-1))) {
                String password = words.get(i);
                System.out.println(password.length() + " " + password.charAt(password.length() / 2));
                return;
            }
        }
    }
}