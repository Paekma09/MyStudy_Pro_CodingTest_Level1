package com.main;

import java.util.Arrays;

public class Main {
	/*
	[문제 설명]
	로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다. 
	아래는 로또의 순위를 정하는 방식입니다.
	순위		당첨 내용
	1			6개 번호가 모두 일치
	2			5개 번호가 일치
	3			4개 번호가 일치
	4			3개 번호가 일치
	5			2개 번호가 일치
	6(낙첨)	그 외
	로또를 구매한 민우는 당첨 번호 발표일을 학수고대하고 있었습니다. 
	하지만, 민우의 동생이 로또에 낙서를 하여, 일부 번호를 알아볼 수 없게 되었습니다. 
	당첨 번호 발표 후, 민우는 자신이 구매했던 로또로 당첨이 가능했던 최고 순위와 최저 순위를 알아보고 싶어 졌습니다.
	알아볼 수 없는 번호를 0으로 표기하기로 하고, 민우가 구매한 로또 번호 6개가 44, 1, 0, 0, 31 25라고 가정해보겠습니다. 
	당첨 번호 6개가 31, 10, 45, 1, 6, 19라면, 당첨 가능한 최고 순위와 최저 순위의 한 예는 아래와 같습니다.
	당첨 번호			31		10			45		1	6		19		결과
	최고 순위 번호	31		0→10		44		1	0→6	25		4개 번호 일치, 3등
	최저 순위 번호	31		0→11		44		1	0→7	25		2개 번호 일치, 5등
		순서와 상관없이, 구매한 로또에 당첨 번호와 일치하는 번호가 있으면 맞힌 걸로 인정됩니다.
		알아볼 수 없는 두 개의 번호를 각각 10, 6이라고 가정하면 3등에 당첨될 수 있습니다.
			3등을 만드는 다른 방법들도 존재합니다. 하지만, 2등 이상으로 만드는 것은 불가능합니다.
		알아볼 수 없는 두 개의 번호를 각각 11, 7이라고 가정하면 5등에 당첨될 수 있습니다.
			5등을 만드는 다른 방법들도 존재합니다. 하지만, 6등(낙첨)으로 만드는 것은 불가능합니다.
	민우가 구매한 로또 번호를 담은 배열 lottos, 당첨 번호를 담은 배열 win_nums가 매개변수로 주어집니다. 
	이때, 당첨 가능한 최고 순위와 최저 순위를 차례대로 배열에 담아서 return 하도록 solution 함수를 완성해주세요.
	[제한사항]
	lottos는 길이 6인 정수 배열입니다.
	lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
		0은 알아볼 수 없는 숫자를 의미합니다.
		0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
		lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
	win_nums은 길이 6인 정수 배열입니다.
	win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
		win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
		win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.
	[입출력 예]
	lottos						win_nums							result
	[44, 1, 0, 0, 31, 25]	[31, 10, 45, 1, 6, 19]		[3, 5]
	[0, 0, 0, 0, 0, 0]		[38, 19, 20, 40, 15, 25]		[1, 6]
	[45, 4, 35, 20, 3, 9]	[20, 9, 3, 45, 4, 35]			[1, 1]
	[입출력 예 설명]
	입출력 예 #1
		문제 예시와 같습니다.
	입출력 예 #2
		알아볼 수 없는 번호들이 아래와 같았다면, 1등과 6등에 당첨될 수 있습니다.
		당첨 번호			38			19			20			40			15			25			결과
		최고 순위 번호	0→38		0→19		0→20		0→40		0→15		0→25		6개 번호 일치, 1등
		최저 순위 번호	0→21		0→22		0→23		0→24		0→26		0→27		0개 번호 일치, 6등
	입출력 예 #3
		민우가 구매한 로또의 번호와 당첨 번호가 모두 일치하므로, 최고 순위와 최저 순위는 모두 1등입니다.
	*/
	public static void main(String[] args) {
		int[] lottos1 = {44, 1, 0, 0, 31, 25};
		int[] win_nums1 = {31, 10, 45, 1, 6, 19};
		int[] lottos2 = {0, 0, 0, 0, 0, 0};
		int[] win_nums2 = {38, 19, 20, 40, 15, 25};
		int[] lottos3 = {45, 4, 35, 20, 3, 9};
		int[] win_nums3 = {20, 9, 3, 45, 4, 35};
		
		System.out.println(Arrays.toString(lottos1)+" "+Arrays.toString(win_nums1));
		System.out.println(Arrays.toString(solution(lottos1, win_nums1)));
		System.out.println(Arrays.toString(lottos2)+" "+Arrays.toString(win_nums2));
		System.out.println(Arrays.toString(solution(lottos2, win_nums2)));
		System.out.println(Arrays.toString(lottos3)+" "+Arrays.toString(win_nums3));
		System.out.println(Arrays.toString(solution(lottos3, win_nums3)));
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // 비교의 효율성을 올리기 위해 두 배열 모두 같은 조건으로 정렬해준다.
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        // 같은 수의 갯수 저장 뱐수 선언 및 초기화
        int eq = 0;
        // 로또에서 지워진 수의 갯수 저장 변수 선언 및 초기화
        int zero = 0;
        // 지워진 수의 갯수 구하기, 로또와 수가 같은 수의 갯수 구하기(break 중요)
        for(int i=0; i<lottos.length; i++) {
        	if(lottos[i] == 0) {
        		zero++;
        	}
        	for(int j=0; j<win_nums.length; j++) {
        		if(lottos[i] == win_nums[j]) {
        			eq++;
        			break;
        		}
        	}
        }
        // 로또와 맞은 수의 갯수를 최대화, 치소화 시킨 갯수 저장할 배열 선언 및 값 저장
        // 최대값은 맞은 갯수와 0의 갯수를 합친것이고 최소값은 맞은 갯수와 같다.
        int[] temp = {zero+eq, eq};
        // 배열이므로 for문과 switch문으로 등수를 answer배열에 저장한다.
        for(int i=0; i<temp.length; i++) {
        	switch (temp[i]) {
    		case 6:
    			answer[i] = 1;
    			break;
    		case 5:
    			answer[i] = 2;
    			break;
    		case 4:
    			answer[i] = 3;
    			break;
    		case 3:
    			answer[i] = 4;
    			break;
    		case 2:
    			answer[i] = 5;
    			break;
    		default:
    			answer[i] = 6;
    			break;
    		}
        }
        return answer;
    }
}
