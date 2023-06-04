package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 재밌는나머지연산 {
	
	public static long getRemainderSum(long n, long r) {
		long sum = 0;
		long tmp = n - r;
		for(long i=1;i*i<=tmp;i++) {
			if(tmp%i==0) {
				if(n%i==r) {
					sum+=i;
				}
				if(i*i!=tmp && n%(tmp/i)==r) {
					sum+=tmp/i;
				}
			}
		}
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
