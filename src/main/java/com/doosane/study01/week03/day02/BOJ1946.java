package com.doosane.study01.week03.day02;
/*
 백준 문제 1946번 : 신입 사원
 문제 분석 :
    다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발
    이러한 조건을 만족시키면서, 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성
 제약 조건 :
    첫째 줄에는 테스트 케이스의 개수 T(1 ≤ T ≤ 20)가 주어진다.
    각 테스트 케이스의 첫째 줄에 지원자의 숫자 N(1 ≤ N ≤ 100,000)이 주어진다.
    둘째 줄부터 N개 줄에는 각각의 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 한 줄에 주어진다.
    두 성적 순위는 모두 1위부터 N위까지 동석차 없이 결정된다고 가정한다.
 의사 결정 :
    1. BufferedReader로 입력을 받고, 첫재 줄에는 지원자의 숫자 N
    2. 둘째 줄에는 지원자의 서류심사 성적, 면접 성적의 순위가 공백을 사이에 두고 입력
    3. 각 테스트 케이스에 대해서 진영 주식회사가 선발할 수 있는 신입사원의 최대 인원수를 한 줄에 하나씩 출력한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class BOJ1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); // 지원자의 숫자
            int[][] applicants = new int[N][2];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                applicants[i][0] = Integer.parseInt(st.nextToken()); // 서류심사 성적
                applicants[i][1] = Integer.parseInt(st.nextToken()); // 면접 성적
            }
            // 서류심사 성적 기준으로 오름차순 정렬
            Arrays.sort(applicants, Comparator.comparingInt(a -> a[0]));
            int maxHires = 1;
            int bestInterviewScore = applicants[0][1];

            for (int i = 1; i < N; i++) {
                if (applicants[i][1] < bestInterviewScore) {
                    maxHires++;
                    bestInterviewScore = applicants[i][1];
                }
            }
            System.out.println(maxHires); // 각 테스트 케이스에 대한 결과 출력
        }
    }
}