package 백준;

import java.io.*;
import java.util.*;

public class 기본_백준 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			int a = Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.write(n+"\n");
		bw.close();
	}
}
