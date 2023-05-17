package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	/*
	[문제 설명]
	주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
	숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, nums에 있는 숫자들 중 
	서로 다른 3개를 골라 더했을 때 소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.
	[제한 조건]
	nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
	nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.
	[입출력 예]
	nums				result
	[1,2,3,4]		1
	[1,2,7,6,4]		4
	[입출력 예 설명]
	입출력 예 #1
		[1,2,4]를 이용해서 7을 만들 수 있습니다.
	입출력 예 #2
		[1,2,4]를 이용해서 7을 만들 수 있습니다.
		[1,4,6]을 이용해서 11을 만들 수 있습니다.
		[2,4,7]을 이용해서 13을 만들 수 있습니다.
		[4,6,7]을 이용해서 17을 만들 수 있습니다.
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4};
		int[] nums2 = {1, 2, 7, 6, 4};
		
		System.out.println(Arrays.toString(nums1));
		System.out.println(solution(nums1));
		System.out.println(Arrays.toString(nums2));
		System.out.println(solution(nums2));
	}
	
	public static int solution(int[] nums) {
        int answer = 0;
        // nums 배열에서 서로 다은 3가지의 인덱스로 만들 수 있는 조합 저장할 List 생성 
        List<Integer[]> arr = new ArrayList<>();
        // 반복문을 통해 조합 저장
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			Integer[] temp = {nums[i], nums[j], nums[k]};
        			arr.add(temp);
        		}
        	}
        }
        // 각 조합의 합을 저장해 줄 배열 생성
        int[] sum = new int[arr.size()];
        // 반목문으로 합계 배열에 저장
        for(int i=0; i<arr.size(); i++) {
        	sum[i] = arr.get(i)[0] + arr.get(i)[1] + arr.get(i)[2];
        }
        // 합계를 반복문으로 소수 판별 메소드를 이용하여 카운트
        for(int i=0; i<sum.length; i++) {
        	if(prime(sum[i]) == true) {
        		answer++;
        	}
        }
        return answer;
    }
	/*
	 * 소수 판별 메소드
	 */
	public static boolean prime(int num){
        // 0 또는 1은 소수가 아님
        if(num < 2) return false;
        // 2는 소수
        if(num == 2) return true;
        // 그외의 수(루트이하의 수로 나눠보기)
        for(int i = 2; i <= Math.sqrt(num); i++){
            //루트이하 수에서 나눠지는 수가 있으면 소수가 아님
            if(num % i == 0){
                return false;
            }
        }
        //안나왔으면 소수
        return true;
    }
}