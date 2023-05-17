package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
	/*
	[���� ����]
	�־��� ���� �� 3���� ���� ������ �� �Ҽ��� �Ǵ� ����� ������ ���Ϸ��� �մϴ�. 
	���ڵ��� ����ִ� �迭 nums�� �Ű������� �־��� ��, nums�� �ִ� ���ڵ� �� 
	���� �ٸ� 3���� ��� ������ �� �Ҽ��� �Ǵ� ����� ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.
	[���� ����]
	nums�� ����ִ� ������ ������ 3�� �̻� 50�� �����Դϴ�.
	nums�� �� ���Ҵ� 1 �̻� 1,000 ������ �ڿ����̸�, �ߺ��� ���ڰ� ������� �ʽ��ϴ�.
	[����� ��]
	nums				result
	[1,2,3,4]		1
	[1,2,7,6,4]		4
	[����� �� ����]
	����� �� #1
		[1,2,4]�� �̿��ؼ� 7�� ���� �� �ֽ��ϴ�.
	����� �� #2
		[1,2,4]�� �̿��ؼ� 7�� ���� �� �ֽ��ϴ�.
		[1,4,6]�� �̿��ؼ� 11�� ���� �� �ֽ��ϴ�.
		[2,4,7]�� �̿��ؼ� 13�� ���� �� �ֽ��ϴ�.
		[4,6,7]�� �̿��ؼ� 17�� ���� �� �ֽ��ϴ�.
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
        // nums �迭���� ���� ���� 3������ �ε����� ���� �� �ִ� ���� ������ List ���� 
        List<Integer[]> arr = new ArrayList<>();
        // �ݺ����� ���� ���� ����
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			Integer[] temp = {nums[i], nums[j], nums[k]};
        			arr.add(temp);
        		}
        	}
        }
        // �� ������ ���� ������ �� �迭 ����
        int[] sum = new int[arr.size()];
        // �ݸ����� �հ� �迭�� ����
        for(int i=0; i<arr.size(); i++) {
        	sum[i] = arr.get(i)[0] + arr.get(i)[1] + arr.get(i)[2];
        }
        // �հ踦 �ݺ������� �Ҽ� �Ǻ� �޼ҵ带 �̿��Ͽ� ī��Ʈ
        for(int i=0; i<sum.length; i++) {
        	if(prime(sum[i]) == true) {
        		answer++;
        	}
        }
        return answer;
    }
	/*
	 * �Ҽ� �Ǻ� �޼ҵ�
	 */
	public static boolean prime(int num){
        // 0 �Ǵ� 1�� �Ҽ��� �ƴ�
        if(num < 2) return false;
        // 2�� �Ҽ�
        if(num == 2) return true;
        // �׿��� ��(��Ʈ������ ���� ��������)
        for(int i = 2; i <= Math.sqrt(num); i++){
            //��Ʈ���� ������ �������� ���� ������ �Ҽ��� �ƴ�
            if(num % i == 0){
                return false;
            }
        }
        //�ȳ������� �Ҽ�
        return true;
    }
}