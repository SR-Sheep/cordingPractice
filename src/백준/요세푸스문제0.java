package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스문제0 {
	//https://www.acmicpc.net/problem/11866
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //총 사람수
		int a = Integer.parseInt(st.nextToken()); //제거해야 할 사람 간의 간격
		Queue<Integer> q = new LinkedList<>(); //큐 선언
		for(int i=1;i<=n;i++) q.add(i); //큐에 사람들 채워넣기
		StringBuilder sb = new StringBuilder("<"); //답을 저장할 스트링빌더
		int count = 1; //차례
		while(!q.isEmpty()) {
			int curr = q.poll();
			if(count++%a==0) sb.append(curr+", "); //a의 배수 차례일시 제거
			else q.add(curr); //제거되지 않으면 다시 큐에 넣기
		}
		sb.delete(sb.length()-2, sb.length()).append(">"); //마지막 ", " 제거 한 뒤 ">"넣기
		bw.append(sb);
		br.close();
		bw.close();
	}
}
