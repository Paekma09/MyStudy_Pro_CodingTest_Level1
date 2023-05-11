package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
	수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.
	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
	가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	[제한사항]
	시험은 최대 10,000 문제로 구성되어있습니다.
	문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
	가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
	[입출력 예]
	answers		return
	[1,2,3,4,5]	[1]
	[1,3,2,4,2]	[1,2,3]
	[입출력 예 설명]
	입출력 예 #1
		수포자 1은 모든 문제를 맞혔습니다.
		수포자 2는 모든 문제를 틀렸습니다.
		수포자 3은 모든 문제를 틀렸습니다.
		따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.
	입출력 예 #2
		모든 사람이 2문제씩을 맞췄습니다.
	*/
	public static void main(String[] args) {
		int[] answers1 = {1, 2, 3, 4, 5};
		int[] answers2 = {1, 3, 2, 4, 2};
		int[] answers3 = {1, 3, 2, 4, 2, 1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 1, 3, 2, 4, 2};
		
		System.out.print(Arrays.toString(answers1)+" ");
		System.out.println(Arrays.toString(solution(answers1)));
		System.out.print(Arrays.toString(answers2)+" ");
		System.out.println(Arrays.toString(solution(answers2)));
		System.out.print(Arrays.toString(answers3)+" ");
		System.out.println(Arrays.toString(solution(answers3)));
	}
	
	public static int[] solution(int[] answers) {
        // answer의 배열 길이가 유동적이므로 List 생성
        List<Integer> list = new ArrayList<>();
        // 문제에서 1번,2번,3번 수포자들의 답안 작성 패턴을 배열로 만든다.
        int[] patternA = {1, 2, 3, 4, 5};
        int[] patternB = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] patternC = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        // answers길이만큼 수포자들의 답안지를 만들 배열을 생성
        int[] A = new int[answers.length];
        int[] B = new int[answers.length];
        int[] C = new int[answers.length];
        // 생성된 답안지 배열에 패턴을 적용하기 위해 1번의 index는 0, 2번의 index는 1, 3번의 index는 2으로 하는 index배열 생성
        int[] index = new int[3];
        // 정답 수를 넣을 배열 생성 - 1번의 정답은 인덱스0, 2번의 정답은 인덱스1, 3번의 정답은 인덱스2
        int[] correct = new int[3];
        // 반복문을 돌며 답안지에 패턴 적용
        for(int i=0; i<answers.length; i++) {
        	if(index[0] < patternA.length) {
        		A[i] = patternA[index[0]];
        		index[0]++;
        		if(index[0] == patternA.length) {
        			index[0] = 0;
        		}
        	}
        	if(index[1] < patternB.length) {
        		B[i] = patternB[index[1]];
        		index[1]++;
        		if(index[1] == patternB.length) {
        			index[1] = 0;
        		}
        	}
        	if(index[2] < patternC.length) {
        		C[i] = patternC[index[2]];
        		index[2]++;
        		if(index[2] == patternC.length) {
        			index[2] = 0;
        		}
        	}
        }
        // 반복문으로 정답의 갯수 탐색
        for(int i=0; i<answers.length; i++) {
        	if(A[i] == answers[i]) {
        		correct[0]++;
        	}
        	if(B[i] == answers[i]) {
        		correct[1]++;
        	}
        	if(C[i] == answers[i]) {
        		correct[2]++;
        	}
        }
        // 정답 갯수의 최대값 구하기
        int max = correct[0];
        for(int i=0; i<correct.length; i++) {
        	if(max<correct[i]) {
        		max = correct[i];
        	}
        }
        // 최대값과 비교하여 list에 담기 (최대값과 같은 값이 있을 수 있으므로)
        for(int i=0; i<correct.length; i++) {
        	if(max == correct[i]) {
        		list.add(i+1);
        	}
        }
        // List를 int 배열로 변환 및 저장
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

}
