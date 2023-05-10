package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요. 
	단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
	예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.
	[제한사항]
	arr은 길이 1 이상인 배열입니다.
	인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
	[입출력 예]
	arr			return
	[4,3,2,1]	[4,3,2]
	[10]			[-1]
	*/
	public static void main(String[] args) {
		int[] arr1 = {4, 3, 2, 1};
		int[] arr2 = {10};
		
		System.out.print(Arrays.toString(arr1)+" ");
		System.out.println(Arrays.toString(solution(arr1)));
		System.out.print(Arrays.toString(arr2)+" ");
		System.out.println(Arrays.toString(solution(arr2)));
	}
	
	public static int[] solution(int[] arr) {
		int[] answer = {};
		// arr의 최소값을 삭제한 배열 저장하기 위해 List 생성
		List<Integer> list = new ArrayList<>();
		// arr의 최소값 구하기
		int min = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(min>arr[i]) {
				min = arr[i];
			}
		}
		// arr배열에서 최소값이 아니면 List에 저장하기
		for(int i=0; i<arr.length; i++) {
			if(min != arr[i]) {
				list.add(arr[i]);
			}
		}
		// list의 사이즈가 0일 때와 아닐때 분기
		// List를 int배열로 변환하여 저장
        if(list.size() == 0) {
        	list.add(-1);
        	answer = list.stream().mapToInt(Integer::intValue).toArray();
        }else {
        	answer = list.stream().mapToInt(Integer::intValue).toArray();
        }
        return answer;
    }
}
