package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 고인물이싫어요 {
	//https://www.acmicpc.net/problem/25187
	
	static int[] Parents;
	static Water[] Waters;
	
	static class Water{
		int clean, standing;
		public Water(int clean, int standing) {
			this.clean=clean;
			this.standing=standing;
		}
		
		public void addWater(Water w) {
			this.clean+=w.clean;
			this.standing+=w.standing;
		}
		
		public int isCleanWater() {
			return this.clean>this.standing?1:0;
		}
		
		@Override
		public String toString() {
			return "clean : "+clean+" / standing : "+standing;
		}
	}
	
	static void setParent(int tank1, int tank2) {
		int parent1 = getParent(tank1);
		int parent2 = getParent(tank2);
		if(parent1>parent2) {
			int tmp = parent1;
			parent1=parent2;
			parent2=tmp;
		}
		if(parent1!=parent2) {
			Parents[parent2]=parent1;
			Waters[parent1].addWater(Waters[parent2]);
		}
	}
	
	static int getParent(int tank) {
		if(Parents[tank]!=tank) {
			Parents[tank]=getParent(Parents[tank]);
		}
		return Parents[tank];
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken()); //물탱크
		int m=Integer.parseInt(st.nextToken()); //파이프
		int q=Integer.parseInt(st.nextToken()); //문제수
		
		Waters=new Water[n+1];
		Parents=new int[n+1];
		st=new StringTokenizer(br.readLine());
		for(int i=1;i<=n;i++) {
			Parents[i]=i;
			if(Integer.parseInt(st.nextToken())==1) {
				Waters[i]=new Water(1, 0);
			}else {
				Waters[i]=new Water(0, 1);
			}
		}
		
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int tank1=Integer.parseInt(st.nextToken());
			int tank2=Integer.parseInt(st.nextToken());
			setParent(tank1, tank2);
		}
		System.out.println();
		for(int i=1;i<=n;i++) {
			System.out.println(i+ " => "+Waters[i]);
		}
		for(int i=1;i<=n;i++) {
			System.out.println(getParent(i));
		}
		System.out.println();
		for(int i=1;i<=n;i++) {
			System.out.println(i+ " => "+Waters[i]);
		}
		
		for(int i=0;i<q;i++) {
			int tank = Integer.parseInt(br.readLine());
			bw.append(Waters[getParent(tank)].isCleanWater()+"\n");
		}
		
		bw.close();
		br.close();
	}
}
