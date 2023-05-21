package com.main;

import java.util.ArrayList;
import java.util.List;

public class Main {
	/*
	[문제 설명]
	숫자로 이루어진 문자열 t와 p가 주어질 때, t에서 p와 길이가 같은 부분문자열 중에서, 이 부분문자열이 나타내는 수가 
	p가 나타내는 수보다 작거나 같은 것이 나오는 횟수를 return하는 함수 solution을 완성하세요.
	예를 들어, t="3141592"이고 p="271" 인 경우, t의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592입니다. 
	이 문자열이 나타내는 수 중 271보다 작거나 같은 수는 141, 159 2개 입니다.
	[제한사항]
	1 ≤ p의 길이 ≤ 18
	p의 길이 ≤ t의 길이 ≤ 10,000
	t와 p는 숫자로만 이루어진 문자열이며, 0으로 시작하지 않습니다.
	[입출력 예]
	t							p			result
	"3141592"				"271"	2
	"500220839878"	"7"		8
	"10203"				"15"		3
	[입출력 예 설명]
	입출력 예 #1
		본문과 같습니다.
	입출력 예 #2
		p의 길이가 1이므로 t의 부분문자열은 "5", "0", 0", "2", "2", "0", "8", "3", "9", "8", "7", "8"이며 
		이중 7보다 작거나 같은 숫자는 "5", "0", "0", "2", "2", "0", "3", "7" 이렇게 8개가 있습니다.
	입출력 예 #3
		p의 길이가 2이므로 t의 부분문자열은 "10", "02", "20", "03"이며, 이중 15보다 작거나 같은 숫자는 "10", "02", "03" 이렇게 3개입니다. 
		"02"와 "03"은 각각 2, 3에 해당한다는 점에 주의하세요
	*/
	public static void main(String[] args) {
		String t1 = "3141592";
		String p1 = "271";
		String t2 = "500220839878";
		String p2 = "7";
		String t3 = "10203";
		String p3 = "15";
		
		System.out.print(t1+" "+p1+" \n");
		System.out.println(solution(t1, p1));
		System.out.print(t2+" "+p2+" \n");
		System.out.println(solution(t2, p2));
		System.out.print(t3+" "+p3+" \n");
		System.out.println(solution(t3, p3));
	}
	
	public static int solution(String t, String p) {
        int answer = 0;
        // p의 길이를 변수에 저장
        int length = p.length();
        // 길이가 유동적인 배열이 나오기 때문에 List생성
        List<String> list = new ArrayList<>();
        // t문자열을 처음부터 이동하며 p의 길이로 잘라서 list에 저장한다. 
        for(int i=0; i<t.length()-length+1; i++) {
        	list.add(t.substring(i, length+i));
        }
        // list에 요소값들과 p의 값을 비교하여 answer에 카운팅
        for(int i=0; i<list.size(); i++) {
        	if(Long.parseLong(list.get(i)) <= Long.parseLong(p)) {
        		answer++;
        	}
        }
        return answer;
    }

}
