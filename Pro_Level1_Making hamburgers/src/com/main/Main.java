package com.main;

import java.util.Arrays;
import java.util.Stack;

public class Main {
	/*
	[문제 설명]
	햄버거 가게에서 일을 하는 상수는 햄버거를 포장하는 일을 합니다. 
	함께 일을 하는 다른 직원들이 햄버거에 들어갈 재료를 조리해 주면 조리된 순서대로 상수의 앞에 아래서부터 위로 쌓이게 되고, 
	상수는 순서에 맞게 쌓여서 완성된 햄버거를 따로 옮겨 포장을 하게 됩니다. 
	상수가 일하는 가게는 정해진 순서(아래서부터, 빵 – 야채 – 고기 - 빵)로 쌓인 햄버거만 포장을 합니다. 
	상수는 손이 굉장히 빠르기 때문에 상수가 포장하는 동안 속 재료가 추가적으로 들어오는 일은 없으며, 
	재료의 높이는 무시하여 재료가 높이 쌓여서 일이 힘들어지는 경우는 없습니다.
	예를 들어, 상수의 앞에 쌓이는 재료의 순서가 [야채, 빵, 빵, 야채, 고기, 빵, 야채, 고기, 빵]일 때, 상수는 여섯 번째 재료가 쌓였을 때, 
	세 번째 재료부터 여섯 번째 재료를 이용하여 햄버거를 포장하고, 아홉 번째 재료가 쌓였을 때, 
	두 번째 재료와 일곱 번째 재료부터 아홉 번째 재료를 이용하여 햄버거를 포장합니다. 즉, 2개의 햄버거를 포장하게 됩니다.
	상수에게 전해지는 재료의 정보를 나타내는 정수 배열 ingredient가 주어졌을 때, 
	상수가 포장하는 햄버거의 개수를 return 하도록 solution 함수를 완성하시오.
	[제한사항]
	1 ≤ ingredient의 길이 ≤ 1,000,000
	ingredient의 원소는 1, 2, 3 중 하나의 값이며, 순서대로 빵, 야채, 고기를 의미합니다.
	[입출력 예]
	ingredient																																	result
	[2, 1, 1, 2, 3, 1, 2, 3, 1]																												2
	[1, 3, 2, 1, 2, 1, 3, 1, 2]																												0
	[1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1]																									3
	[1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 2, 3, 1, 3, 3, 3, 2, 1, 2, 3, 1]		5
	[1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1]												3
	[1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1]																					3
	[1, 2, 2, 3, 1]																																0
	[입출력 예 설명]
	입출력 예 #1
		문제 예시와 같습니다.
	입출력 예 #2
		상수가 포장할 수 있는 햄버거가 없습니다.
	*/
	public static void main(String[] args) {
		int[] ingredient1 = {2, 1, 1, 2, 3, 1, 2, 3, 1};
		int[] ingredient2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
		int[] ingredient3 = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};
		int[] ingredient4 = {1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1, 2, 3, 1, 3, 3, 3, 2, 1, 2, 3, 1};
		int[] ingredient5 = {1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 1, 1, 2, 3, 3, 1};
		int[] ingredient6 = {1, 2, 3, 1, 2, 3, 1, 1, 1, 1, 2, 3, 1, 2, 3, 1};
		int[] ingredient7 = {1, 2, 2, 3, 1};
		
		System.out.println(Arrays.toString(ingredient1));
		System.out.println(solution(ingredient1));
		System.out.println(Arrays.toString(ingredient2));
		System.out.println(solution(ingredient2));
		System.out.println(Arrays.toString(ingredient3));
		System.out.println(solution(ingredient3));
		System.out.println(Arrays.toString(ingredient4));
		System.out.println(solution(ingredient4));
		System.out.println(Arrays.toString(ingredient5));
		System.out.println(solution(ingredient5));
		System.out.println(Arrays.toString(ingredient6));
		System.out.println(solution(ingredient6));
		System.out.println(Arrays.toString(ingredient7));
		System.out.println(solution(ingredient7));	
	}
	// Stack만 알면 풀수 있는 문제
	public static int solution(int[] ingredient) {
        int answer = 0;
        // 이 문제는 Collection 중 Stack을 이용해야 함
        Stack<Integer> stack = new Stack<>();
        int length = ingredient.length;
        // for문 처럼 ingredient배열의 인덱스를 활용하기 위한 변수 선언
        int i = 0;
        // length가 0보다 클때까지만 반복한다.
        while(length>0) {
        	// stack에 ingredient값을 인덱스로 차례로 저장한다.
        	stack.push(ingredient[i]);
        	// 단, stack의 size가 4이상 일때 부터 stack에 제일 윗쪽 부터 햄버가와 같은 형태인지 확인하여 같은 형태이면 4번 pop해준다.
        	// answer는 +1 해 준다.
        	if(stack.size()>=4) {
        		if(stack.get(stack.size()-1) == 1 && stack.get(stack.size()-2) == 3 && stack.get(stack.size()-3) == 2 && stack.get(stack.size()-4) == 1) {
            		stack.pop();
            		stack.pop();
            		stack.pop();
            		stack.pop();
            		answer++; 
            	}
        	}
        	i++;
        	length--;
        }
        return answer;
    }
}
