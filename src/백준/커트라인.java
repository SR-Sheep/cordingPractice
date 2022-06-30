package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 커트라인 {
	//https://www.acmicpc.net/problem/25305
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int cut=Integer.parseInt(st.nextToken());
		List<Integer> scores = new ArrayList<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int score=Integer.parseInt(st.nextToken());
			scores.add(score);
		}
		Collections.sort(scores,Collections.reverseOrder());
		System.out.println(scores.get(cut-1));
		br.close();
	}
}
