package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	네오는 평소 프로도가 비상금을 숨겨놓는 장소를 알려줄 비밀지도를 손에 넣었다. 
	그런데 이 비밀지도는 숫자로 암호화되어 있어 위치를 확인하기 위해서는 암호를 해독해야 한다. 
	다행히 지도 암호를 해독할 방법을 적어놓은 메모도 함께 발견했다.
		1. 지도는 한 변의 길이가 n인 정사각형 배열 형태로, 각 칸은 "공백"(" ") 또는 "벽"("#") 두 종류로 이루어져 있다.
		2. 전체 지도는 두 장의 지도를 겹쳐서 얻을 수 있다. 
			각각 "지도 1"과 "지도 2"라고 하자. 지도 1 또는 지도 2 중 어느 하나라도 벽인 부분은 전체 지도에서도 벽이다. 
			지도 1과 지도 2에서 모두 공백인 부분은 전체 지도에서도 공백이다.
		3. "지도 1"과 "지도 2"는 각각 정수 배열로 암호화되어 있다.
		4. 암호화된 배열은 지도의 각 가로줄에서 벽 부분을 1, 공백 부분을 0으로 부호화했을 때 얻어지는 이진수에 해당하는 값의 배열이다.
	네오가 프로도의 비상금을 손에 넣을 수 있도록, 비밀지도의 암호를 해독하는 작업을 도와줄 프로그램을 작성하라.
	[입력형식]
	입력으로 지도의 한 변 크기 n 과 2개의 정수 배열 arr1, arr2가 들어온다.
		1 ≦ n ≦ 16
		arr1, arr2는 길이 n인 정수 배열로 주어진다.
		정수 배열의 각 원소 x를 이진수로 변환했을 때의 길이는 n 이하이다. 즉, 0 ≦ x ≦ 2n - 1을 만족한다.
	[출력형식]
	원래의 비밀지도를 해독하여 '#', 공백으로 구성된 문자열 배열로 출력하라.
	[입출력 예]
	매개변수	값
	n			5
	arr1		[9, 20, 28, 18, 11]
	arr2		[30, 1, 21, 17, 28]
	출력		["#####","# # #", "### #", "# ##", "#####"]
	매개변수	값
	n			6
	arr1		[46, 33, 33 ,22, 31, 50]
	arr2		[27 ,56, 19, 14, 14, 10]
	출력		["######", "### #", "## ##", " #### ", " #####", "### # "]
	[입출력 예 설명]
	입출력 예 #1
		문제 예시와 같습니다.
	입출력 예 #2
		명함들을 적절히 회전시켜 겹쳤을 때, 3번째 명함(가로: 8, 세로: 15)이 다른 모든 명함보다 크기가 큽니다. 
		따라서 지갑의 크기는 3번째 명함의 크기와 같으며, 120(=8 x 15)을 return 합니다.
	입출력 예 #3
		명함들을 적절히 회전시켜 겹쳤을 때, 모든 명함을 포함하는 가장 작은 지갑의 크기는 133(=19 x 7)입니다.
	*/
	public static void main(String[] args) {
		int n1 = 5;
		int[] arr1 = {9, 20, 28, 18, 11};
		int[] arr2 = {30, 1, 21, 17, 28}; 
		int n2 = 6;
		int[] arr3 = {46, 33, 33 ,22, 31, 50};
		int[] arr4 = {27 ,56, 19, 14, 14, 10};
		
		System.out.println(n1+" "+Arrays.toString(arr1)+" "+Arrays.toString(arr2)+" ");
		System.out.println(Arrays.toString(solution(n1, arr1, arr2)));
		System.out.println(n2+" "+Arrays.toString(arr3)+" "+Arrays.toString(arr4)+" ");
		System.out.println(Arrays.toString(solution(n2, arr3, arr4)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		// arr1과 arr2를 2진수로 바꾸어서 저장할 문자열 배열 생성
		String[] str1 = new String[n];
		String[] str2 = new String[n];
		// 추후 "#"과 " "을 넣어서 만든 문자열을 저장하기 위한 List 생성
		List<String> list = new ArrayList<>();
		// 반복문으로 돌면서 n자릿수에 맞는 2진수로 변환 Integer로 하면 큰 수의 경우 범위가 벗어나 런타임 에러 발생 Long 타입으로 진행
		for(int i=0; i<n; i++) {
			// format "%0은 0으로 n길이를 맞춘다"는 의미 -> 2진수로 변경된 수의 길이가 n보다 작으면 작은 만큼 0으로 채운다는 의미
			str1[i] = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr1[i])));
			str2[i] = String.format("%0"+n+"d", Long.parseLong(Long.toBinaryString(arr2[i])));
		}
		// str1과 str2의 문자열을 문자로 하나씩 쪼개어 어느 하나라도 1이면 temp에 "#"을 아니면 " "을 추가한다.
		// temp에 저장된 문자열을 list에 추가한다.
		for(int i=0; i<n; i++) {
			String temp = "";
			for(int j=0; j<n; j++) {
				if(str1[i].charAt(j) == '1' || str2[i].charAt(j) == '1') {
					temp += "#";
				}else {
					temp += " ";
				}
			}
			list.add(temp);
		}
		// list를 문자열 배열로 변환하여 저장한다.
		String[] answer = list.toArray(new String[list.size()]);
		return answer;
	}

}
