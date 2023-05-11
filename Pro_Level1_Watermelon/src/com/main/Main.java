package com.main;

public class Main {
	/*
	[문제 설명]
	길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수, solution을 완성하세요. 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
	[제한사항]
	n은 길이 10,000이하인 자연수입니다.
	[입출력 예]
	n	return
	3	"수박수"
	4	"수박수박"
	*/
	public static void main(String[] args) {
		int n1 = 3;
		int n2 = 4;
		
		System.out.print(n1+" ");
		System.out.println(solution(n1));
		System.out.print(n2+" ");
		System.out.println(solution(n2));
	}
	
	public static String solution(int n) {
        String answer = "";
        // 인덱스번호가 짝수 일때와 홀수 일때로 분기하여 "수", "박" 을 저장한다.
        for(int i=0; i<n; i++){
            if(i%2==0){
                answer += "수";
            }else{
                answer += "박";
            }
        }
        return answer;
    }
}
