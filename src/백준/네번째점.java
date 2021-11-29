package 백준;

import java.io.*;
import java.util.*;

public class 네번째점 {
	//https://www.acmicpc.net/problem/3009
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		HashMap<Integer,Integer> xMap = new HashMap<Integer, Integer>();
		HashMap<Integer,Integer> yMap = new HashMap<Integer, Integer>();
		
		for(int i=0;i<3;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			xMap.put(x, xMap.getOrDefault(x, 0)+1);
			yMap.put(y, yMap.getOrDefault(y, 0)+1);
		}
		for(Integer key:xMap.keySet()) {
			if(xMap.get(key)==1) bw.append(key+" ");
		}
		for(Integer key:yMap.keySet()) {
			if(yMap.get(key)==1) bw.append(key+"\n");
		}
		br.close();
		bw.close();
	}
}
