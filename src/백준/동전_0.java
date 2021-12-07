package 백준;

import java.io.*;
import java.util.*;

public class 동전_0 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());
		List<Integer> list = new ArrayList<Integer>(); 
		int answer = 0;
		for(int i=0;i<n;i++) {
			list.add(0, Integer.parseInt(br.readLine()));
		}
		for(int coin:list) {
			answer+=money/coin;
			money%=coin;
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
