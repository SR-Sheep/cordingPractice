package 프로그래머스;

import java.util.Arrays;

public class 탐욕법_구명보트 {
    public static int solution(int[] people, int limit) {
        //운행 횟수
    	int count=0;
    	//정렬
    	Arrays.sort(people);
    	int idx=0;
    	//역순(큰거부터)
        for(int i=people.length-1;i>-1;i--) {
        	if(idx==i) {
        		count++;
        		break;
        	}else if(idx>i){
        		break;
        	}
        	int heavy =people[i];
        	int light =people[idx];
        	if(heavy+light<=limit) idx++;
        	count++;
        }
        return count;
    }
	
	public static void main(String[] args) {
		int[] p = {70,50,80,50};
		int limit = 100;
		System.out.println(solution(p, limit));
	}
}
