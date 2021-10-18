package 프로그래머스;

import java.util.Arrays;
import java.util.PriorityQueue;

public class 힙_디스크컨트롤러 {
	/*
	각 작업에 대해 [작업이 요청되는 시점, 작업의 소요시간]을 담은 2차원 배열 jobs가 매개변수로 주어질 때,
	작업의 요청부터 종료까지 걸린 시간의 평균을 가장 줄이는 방법으로 처리하면
	평균이 얼마가 되는지 return 하도록 solution 함수를 작성해주세요.
	(단, 소수점 이하의 수는 버립니다)

	*제한 사항
	jobs의 길이는 1 이상 500 이하입니다.
	jobs의 각 행은 하나의 작업에 대한 [작업이 요청되는 시점, 작업의 소요시간] 입니다.
	각 작업에 대해 작업이 요청되는 시간은 0 이상 1,000 이하입니다.
	각 작업에 대해 작업의 소요시간은 1 이상 1,000 이하입니다.
	하드디스크가 작업을 수행하고 있지 않을 때에는 먼저 요청이 들어온 작업부터 처리합니다.
	 */
	public static int time(int start,int end) {
		return end-start;
	}
	
    public static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
        Arrays.sort(jobs, (x,y)->(x[0]-y[0])); //시작 시간이 빠른 것 부터 정렬
        
        int end = jobs[0][0]+jobs[0][1];
        answer+=end;
        for(int i=1;i<jobs.length;i++) {
        	int request = jobs[i][0];
        	//겹치면 q에 넣기
        	if(request<end) {
        		pq.add(jobs[i]);
        		continue;
        	}
        	
        	//지금 친구 정산
        	if(pq.isEmpty()) {
	    		end+=jobs[i][1];
	    		answer+=end-jobs[i][0];
        		continue;
        	}
        	
        	//안겹침
        	//이전 애들 정산
        	while(!pq.isEmpty()) {
        		int[] overlay=pq.poll();
        		end+=overlay[1];
        		answer+=end-overlay[0];
        	}
        	i--;//다시 해보기
        }
        while(!pq.isEmpty()) {
    		int[] overlay=pq.poll();
    		end+=overlay[1];
    		answer+=end-overlay[0];
    	}
        return answer/jobs.length;
    }
	
	
	public static void main(String[] args) {
		int[][] job= {{0,3},{1,9},{2,6}};
		System.out.println(solution(job));
	}

}
