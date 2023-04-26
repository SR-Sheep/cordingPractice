package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/27963
public class 합금주화 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		double d1 = Double.parseDouble(st.nextToken()); //밀도1
		double d2 = Double.parseDouble(st.nextToken()); //밀도2
		double x = Double.parseDouble(st.nextToken()); //높은 밀도의 비율
		//d1이 큰것으로 수정
		if(d1<d2) {
			double tmp = d1;
			d1 = d2;
			d2 = tmp;
		}
		double tmp1 = 1/d1 * x;
		double tmp2 = 1/d2 * (100-x);
		double answer = 100/(tmp1+tmp2);		
		System.out.println(answer);
		br.close();
	}
}
