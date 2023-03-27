package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 비밀번호찾기 {
	//https://www.acmicpc.net/problem/17219
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); //사이트 수
		int q = Integer.parseInt(st.nextToken()); //문제 수
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			map.put(st.nextToken(), st.nextToken()); //사이트명 , 비밀번호
		}
		for(int i=0;i<q;i++) {
			bw.append(map.get(br.readLine())+"\n"); //각 키에 맞는 비밀번호 출력
		}
		bw.close();
		br.close();
	}
}

