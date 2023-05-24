package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	/*
	[문제 설명]
	과일 장수가 사과 상자를 포장하고 있습니다. 
	사과는 상태에 따라 1점부터 k점까지의 점수로 분류하며, k점이 최상품의 사과이고 1점이 최하품의 사과입니다. 
	사과 한 상자의 가격은 다음과 같이 결정됩니다.
		한 상자에 사과를 m개씩 담아 포장합니다.
		상자에 담긴 사과 중 가장 낮은 점수가 p (1 ≤ p ≤ k)점인 경우, 사과 한 상자의 가격은 p * m 입니다.
	과일 장수가 가능한 많은 사과를 팔았을 때, 얻을 수 있는 최대 이익을 계산하고자 합니다.(사과는 상자 단위로만 판매하며, 남는 사과는 버립니다)
	예를 들어, k = 3, m = 4, 사과 7개의 점수가 [1, 2, 3, 1, 2, 3, 1]이라면, 
	다음과 같이 [2, 3, 2, 3]으로 구성된 사과 상자 1개를 만들어 판매하여 최대 이익을 얻을 수 있습니다.
		(최저 사과 점수) x (한 상자에 담긴 사과 개수) x (상자의 개수) = 2 x 4 x 1 = 8
	사과의 최대 점수 k, 한 상자에 들어가는 사과의 수 m, 사과들의 점수 score가 주어졌을 때, 
	과일 장수가 얻을 수 있는 최대 이익을 return하는 solution 함수를 완성해주세요.
	[제한 조건]
	3 ≤ k ≤ 9
	3 ≤ m ≤ 10
	7 ≤ score의 길이 ≤ 1,000,000
		1 ≤ score[i] ≤ k
	이익이 발생하지 않는 경우에는 0을 return 해주세요.
	[입출력 예]
	k	m	score											result
	3	4	[1, 2, 3, 1, 2, 3, 1]						8
	4	3	[4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]	33
	[입출력 예 설명]
	입출력 예 #1
		문제의 예시와 같습니다.
	입출력 예 #2
		다음과 같이 사과 상자를 포장하여 모두 팔면 최대 이익을 낼 수 있습니다.
		사과 상자		가격
		[1, 1, 2]	1 x 3 = 3
		[2, 2, 2]	2 x 3 = 6
		[4, 4, 4]	4 x 3 = 12
		[4, 4, 4]	4 x 3 = 12
		따라서 (1 x 3 x 1) + (2 x 3 x 1) + (4 x 3 x 2) = 33을 return합니다.
	 */
	public static void main(String[] args) {
		int k1 = 3;
		int m1 = 4;
		int[] score1 = {1, 2, 3, 1, 2, 3, 1};
		int k2 = 4;
		int m2 = 3;
		int[] score2 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
		int k3 = 4;
		int m3 = 4;
		int[] score3 = {4, 4, 3, 3, 3, 2, 2, 2, 1};
		int k4 = 9;
		int m4 = 2;
		int[] score4 = {7, 7, 6, 5, 2};
		int k5 = 7;
		int m5 = 2;
		int[] score5 = {7, 7, 5, 3, 3, 3, 1};
		int k6 = 9;
		int m6 = 10;
		int[] score6 = {7, 7, 5, 3, 3, 3, 1, 1, 2, 3, 1, 2, 3, 1, 4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2, 4, 4, 3, 3, 3, 2, 2, 2, 1, 8, 8, 9, 9};
		
		System.out.println(k1+" "+m1+" "+Arrays.toString(score1));
		System.out.println(solution(k1, m1, score1));
		System.out.println(k2+" "+m2+" "+Arrays.toString(score2));
		System.out.println(solution(k2, m2, score2));
		System.out.println(k3+" "+m3+" "+Arrays.toString(score3));
		System.out.println(solution(k3, m3, score3));
		System.out.println(k4+" "+m4+" "+Arrays.toString(score4));
		System.out.println(solution(k4, m4, score4));
		System.out.println(k5+" "+m5+" "+Arrays.toString(score5));
		System.out.println(solution(k5, m5, score5));
		System.out.println(k6+" "+m6+" "+Arrays.toString(score6));
		System.out.println(solution(k6, m6, score6));
	}
	
	public static int solution(int k, int m, int[] score) {
        int answer = 0;
        // score의 길이를 count변수에 담아 둔다.
        int count = score.length;
        // score배열을 List로 변환
        List<Integer> scoreList = new ArrayList<>();
        scoreList = Arrays.stream(score).boxed().collect(Collectors.toList());
        // 오름자순으로 정렬
        Collections.sort(scoreList);
        // score의 길이를 박스 당 과일 개수인 m으로 나눈 나머지를 변수에 저장
        int A = count % m;
        // 나머지가 0일때는 상관없으로 0이 아니면 나머지를 점수가 가장 낮은 순부터 나머지 갯수 만큼 제거
        // 참고 : List에서 값을 제거 할 경우 for문을 이용하여 인덱스로 접근해서 제거하면 List의 size가 변경이 되어 값이 틀어질 수 있다.
        // 가급적 while문을 사용하는 것이 안전하다.
        if(A != 0) {
        	while(A>0) {
        		scoreList.remove(0);
        		A--;
        	}
        }
        // scoreList를 한 박스당 갯수인 m개씩 배열에 담아 List에 저장
        List<Integer[]> box = new ArrayList<>();
        int par = 0;
        for(int i=0; i<count/m; i++) {
        	Integer[] temp = new Integer[m];
        	for(int j=0; j<m; j++) {
        		temp[j] = scoreList.get(par);
        		par++;
        	}
        	box.add(temp);
        }
        // 각 박스당 최소 값을 찾아 한 박스 당 개수를 곱한 값을 answer에 더해서 총 합을 구해 준다.
        for(int i=0; i<box.size(); i++) {
        	int[] temp = Arrays.stream(box.get(i)).mapToInt(Integer::intValue).toArray();
        	answer += min(temp) * m;
        }
        return answer;
    }
	// 배열에서 최소값 찾는 메소드
	public static int min(int[] arr) {
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		return min;
	}
}