package 프로그래머스;

import java.util.Arrays;

public class 썸머윈터_예산 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/12982?language=java
	
    public static int solution(int[] d, int budget) {
        int sum=0;
        int answer=0;
        Arrays.sort(d);
        for(int i=0;i<d.length;i++){
            sum+=d[i];
            if(sum>budget) break;
            answer++;
        }
        return answer;
    }
    public static void main(String[] args) {
		int[][] dd = {{1,3,2,5,4},{2,2,3,3}};
		int[] bg = {9,10};
		//3,4
		for(int i=0;i<dd.length;i++) System.out.println(solution(dd[i], bg[i]));
	}
}
