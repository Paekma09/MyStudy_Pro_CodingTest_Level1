package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	/*
	[문제 설명]
	정수 배열 numbers가 주어집니다. 
	numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아 더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 
	return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	numbers의 길이는 2 이상 100 이하입니다.
		numbers의 모든 수는 0 이상 100 이하입니다.
	[입출력 예]
	numbers		result
	[2,1,3,4,1]	[2,3,4,5,6,7]
	[5,0,2,7]		[2,5,7,9,12]
	[입출력 예 설명]
	입출력 예 #1
		2 = 1 + 1 입니다. (1이 numbers에 두 개 있습니다.)
		3 = 2 + 1 입니다.
		4 = 1 + 3 입니다.
		5 = 1 + 4 = 2 + 3 입니다.
		6 = 2 + 4 입니다.
		7 = 3 + 4 입니다.
		따라서 [2,3,4,5,6,7] 을 return 해야 합니다.
	입출력 예 #2
		2 = 0 + 2 입니다.
		5 = 5 + 0 입니다.
		7 = 0 + 7 = 5 + 2 입니다.
		9 = 2 + 7 입니다.
		12 = 5 + 7 입니다.
		따라서 [2,5,7,9,12] 를 return 해야 합니다.
	*/
	public static void main(String[] args) {
		int[] numbers1 = {2,1,3,4,1};
		int[] numbers2 = {5,0,2,7};
		
		System.out.print(Arrays.toString(numbers1)+" \n");
		System.out.println(Arrays.toString(solution(numbers1)));
		System.out.print(Arrays.toString(numbers2)+" \n");
		System.out.println(Arrays.toString(solution(numbers2)));
	}
	
	public static int[] solution(int[] numbers) {
		// 결과값이 유동적이므로 List생성
		List<Integer> list = new ArrayList<>();
		// 반복문을 돌며 numbers값의 요소를 차례로 더해 list에 저장
		for(int i=0; i<numbers.length; i++) {
			for(int j=i+1; j<numbers.length; j++) {
				list.add(numbers[i]+numbers[j]);
			}
		}
		// 중복값을 없애기 위해 List를 Set으로 변환
		Set<Integer> set = new HashSet<>(list);
		// Set을 int 배열로 변환 저장
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        // Set은 순서가 지켜지지 않으며, 문제의 조건대로 오름차순 정렬
        Arrays.sort(answer);
        return answer;
    }

}
