package 프로그래머스;

import java.util.*;

public class 카카오_미로탈출 {
	//선방향
	static int[][] Forward;
	//역방향
	static int[][] Reverse;
    
    static class Room{
		int no,cost; //번호, 비용
		int[] visited; //방문 여부
		public Room(int no,int cost, int[] visited) {
			this.no=no;
			this.cost=cost;
			this.visited=visited.clone();
		}
	}

    
    public static int solution1(int n, int start, int end, int[][] roads, int[] traps) {
        //선방향
    	Forward=new int[n+1][n+1];
    	//역방향
    	Reverse=new int[n+1][n+1];
    	
    	for(int[] road:roads) {
    		//선방향, 역방향 그래프 채우기
    		int s = road[0], e = road[1], cost = road[2];
    		Forward[s][e]=Reverse[e][s]=Forward[s][e]==0?cost:Math.min(Forward[s][e], cost);
    	}
        //트랩 확인을 위한 리스트
    	List<Integer> trapList = new ArrayList<>();
    	for(int trap:traps) {
    		trapList.add(trap);
    	} 
    	//우선순위 큐 선언, 비용이 적은순으로 정렬
    	PriorityQueue<Room> pq = new PriorityQueue<Room>((Room x,Room y)->(x.cost-y.cost));
    	pq.add(new Room(start,0,new int[n+1]));
    	//반복 실행
    	while(!pq.isEmpty()) {
    		Room room = pq.poll();
    		int no = room.no;
    		int cost = room.cost;
    		int[] visited=room.visited;
    		//현재가 도착지점이면 비용 출력
    		if(no==end) return cost;
    		//현재 위치 방문수 증가
    		visited[no]++;
    		//2번 이상 방문시 컨티뉴(최대 2번까지 방문)
    		if(visited[no]>2) continue;
            //함정 작동 여부 판별
    		boolean activeTrap=false;
    		//함정 목록이 있고, 방문 횟수가 홀수이면 함정 작동
    		if(trapList.contains(no)&&visited[no]%2==1) activeTrap=true;
    		
    		//모든 노드에 대한 탐색
    		for(int next=1;next<n+1;next++) {
    			//현 노드와 같으면 컨티뉴
    			if(next==no) continue;
                //다음 방문할 노드의 함정 작동 판단
                boolean nextActiveTrap=false;
                //함정 목록에 있고, 방문 횟수가 홀수이면 작동
                if(trapList.contains(next)&&visited[next]%2==1) nextActiveTrap=true;
                //역방향, 함정 1개만 작동
                if(Reverse[no][next]!=0) {
                	//함정이 1개만 작동시(두개의 함정 여부가 서로 다를경우)
                    if(activeTrap ^ nextActiveTrap){
                    	//우선순위 큐에 다음 위치, 비용, 방문을 삽입
                        pq.add(new Room(next, cost+Reverse[no][next], visited));
                    }
                };
                //순방향, 함정 0개 혹은 2개 작동    				
                if(Forward[no][next]!=0) {
                	//함정이 0개 혹은 2개 작동시(두개의 함정 작동이 같을 경우)
                    if(!(activeTrap^nextActiveTrap)){
                    	//우선순위 큐에 다음 위치, 비용, 방문을 삽입
                        pq.add(new Room(next,cost+Forward[no][next],visited));
                    }
    			}
    		}
    	}
    	//도착 못할 시 -1 리턴
        return -1;
    }
	
	
	
	
	
	//------------- 다른 사람의 풀이를 공부한 것임 --------------//
    static class Tuple implements Comparable<Tuple>{
        //비용, 인덱스, 함정발동상황
    	int val, idx, state;
        
        public Tuple(int val, int idx, int state){
            this.val = val; this.idx = idx; this.state = state;
        }
        //비용이 적을수록 먼저 위치	
        @Override
        public int compareTo(Tuple o) {
            if (val > o.val) return 1;
            if (val == o.val) return 0;
            return -1;
        }
    }

