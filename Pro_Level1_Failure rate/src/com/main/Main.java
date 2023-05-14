package com.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	/*
	[문제 설명]
	슈퍼 게임 개발자 오렐리는 큰 고민에 빠졌다. 그녀가 만든 프랜즈 오천성이 대성공을 거뒀지만, 요즘 신규 사용자의 수가 급감한 것이다. 
	원인은 신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것이 문제였다.
	이 문제를 어떻게 할까 고민 한 그녀는 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다. 
	역시 슈퍼 개발자라 대부분의 로직은 쉽게 구현했지만, 실패율을 구하는 부분에서 위기에 빠지고 말았다. 
	오렐리를 위해 실패율을 구하는 코드를 완성하라.
		실패율은 다음과 같이 정의한다.
			스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
	전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages가 매개변수로 주어질 때, 
	실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.
	[제한사항]
	스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
	stages의 길이는 1 이상 200,000 이하이다.
	stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
		각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
		단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
	만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
	스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.
	[입출력 예]
	N	stages							result
	5	[2, 1, 2, 6, 2, 4, 3, 3]	[3,4,2,1,5]
	4	[4,4,4,4,4]					[4,1,2,3]
	[입출력 예 설명]
	입출력 예 #1
		1번 스테이지에는 총 8명의 사용자가 도전했으며, 이 중 1명의 사용자가 아직 클리어하지 못했다. 
		따라서 1번 스테이지의 실패율은 다음과 같다.
			1 번 스테이지 실패율 : 1/8
		2번 스테이지에는 총 7명의 사용자가 도전했으며, 이 중 3명의 사용자가 아직 클리어하지 못했다. 
		따라서 2번 스테이지의 실패율은 다음과 같다.
			2 번 스테이지 실패율 : 3/7
		마찬가지로 나머지 스테이지의 실패율은 다음과 같다.
			3 번 스테이지 실패율 : 2/4
			4번 스테이지 실패율 : 1/2
			5번 스테이지 실패율 : 0/1
		각 스테이지의 번호를 실패율의 내림차순으로 정렬하면 다음과 같다.
			[3,4,2,1,5]
	입출력 예 #2
		모든 사용자가 마지막 스테이지에 있으므로 4번 스테이지의 실패율은 1이며 나머지 스테이지의 실패율은 0이다.
			[4,1,2,3]
	*/
	public static void main(String[] args) {
		int N1 = 5;
		int[] stages1 = {2, 1, 2, 6, 2, 4, 3, 3};
		int N2 = 4;
		int[] stages2 = {4, 4, 4, 4, 4};
		
		System.out.println("입력값 : "+N1+" "+Arrays.toString(stages1));
		System.out.println("출력값 : "+Arrays.toString(solution(N1, stages1)));
		System.out.println("입력값 : "+N2+" "+Arrays.toString(stages2));
		System.out.println("출력값 : "+Arrays.toString(solution(N2, stages2)));
	}
	
	public static int[] solution(int N, int[] stages) {
		// answer와 stageNumber 모두 길이는 N이다.
		int[] answer = new int[N];
		int[] stageNumber = new int[N];
        // 실패율을 담아 줄 Double형 List를 생성
        List<Double> fail = new ArrayList<>();
        // stageNumber배열을 채워준다.
        for(int i=1; i<=N; i++) {
        	stageNumber[i-1] = i;
        }
        // count 배열은 현재 스테이지별로 머물고 있는 사람 수를 카운팅하여 배열에 넣는다.
        int[] count = new int[N];
        for(int i=0; i<stageNumber.length; i++) {
        	for(int j=0; j<stages.length; j++) {
        		if(stageNumber[i] == stages[j]) {
        			count[i]++;
        		}
        	}
        }
        // 총 사람 수는 stages의 길이와 같다.
        int people = stages.length;
        // 해당 스테이지에 머물고 있는 사람이 있을 경우 반드시 double형으로 실패율 계산한다.
        // 또한, 총 사람수를 현재 계산된 사람을 제외해야한다.
        for(int i=0; i<count.length; i++) {
        	if(count[i] != 0) {
        		fail.add((double)count[i] / people);  
        		people = people - count[i];
        	}else {
        		fail.add(0.0);
        	}
        }
        // 실패율과 해당 스테이즈 번호를 매치하여 저장할 Map을 생성한다.
        Map<Integer, Double> map = new HashMap<>();
        for(int i=0; i<fail.size(); i++) {
        	map.put(i+1, fail.get(i));
        }
        // Map의 keySet을 가져올 ArrayList를 생성한다.
        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        // Value값으로 내림차순 정렬한다.
        Collections.sort(list, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        // keySet이 저장되어 있는 list에서 key값을 가져와 answer배열에 넣어준다.
        int cnt = 0;
        for(int key : list) {
        	answer[cnt] = key;
        	cnt++;
        }
        return answer;
    }
}
