package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 숫자카드2 {
	
	//https://www.acmicpc.net/problem/10816
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		StringTokenizer st=new StringTokenizer(br.readLine());
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			map.put(num, map.getOrDefault(num, 0)+1);
		}
		n = Integer.parseInt(br.readLine());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			sb.append(map.get(num)==null?0:map.get(num)).append(" ");
		}
		bw.append(sb);
		br.close();
		bw.close();
	}
}
