package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 와글와글숭고한 {
	//https://www.acmicpc.net/problem/17388
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] univ = {"Soongsil","Korea","Hanyang","OK"};
		int[] scores = new int[3];
		StringTokenizer st=new StringTokenizer(br.readLine());
		int min = 301;
		int sum = 0;
		for(int i=0;i<3;i++) {
			scores[i]=Integer.parseInt(st.nextToken());
			sum+=scores[i];
			min = Math.min(min, scores[i]);
		}
		
		if(sum>=100) System.out.println(univ[3]);
		else {
			for(int i=0;i<3;i++) {
				if(min==scores[i]) {
					System.out.println(univ[i]);
					break;
				}
			}
		}
		
		br.close();
	}
}
