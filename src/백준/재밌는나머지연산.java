package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재밌는나머지연산 {
	//https://www.acmicpc.net/problem/28138
	
	public static long getRemainderSum(long n, long r) {
		long sum = 0;
		long tmp = n - r; //n-r을 한 수의 약수 중 조건에 해당되는 경우 합
		for(long i=1;i*i<=tmp;i++) {
			if(tmp%i==0) {
				//i로 n을 나누었을 때, r인 경우
				if(n%i==r) {
					sum+=i;
				}
				//i의 파트너로 n을 나누었을 때, r인 경우
				//(단 i*i 가 tmp 인경우 중복임으로 제외)
				if(i*i!=tmp && n%(tmp/i)==r) {
					sum+=tmp/i;
				}
			}
		}
		//출력
        return sum;
	} 
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long n=Long.parseLong(st.nextToken());
		long r=Long.parseLong(st.nextToken());
		System.out.println(getRemainderSum(n, r));
		br.close();
	}
}
