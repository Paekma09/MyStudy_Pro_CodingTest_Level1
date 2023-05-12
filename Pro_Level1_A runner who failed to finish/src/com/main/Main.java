package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
	완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	[제한사항]
	마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다.
	completion의 길이는 participant의 길이보다 1 작습니다.
	참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다.
	참가자 중에는 동명이인이 있을 수 있습니다.
	[입출력 예]
	participant															completion											return
	["leo", "kiki", "eden"]											["eden", "kiki"]										"leo"
	["marina", "josipa", "nikola", "vinko", "filipa"]		["josipa", "filipa", "marina", "nikola"]		"vinko"
	["mislav", "stanko", "mislav", "ana"]					["stanko", "ana", "mislav"]					"mislav"
	[입출력 예 설명]
	입출력 예 #1
		"leo"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
	입출력 예 #2
		"vinko"는 참여자 명단에는 있지만, 완주자 명단에는 없기 때문에 완주하지 못했습니다.
	입출력 예 #3
		"mislav"는 참여자 명단에는 두 명이 있지만, 완주자 명단에는 한 명밖에 없기 때문에 한명은 완주하지 못했습니다.
	*/
	public static void main(String[] args) {
		String[] participant1 = {"leo", "kiki", "eden"};
		String[] competion1 = {"eden", "kiki"};
		String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
		String[] competion2 = {"josipa", "filipa", "marina", "nikola"};
		String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
		String[] competion3 = {"stanko", "ana", "mislav"};
		
		System.out.println(Arrays.toString(participant1)+" "+Arrays.toString(competion1));
		System.out.println(solution(participant1, competion1));
		System.out.println(Arrays.toString(participant2)+" "+Arrays.toString(competion2));
		System.out.println(solution(participant2, competion2));
		System.out.println(Arrays.toString(participant3)+" "+Arrays.toString(competion3));
		System.out.println(solution(participant3, competion3));
	}
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        // 시간 복잡도의 효율성을 올리기 위해 각 배열 같은 조건으로 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        // 완주자 배열을 기준으로 반복문을 돌며 값이 다르면 answer에 저장
        for(int i=0; i<completion.length; i++) {
        	if(!completion[i].equals(participant[i])) {
        		answer = participant[i];
        		break;
        	}
        }
        // 만약 answer에 값이 저장 되어 있지 않으면 answer는 참가자의 마지막 인덱스이다.
        if(answer.equals("")) {
        	answer = participant[participant.length-1];
        }
        return answer;
    }
}
