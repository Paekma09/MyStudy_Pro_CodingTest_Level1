package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	array의 각 element 중 divisor로 나누어 떨어지는 값을 오름차순으로 정렬한 배열을 반환하는 함수, solution을 작성해주세요.
	divisor로 나누어 떨어지는 element가 하나도 없다면 배열에 -1을 담아 반환하세요.
	[제한사항]
	arr은 자연수를 담은 배열입니다.
	정수 i, j에 대해 i ≠ j 이면 arr[i] ≠ arr[j] 입니다.
	divisor는 자연수입니다.
	array는 길이 1 이상인 배열입니다.
	[입출력 예]
	arr				divisor	return
	[5, 9, 7, 10]	5			[5, 10]
	[2, 36, 1, 3]	1			[1, 2, 3, 36]
	[3,2, 6]			10			[-1]
	[입출력 예 설명]
	입출력 예 #1
		arr의 원소 중 5로 나누어 떨어지는 원소는 5와 10입니다. 따라서 [5, 10]을 리턴합니다.
	입출력 예 #2
		arr의 모든 원소는 1으로 나누어 떨어집니다. 원소를 오름차순으로 정렬해 [1, 2, 3, 36]을 리턴합니다.
	입출력 예 #3
		3, 2, 6은 10으로 나누어 떨어지지 않습니다. 나누어 떨어지는 원소가 없으므로 [-1]을 리턴합니다.
	*/
	public static void main(String[] args) {
		int[] arr1 = {5, 9, 7, 10};
		int divisor1 = 5;
		int[] arr2 = {2, 36, 1, 3};
		int divisor2 = 1;
		int[] arr3 = {3, 2, 6};
		int divisor3 = 10;
		
		System.out.print(Arrays.toString(arr1)+" "+divisor1+" ");
		System.out.println(Arrays.toString(solution(arr1, divisor1)));
		System.out.print(Arrays.toString(arr2)+" "+divisor2+" ");
		System.out.println(Arrays.toString(solution(arr2, divisor2)));
		System.out.print(Arrays.toString(arr3)+" "+divisor3+" ");
		System.out.println(Arrays.toString(solution(arr3, divisor3)));
	}
	
	public static int[] solution(int[] arr, int divisor) {
		// 배열의 길이가 유동적이므로 List 선언
		List<Integer> list = new ArrayList<>();
		// 문제의 조건이 맞으면 요소값 list에 저장
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%divisor == 0) {
				list.add(arr[i]);
			}
		}
		// list의 사이즈가 0일 때 list에 -1 값 저장
		if(list.size() == 0) {
			list.add(-1);
		}
		// list를 int 배열로 변환 및 저장
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        // int배열 오름차순으로 정렬
        Arrays.sort(answer);
        return answer;
    }
}
