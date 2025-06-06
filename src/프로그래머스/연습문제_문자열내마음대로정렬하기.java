package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;

public class 연습문제_문자열내마음대로정렬하기 {
    //https://programmers.co.kr/learn/courses/30/lessons/12915
	public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, new Comparator<String>() {
        	@Override
        	public int compare(String o1, String o2) {
        		if(o1.charAt(n)!=o2.charAt(n)) {
        			return (o1.charAt(n)+"").compareTo(o2.charAt(n)+""); //n번째 글자 비교
        		}else {
        			return o1.compareTo(o2); //같으면 바로 비교
        		}
        	}
        });
        return strings;
    }
}
