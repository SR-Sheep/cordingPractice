package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class 숨바꼭질4 {
	//https://www.acmicpc.net/problem/13913
	
	static int N, K;
	static int[] prevPositions = new int[100001];
	static int[] times = new int[100001];
	
	//동생 찾기의 여정
	static void findBrother() {
		times[N]=1;
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(N); //수빈의 위치 입력
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(curr == K) return; //동생을 만나면 리턴
			for(int i=0;i<3;i++) {
				int next =curr;
				if(i==0) next-=1; //한칸 뒤로
				else if(i==1) next+=1; //한칸 앞으로
				else next*=2; //두배 이동
				
				//범위 밖이면 컨티뉴
				if(next<0||next>100000) continue;
				//이전에 방문했으면 컨티뉴
				if(times[next]!=0) continue;
				//다음 방문지에 현재 위치 기록
				prevPositions[next]=curr;
				times[next]=times[curr]+1;
				//큐에 다음 방문지 넣기
				q.add(next);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //수빈의 위치
		K=Integer.parseInt(st.nextToken()); //동생의 위치
		//N이 K보다 크다면 뒤로 가는 방법뿐
		if(N>K) {
			int moveCount = N-K;
			bw.append(moveCount+"\n");
			while(N>=K) {
				bw.append(N--+" ");
			}
		}else {
			//동생 찾기의 여정 기록
			findBrother();
			//역 추적을 위한 스택
			Stack<Integer> stack = new Stack<Integer>();
			stack.add(K); //K의 위치 넣기
			
			//이동 횟수
			int moveCount = times[K]-1;
			
			int route = K;
			
			//마지막 방문지가 수빈의 위치가 아니면 반복
			while(route!=N) {
				route=prevPositions[route];
				//해당 위치의 이전 위치를 스택에 넣기
				stack.add(route);
			}
			//이동 횟수 출력
			bw.append(moveCount+"\n");
			
			//이동 위치 출력
			while(!stack.isEmpty()) {
				bw.append(stack.pop()+" ");
			}
		}
		br.close();
		bw.close();
	}
}
