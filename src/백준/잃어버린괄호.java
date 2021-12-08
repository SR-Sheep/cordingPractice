package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 잃어버린괄호 {
	
	//https://www.acmicpc.net/problem/1541
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine(),"+-",true);
		int sum = Integer.parseInt(st.nextToken());
		char c =' ';
		int num = 0;
		boolean allPlus = true;
		//마이너스를 만난 시점부터 sum에서 수 빼기
		while(st.hasMoreTokens()) {
			c = st.nextToken().charAt(0);
			num = Integer.parseInt(st.nextToken());
			if(allPlus) { 
				if(c=='+') {
					sum+=num; //+면 더하기
				}else {
					allPlus = false;
					sum-=num;
				}
			}else {
				sum-=num;
			}
		}
		bw.append(sum+"\n");
		br.close();
		bw.close();
	}
}
