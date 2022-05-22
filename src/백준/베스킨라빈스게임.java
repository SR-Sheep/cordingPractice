package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 베스킨라빈스게임 {
	//https://www.acmicpc.net/problem/20004
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken()); //도달 숫자
		long m=Long.parseLong(st.nextToken()); //최대 개수
		//불러야 하는 수
		long callNumber = n-1;
		long term = m+1;
		
		callNumber%=term;
		String answer = "";
		if(callNumber!=0&&callNumber<m) answer = "Can win"; 
		else answer = "Can't win";
		
		System.out.println(answer);
		
		br.close();
	}
}
