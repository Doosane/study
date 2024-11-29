package com.doosane.study01.week02.day03.ex03;

import java.io.*;

/*
 백준 문제 31562번
 전주 듣고 노래 맞히기
     문제 분석 :
         정환이 맞히기를 시도할 각 노래에 대하여 프로그램에 저장된 노래와 첫 세 음이 동일한 노래가
         하나만 있다면 해당 노래의 제목을, 두 개 이상이면 ?을, 없다면 !을 한 줄에 하나씩 출력

     제약 조건 :
          1<= N <= 1000
          1<= M <= 1000
          1<= T <= 30
          입력으로 주어지는 모든 수는 정수이다.

     의사 결정 :
          1. BufferedReader 로 입력받는다.
          2. HashMap<String, String>을 사용하여 첫 3개 음을 key로, 해당 음에 맞는 노래 제목을 value로 저장
          3. 만약 동일한 첫 3개 음이 여러 노래와 일치하면, 그 음에 대해 "MULTIPLE"로 표기하여 후속 검색에서
             다수의 노래가 일치하는 경우를 처리
          4. 각 음에 대해 먼저 HashMap에서 해당 음이 존재하는지 확인
          5. 존재한다면, 하나의 노래만 해당 음과 일치하면 노래 제목을 출력
                       두 개 이상의 노래가 해당 음과 일치하면 "?"를 출력
                       해당 음이 없으면 "!"를 출력
          6. BufferedWriter를 사용하여 결과를 출력, 한 번에 출력하는 방식으로 성능을 최적화
 */

// 만약 저장된 노래 중 입력한 첫 세 음으로 시작하는 노래가 여러 개 있어 무슨 노래인지
// 정확히 알 수 없는 경우 ?를 출력하고, 입력한 첫 세 음에 맞는 저장된 노래가 없을 경우 !를 출력
// 정환을 도와서 첫 세 음만으로 본인이 음을 아는 노래를 맞히는 프로그램을 완성하자. 이 프로그램은 대문자와 소문자를 구분

import java.util.HashMap;
public class BOJ31562 {
    public static void main(String[] args) throws IOException {
        // BufferedReader와 BufferedWriter 사용하여 입력과 출력을 효율적으로 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 N(저장된 노래 수)과 M(입력 받을 음의 수) 읽기
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);  // 저장된 노래의 수
        int M = Integer.parseInt(firstLine[1]);  // 맞힐 음의 수

        // 3개 음을 key로, 해당 음이 가진 노래 제목 리스트를 value로 갖는 HashMap 생성
        // 음이 여러 개일 수 있으므로, 중복된 음이 들어올 경우 "MULTIPLE"로 처리
        HashMap<String, String> songMap = new HashMap<>();

        // N개의 노래 정보 입력 받기
        for (int i = 0; i < N; i++) {
            // 노래 제목과 3개의 음 정보 받기
            String[] songInfo = br.readLine().split(" ");
            String songName = songInfo[1];  // 노래 제목
            String note = songInfo[2] + songInfo[3] + songInfo[4];  // 첫 3개 음 (음은 3개만 필요)

            // 음이 이미 저장되어 있을 경우, "MULTIPLE"로 설정하여 여러 개의 노래가 일치함을 표시
            if (songMap.containsKey(note)) {
                songMap.put(note, "MULTIPLE");  // 동일한 음이 여러 노래에 매칭됨
            } else {
                songMap.put(note, songName);  // 첫 번째 등장하는 음은 노래 제목으로 저장
            }
        }

        // M개의 음을 처리
        for (int i = 0; i < M; i++) {
            // 첫 3개 음을 입력받고 공백 제거 (음은 연속된 문자열로 처리)
            String note = br.readLine().replace(" ", "");

            // 해당 음이 songMap에 존재하는지 확인
            if (!songMap.containsKey(note)) {
                // 음에 맞는 노래가 없는 경우 "!" 출력
                bw.write("!\n");
            } else {
                // 해당 음에 대해 저장된 값이 "MULTIPLE"이면 여러 개의 노래가 일치한 것이므로 "?" 출력
                String result = songMap.get(note);
                if (result.equals("MULTIPLE")) {
                    bw.write("?\n");
                } else {
                    // 정확히 하나의 노래가 일치하면 그 노래 제목을 출력
                    bw.write(result + "\n");
                }
            }
        }

        // 최종 결과 출력
        bw.flush();  // 버퍼에 저장된 모든 데이터를 출력
        br.close();
        bw.close();
    }
}
