package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연속XOR {
	//https://www.acmicpc.net/problem/25306
	//1~l까지의 XOR 연산 결과
	public static long getXORSum(long l) {
		long remainder = l%4;
		if(remainder==0) {
			return l;
		}else if(remainder==1) {
			return 1;
		}else if(remainder==2) {
			return l+1;
		}else {
			return 0;
		}
	}
	//start~end까지 XOR 연산 결과
	//= (1~(start-1) XOR 연산 결과) ^ (1~end XOR 연산 결과)
	public static long getStreamXOR(long start, long end) {
		return getXORSum(start-1)^getXORSum(end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long start=Long.parseLong(st.nextToken());
		long end=Long.parseLong(st.nextToken());
		System.out.println(getStreamXOR(start, end));
		br.close();
	}
}
