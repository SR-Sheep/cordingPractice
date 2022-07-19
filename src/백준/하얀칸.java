package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 하얀칸 {
	//https://www.acmicpc.net/problem/1100
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = 0;
		for(int i=0;i<8;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				char c = s.charAt(j);
				if(c=='F'&&(i+j)%2==0) { //f이고 행+열의 합의 짝수이면 흰칸
					count++;
				}
			}
		}
		System.out.println(count);
		br.close();
	}
}
