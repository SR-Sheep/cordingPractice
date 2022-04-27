package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 행성터널 {
	//https://www.acmicpc.net/problem/2887
	
	static int N;
	static List<Planet> Planets;
	static int[] Parents;
	
	//부모 찾기
	public static int getParent(int node) {
		if(Parents[node]==node) return node;
		return Parents[node]=getParent(Parents[node]);
	}
	//부모 세팅, 작은 수가 부모
	public static void setParent(int node1, int node2) {
		int p1 = getParent(node1);
		int p2 = getParent(node2);
		if(p1<p2) Parents[p2]=p1;
		else Parents[p1]=p2;
	}
	//같은 부모 판별
	public static boolean isSameParent(int node1, int node2) {
		return getParent(node1)==getParent(node2);
	}
	
	
	static class Planet{
		int no;
		int x,y,z;
		
		public Planet(int no ,int x,int y, int z) {
			this.no = no;
			this.x=x;
			this.y=y;
			this.z=z;
		}
		
		public int getCost(Planet planet) {
			int cost = Math.abs(this.x-planet.x);
			cost=Math.min(cost, Math.abs(this.y-planet.y));
			cost=Math.min(cost, Math.abs(this.z-planet.z));
			return cost;
		}
		
		@Override
		public String toString() {
			return "("+x+","+y+","+z+")";
		}
	}
	
	static class Cost implements Comparable<Cost>{
		int planetNo1, planetNo2;
		int cost;
		
		public Cost(int p1, int p2, int cost) {
			this.planetNo1=p1;
			this.planetNo2=p2;
			this.cost= cost;
		}
		
		@Override
		public int compareTo(Cost o) {
			if(this.cost<o.cost) return -1;
			else if(this.cost>o.cost) return 1;
			return 0;
		}
		
		@Override
		public String toString() {
			return this.planetNo1 + " " + this.planetNo2 + " " + this.cost;
		}
		
	}
	
	
	public static int mst() {
		int cost = 0;
		int count = 0;
		
		List<Cost> costs = new ArrayList<>();
//		최대 100001 * 100000 / 2 개로 메모리 초과		
//		for(int i=0;i<N;i++) {
//			Planet p = Planets.get(i);
//			for(int j=i+1;j<N;j++) {
//				costs.add(new Cost(i,j,p.getCost(Planets.get(j))));
//			}
//		}
//		x,y,z 정렬을 통해 간선 개수 최소화, 최대 300000개		
		Collections.sort(Planets, (x, y)->(x.x - y.x));
		for(int i=0;i<N-1;i++) {
			costs.add(new Cost(Planets.get(i).no, Planets.get(i+1).no, Planets.get(i+1).x-Planets.get(i).x));
		}
		Collections.sort(Planets, (x, y)->(x.y - y.y));
		for(int i=0;i<N-1;i++) {
			costs.add(new Cost(Planets.get(i).no, Planets.get(i+1).no, Planets.get(i+1).y-Planets.get(i).y));
		}
		Collections.sort(Planets, (x, y)->(x.z - y.z));
		for(int i=0;i<N-1;i++) {
			costs.add(new Cost(Planets.get(i).no, Planets.get(i+1).no, Planets.get(i+1).z-Planets.get(i).z));
		}
		
		Collections.sort(costs);
		
		
		for(Cost c:costs) {
			int p1 = c.planetNo1;
			int p2 = c.planetNo2;
			
			if(getParent(p1)!=getParent(p2)) {
				setParent(p1, p2);
				count++;
				cost+=c.cost;
				if(count==N-1) break;
			}
			
		}
		
		return cost;
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Planets = new ArrayList<>();
		Parents=new int[N];
		for(int i=1;i<N;i++) {
			Parents[i]=i;
		}
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken());
			int y=Integer.parseInt(st.nextToken());
			int z=Integer.parseInt(st.nextToken());
			Planets.add(new Planet(i,x, y, z));
		}
		System.out.println(mst());
		br.close();
	}
}
