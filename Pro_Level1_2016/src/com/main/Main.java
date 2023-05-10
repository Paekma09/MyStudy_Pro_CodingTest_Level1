package com.main;

public class Main {
	/*
	[문제 설명]
	2016년 1월 1일은 금요일입니다. 
	2016년 a월 b일은 무슨 요일일까요? 두 수 a ,b를 입력받아 2016년 a월 b일이 무슨 요일인지 리턴하는 함수, solution을 완성하세요. 
	요일의 이름은 일요일부터 토요일까지 각각 SUN,MON,TUE,WED,THU,FRI,SAT입니다. 
	예를 들어 a=5, b=24라면 5월 24일은 화요일이므로 문자열 "TUE"를 반환하세요.
	[제한사항]
	2016년은 윤년입니다.
	2016년 a월 b일은 실제로 있는 날입니다. (13월 26일이나 2월 45일같은 날짜는 주어지지 않습니다)
	[입출력 예]
	a	b		result
	5	24		"TUE"
	*/
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		System.out.print(a+" "+b+" \n");
		System.out.println(solution(a, b));
	}
	
	public static String solution(int a, int b) {
        String answer = "";
        // 요일을 넣은 배열 생성(1월 1일이 금요일이므로 금요일 부터 저장)
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        // 월의 날짜수를 넣은 배열 생성(1월이므로 1월부터 12월까지 저장)
        int[] month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        // 1월1일부터 해당 날까지의 일수 저장할 변수 선언
        int date = 0;
        // 1월부터 a월까지 이므로 a월 이전까지 반복하며 날짜수를 더해준다.
        for(int i=0; i<a-1; i++) {
        	date += month[i];
        }
        // date에 b일까지이므로 b를 더해주고 -1을 해 준다.
        date += b - 1;
        // 요일 배열에서 7로 나눈 나머지 인덱스 요일이다.
        answer = day[date%7];
        return answer;
    }

}
