package 프로그래머스;

import java.util.LinkedList;
import java.util.Queue;

public class 마에스터_게임맵최단거리 {
	/*
	게임 맵의 상태 maps가 매개변수로 주어질 때,
	캐릭터(1,1)가 상대 팀 진영(n,m)에 도착하기 위해서 지나가야 하는 칸의 개수의 최솟값을 return 하도록 solution 함수를 완성해주세요.
	단, 상대 팀 진영에 도착할 수 없을 때는 -1을 return 해주세요.

	제한사항
	maps는 n x m 크기의 게임 맵의 상태가 들어있는 2차원 배열로, n과 m은 각각 1 이상 100 이하의 자연수입니다.
	n과 m은 서로 같을 수도, 다를 수도 있지만, n과 m이 모두 1인 경우는 입력으로 주어지지 않습니다.
	maps는 0과 1로만 이루어져 있으며, 0은 벽이 있는 자리, 1은 벽이 없는 자리를 나타냅니다.
	처음에 캐릭터는 게임 맵의 좌측 상단인 (1, 1) 위치에 있으며, 상대방 진영은 게임 맵의 우측 하단인 (n, m) 위치에 있습니다.
	*/
	//방향
    static int[][] D = {{1,0},{-1,0},{0,1},{0,-1}};
    public int solution(int[][] maps) {
        //방문여부
    	boolean[][] visited=new boolean[maps.length][maps[0].length];
        //계속적인 회전을 위한 큐
    	Queue<int[]> q = new LinkedList<>();
        //초기 캐릭터 위치와 타일 수 큐 삽입 (0,0) , 1개
    	q.add(new int[]{0,0,1});
    	//큐 회전
        while(!q.isEmpty()){
            int[] now = q.poll();
            int r = now[0]; //row
            int c = now[1]; //column
            int cnt = now[2]; //타일 수
            //목적지 도착시 타일수 리턴
            if(r==maps.length-1&&c==maps[0].length-1) return cnt;
            //목적지가 아닐시 4방향 탐색
            for(int i=0;i<4;i++){
                int nr = r+D[i][0]; //새로운 r
                int nc = c+D[i][1]; //새로운 c
                //범위를 벗어나면 컨티뉴
                if(nr<0||nr>=maps.length||nc<0||nc>=maps[0].length) continue;
                //새위치가 1이 아니면 컨티뉴
                if(maps[nr][nc]!=1) continue;
                //방문했으면 컨티뉴
                if(visited[nr][nc]) continue;
                //방문 여부 표시
                visited[nr][nc]=true;
                //새 위치와 현재 타일수+1 큐 삽입 
                q.add(new int[] {nr,nc,cnt+1});
            }
            
        }
        //모두 탐색 결과 도착하지 못하면 -1 리턴
        return -1;
    }
}
