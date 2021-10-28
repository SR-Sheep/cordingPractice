package 프로그래머스;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class 카카오_미로탈출 {
	
	static int[] Visited;
	static int[][] Forward;
	static int[][] Reverse;
	static final int INF = Integer.MAX_VALUE;
	
    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
    	Visited=new int[n+1]; //idx 그대로 사용
    	Forward=new int[n+1][n+1];
    	Reverse=new int[n+1][n+1];
    	for(int i=1;i<n+1;i++) {
    		for(int j=1;j<n+1;j++) {
    			Forward[i][j]=INF;
    			Reverse[i][j]=INF;
    		}
    	}
    	for(int[] road:roads) {
    		Forward[road[0]][road[1]]=Math.min(Forward[road[0]][road[1]],road[2]);
    		Reverse[road[1]][road[0]]=Math.min(Reverse[road[0]][road[1]],road[2]);
    	}
    	ArrayList<Integer> trapList = new ArrayList<Integer>();
    	for(int trap:traps) trapList.add(trap);
    	
//    	System.out.println(" ");
//    	for(int[] f : Forward) {
//    		for(int i:f) {
//    			if(i!=INF) {
//    				System.out.print(i+" ");
//    			}else {
//    				System.out.print("INF ");
//    			}
//    		}
//    		System.out.println();
//    	}
    	
    	// no, 비용
    	PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x,y)->(x[1]-y[1]));
    	pq.add(new int[] {start,0});
    	while(!pq.isEmpty()) {
    		int[] now = pq.poll();
    		int no = now[0];
    		int cost = now[1];
    		
    		if(no==end) return cost;
    		Visited[no]++;
    		
    		boolean activeTrap=false;
    		if(trapList.contains(no)&&Visited[no]%2==1) activeTrap=true;
    		
    		for(int i=1;i<n+1;i++) {
    			if(i==no) continue;
    			int tmpCost=0;
    			if(activeTrap) {
    				if(Reverse[no][i]!=INF) {
    					tmpCost=Reverse[no][i];
    				};
    			}else {
    				if(Forward[no][i]!=INF) {
    					tmpCost=Forward[no][i];
    				};
    			}
    			if(tmpCost!=0) {
    				pq.add(new int[] {i,cost+tmpCost});
    			}
    		}
    	}
        return -1;
    }
	
	public static void main(String[] args) {
		int n=4,s=1,e=4;
		int[][] roads= {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
		int[] trap= {2,3}; // 5
//		int n=3,s=1,e=3;
//		int[][] roads= {{1,2,2},{3,2,3}};
//		int[] trap= {2}; // 5
		System.out.println(solution(n, s, e, roads, trap));
	}

}
