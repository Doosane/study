package com.doosane.lec.week01.gold;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
백준 문제 1417번 : 아즈버의 이빨 자국

문제 분석 :
첫째 줄에 아즈버의 송곳니 사이 간격이 될 수 있는 수의 개수 K를 출력한다.
K가 1이상일 경우, 둘째 줄에 공백을 사이에 두고 송곳니 사이 간격이 될 수 있는 수를 오름차순으로 출력

제약 조건 :
이빨 자국의 개수 N  (2<= N <= 4000)
이빨 자국이 찍힌 위치를 나타내는 정수 x ( 0<= x <10^9)

의사 결정 :
1.이빨 자국 읽기:
    배열(teeth)과 Set(teethSet)에 저장.
    Set은 빠른 검색을 위해 사용.

2.가능한 간격 후보 계산:
    기준점(첫 번째 위치)과의 간격을 candidateIntervals에 추가.

3.간격 후보 검증:
    각 후보 간격에 대해 모든 위치에서 ± 간격에 이빨 자국이 있는지 확인.

4.결과 정렬 및 출력:
    유효한 간격을 오름차순으로 정렬 후 출력.
 */
import java.util.*;
public class BOJ30105 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이빨 자국의 총 개수
        int[] teeth = new int[N]; // 이빨 자국 위치를 저장할 배열
        Set<Integer> teethSet = new HashSet<>(); // 이빨 자국 위치를 저장할 Set
        Set<Integer> candidateIntervals = new HashSet<>(); // 가능한 간격 후보를 저장할 Set
        List<Integer> validIntervals = new ArrayList<>(); // 최종적으로 가능한 간격을 저장할 리스트

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            teeth[i] = Integer.parseInt(st.nextToken());
            teethSet.add(teeth[i]); // 이빨 자국의 위치를 Set에 저장 (중복 제거를 위해)
        }

        // 기준점(첫 번째 이빨 자국)과 다른 이빨 자국 간의 간격 계산
        for (int i = 1; i < N; i++) {
            candidateIntervals.add(teeth[i] - teeth[0]); // 첫 번째 자국과의 간격을 후보로 추가
        }

        // 가능한 간격 후보들을 검증
        for (int interval : candidateIntervals) {
            boolean isValid = true; // 현재 간격이 유효한지 확인
            for (int position : teeth) {
                // 현재 위치에서 간격을 기준으로 +-interval 위치에 이빨 자국이 있는지 확인
                if (!teethSet.contains(position - interval) && !teethSet.contains(position + interval)) {
                    isValid = false; // 유효하지 않으면 종료
                    break;
                }
            }
            if (isValid) {
                validIntervals.add(interval); // 유효한 간격을 리스트에 추가
            }
        }

        // 유효한 간격을 오름차순으로 정렬
        Collections.sort(validIntervals);

        // 결과 출력
        System.out.println(validIntervals.size()); // 가능한 간격의 개수
        for (int interval : validIntervals) {
            System.out.print(interval + " "); // 가능한 간격을 출력
        }
    }
}