package 프로그래머스;

import java.util.Arrays;
import java.util.Comparator;
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
	
	/*
	 * 전략
	 * 
	 * 작업 수행중이면 수행 시간이 짧은 걸 먼저 수행
	 * 작업 수행이 아니라면 순서대로 수행
	 */
    public static int solution(int[][] jobs) {
    	//시작 시간 빠른 순 정렬
    	Arrays.sort(jobs,(x,y)->(x[0]-y[0]));
    	//실행시간 적은 순 정렬
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
    	//시간, 인덱스, 답 초기화
    	int time =0, idx=0, answer=0;
    	//인덱스가 범위내에 있거나, pq가 비어있지 않다면 while진행
    	while(idx<jobs.length||!pq.isEmpty()) {
    		//인덱스가 범위내에 있고, 시작시간이 시간 이내라면 pq에 집어넣기
    		while(idx<jobs.length&&jobs[idx][0]<=time) {
    			pq.add(jobs[idx++]);
    		}
    		
    		//pq가 비어있다면 (시간 이내에 시작하는 task가 없다면)
    		if(pq.isEmpty()) {
    			//해당 시작 시간을 time으로 지정
    			time=jobs[idx][0];
    			continue;
    		}
    		//pq가 비어있지 않다면
    		//시간에 pq에 들어간 작은 수행시간을 더함
    		int[] job = pq.poll();
    		time+=job[1];
    		//종료 시간 - 시작시간
    		answer += time-job[0];
    	}
    	//평균시간이므로 jobs의 길이로 나눠줌
    	return answer/jobs.length;
    }	
	
	public static void main(String[] args) {
		int[][] job= {{0,3},{1,9},{2,6}};//28
		System.out.println(solution(job));
		int[][] job2= {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};//72
		//System.out.println(solution(job2));
		int[][] job3= {{24, 10}, {28, 39}, {43, 20}, {37, 5}, {47, 22}, {20, 47}, {15, 2}, {15, 34}, {35, 43}, {26, 1}};//72
		//System.out.println(solution(job3));
	}

}
