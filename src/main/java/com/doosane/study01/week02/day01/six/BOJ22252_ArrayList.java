package com.doosane.study01.week02.day01.six;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/**
 * ArrayList 로 우선순위 큐 안쓰고 구현하기
 *
 * 177088KB	1316ms
 */
public class BOJ22252_ArrayList {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 질의의 수
        int q = Integer.parseInt(br.readLine());

        // 이름별로 정보를 저장하는 맵
        HashMap<String, List<Integer>> infos = new HashMap<>();

        // 호석이가 구매한 정보의 합
        long totalSum = 0;

        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken()); // 명령 종류
            String name = st.nextToken(); // 이름
            int k = Integer.parseInt(st.nextToken()); // 거래할 정보의 개수

            if (command == 1) {  // 고릴라가 정보를 얻는 경우
                // 해당 이름에 대한 정보를 가져오거나 없으면 새 리스트 생성
                List<Integer> info = infos.getOrDefault(name, new ArrayList<>());

                // k개의 정보를 리스트에 추가
                for (int i = 0; i < k; i++) {
                    info.add(Integer.parseInt(st.nextToken()));
                }

                // 리스트를 내림차순으로 정렬
                Collections.sort(info, Collections.reverseOrder());

                // 업데이트된 리스트를 맵에 저장
                infos.put(name, info);

            } else {  // 호석이가 거래하는 경우
                List<Integer> info = infos.get(name);

                // 만약 해당 이름에 정보가 없다면 건너뛰기
                if (info == null) {
                    continue;
                }

                // 거래할 정보가 충분하면 k개만 거래
                for (int i = 0; i < k && i < info.size(); i++) {
                    totalSum += info.get(i); // 가장 큰 정보부터 더하기
                }

                // 고릴라가 가진 정보에서 거래한 만큼 제거
                info.subList(0, Math.min(k, info.size())).clear();
            }
        }

        // 총 합을 출력
        System.out.println(totalSum);
    }
}




