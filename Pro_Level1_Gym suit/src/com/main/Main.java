package com.main;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	/*
	[문제 설명]
	점심시간에 도둑이 들어, 일부 학생이 체육복을 도난당했습니다. 
	다행히 여벌 체육복이 있는 학생이 이들에게 체육복을 빌려주려 합니다. 
	학생들의 번호는 체격 순으로 매겨져 있어, 바로 앞번호의 학생이나 바로 뒷번호의 학생에게만 체육복을 빌려줄 수 있습니다. 
	예를 들어, 4번 학생은 3번 학생이나 5번 학생에게만 체육복을 빌려줄 수 있습니다. 
	체육복이 없으면 수업을 들을 수 없기 때문에 체육복을 적절히 빌려 최대한 많은 학생이 체육수업을 들어야 합니다.
	전체 학생의 수 n, 체육복을 도난당한 학생들의 번호가 담긴 배열 lost, 
	여벌의 체육복을 가져온 학생들의 번호가 담긴 배열 reserve가 매개변수로 주어질 때, 
	체육수업을 들을 수 있는 학생의 최댓값을 return 하도록 solution 함수를 작성해주세요.
	[제한사항]
	전체 학생의 수는 2명 이상 30명 이하입니다.
	체육복을 도난당한 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌의 체육복을 가져온 학생의 수는 1명 이상 n명 이하이고 중복되는 번호는 없습니다.
	여벌 체육복이 있는 학생만 다른 학생에게 체육복을 빌려줄 수 있습니다.
	여벌 체육복을 가져온 학생이 체육복을 도난당했을 수 있습니다. 
	이때 이 학생은 체육복을 하나만 도난당했다고 가정하며, 남은 체육복이 하나이기에 다른 학생에게는 체육복을 빌려줄 수 없습니다.
	[입출력 예]
	n	lost		reserve		return
	5	[2, 4]	[1, 3, 5]	5
	5	[2, 4]	[3]			4
	3	[3]		[1]			2
	[입출력 예 설명]
	입출력 예 #1
		1번 학생이 2번 학생에게 체육복을 빌려주고, 3번 학생이나 5번 학생이 4번 학생에게 체육복을 빌려주면 
		학생 5명이 체육수업을 들을 수 있습니다.
	입출력 예 #2
		3번 학생이 2번 학생이나 4번 학생에게 체육복을 빌려주면 학생 4명이 체육수업을 들을 수 있습니다.
	*/
	public static void main(String[] args) {
		int n1 = 5;
		int[] lost1 = {2, 4};
		int[] reserve1 = {1, 3, 5};
		int n2 = 5;
		int[] lost2 = {2, 4};
		int[] reserve2 = {3};
		int n3 = 3;
		int[] lost3 = {3};
		int[] reserve3 = {1};
		int n4=5; 
		int[] lost4 = {4, 2}; 
		int[] reserve4 = {3, 5};
		
		System.out.println(n1+" "+Arrays.toString(lost1)+" "+Arrays.toString(reserve1));
		System.out.println(solution(n1, lost1, reserve1));
		System.out.println(n2+" "+Arrays.toString(lost2)+" "+Arrays.toString(reserve2));
		System.out.println(solution(n2, lost2, reserve2));
		System.out.println(n3+" "+Arrays.toString(lost3)+" "+Arrays.toString(reserve3));
		System.out.println(solution(n3, lost3, reserve3));
		System.out.println(n4+" "+Arrays.toString(lost4)+" "+Arrays.toString(reserve4));
		System.out.println(solution(n4, lost4, reserve4));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 문제에 주어지는 배열들이 정렬되어있다는 언급이 없으므로 정렬부터 시켜준다.
        Arrays.sort(lost);
        Arrays.sort(reserve);
        // 여분이 있는데 도난당한 경우 lost, reserve 모두에게서 삭제 되어 져야한다.
        // 그러므로 두 배열 모두 List로 변환 해 준다.
        List<Integer> lostList = Arrays.stream(lost).boxed().collect(Collectors.toList());
        List<Integer> reserveList = Arrays.stream(reserve).boxed().collect(Collectors.toList());
        // 염두 해야 할 것은 List는 앞에서부터 for문을 돌경우 요소를 삭제 했을때 사이즈의 변동으로 잘못된 결과가 나올 수 있다.
        // 그러므로 뒤에서부터 for문을 돌린다. (당연히 정렬이 되어 있다는 가정하에...)
        for(int i=lostList.size()-1; i>=0; i--) {
        	for(int j=reserveList.size()-1; j>=0; j--) {
        		if(lostList.get(i) == reserveList.get(j)) {
        			lostList.remove(i);
        			reserveList.remove(j);
        			break;
        		}
        	}
        }
        // 위에서와 같은 이유로 뒤에서부터 for문을 돌리며, 여벌이 있는 학생이 먼저 1 앞 번호의 학생에게 빌려주고
        // 없을 시에는 1 뒤 번호의 학생에게 빌려준다.
        // 둘다 없을 경우는 빌려 줄 수 없다.
        for(int i=reserveList.size()-1; i>=0; i--) {
        	for(int j=lostList.size()-1; j>=0; j--) {
        		if(reserveList.get(i) - lostList.get(j) == 1 ) {
        			lostList.remove(j);
        			break;
        		}else if(lostList.get(j) - reserveList.get(i) == 1) {
        			lostList.remove(j);
        			break;
        		}
        	}
        }
        // 전체 학생 수에서 도둑맞은 학생 중 빌려입지 못한 남은 학생수를 빼주면 answer가 나온다.
        answer = n - lostList.size();
        System.out.println();
        return answer;
    }
}
