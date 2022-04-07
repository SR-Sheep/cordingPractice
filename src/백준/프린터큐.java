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
		int n = Integer.parseInt(br.readLine()); //테스트 개수
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int doc = Integer.parseInt(st.nextToken()); //문서 개수
			int idx = Integer.parseInt(st.nextToken()); //몇번째로 인쇄되는지 궁금한 문서
			int val = 0; //궁금한 문서의 중요도
			int order = 0; //순서
			Queue<int[]> q = new LinkedList<>();
			int[] max = new int[10]; //중요도를 저장
			st=new StringTokenizer(br.readLine());
			//중요도
			for(int j=0;j<doc;j++) {
				int imp=Integer.parseInt(st.nextToken());
				if(j==idx) val = imp; //궁금한 문서의 중요도 저장
				q.add(new int[] {j,imp}); //큐에 삽입(순서, 중요도)
				max[imp]++; //중요도 개수 증가
			}
			//중요도 높은 순 탐색
			for(int j=9;j>=val;j--) {
				while(max[j]>0) { //남은 중요도의 수가 0보다 크면 반복
					int[] curr=q.poll(); //큐에서 빼기
					int index = curr[0]; //현재 문서 번호
					int value = curr[1]; //현재 문서의 중요도
					if(j!=value) { //현재 문서가 최대 중요도가 아니면
						q.add(curr); //다시 큐에 넣기
					}else if(index==idx) { //내가 찾는 문서이면 
						order++; //순서 증가
						break; //종료
					}else { //최대 중요도이지만 내가 찾는 문서가 아니라면
						order++; //순서 증가
						max[j]--; //중요도 개수 감소
					}
				}
			}
			//출력
			bw.append(order+"\n");
		}
		br.close();
		bw.close();
	}
}
