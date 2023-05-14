package com.main;

public class Main {
	/*
	[문제 설명]
	양의 정수 x가 하샤드 수이려면 x의 자릿수의 합으로 x가 나누어져야 합니다. 
	예를 들어 18의 자릿수 합은 1+8=9이고, 18은 9로 나누어 떨어지므로 18은 하샤드 수입니다. 
	자연수 x를 입력받아 x가 하샤드 수인지 아닌지 검사하는 함수, solution을 완성해주세요.
	[제한사항]
	x는 1 이상, 10000 이하인 정수입니다.
	[입출력 예]
	x		return
	10		true
	12		true
	11		false
	13		false
	[입출력 예 설명]
	입출력 예 #1
		10의 모든 자릿수의 합은 1입니다. 10은 1로 나누어 떨어지므로 10은 하샤드 수입니다.
	입출력 예 #2
		12의 모든 자릿수의 합은 3입니다. 12는 3으로 나누어 떨어지므로 12는 하샤드 수입니다.
	입출력 예 #3
		11의 모든 자릿수의 합은 2입니다. 11은 2로 나누어 떨어지지 않으므로 11는 하샤드 수가 아닙니다.
	입출력 예 #4
		13의 모든 자릿수의 합은 4입니다. 13은 4로 나누어 떨어지지 않으므로 13은 하샤드 수가 아닙니다.
	*/
	public static void main(String[] args) {
		int x1 = 10;
		int x2 = 12;
		int x3 = 11;
		int x4 = 13;
		
		System.out.print(x1+" ");
		System.out.println(solution(x1));
		System.out.print(x2+" ");
		System.out.println(solution(x2));
		System.out.print(x3+" ");
		System.out.println(solution(x3));
		System.out.print(x4+" ");
		System.out.println(solution(x4));
	}
	
	public static boolean solution(int x) {
        boolean answer = true;
        // x를 String으로 변환
        String str = String.valueOf(x);
        // str을 한 문자와 공백으로 구분하여 저장
        String temp = "";
        for(int i=0; i<str.length(); i++) {
        	temp += str.charAt(i)+" ";
        }
        // String을 String 배열로 변환
        String[] strArr = temp.split(" ");
        // String배열을 int배열로 변환
        int[] arr = new int[strArr.length];
        for(int i=0; i<arr.length; i++) {
        	arr[i] = Integer.parseInt(strArr[i]);
        }
        // arr배열의 각 요소의 총 합 구하기
        int sum = 0;
        for(int i=0; i<arr.length; i++) {
        	sum += arr[i];
        }
        // x를 총합으로 나누었을때 나누어떨어지는지 여부 확인 하여 answer값 분기
        if(x%sum == 0) {
        	answer = true;
        }else {
        	answer = false;
        }
        return answer;
    }
}
