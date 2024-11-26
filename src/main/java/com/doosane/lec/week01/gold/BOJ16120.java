package com.doosane.lec.week01.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 16120번
 * PPAP
 */
public class BOJ16120 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

            // PPAP 규칙을 확인하고 결과를 출력
            if(checkPPAP(str)) {
                System.out.println("PPAP");

            } else {
                System.out.println("NP");
            }

    }

    /**
     * 주어진 문자열이 PPAP 규칙을 만족하는지 확인하는 메서드
     *
     * @param str 검증할 문자열
     * @return PPAP 규칙을 만족하면 true, 아니면 false
     */
    private static boolean checkPPAP(String str) {
        int pCount = 0;

        // 문자열을 순차적으로 검사
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);

            // 'P'가 오면 카운트 증가
            if (cur == 'P') {
                pCount++;

            // 'A'가 오면 이전에 두 개 이상의 'P'가 있어야 함
            } else if (cur == 'A' && pCount >= 2) {

                // 'A' 뒤에 반드시 'P'가 와야 하므로 다음 문자가 'P'인지 확인
                if (i < str.length() - 1 && str.charAt(i + 1) == 'P') {
                    // 'P' 두 개를 하나로 합치면서 카운트 감소
                    pCount--;

                    // 'P'를 하나 건너뛰어 처리
                    i++;

                } else {
                    // 'A' 뒤에 'P'가 없으면 규칙 위반
                    return false;
                }

            } else {
                // 'A'가 오기 전에 'P'가 충분하지 않으면 규칙 위반
                return false;
            }

        }

        // 마지막에 정확히 하나의 'P'만 남아 있어야 PPAP가 성립
        return pCount == 1;
    }
}