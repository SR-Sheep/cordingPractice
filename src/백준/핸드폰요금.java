package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 핸드폰요금 {
	//https://www.acmicpc.net/problem/1267
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		int m = 0; //민식 요금제 합
		int y = 0; //영식 요금제 합
		
		StringTokenizer st=new StringTokenizer(br.readLine());
		for(int i=0;i<t;i++) {
			int time=Integer.parseInt(st.nextToken()); //통화시간
			y+=10*(time/30+1); //30초마다 10원씩
			m+=15*(time/60+1); //60초마다 15원씩
		}
		if(y>m) {
			System.out.println("M "+m);
		}else if(y<m) {
			System.out.println("Y "+y);
		}else {
			System.out.println("Y M "+m);
		}
		br.close();
	}
}
