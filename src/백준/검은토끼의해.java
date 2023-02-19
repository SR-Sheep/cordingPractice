package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 검은토끼의해 {
	//속도 상관없이 완전탐색
	static char[] WinNumber = {'2','0','2','3'};
	
	public static boolean isWin(int number) {
		String numberStr = String.valueOf(number);
		int idx = 0;
		for(char c:numberStr.toCharArray()) {
			if(idx>3) break;
			if(c==WinNumber[idx]) idx++;
		}
		return idx>3?true:false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer = 0;
		for(int i=2023;i<=n;i++) {
			if(isWin(i)) answer++;
		}
		System.out.println(answer);
		bw.close();
		br.close();
	}
}
