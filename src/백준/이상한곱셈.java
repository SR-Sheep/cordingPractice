package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이상한곱셈 {
	//https://www.acmicpc.net/problem/1225
	//모든 자리의 수를 합치는 메서드
	public static long sumOfNumbers(String num) {
		long sum = 0;
		for(char c:num.toCharArray()) {
			sum+=c-'0';
		}
		return sum;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		String a = st.nextToken();
		String b = st.nextToken();
		//모든 자리 수의 합 간의 곱
		System.out.println(sumOfNumbers(a)*sumOfNumbers(b));
		br.close();
	}
}
