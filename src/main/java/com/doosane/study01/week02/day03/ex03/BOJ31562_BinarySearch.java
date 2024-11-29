package com.doosane.study01.week02.day03.ex03;

import java.io.*;
import java.util.*;

public class BOJ31562_BinarySearch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력값 처리 (N, M)
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        // 첫 3개 음을 key로, 해당 음이 가진 노래 제목 리스트를 value로 갖는 TreeMap
        // TreeMap은 자동으로 키 값에 대해 오름차순 정렬
        TreeMap<String, List<String>> songMap = new TreeMap<>();

        // N개의 노래 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");
            String songName = songInfo[1];
            String note = songInfo[2] + songInfo[3] + songInfo[4];

            // 음에 해당하는 노래 제목을 리스트로 저장
            songMap.putIfAbsent(note, new ArrayList<>());
            songMap.get(note).add(songName);
        }

        // M개의 음을 처리
        for (int i = 0; i < M; i++) {
            String note = br.readLine().replace(" ", "");

            // 첫 3개 음이 있는지 확인
            if (!songMap.containsKey(note)) {
                bw.write("!\n");
            } else {
                List<String> matchingSongs = songMap.get(note);
                if (matchingSongs.size() > 1) {
                    bw.write("?\n");
                } else {
                    bw.write(matchingSongs.get(0) + "\n");
                }
            }
        }

        // 최종 결과 출력
        bw.flush();
        br.close();
        bw.close();
    }
}

