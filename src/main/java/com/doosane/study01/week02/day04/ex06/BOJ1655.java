package com.doosane.study01.week02.day04.ex06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 백준 문제 1655 번 : 가운데를 말해요
 문제 분석:
  백준이가 외치는 수가 주어졌을 때, 동생이 말해야 하는 수를 구하는 프로그램

 제약 조건:
  N은 1보다 크거나 같고, 100,000보다 작거나 같은 자연수
  N줄에 걸쳐서 백준이가 외치는 정수가 차례대로 주어진다.
  정수는 -10,000보다 크거나 같고, 10,000보다 작거나 같다.

 의사 결정:
    1. BufferedReader로 입력 받고
    2. 우선순위큐 두개를 만들어서 , 왼쪽의 우선순위큐의 큰값을 가져오면 중간값을 가져오는것으로
    3. 출력

 */
public class BOJ1655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));// BufferedReader로 입력을 받는다. InputSreamReader함께 사용하여 메모리 효율을 높인다.
        StringTokenizer st = new StringTokenizer(br.readLine());   // StringTokenizer 로 읽어 온 값을 토큰화 한다.
        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> leftMax = new PriorityQueue<>(Collections.reverseOrder()); // 우선순위큐, 최대힙으로 왼쪽의 가장 큰값을 가져오고
        PriorityQueue<Integer> rightMin =new PriorityQueue<>(); // 우선순위큐 최소힙으로 오른쪽의 가장 작은 값을 가져오고
        StringBuilder sb = new StringBuilder(); // StringBuilder 사용 , 한번에 출력하여 시간복잡도를 낮출 수 있도록 하고
        leftMax.offer(Integer.parseInt(br.readLine()));
        // 왼쪽의 우선순위 큐에 저장된 값에 BufferedReader의 readLine() 메서드로 읽어온 값을
        // Integer.parseInt로 직접 형변환 해서 불 필요한 객체 생성을 피하고, leftMax 왼쪽 우선순위 큐의 최대힙에 넣어준다.

        sb.append(leftMax.peek() +"\n");
        //시간 복잡도를 낮추기 위해 한번에 출력하기 위해서 StringBuilder를 사용하고 , 왼쪽 우선순위큐에서 가장 큰값을 leftMax.peek()로 꺼내오고, 행을 바꿔 출력한다.


        for(int i=1; i<N; i++) { // 반복문을 통해 값을 비교해서
            int num = Integer.parseInt(br.readLine());
            // BufferedReader의 readLine() 메서드로 읽어온 값을 Integer.parseInt로 형변환 하여, num에 할당

            if(leftMax.peek() >= num) leftMax.offer(num);
            // 왼쪽 우선순위 큐의 최대 값이 num 보다 클경우, 왼쪽 우선순위큐의 가장 큰값으로 num을 넣어준다.

            else rightMin.offer(num);
            // 반대일 경우 우선순위 큐의 최소힙에 num을 넣어준다.

            // leftMax 와 rightMin 좌우 노드 높이를 갖게 맞춰준다.
            if(leftMax.size() == rightMin.size()+2) {
                rightMin.offer(leftMax.poll());
            }
            else if(leftMax.size()+2==rightMin.size()) {
                leftMax.offer(rightMin.poll());
            }
            // leftMax의 사이즈와 rightMin 사이즈가 틀리다면 큰 쪽이 홀수의 가운데
            // 같다면 짝수에 해당하므로, leftMax의 peek로 가져온 가장 큰값이 조건에 맞는 가운데 수다.
            if(leftMax.size() >= rightMin.size()) sb.append(leftMax.peek());
            else sb.append(rightMin.peek());
            if(i != N-1) sb.append("\n");
        }
        System.out.println(sb.toString()); // 출력
    }
}
