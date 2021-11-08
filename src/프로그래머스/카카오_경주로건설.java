package 프로그래머스;

import java.util.*;

public class 카카오_경주로건설 {
	
	//https://programmers.co.kr/learn/courses/30/lessons/67259
	//직선 비용 100, 커브 비용 500, 0,0-> n-1,n-1 도착 최소 비용 출력
	
	static int[][] D = {{0,-1},{0,1},{1,0},{-1,0}}; //방향
    static final int INF=Integer.MAX_VALUE; //최대값
    
    public static int solution(int[][] board) {
        int n = board.length; //길이
        int answer = 0;
        int[][][] visited=new int[n][n][4]; //row, col, 상하좌우 4가지 방향 (같은 지점이라도 방향에 따라 판단)
        //방문비용 초기화
        for(int[][] vi:visited){
            for(int[] v:vi ) Arrays.fill(v,INF);
        }
        //우선순위 큐, 각 방문시 비용이 다르므로 우선순위 큐 사용, 비용이 적은 순 먼저
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)->(x[3]-y[3]));
        pq.add(new int[]{0,0,-1,0}); //row, col, 방향(맨 처음은 -1), 비용
        while(!pq.isEmpty()){
            int[] now=pq.poll();
            int r = now[0], c= now[1], idx=now[2], cost=now[3];
            //목적지 도착시 cost 출력
            if(r==n-1&&c==n-1){
                answer=cost;
                break;
            }
            //다음 행선지에 대해 탐색
            for(int i=0;i<4;i++){
                int nr = r+D[i][0];
                int nc = c+D[i][1];
                //범위 벗어나면 컨티뉴
                if(nr<0||nc<0||nr>=n||nc>=n) continue;
                //벽으로 막혀있으면 컨티뉴
                if(board[nr][nc]==1) continue;
                //다음 행선지 비용
                int nextCost=0;
                //처음 출발했거나 이전과 같은 방향이면 100원 추가
                if(idx==i||idx<0) nextCost=cost+100;
                //방향전환이라면 커브 + 직선 비용 = 500+100 = 600 추가
                else nextCost=cost+600;
                //해당 row, col, 방향에 저장된 비용 다음 비용이 크면 컨티뉴
                if(visited[nr][nc][i]<nextCost) continue;
                //방문 비용 업데이트
                visited[nr][nc][i]=nextCost;
                //pq에 삽입
                pq.add(new int[]{nr,nc,i,nextCost});
            }
        }
        
        return answer;
    }
}
