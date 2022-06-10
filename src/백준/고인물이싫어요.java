package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 고인물이싫어요 {
	//https://www.acmicpc.net/problem/25187
	
	static int[] Parents; //부모 정보 저장
	static Water[] Waters; //연결된 청정수, 고인물 정보 저장
	
	static class Water{
		int clean, standing;
		//청정수, 고인물 생성자
		public Water(int clean, int standing) {
			this.clean=clean;
			this.standing=standing;
		}
		//기존 탱크 상태 추가
		public void addWater(Water w) {
			this.clean+=w.clean;
			this.standing+=w.standing;
		}
		//청정수 판별
		public int isCleanWater() {
			return this.clean>this.standing?1:0;
		}
	}
	
	//부모 설정
	static void setParent(int tank1, int tank2) {
		int parent1 = getParent(tank1);
		int parent2 = getParent(tank2);
		//작은 값을 parent1로 변경
		if(parent1>parent2) {
			int tmp = parent1;
			parent1=parent2;
			parent2=tmp;
		}
		//부모가 서로 다르면
		if(parent1!=parent2) {
			//부모 설정
			Parents[parent2]=parent1;
			//이전 부모의 연결 정보 -> 새 부모에게 상태 추가
			Waters[parent1].addWater(Waters[parent2]);
		}
	}
	
	//부모 찾기
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
		//초기 설정
		Waters=new Water[n+1]; //각 탱크의 상태
		Parents=new int[n+1]; //각 부모의 상태
		st=new StringTokenizer(br.readLine());
		//탱크 설정
		for(int i=1;i<=n;i++) {
			//부모를 자기 자신으로 설정
			Parents[i]=i;
			//각 탱크의 청정수, 고인물 값 설정
			if(Integer.parseInt(st.nextToken())==1) {
				Waters[i]=new Water(1, 0); //청정수인 경우
			}else {
				Waters[i]=new Water(0, 1); //고인물인 경우
			}
		}
		
		//파이프 설정
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int tank1=Integer.parseInt(st.nextToken());
			int tank2=Integer.parseInt(st.nextToken());
			//탱크1과 탱크2 연결
			setParent(tank1, tank2);
		}
		//문제 설정
		for(int i=0;i<q;i++) {
			//각 탱크가 클린한지 출력
			int tank = Integer.parseInt(br.readLine());
			bw.append(Waters[getParent(tank)].isCleanWater()+"\n");
		}
		
		bw.close();
		br.close();
	}
}
