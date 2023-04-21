package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/2623
public class 음악프로그램 {
	
	static int N;
	static List<Integer>[] Singers;
	static int[] Degrees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Singers = new List[N+1];
		Degrees = new int[N+1];
		for(int i=1;i<=N;i++) {
			Singers[i]=new ArrayList<>();
		}
		//가수 위상정렬
		for(int i=0;i<m;i++) {
			st=new StringTokenizer(br.readLine());
			int singerCount=Integer.parseInt(st.nextToken());
			int singer=Integer.parseInt(st.nextToken());
			for(int j=1;j<singerCount;j++) {
				int nextSinger=Integer.parseInt(st.nextToken());
				Singers[singer].add(nextSinger); //앞에 존재하는 가수 뒤 연결
				Degrees[nextSinger]++; //다음 가수 위상증가
				singer = nextSinger; //앞가수 업데이트
			}
		}
		List<Integer> answers = new ArrayList<>();
		
		Queue<Integer> q = new LinkedList<Integer>();
		//위상이 0이면 추가
		for(int i=1;i<=N;i++) {
			if(Degrees[i]==0) q.add(i);
		}
		//q 탐색
		while(!q.isEmpty()) {
			int singer = q.poll();
			answers.add(singer); //답 추가
			//다음 가수들의 위상 감소
			for(int next:Singers[singer]) {
				//감소한 위상이 0이면 q 추가
				if(--Degrees[next]==0) {
					q.add(next);
				};
			}
		}
		//답의 크기가 N이면 성공
		if(answers.size()==N) {
			for(int answer:answers) {
				bw.append(answer+"\n");
			}
		//답의 크기가 N이 아니면 실패
		}else {
			bw.append("0\n");
		}
		
		bw.close();
		br.close();
	}
}
