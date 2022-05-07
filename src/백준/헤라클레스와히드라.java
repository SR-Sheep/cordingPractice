package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 헤라클레스와히드라 {
	//https://www.acmicpc.net/problem/10205
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for(int i=1;i<=t;i++) {
			bw.append("Data Set "+i+":\n");
			
			int heads=Integer.parseInt(br.readLine());
			String attack = br.readLine();
			
			for(char c:attack.toCharArray()) {
				if(c=='c') {
					heads++;
				}else {
					heads--;
				}
			}
			
			bw.append(heads+"\n\n");
			
		}
		bw.close();
		br.close();
	}
}
