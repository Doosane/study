package com.doosane.study01.week03.day02.ex03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 백준 문제 16173 : 점프왕 쩰리
 문제분석 :
    주어진 게임 구역에서 끝 점(오른쪽 맨 아래 칸)까지 도달할 수 있는지 계산하는 프로그램을 작성하고
    ‘쩰리’가 끝 점에 도달할 수 있으면 “HaruHaru”(인용부호 없이), 도달할 수 없으면 “Hing” (인용부호 없이)을 한 줄에 출력

 제약조건 :
    입력의 첫 번째 줄에는 게임 구역의 크기 N (2 ≤ N ≤ 3)이 주어진다.
    입력의 두 번째 줄부터 마지막 줄까지 게임판의 구역(맵)이 주어진다.
    게임판의 승리 지점(오른쪽 맨 아래 칸)에는 -1이 쓰여있고, 나머지 칸에는 0 이상 100 이하의 정수가 쓰여있다.
 의사결정 :
    1.BufferedReader로 입력 받고
    2.게임 구역의 맵을 저장할 2차원 배열 초기화 , 방문 여부를 확인할 배열 초기화
    3.for문을 통해 StringTokenizer를 사용해 토큰화한 값을 게임 구역의 맵 입력
    4.너비우선탐색(BFS) 사용, 출발점에서 도착점으로 갈 수 있는지 확인
    5.도착점에 도달할 수 있으면 "HaruHaru" 출력, 도착점에 도달할 수 없으면 "Hing" 출력
 */
import java.util.LinkedList;
import java.util.Queue;
public class BOJ16173 {
    static int N; // 게임 구역의 크기 N
    static int[][] map; // 게임 구역의 맵을 저장할 2차원 배열
    static boolean[][] visited; // 방문한 위치를 저장할 배열
    static int[] directionX = {1, 0}; // 오른쪽으로 이동
    static int[] directionY = {0, 1}; // 아래쪽으로 이동
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 게임 구역의 크기 N 입력
        map = new int[N][N]; // N x N 크기의 게임 구역 배열 초기화
        visited = new boolean[N][N]; // 방문 여부를 확인할 배열 초기화
        // 게임 구역의 맵 입력
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // BFS를 사용하여 출발점에서 도착점으로 갈 수 있는지 확인
        if (bfs(0, 0)) {
            System.out.println("HaruHaru"); // 도착점에 도달할 수 있으면 "HaruHaru" 출력
        } else {
            System.out.println("Hing"); // 도착점에 도달할 수 없으면 "Hing" 출력
        }
    }
    private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>(); // 큐 초기화
        queue.offer(new int[]{x, y}); // 출발점 큐에 추가
        visited[x][y] = true; // 출발점 방문 처리
        while (!queue.isEmpty()) { // 큐가 비어있지 않으면 반복
            int[] current = queue.poll(); // 현재 위치를 큐에서 가져옴
            int currentX = current[0]; // 현재 x 좌표
            int currentY = current[1]; // 현재 y 좌표
            int jump = map[currentX][currentY]; // 현재 위치에서의 점프 크기
            if (jump == -1) { // 도착점에 도달한 경우
                return true;
            }
            // 오른쪽과 아래쪽으로 점프
            for (int i = 0; i < 2; i++) {
                int jumpX = currentX + directionX[i] * jump; // 점프하여 도착할 x 좌표
                int jumpY = currentY + directionY[i] * jump; // 점프하여 도착할 y 좌표
                // 점프가 유효한 범위 내에 있고 방문하지 않은 위치인 경우
                if (jumpX >= 0 && jumpY >= 0 && jumpX < N && jumpY < N && !visited[jumpX][jumpY]) {
                    queue.offer(new int[]{jumpX, jumpY}); // 큐에 새로운 위치 추가
                    visited[jumpX][jumpY] = true; // 방문 처리
                }
            }
        }
        return false; // 도착점에 도달할 수 없는 경우
    }
}
