package com.doosane.study01.week02.day03.ex01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
    문자열 해싱
    성능: O(N * M) 시간 복잡도 (M은 단어 길이), O(N) 공간 복잡도
    장점: 빠른 해시 비교, 충돌 가능성 낮음
    단점: 해시 함수 구현 복잡성, 약간의 오버헤드
 */
public class BOJ9933_StringHashing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Long, String> hashes = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            long hash = hash(word);
            long reverseHash = reverseHash(word);

            if (hashes.containsKey(reverseHash) || hash == reverseHash) {
                System.out.println(word.length() + " " + word.charAt(word.length() / 2));
                return;
            }
            hashes.put(hash, word);
        }
    }

    private static long hash(String s) {
        long h = 0, p = 31, m = 1000000007;
        for (char c : s.toCharArray()) {
            h = (h * p + (c - 'a' + 1)) % m;
        }
        return h;
    }

    private static long reverseHash(String s) {
        long h = 0, p = 31, m = 1000000007;
        for (int i = s.length() - 1; i >= 0; i--) {
            h = (h * p + (s.charAt(i) - 'a' + 1)) % m;
        }
        return h;
    }
}