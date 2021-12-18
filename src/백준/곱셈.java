package น้มุ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ฐ๖ผภ {
	//https://www.acmicpc.net/problem/1629
	
	public static long solution(int n, int m, int div) {
		if(m==1) {
			return n%div;
		} 
		long tmp = solution(n, m/2, div);
		if(m%2==1) {
			return ((tmp*tmp)%div)*(n%div)%div;
		}
		return tmp*tmp%div;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		int div=Integer.parseInt(st.nextToken());
		long answer = solution(n, m, div);
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}
}
