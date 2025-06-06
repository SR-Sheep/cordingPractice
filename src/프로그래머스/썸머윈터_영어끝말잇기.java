package 프로그래머스;

import java.util.HashMap;

public class 썸머윈터_영어끝말잇기 {
	//https://programmers.co.kr/learn/courses/30/lessons/12981
	/*
	문제 설명
	1부터 n까지 번호가 붙어있는 n명의 사람이 영어 끝말잇기를 하고 있습니다. 영어 끝말잇기는 다음과 같은 규칙으로 진행됩니다.

	1번부터 번호 순서대로 한 사람씩 차례대로 단어를 말합니다.
	마지막 사람이 단어를 말한 다음에는 다시 1번부터 시작합니다.
	앞사람이 말한 단어의 마지막 문자로 시작하는 단어를 말해야 합니다.
	이전에 등장했던 단어는 사용할 수 없습니다.
	한 글자인 단어는 인정되지 않습니다.
	
	사람의 수 n과 사람들이 순서대로 말한 단어 words 가 매개변수로 주어질 때,
	가장 먼저 탈락하는 사람의 번호와 그 사람이 자신의 몇 번째 차례에 탈락하는지를 구해서 return 하도록 solution 함수를 완성해주세요.

	제한 사항
	끝말잇기에 참여하는 사람의 수 n은 2 이상 10 이하의 자연수입니다.
	words는 끝말잇기에 사용한 단어들이 순서대로 들어있는 배열이며, 길이는 n 이상 100 이하입니다.
	단어의 길이는 2 이상 50 이하입니다.
	모든 단어는 알파벳 소문자로만 이루어져 있습니다.
	끝말잇기에 사용되는 단어의 뜻(의미)은 신경 쓰지 않으셔도 됩니다.
	정답은 [ 번호, 차례 ] 형태로 return 해주세요.
	만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
	
	*/
	
	public static int[] solution(int n, String[] words) {
        int[] answer = new int[]{0,0}; //답을 저장할 배열 선언, 0,0 초기화
        HashMap<String, Integer> map = new HashMap<>(); //결과를 저정할 해쉬맵 선언
        map.put(words[0],1); //맨 처음 단어를 맵에 입력
        char beforeLastChar = words[0].charAt(words[0].length()-1); //전 단어의 마지막 문자
        for(int i=1;i<words.length;i++){ //탐색
        	//전 단어의 마지막 문자가 다음 단어 첫문자와 일치하고, 맵에 존재하지 않는다면
            if(beforeLastChar == words[i].charAt(0)&&map.get(words[i])==null){ 
                //마지막 문자 업데이트
            	beforeLastChar=words[i].charAt(words[i].length()-1);
                //맵에 해당 단어 추가
            	map.put(words[i],1);
            //마지막 문자가 다음 첫글자와 일치하지 않거나(끝말잇기 위배)
        	//맵에 존재하는 단어라면(이전에 나온 단어)
            }else{
            	//번호(자신 번호)
                answer[0]=i%n +1;
                //차례(바퀴 수)
                answer[1]=i/n +1;
                break;
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		int num = 3;
		String[][] words= {{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"},
				{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"},
				{"hello", "one", "even", "never", "now", "world", "draw"}};
		int[] n = {3,5,2}; //(3,3) , (0,0) , (1,3)
		for(int i=0;i<num;i++) {
			for(int j:solution(n[i], words[i])) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
		
		
	}
}
