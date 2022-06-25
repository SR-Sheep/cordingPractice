package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 영수증 {
	//https://www.acmicpc.net/problem/25304
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int receipt = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		int sum =0;
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			int price=Integer.parseInt(st.nextToken());
			int count=Integer.parseInt(st.nextToken());
			sum+=price*count;
		}
		System.out.println(receipt==sum?"Yes":"No");
		br.close();
	}
}
