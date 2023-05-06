package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	함수 solution은 정수 x와 자연수 n을 입력 받아, x부터 시작해 x씩 증가하는 숫자를 n개 지니는 리스트를 리턴해야 합니다. 
	다음 제한 조건을 보고, 조건을 만족하는 함수, solution을 완성해주세요.
	[제한사항]
	x는 -10000000 이상, 10000000 이하인 정수입니다.
	n은 1000 이하인 자연수입니다.
	[입출력 예]
	x	n	answer
	2	5	[2,4,6,8,10]
	4	3	[4,8,12]
	-4	2	[-4, -8]
	*/
	public static void main(String[] args) {
		int x1 = 2;
		int n1 = 5;
		int x2 = 4;
		int n2 = 3;
		int x3 = -4;
		int n3 = 2;
		
		System.out.print(x1+" "+n1+" ");
		System.out.println(Arrays.toString(solution(x1, n1)));
		System.out.print(x2+" "+n2+" ");
		System.out.println(Arrays.toString(solution(x2, n2)));
		System.out.print(x3+" "+n3+" ");
		System.out.println(Arrays.toString(solution(x3, n3)));
	}
	
	public static long[] solution(int x, int n) {
		// 배열의 길이가 유동적이므로 List 생성
		List<Long> list = new ArrayList<>();
		// 반복문 횟수 저장할 변수 선언 및 초기화
		Long temp = (long) 0;
		// n번 반복하며 List에 저장
		while(temp != n) {
			temp++;
			list.add(temp * x);
		}
		// List를 int배열로 변환 저장
        long[] answer = list.stream().mapToLong(Long::longValue).toArray();
        return answer;
    }
}
