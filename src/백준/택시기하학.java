package 백준;

import java.io.*;

public class 택시기하학 {
	
	//https://www.acmicpc.net/problem/3053
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int r = Integer.parseInt(br.readLine());
		//유클리드 기하학 ( r^2 * 파이 )
		bw.append(r*r*Math.PI+"\n");
		//택시 기하학 (r^2 * 2)
		bw.append(r*r*2+"\n");
		br.close();
		bw.close();
	}
}
