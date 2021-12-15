package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 프린터큐 {
	//https://www.acmicpc.net/problem/1966
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //반복 수
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int doc = Integer.parseInt(st.nextToken()); //문서 수
			int idx = Integer.parseInt(st.nextToken()); //궁금해하는 값
			int val = 0; //궁금해하는 값의 중요도
			int order = 0; //출력순서
			Queue<int[]> q = new LinkedList<>();
			int[] max = new int[10]; //중요도 수를 저장할 배열
			st=new StringTokenizer(br.readLine());
			//중요도 입력
			for(int j=0;j<doc;j++) {
				int imp=Integer.parseInt(st.nextToken());
				if(j==idx) val = imp; //궁금해하는 값의 중요도
				q.add(new int[] {j,imp}); //큐에 (인덱스, 중요도)로 삽입
				max[imp]++; //중요도의 수를 저장함
			}
			//높은 중요도부터 역순으로 탐색
			for(int j=9;j>=val;j--) {
				while(max[j]>0) { //해당 중요도가 0이 될때까지 탐색
					int[] curr=q.poll(); //큐에서 뽑기
					int index = curr[0]; //현재 인덱스
					int value = curr[1]; //현재 중요도
					if(j!=value) { //현재 중요도가 가장 높은 값이 아니라면
						q.add(curr); //다시 큐에 넣기
					}else if(index==idx) { //현재 중요도가 가장 높은 값이고, 궁금해하는 값이면
						order++; //순서 증가 후
						break; //멈춤
					}else { //현재 중요도가 가장 높은값이나 굼금해하는 값이 아니면
						order++; //순서 증가 후
						max[j]--; //최대값의 갯수 감소
					}
				}
			}
			bw.append(order+"\n");
		}
		br.close();
		bw.close();
	}
}
