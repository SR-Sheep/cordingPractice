package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈 {
	
	//https://www.acmicpc.net/problem/9375
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine()); //준비된 소품 수
			HashMap<String,Integer> map = new LinkedHashMap<>(); //맵 선언 
			for(int j=0;j<m;j++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				String wear = st.nextToken(); //소품 종류
				map.put(wear, map.getOrDefault(wear, 1)+1); //소품 종류의 갯수 +1
			}
			int answer = 1;
			//(각 소품의 갯수 +1) 모두 곱하기
			for(String key:map.keySet()) {
				answer*=map.get(key);
			}
			bw.append(answer-1+"\n"); //모두 안 착용 하는 경우 1 빼기
		}
		br.close();
		bw.close();
	}
}
