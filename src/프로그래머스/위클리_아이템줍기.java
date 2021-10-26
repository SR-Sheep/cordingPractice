package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 위클리_아이템줍기 {
	//방향 이동을 위한 디렉션
	static int[][] D= {{1,0},{-1,0},{0,1},{0,-1}};
	//목적지
	static int ItemR, ItemC;
	//길찾기
	public static int findRoute(int col,int row, boolean[][] graph) {
		int answer=0;
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {row,col,0}); // row, col, count
		graph[row][col]=false; //자신이 있던 자리를 지움
		
		while(!q.isEmpty()) {
			int[] now=q.poll();
			int r = now[0], c = now[1], count=now[2];
			//현재 위치가 목적지라면
			if(r==ItemR&&c==ItemC) {
				answer=count/2; //2배를 곱한 값을 사용하였음으로 2로 나눔
				break;
			} 
			//현재 위치 기준 모든 방향 탐색
			for(int i=0;i<4;i++) {
				int nr = r+D[i][0];
				int nc = c+D[i][1];
				//그래프를 벗어나면 continue;
				if(nr<0||nr>=graph.length||nc<0||nc>=graph.length) continue;
				//새 위치가 false면 continue;
				if(!graph[nr][nc]) continue;
				//새 위치 자리 지우기
				graph[nr][nc]=false;
				//새위치와 횟수+1을 큐에 다시 넣음
				q.add(new int[] {nr,nc,count+1});
			}
		}
		return answer;
		
	}
	//내부 사각형 지우기
	public static void erasing(int[] rec, boolean[][] graph) {
		int c1 = rec[0]*2, c2=rec[2]*2;
		int r1 = rec[1]*2, r2=rec[3]*2;
    	//나보다 작은 것들은 초기화
    	for(int r=r1+1;r<r2;r++) {
    		for(int c=c1+1;c<c2;c++) {
    			graph[r][c]=false;
    		}
    	}
	}
	//사각형 그리기
	public static void drawing(int[] now, boolean[][] graph) {
    	int c1 = now[0]*2, c2=now[2]*2;
    	int r1 = now[1]*2, r2=now[3]*2;
    	
    	for(int r=r1;r<=r2;r++) {
    		for(int c=c1;c<=c2;c++) {
    			graph[r][c]=true;
    		}
    	}
	}
	//확인하기 위한 그래프 출력
	public static void printGraph(int r, int c, boolean[][] graph) {
        int ridx=0;
        for(boolean[] g:graph) {
        	int cidx=0;
        	for(boolean b:g) {
        		String tmp ="□"; //빈공간
        		if(b==true) {
        			if(ridx==r&&cidx==c) {
        				tmp="♣";
        			}else if(ridx==ItemR&&cidx==ItemC) {
        				tmp="♥";
    				}else if(cidx!=0&&cidx%2==0&&ridx%2==0) {
        				tmp="■"; //점
        			}else {
        				tmp="º"; //연결선
        			}
        		}		
        		System.out.print(tmp+" ");		
        		cidx++;
        	}
        	System.out.println();
        	ridx++;
        }
	}
	
	public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    	//보드를 표시하기 위한 그래프, 1~50까지 사용하기에 size가 51이지만 꺾인 부분 때문에 2배를 적용
    	boolean[][] graph=new boolean[102][102];
        //꺾인 부분을 해결하기 위해 모든 값을 2배 적용
        int c=characterX*2;
        int r=characterY*2;
        ItemC=itemX*2;
        ItemR=itemY*2;
        
        Queue<int[]> q = new LinkedList<int[]>();
        //사각형 채우기
        for(int i=0;i<rectangle.length;i++) {
        	drawing(rectangle[i],graph);
        }
        //사각형 내부 지우기
        for(int i=0;i<rectangle.length;i++) {
        	erasing(rectangle[i], graph);
        }
        //printGraph(r, c, graph);
        return findRoute(c, r, graph);
    }
	
	public static void main(String[] args) {
		int[][][] r ={{{1,1,7,4},{3,2,5,5},{4,3,6,9},{2,6,8,8}},{{1,1,8,4},{2,2,4,9},{3,6,9,8},{6,3,7,7}},{{1,1,5,7}},{{2,1,7,5},{6,4,10,10}},{{2,2,5,5},{1,3,6,4},{3,1,4,6}}};
		int[] cx = {1,9,1,3,1};
		int[] cy = {3,7,1,1,4};
		int[] ix= {7,6,4,7,6};
		int[] iy = {8,1,7,10,3};
		
		
		for(int i=0;i<5;i++) {
			System.out.println(solution(r[i], cx[i], cy[i], ix[i], iy[i]));
			
			
		}
		
		
	}
}
