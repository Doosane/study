package com.doosane.lec.week01.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 백준 1302번
 *
 *
 *
 * 베스트 셀러
 */
public class BOJ1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 팔린 책 개수
        int N = Integer.parseInt(br.readLine());

        // 책 제목 저장할 리스트
        List<String> books = new ArrayList<>();

        // 책 제목을 입력 받음
        for (int i = 0; i < N; i++) {
            books.add(br.readLine());
        }

        // 책 제목의 빈도수 계산을 위한 HashMap
        Map<String, Integer> bookCount = new HashMap<>();

        // 책 제목 빈도수 계산
        for (String book : books) {
            bookCount.put(book, bookCount.getOrDefault(book, 0) + 1);
        }

        // 가장 많이 팔린 책 찾기
        String mostSoldBook = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : bookCount.entrySet()) {
            String book = entry.getKey();
            int count = entry.getValue();

            // 최대 빈도수 업데이트, 동일한 빈도수일 경우 사전 순으로 비교
            if (count > maxCount || count == maxCount && book.compareTo(mostSoldBook) < 0) {
                mostSoldBook = book;
                maxCount = count;
            }
        }

        // 결과 출력
        System.out.println(mostSoldBook);
    }
}
