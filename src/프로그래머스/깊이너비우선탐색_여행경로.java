package 프로그래머스;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 깊이너비우선탐색_여행경로 {
	
	static class Airplane{
		private String land;
		private boolean[] visited;
		private Stack<String> route;
		private int count;
		
		public Airplane(String l, boolean[] v, Stack<String> r, int count) {
			this.land=l;
			this.visited=Arrays.copyOf(v, v.length);
			this.route=(Stack<String>)r.clone();
			this.route.add(l);
			this.count=count;
		}

		public String getLand() {
			return land;
		}

		public void setLand(String land) {
			this.land = land;
		}

		public boolean[] getVisited() {
			return visited;
		}

		public void setVisited(boolean[] visited) {
			this.visited = visited;
		}
		
		public Stack<String> getRoute() {
			return route;
		}

		public void setRoute(Stack<String> route) {
			this.route = route;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		@Override
		public String toString() {
			return land+" "+route;
		}
		
	}
	
	
    public static String[] solution(String[][] tickets) {
    	String[] answer= {};
    	//도착지 기준 알파벳 순 정렬
        Arrays.sort(tickets,(x,y)->x[1].compareTo(y[1]));
        //방문 여부 표시
        boolean[] visited=new boolean[tickets.length];
        //큐 선언
        Queue<Airplane> q = new LinkedList<>();
        //스택 선언, Airplane 클래스에서 사용
        Stack<String> stack = new Stack<String>();
        //시작점을 stack에 넣기
        stack.add("ICN");
        //시작이 ICN이면 넣어주기
        for(int i=0;i<tickets.length;i++) {
        	if(tickets[i][0].equals("ICN")) {
        		visited[i]=true;
        		q.add(new Airplane(tickets[i][1], visited,stack,1));
        		visited[i]=false;
        	}
        }
        
        while(!q.isEmpty()) {
        	Airplane airplane = q.poll();
        	boolean[] v =airplane.getVisited();
        	Stack<String> r=airplane.getRoute();
        	String l = airplane.getLand();
        	int c = airplane.getCount();
        	//모든 티켓을 사용한 경우 break;
        	if(c>=tickets.length) {
        		answer=new String[r.size()];
        		for(int i=r.size()-1;i>=0;i--) {
        			answer[i]=r.pop();
        		}
        		break;
        	}
        	
        	for(int i=0;i<tickets.length;i++) { 
        		//도착지=출발지이면
        		if(tickets[i][0].equals(l)) {
        			//방문시 패쓰
        			if(v[i]) continue;
        			v[i]=true;
        			q.add(new Airplane(tickets[i][1], v, r, c+1));
        			v[i]=false;
        		}
        	}
        	r.clear(); //메모리를 위해 비움
        }
        return answer;
    }
    
	public static void main(String[] args) {
		String[][] t ={{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
		for(String s:solution(t)) {
			System.out.print(s+" "); //ICN ATL ICN SFO ATL SFO 
		}
		System.out.println();
	}

}
