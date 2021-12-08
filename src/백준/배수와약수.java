package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 배수와약수 {
	
	//https://www.acmicpc.net/problem/5086
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] print = {"factor","multiple","neither"};
		StringTokenizer st=new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		while(a!=0&&b!=0) {
			if(b%a==0) bw.append(print[0]+"\n"); //약수
			else if(a%b==0) bw.append(print[1]+"\n"); //배수
			else bw.append(print[2]+"\n"); //둘다 아님
			//다음 수
			st=new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
		}
		br.close();
		bw.close();
	}
}
