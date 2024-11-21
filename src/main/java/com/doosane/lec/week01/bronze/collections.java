package com.doosane.lec.week01.bronze;

import java.util.ArrayList;
import java.util.List;

/**
 * 백준 5일차
 * 자료구조 편
 * Collections
 * 주요 인터페이스들 살펴보기
 */
public class collections {

//    * ArrayList 클래스

//    ArrayList 클래스
//    동적 배열로 구현
//    인덱스를 기반한 빠른 검색
//    삽입, 삭제 시에는 느릴 수 있음
//    List<String> list = new ArrayList<>();
//list.add("apple");
//list.add("banana");
//list.add("cherry");
//
//System.out.println(list); // 출력: [apple, banana, cherry]
//
//list.remove("banana");
//System.out.println(list); // 출력: [apple, cherry]
//
//System.out.println(list.get(0)); // 출력: apple


//   * LinkedList 클래스
    // 추가하는 행위가 연결할때, 떨어져 있을때 사용하면 arrayList보다 좋다. 단, 순차적 접근을 해야한다는 단점이 있음
//이중 연결 리스트로 구현
//    삽입, 삭제가 ArrayList 클래스 보다 빠름
//    조회 시 인덱스에 의한 접근이 불가
//    List<String> list = new LinkedList<>();
//list.add("apple");
//list.add("banana");
//list.add("cherry");
//
//System.out.println(list); // 출력: [apple, banana, cherry]
//
//list.remove("banana");
//System.out.println(list); // 출력: [apple, cherry]
//
//System.out.println(list.get(0)); // 출력: apple

//    - Set Interface
//    - 순서가 없는 데이터 집합
//    - 중복을 허용하지 않음

//    HashSet 클래스
//    해시 테이블로 구현
//    빠른 검색, 삽입, 삭제 가능
//    Set<String> set = new HashSet<>();
//set.add("apple");
//set.add("banana");
//set.add("cherry");
//
//System.out.println(set); // 출력: [apple, banana, cherry]
//
//set.remove("banana");
//System.out.println(set); // 출력: [apple, cherry]
//
//System.out.println(set.contains("apple")); // 출력: true

//    TreeSet 클래스
//    이진 검색 트리로 구현
//    정렬된 순서를 유지
//    Set<String> set = new TreeSet<>();
//set.add("apple");
//set.add("banana");
//set.add("cherry");
//
//System.out.println(set); // 출력: [apple, banana, cherry]
//
//set.remove("banana");
//System.out.println(set); // 출력: [apple, cherry]
//
//System.out.println(set.contains("apple")); // 출력: true

//    - Map Interface
//    - 키-값 쌍으로 이루어진 데이터 집합
//    - 키는 중복을 허용하지 않음
//    - 키를 통한 빠른 접근 가능

//HashMap 클래스
//    해시 테이블로 구현
//    빠른 검색, 삽입, 삭제가 가능
//    Map<String, Integer> map = new HashMap<>();
//map.put("apple", 1);
//map.put("banana", 2);
//map.put("cherry", 3);
//
//System.out.println(map); // 출력: {apple=1, banana=2, cherry=3}
//
//map.remove("banana");
//System.out.println(map); // 출력: {apple=1, cherry=3}
//
//System.out.println(map.get("apple")); // 출력: 1

//    TreeMap 클래스
//    이진 검색 트리로 구현
//    키에 대해 정렬된 순서를 유지
//    Map<String, Integer> map = new TreeMap<>();
//map.put("apple", 1);
//map.put("banana", 2);
//map.put("cherry", 3);
//
//System.out.println(map); // 출력: {apple=1, banana=2, cherry=3}
//
//map.remove("banana");
//System.out.println(map); // 출력: {apple=1, cherry=3}
//
//System.out.println(map.get("apple")); // 출력: 1


}
