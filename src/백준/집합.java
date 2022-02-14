package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 집합 {
	//https://www.acmicpc.net/problem/11723
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int s = 1<<20; //공집합
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			char cmd = st.nextToken().charAt(1);
			//all
			if(cmd=='l') {
				s=(1<<21) - 1;
			//empty	
			}else if(cmd=='m') {
				s=1<<20;
			}else {
				int x = Integer.parseInt(st.nextToken());
				int idx = 1<<x;
				//add
				if(cmd=='d') {
					s|=idx;
				//remove	
				}else if(cmd=='e') {
					s&=~idx;
				//check
				}else if(cmd=='h') {
					if(s==(s|idx)) {
						bw.append("1\n");
					}else {
						bw.append("0\n");
					}
				//toggle
				}else {
					if(s==(s|idx)) {
						s&=~idx;
					}else {
						s|=idx;
					}
				}
			}
		}
		br.close();
		bw.close();
	}
}
