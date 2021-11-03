package ���α׷��ӽ�;

import java.util.*;

public class īī��_�̷�Ż�� {
	//������
	static int[][] Forward;
	//������
	static int[][] Reverse;
    
    static class Room{
		int no,cost; //��ȣ, ���
		int[] visited; //�湮 ����
		public Room(int no,int cost, int[] visited) {
			this.no=no;
			this.cost=cost;
			this.visited=visited.clone();
		}
	}

    
    public static int solution1(int n, int start, int end, int[][] roads, int[] traps) {
        //������
    	Forward=new int[n+1][n+1];
    	//������
    	Reverse=new int[n+1][n+1];
    	
    	for(int[] road:roads) {
    		//������, ������ �׷��� ä���
    		int s = road[0], e = road[1], cost = road[2];
    		Forward[s][e]=Reverse[e][s]=Forward[s][e]==0?cost:Math.min(Forward[s][e], cost);
    	}
        //Ʈ�� Ȯ���� ���� ����Ʈ
    	List<Integer> trapList = new ArrayList<>();
    	for(int trap:traps) {
    		trapList.add(trap);
    	} 
    	//�켱���� ť ����, ����� ���������� ����
    	PriorityQueue<Room> pq = new PriorityQueue<Room>((Room x,Room y)->(x.cost-y.cost));
    	pq.add(new Room(start,0,new int[n+1]));
    	//�ݺ� ����
    	while(!pq.isEmpty()) {
    		Room room = pq.poll();
    		int no = room.no;
    		int cost = room.cost;
    		int[] visited=room.visited;
    		//���簡 ���������̸� ��� ���
    		if(no==end) return cost;
    		//���� ��ġ �湮�� ����
    		visited[no]++;
    		//2�� �̻� �湮�� ��Ƽ��(�ִ� 2������ �湮)
    		if(visited[no]>2) continue;
            //���� �۵� ���� �Ǻ�
    		boolean activeTrap=false;
    		//���� ����� �ְ�, �湮 Ƚ���� Ȧ���̸� ���� �۵�
    		if(trapList.contains(no)&&visited[no]%2==1) activeTrap=true;
    		
    		//��� ��忡 ���� Ž��
    		for(int next=1;next<n+1;next++) {
    			//�� ���� ������ ��Ƽ��
    			if(next==no) continue;
                //���� �湮�� ����� ���� �۵� �Ǵ�
                boolean nextActiveTrap=false;
                //���� ��Ͽ� �ְ�, �湮 Ƚ���� Ȧ���̸� �۵�
                if(trapList.contains(next)&&visited[next]%2==1) nextActiveTrap=true;
                //������, ���� 1���� �۵�
                if(Reverse[no][next]!=0) {
                	//������ 1���� �۵���(�ΰ��� ���� ���ΰ� ���� �ٸ����)
                    if(activeTrap ^ nextActiveTrap){
                    	//�켱���� ť�� ���� ��ġ, ���, �湮�� ����
                        pq.add(new Room(next, cost+Reverse[no][next], visited));
                    }
                };
                //������, ���� 0�� Ȥ�� 2�� �۵�    				
                if(Forward[no][next]!=0) {
                	//������ 0�� Ȥ�� 2�� �۵���(�ΰ��� ���� �۵��� ���� ���)
                    if(!(activeTrap^nextActiveTrap)){
                    	//�켱���� ť�� ���� ��ġ, ���, �湮�� ����
                        pq.add(new Room(next,cost+Forward[no][next],visited));
                    }
    			}
    		}
    	}
    	//���� ���� �� -1 ����
        return -1;
    }
	
	
	
	
	
	//------------- �ٸ� ����� Ǯ�̸� ������ ���� --------------//
    static class Tuple implements Comparable<Tuple>{
        //���, �ε���, �����ߵ���Ȳ
    	int val, idx, state;
        
        public Tuple(int val, int idx, int state){
            this.val = val; this.idx = idx; this.state = state;
        }
        //����� �������� ���� ��ġ	
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
    //������ �ε��� & ���� ���� ����, ������ �ߵ��Ǹ� true, �ߵ� �ȵǸ� false;
    static boolean bitmask(int state, int idx){
        return ((1 << trapidx[idx]) & state) != 0;
    }

