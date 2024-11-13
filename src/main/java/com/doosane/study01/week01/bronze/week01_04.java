package com.doosane.study01.week01.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
public class week01_04  {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); // br로 첫 줄 받아서 st에 저장(N과 M을 공백없이 저장)

        // N, M 입력받기
        int N = Integer.parseInt(st.nextToken()); // 받은 첫줄을 N과 M으로 각각 나눔
        int M = Integer.parseInt(st.nextToken());

        // 각 행을 입력받고, 뒤집어서, 출력한다.
        for (int i = 0; i < N; i++) {
            char[] arr = br.readLine().toCharArray(); // br로 한 줄씩 받아서, char 배열에 한 글자씩 넣는다.
            for(int j = M-1; j >= 0; j--) {  // 배열에 저장된 값을 역순으로 출력한다.
                System.out.print(arr[j]);
            }
            System.out.println(); // 한 줄 출력이 끝나면 줄바꿈
        }
    }
}
