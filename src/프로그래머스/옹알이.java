package 프로그래머스;

public class 옹알이 {
	//https://school.programmers.co.kr/learn/courses/30/lessons/120956
    public static int solution(String[] babbling) {
        int answer = 0;
        String regex = "[0-9]+"; //정규표현식, 숫자만 가능
        String[] langs = {"aya", "ye", "woo", "ma"}; //아기가 할 수 있는 언어
        //단어 탐색
        for(String word:babbling){
            for(String lang:langs){
                word = word.replaceAll(lang,"1"); //아기가 할 수 있는 언어라면 숫자로 변환
            }
            if(word.matches(regex)) answer++; //모두 숫자라면 답 증가
        }
        //답 출력
        return answer;
    }
}