    public static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        // d���� INF�� �ʱ�ȭ
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < 1024; j++)
                d[i][j] = INF;
        }
        // adj, adjrev�� ���� �ʱ�ȭ
        for(int i = 1; i <= n; i++){
            adj[i] = new ArrayList<>(); //i���� �� �� �ִ� �迭
            adjrev[i] = new ArrayList<>(); //i�� �����ϴ� �迭(����)            
        }
        // trapidx�� ���� �ʱ�ȭ
        for(int i = 1; i <= n; i++) {
        	trapidx[i] = -1;
        }
        
        for(int i = 0; i < traps.length; i++) {
        	int num = traps[i];
        	trapidx[num] = i;
        }
        
        //TrapIdx : ��� ��� �� Ʈ���� idx�� ������ ����, ������ -1

        // ��� ó��
        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0]; //����
            int v = roads[i][1]; //����
            int val = roads[i][2]; //���
            adj[u].add(new Pair(v, val)); //������, u -> v, ���
            adjrev[v].add(new Pair(u, val));//������, v -> u, ���            
        }

        d[start][0] = 0;
        PriorityQueue<Tuple> pq = new PriorityQueue<>();        
        pq.add(new Tuple(d[start][0], start, 0)); //���������� ������ 0 �ߵ��� ��Ȳ , ����, ��� 0
        while(!pq.isEmpty()){
            Tuple cur = pq.poll();
            // pq���� ������ ���Ҵ� ����� ���̶�� ���� �̿��ؼ� �� �������� d[..][end]�� for������ ��ȸ���� �ʾƵ� �ǰ� idx == end�� �� �ٷ� ���� ��ȯ
            if(cur.idx == end) return cur.val;
            //���� idx���� ���� ���� ������ ����� �ٸ��� ��Ƽ��  
            if(d[cur.idx][cur.state] != cur.val) continue;
            
            for(int i = 0; i < adj[cur.idx].size(); i++){ // ������ ������ ���� Ȯ��
                Pair nxt = adj[cur.idx].get(i); // �������� ����� ���� ��
                int rev = 0;
                //���� ��尡 Ʈ���̰�, ������ �ߵ��ȴٸ� rev ������	
                if(trapidx[cur.idx] != -1 && bitmask(cur.state, cur.idx)) rev ^= 1; // ���� cur.idx�� trap�� ���� ���¶�� rev ���¸� ������
                //���� ��尡 Ʈ���̰�, ������ �ߵ��ȴٸ� rev ������	
                if(trapidx[nxt.x] != -1 && bitmask(cur.state, nxt.x)) rev ^= 1; // ���� nxt.x�� trap�� ���� ���¶�� rev ���¸� ������
                //rev�� 1�̸� ��Ƽ�� ( 1�� �Ǵ� ��� : ���� 1�� �ߵ�)
                if(rev != 0) continue; // ������ ������ ���� �����Ƿ� trap�� 1���� ���� ��Ȳ�� ��� �Ѿ
                //���� ����
                int nxt_state = cur.state;
                //���� ��尡 �����̶��, ���� ����� ���� ����
                if(trapidx[nxt.x] != -1) nxt_state ^= (1 << trapidx[nxt.x]);
                //���� ���, ������ �� > ���� ��� + ���� ��� �̶��
                if(d[nxt.x][nxt_state] > nxt.y + cur.val){
                	///���� ���, ���¿� �ּҺ�� ����
                    d[nxt.x][nxt_state] = nxt.y + cur.val;
                    //pq�� �ֱ� (���� ���/���� ���� , ���� ��� , ���� ����); 
                    pq.add(new Tuple(d[nxt.x][nxt_state], nxt.x, nxt_state));
                }               
            }

            for(int i = 0; i < adjrev[cur.idx].size(); i++){ // ������ ������ ���� Ȯ��
                Pair nxt = adjrev[cur.idx].get(i); // �������� ����� ���� ��
                int rev = 0;
                if(trapidx[cur.idx] != -1 && bitmask(cur.state, cur.idx)) rev ^= 1; // ���� cur.idx�� trap�� ���� ���¶�� rev ���¸� ������
                if(trapidx[nxt.x] != -1 && bitmask(cur.state, nxt.x)) rev ^= 1; // ���� nxt.x�� trap�� ���� ���¶�� rev ���¸� ������
                if(rev != 1) continue; // ������ ������ ���� �����Ƿ� trap�� 0�� or 2�� ���� ��Ȳ�� ��� �Ѿ
                int nxt_state = cur.state;
                //���� ��尡 �����̶�� ���� ��� ������ ���� ������
                if(trapidx[nxt.x] != -1) nxt_state ^= (1 << trapidx[nxt.x]);
                //�׷��� �ּҰ����� ������Ʈ
                if(d[nxt.x][nxt_state] > nxt.y + cur.val){
                    d[nxt.x][nxt_state] = nxt.y + cur.val;
                    //pq�� �ֱ�(�������/���� �� ��, ���� ���, ����);
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