    static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final int INF = 0x7f7f7f7f;
    static int d[][] = new int[1004][1024];
    static List<Pair> adj[] = new ArrayList[1004];
    static List<Pair> adjrev[] = new ArrayList[1004];
    static int trapidx[] = new int[1004];
    //함정의 인덱스 & 현재 함정 상태, 함정이 발동되면 true, 발동 안되면 false;
    static boolean bitmask(int state, int idx){
        return ((1 << trapidx[idx]) & state) != 0;
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        // d값을 INF로 초기화
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 1024; j++)
                d[i][j] = INF;
        }
        // adj, adjrev에 대한 초기화
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>(); //i에서 갈 수 있는 배열
            adjrev[i] = new ArrayList<>(); //i에 도착하는 배열(역순)            
        }
        // trapidx에 대한 초기화
        for(int i = 1; i <= n; i++) {
        	trapidx[i] = -1;
        }
        
        for(int i = 0; i < traps.length; i++) {
        	int num = traps[i];
        	trapidx[num] = i;
        }
        
        //TrapIdx : 모든 노드 중 트랩의 idx를 가지고 있음, 나머진 -1

        // 통로 처리
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0]; //시작
            int v = roads[i][1]; //도착
            int val = roads[i][2]; //비용
            adj[u].add(new Pair(v, val)); //순방향, u -> v, 비용
            adjrev[v].add(new Pair(u, val));//역방향, v -> u, 비용            
        }

        d[start][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();        
        pq.add(new Tuple(d[start][0], start, 0)); //시작점에서 함정이 0 발동인 상황 , 시작, 비용 0
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            // pq에서 뽑히는 원소는 가까운 순이라는 점을 이용해서 맨 마지막에 d[..][end]를 for문으로 순회하지 않아도 되게 idx == end일 때 바로 답을 반환
            if(cur.idx == end) return cur.val;
            //현재 idx에서 현재 함정 상태의 비용이 다르면 컨티뉴  
            if(d[cur.idx][cur.state] != cur.val) continue;
            
            for(int i = 0; i < adj[cur.idx].size(); i++){ // 정방향 간선에 대한 확인
                Pair nxt = adj[cur.idx].get(i); // 간선으로 연결된 다음 방
                int rev = 0;
                //현재 노드가 트랩이고, 함정이 발동된다면 rev 뒤집기	
                if(trapidx[cur.idx] != -1 && bitmask(cur.state, cur.idx)) rev ^= 1; // 현재 cur.idx번 trap을 밟은 상태라면 rev 상태를 뒤집음
                //다음 노드가 트랩이고, 함정이 발동된다면 rev 뒤집기	
                if(trapidx[nxt.x] != -1 && bitmask(cur.state, nxt.x)) rev ^= 1; // 현재 nxt.x번 trap을 밟은 상태라면 rev 상태를 뒤집음
                //rev가 1이면 컨티뉴 ( 1이 되는 경우 : 함정 1개 발동)
                if(rev != 0) continue; // 정방향 간선을 보고 있으므로 trap을 1개만 밟은 상황일 경우 넘어감
                //다음 상태
                int nxt_state = cur.state;
                //다음 노드가 함정이라면, 다음 노드의 함정 반전
                if(trapidx[nxt.x] != -1) nxt_state ^= (1 << trapidx[nxt.x]);
                //다음 노드, 상태의 값 > 현재 비용 + 다음 비용 이라면
                if(d[nxt.x][nxt_state] > nxt.y + cur.val){
                	///다음 노드, 상태에 최소비용 적용
                    d[nxt.x][nxt_state] = nxt.y + cur.val;
                    //pq에 넣기 (다음 노드/함정 상태 , 다음 노드 , 함정 상태); 
                    pq.add(new Tuple(d[nxt.x][nxt_state], nxt.x, nxt_state));
                }               
            }

            for(int i = 0; i < adjrev[cur.idx].size(); i++){ // 역방향 간선에 대한 확인
                Pair nxt = adjrev[cur.idx].get(i); // 간선으로 연결된 다음 방
                int rev = 0;
                if(trapidx[cur.idx] != -1 && bitmask(cur.state, cur.idx)) rev ^= 1; // 현재 cur.idx번 trap을 밟은 상태라면 rev 상태를 뒤집음
                if(trapidx[nxt.x] != -1 && bitmask(cur.state, nxt.x)) rev ^= 1; // 현재 nxt.x번 trap을 밟은 상태라면 rev 상태를 뒤집음
                if(rev != 1) continue; // 역방향 간선을 보고 있으므로 trap을 0개 or 2개 밟은 상황일 경우 넘어감
                int nxt_state = cur.state;
                //다음 노드가 함정이라면 다음 노드 함정의 상태 뒤집음
                if(trapidx[nxt.x] != -1) nxt_state ^= (1 << trapidx[nxt.x]);
                //그래프 최소값으로 업데이트
                if(d[nxt.x][nxt_state] > nxt.y + cur.val){
                    d[nxt.x][nxt_state] = nxt.y + cur.val;
                    //pq에 넣기(다음노드/상태 의 값, 다음 노드, 상태);
                    pq.add(new Tuple(d[nxt.x][nxt_state], nxt.x, nxt_state));
                }               
            }
        }
        return -1; // unreachable
    }
	
	
	public static void main(String[] args) {
//		int n=4,s=1,e=4;
//		int[][] roads= {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
//		int[] trap= {2,3}; // 4
		int n=3,s=1,e=3;
		int[][] roads= {{1,2,2},{3,2,3}};
		int[] trap= {2}; // 5
		
		int n1 = 4, s1=1, e1=4;
		int[][] roads1= {{1,2,1},{1,3,0},{2,3,2},{3,4,3}};
		int[] trap1= {2,3};
		System.out.println(solution(n, s, e, roads, trap));
		System.out.println(solution(n1, s1, e1, roads1, trap1));
		System.out.println(1^2);
		
		System.out.println(true^true);
		
	}

}
