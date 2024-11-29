package com.doosane.study01.week02.day03.ex03;

import java.io.*;
import java.util.*;
/*
 백준 문제 31562 : 전주 듣고 노래 맞히기
 ArrayList를 활용해 풀이
 */
public class BOJ31562_ArrayList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력값 처리 (N, M)
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        // 음에 대한 매핑을 리스트로 관리
        Map<String, List<String>> songMap = new HashMap<>();

        // N개의 노래 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");
            String songName = songInfo[1];
            String note = songInfo[2] + songInfo[3] + songInfo[4];

            // 음에 대한 노래 제목을 리스트에 추가
            songMap.computeIfAbsent(note, k -> new ArrayList<>()).add(songName);
        }

        // M개의 음을 처리
        for (int i = 0; i < M; i++) {
            String note = br.readLine().replace(" ", "");

            if (!songMap.containsKey(note)) {
                bw.write("!\n");
            } else {
                List<String> songs = songMap.get(note);
                if (songs.size() > 1) {
                    bw.write("?\n");
                } else {
                    bw.write(songs.get(0) + "\n");
                }
            }
        }

        // 최종 결과 출력
        bw.flush();
        br.close();
        bw.close();
    }
}

