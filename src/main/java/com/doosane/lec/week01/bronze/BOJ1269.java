package com.doosane.lec.week01.bronze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * 대칭 차집합
 * 메모리 : 85424KB
 * 시간 : 704ms
 */
public class BOJ1269 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

         StringTokenizer st = new StringTokenizer(br.readLine());
         int aSize = Integer.parseInt(st.nextToken());
         int bSize = Integer.parseInt(st.nextToken());

         Set<Integer> setA = new HashSet<>();

         st = new StringTokenizer(br.readLine());
         for (int i = 0; i < aSize; i ++) {
             setA.add(Integer.parseInt(st.nextToken()));
         }

         Set<Integer> setB = new HashSet<>();
         for(int i= 0; i< bSize; i++) {
             setB.add(Integer.parseInt(st.nextToken()));
         }

         int uniqueInA = 0;
         for (int num : setA ) {
             if (!setB.contains(num)) {
                 uniqueInA++;
             }
         }

         int uniqueInB = 0 ;
         for (int num : setB) {
             if(!setA.contains(num)) {
                 uniqueInB++;
             }
         }

         int result = uniqueInA + uniqueInB;
         System.out.println(result);
         br.close();
    }
}