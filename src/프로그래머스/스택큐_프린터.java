package 프로그래머스;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class 스택큐_프린터 {


	/*
	1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	3. 그렇지 않으면 J를 인쇄합니다.
	
	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.
	현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와
	내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요. 
	
	제한사항
	
	현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
	인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
	location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
	 */
    public static int solution(int[] priorities, int location) {
        Queue<int[]> q = new LinkedList<>(); //큐 선언
        //높은 우선순위 먼저 출력되는 pq
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((x,y)->y-x);
        
        for(int i=0;i<priorities.length;i++) {
        	q.add(new int[] {i,priorities[i]}); //index와 우선순위를 q에 넣기
        	pq.add(priorities[i]); //우선순위 pq에 넣기
        }
        
        int order=1; //순서 기본값
        
        while(!q.isEmpty()) {
        	int[] now = q.poll(); //q의 맨 처음
        	int idx=now[0];
        	int priority = now[1];
        	if(priority<pq.peek()) { //pq의 맨 처음(우선순위 최대치) 값보다 작으면
        		q.add(now); //q의 맨 뒤에 다시 넣기
        		continue;
        	}
        	//여기까지 오면 현재 우선순위 = 우선순위 최대치
        	pq.poll(); //pq에서 최우선순위 삭제
        	if(idx==location) return order; //만약 찾고자 하는 위치일 경우 return
        	order++; //순서 증가
        }
    	return -1;
    }
	
	
	public static void main(String[] args) {
		List<int[][]> list = new ArrayList<>();
		list.add(new int[][]{{2, 1, 3, 2}, {2}});
		list.add(new int[][] {{1, 1, 9, 1, 1, 1},{0}});
		list.add(new int[][] {{1, 1, 9, 1, 1, 1},{2}});
		for(int[][] question:list) {
			System.out.println(solution(question[0], question[1][0]));
		}
	}

}
