package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다. 
	2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.
	[제한사항]
	행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.
	[입출력 예]
	arr1					arr2					return
	[[1,2],[2,3]]		[[3,4],[5,6]]		[[4,6],[7,9]]
	[[1],[2]]			[[3],[4]]			[[4],[6]]
	*/
	public static void main(String[] args) {
		int[][] arr1 = {{1, 2},{2, 3}};
		int[][] arr2 = {{3, 4},{5, 6}};
		int[][] arr3 = {{1},{2}};
		int[][] arr4 = {{3},{4}};
		
		System.out.print(Arrays.deepToString(arr1)+" "+Arrays.deepToString(arr2)+" ");
		System.out.println(Arrays.deepToString(solution(arr1, arr2)));
		System.out.print(Arrays.deepToString(arr3)+" "+Arrays.deepToString(arr4)+" ");
		System.out.println(Arrays.deepToString(solution(arr3, arr4)));
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		// 문제의 조건을 보고 answer배열의 길이와 answer[0]배열 길이를 알 수 있다. 배열 초기화
        int[][] answer = new int[arr1.length][arr1[0].length];
        // arr1과 arr2의 매치되는 요소값 더하여 answer배열에 저장
        for(int i=0; i<arr1.length; i++) {
        	for(int j=0; j<arr1[i].length; j++) {
        		answer[i][j] = arr1[i][j] + arr2[i][j];
        	}
        }
        return answer;
    }
}