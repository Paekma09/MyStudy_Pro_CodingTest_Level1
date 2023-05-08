package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	0부터 9까지의 숫자 중 일부가 들어있는 정수 배열 numbers가 매개변수로 주어집니다. 
	numbers에서 찾을 수 없는 0부터 9까지의 숫자를 모두 찾아 더한 수를 return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	1 ≤ numbers의 길이 ≤ 9
		0 ≤ numbers의 모든 원소 ≤ 9
		numbers의 모든 원소는 서로 다릅니다.
	[입출력 예]
	numbers				result
	[1,2,3,4,6,7,8,0]	14
	[5,8,4,0,6,7,9]		6
	[입출력 예 설명]
	입출력 예 #1
		5, 9가 numbers에 없으므로, 5 + 9 = 14를 return 해야 합니다.
	입출력 예 #2
		1, 2, 3이 numbers에 없으므로, 1 + 2 + 3 = 6을 return 해야 합니다.
	*/
	public static void main(String[] args) {
		int[] numbers1 = {1, 2, 3, 4, 6, 7, 8, 0};
		int[] numbers2 = {5, 8, 4, 0, 6, 7, 9};
		
		System.out.print(Arrays.toString(numbers1)+" ");
		System.out.println(solution(numbers1));
		System.out.print(Arrays.toString(numbers2)+" ");
		System.out.println(solution(numbers2));
	}
	
	public static int solution(int[] numbers) {
		int answer = 0;
		// 배열의 길이가 유동적이므로 List 생성 및 초기화
		List<Integer> num = new ArrayList<>();
		for(int i=0; i<10; i++) {
			num.add(i);
		}
		// numbers배열의 요소와 List의 요소값이 같으면 List에서 제거
		for(int i=0; i<numbers.length; i++) {
			for(int j=num.size()-1; j>=0; j--) {
				if(numbers[i] == num.get(j)) {
					num.remove(j);
				}
			}
		}
		// 제거되고 남은 요소값의 전체 합
		for(int i=0; i<num.size(); i++) {
			answer += num.get(i);
		}  
        return answer;
    }
}
