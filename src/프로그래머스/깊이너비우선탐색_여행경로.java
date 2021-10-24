package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ���̳ʺ�켱Ž��_������ {
	
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
    	//������ ���� ���ĺ� �� ����
        Arrays.sort(tickets,(x,y)->x[1].compareTo(y[1]));
        //�湮 ���� ǥ��
        boolean[] visited=new boolean[tickets.length];
        //ť ����
        Queue<Airplane> q = new LinkedList<>();
        //���� ����, Airplane Ŭ�������� ���
        Stack<String> stack = new Stack<String>();
        //�������� stack�� �ֱ�
        stack.add("ICN");
        //������ ICN�̸� �־��ֱ�
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
        	//��� Ƽ���� ����� ��� break;
        	if(c>=tickets.length) {
        		answer=new String[r.size()];
        		for(int i=r.size()-1;i>=0;i--) {
        			answer[i]=r.pop();
        		}
        		break;
        	}
        	
        	for(int i=0;i<tickets.length;i++) { 
        		//������=������̸�
        		if(tickets[i][0].equals(l)) {
        			//�湮�� �о�
        			if(v[i]) continue;
        			v[i]=true;
        			q.add(new Airplane(tickets[i][1], v, r, c+1));
        			v[i]=false;
        		}
        	}
        	r.clear(); //�޸𸮸� ���� ���
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
