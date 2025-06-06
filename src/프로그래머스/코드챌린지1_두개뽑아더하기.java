package 프로그래머스;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 코드챌린지1_두개뽑아더하기 {
	/*
	문제 설명
	정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 두 개의 수를 뽑아
	더해서 만들 수 있는 모든 수를 배열에 오름차순으로 담아 return 하도록 solution 함수를 완성해주세요.

	제한사항
	numbers의 길이는 2 이상 100 이하입니다.
	numbers의 모든 수는 0 이상 100 이하입니다.
	*/
    public static int[] solution(int[] numbers) {
    	//중복을 제거하기 위한 set 선언
        Set<Integer> set = new HashSet<Integer>();
        //2개 수 뽑아서 더하기
        for(int i=0;i<numbers.length-1;i++) {
        	for(int j=i+1;j<numbers.length;j++) {
        		set.add(numbers[i]+numbers[j]);
        	}
        }
        //답을 제출한 answer 배열 선언
        int[] answer = new int[set.size()];
        //답 인덱스 선언
        int idx=0;
        //answer 배열에 set 입력
        for(Integer num:set) answer[idx++]=num;
        //정렬
        Arrays.sort(answer);
        return answer;
    }
	public static void main(String[] args) {
		int[] numbers= {2,1,3,4,1};
		for(int i:solution(numbers)) System.out.println(i);
	}

}
