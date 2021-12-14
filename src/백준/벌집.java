package น้มุ;

import java.io.*;

public class น๚มý {
	//https://www.acmicpc.net/problem/2292
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int num = 1;
		int d = 6;
		int answer = 1;
		while(num<n) {
			answer++;
			num+=d;
			d+=6;
		}
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
