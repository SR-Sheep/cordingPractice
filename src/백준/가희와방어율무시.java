package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 가희와방어율무시 {
	//https://www.acmicpc.net/submit/25238
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int era=Integer.parseInt(st.nextToken()); //방어율
		int defIg=Integer.parseInt(st.nextToken()); //방무
		int result = era*(100-defIg)/100;
		System.out.println(result>=100?0:1);
		br.close();
	}
}
