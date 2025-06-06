package 프로그래머스;

import java.util.Arrays;

public class 카카오_외벽점검 {
	//https://programmers.co.kr/learn/courses/30/lessons/60062;
	//https://www.youtube.com/watch?v=LtPYdZbJlzk 공부한 내용임
	//최소값 구하기 -> 1개를 수행하고, 방문여부 체크 // 2번째 수행시 방문한 곳 패쓰한 재귀 실행, 답의 최대값을 넘을시 브레이크
	
	static final int INF  = Integer.MAX_VALUE;
	static int[] Dist;
	static int[] Weak;
	static int N;
	static int Answer;
	
	static void search(int count, int position, int visited) {
		if(count>Dist.length||count>=Answer) return;
		
		for(int i=0;i<Weak.length;i++) {
			int next = (position+i)%Weak.length;
			int diff = Weak[next]-Weak[position];
			//거리가 음수면 n 더하기
			if(diff<0) diff+=N;
			//두 번째 큰 수
			if(diff>Dist[Dist.length-count]) break;
			//방문여부 확인
			visited|=1<<next;
		}
		//모든점 방문시 답 변경
		if(visited==(1<<Weak.length)-1) {
			Answer=count;
			return;
		}
		for(int i=0;i<Weak.length;i++) {
			//방문한 곳 패쓰
			if((visited&(1<<i))!=0) continue;
			//재귀
			search(count+1,i,visited);
		}
	}
	
    public static int solution(int n, int[] weak, int[] dist) {
        Answer=INF;
    	N=n;
        Arrays.sort(dist);
        Dist=dist;
        Weak=weak;
        
        for(int i=0;i<weak.length;i++) {
        	search(1, i, 0); //갯수, 시작점, 방문여부
        }
        return Answer==INF?-1:Answer;
    }
    
	public static void main(String[] args) {
		int n = 12;
//		int[] weak = {1,5,6,10};
//		int[] dist= {1,2,3,4};
//		System.out.println(solution(n, weak, dist));
//		int[] weak2 = {1, 3, 4, 9, 10};
//		int[] dist2= {3,5,7};
//		System.out.println(solution(n, weak2, dist2));
		n=200;
		int[] weak3 = {0, 10, 50, 80, 120, 160};
		int[] dist3= {1, 10, 5, 40, 30};
		System.out.println(solution(n, weak3, dist3)); //3
		
	}

}
