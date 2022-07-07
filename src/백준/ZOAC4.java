package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC4 {
	//https://www.acmicpc.net/problem/23971
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int w=Integer.parseInt(st.nextToken());//가로길이
		int h=Integer.parseInt(st.nextToken());//세로길이
		int n=Integer.parseInt(st.nextToken());//세로 비우는 칸
		int m=Integer.parseInt(st.nextToken());//가로 비우는 칸
		long answer = ((w-1)/(n+1)+1)*((h-1)/(m+1)+1); //계산
		System.out.println(answer);//출력
		br.close();
	}
}
