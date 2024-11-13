package com.doosane.study01.week01.bronze;
import java.util.Scanner;
/* 붕어빵 문제 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int N = sc.nextInt();
            int M = sc.nextInt();

            // 입력 범위 확인
            if (N < 0 || N > 10 || M < 0 || M > 10) {
                System.err.println("N과 M은 0 이상 10 이하");
                System.exit(1);
            }

            sc.nextLine(); // 버퍼에 남은 개행 문자 제거

            char[][] bungabbang = new char[N][M];

            // N개의 행을 입력받아 배열에 저장
            for (int i = 0; i < N; i++) {
                String line = sc.nextLine();
                if (line.length() != M) {
                    System.err.println("행의 길이 오류");
                    System.exit(1);
                }
                bungabbang[i] = line.toCharArray();
            }
            sc.close(); // 입력 완료 후 Scanner 닫기

            // 좌우 반전된 행렬을 출력
            for (int i = 0; i < N; i++) {
                for (int j = M - 1; j >= 0; j--) {
                    System.out.print(bungabbang[i][j]);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println("오류발생: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        } finally {
            sc.close();
        }
    }
}