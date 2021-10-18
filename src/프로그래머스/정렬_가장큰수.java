package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 정렬_가장큰수 {
	/*
	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
	순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
	return 하도록 solution 함수를 작성해주세요.

	제한 사항
	numbers의 길이는 1 이상 100,000 이하입니다.
	numbers의 원소는 0 이상 1,000 이하입니다.
	정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	입출력 예
	 */
	
	
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder(); //답 조합을 위한 스트링 빌더 선언
        //스트링 배열로 변환
        String[] sArr= new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	sArr[i]=numbers[i]+"";//
        }
        //정렬
        Arrays.sort(sArr, new Comparator<String>(){
        	//compareTo는 스트링도 가능
        	@Override
        	public int compare(String o1, String o2) {
        		return (o2+o1).compareTo(o1+o2);
        	}
        });
        //0으로 시작하면 0으로 리턴
        if(sArr[0].equals("0")) return "0";
        //답 제출
        for(String s:sArr) {
        	sb.append(s);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int	[][] questions= {{6,10,2},{3,30,34,5,9}};
		for(int[] question:questions) {
			System.out.println(solution(question));
		}
	}
}
