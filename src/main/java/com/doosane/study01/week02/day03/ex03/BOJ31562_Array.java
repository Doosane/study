package com.doosane.study01.week02.day03.ex03;
import java.io.*;
/*
 [백준] 문제 1417 : 전주 듣고 노래 맞히기
 Array 활용 하여 풀이
 */
public class BOJ31562_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 입력값 처리 (N, M)
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);

        // 최대 3개의 음만 확인할 수 있는 배열 크기 지정
        String[] songArray = new String[1000000];  // 해시 크기를 충분히 크게 설정

        // N개의 노래 정보 입력 받기
        for (int i = 0; i < N; i++) {
            String[] songInfo = br.readLine().split(" ");
            String songName = songInfo[1];
            String note = songInfo[2] + songInfo[3] + songInfo[4];

            // 음을 인덱스화하여 배열에 노래 제목 저장
            int index = note.hashCode() % songArray.length;  // 해시 값 계산
            if (songArray[index] == null) {
                songArray[index] = songName;  // 처음 등록되는 음은 제목 저장
            } else {
                songArray[index] = "MULTIPLE";  // 여러 개가 있으면 MULTIPLE로 표시
            }
        }

        // M개의 음을 처리
        for (int i = 0; i < M; i++) {
            String note = br.readLine().replace(" ", "");

            // 해당 음의 해시값을 구하여 배열에서 확인
            int index = note.hashCode() % songArray.length;
            if (songArray[index] == null) {
                bw.write("!\n");
            } else if (songArray[index].equals("MULTIPLE")) {
                bw.write("?\n");
            } else {
                bw.write(songArray[index] + "\n");
            }
        }

        // 최종 결과 출력
        bw.flush();
        br.close();
        bw.close();
    }
}

