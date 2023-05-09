package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZOAC_ToFindPassword {
	//�ִ����� : ��Ŭ���� ȣ����
	public static long gcd(long n, long m) {
		if(m==0) return n;
		return gcd(m, n%m);
	}
	//�ּҰ���� = a*b / �ִ�����
	public static long lcm(long n, long m) {
		if(n>m) return n*m/gcd(n,m);
		return n*m/gcd(m,n);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		long k=Long.parseLong(st.nextToken());
		long n=Long.parseLong(st.nextToken());
		st=new StringTokenizer(br.readLine());
		long num=Long.parseLong(st.nextToken());
		for(long i=1;i<n;i++) {
			num=lcm(num,Long.parseLong(st.nextToken()));
		}
		System.out.println(num-k);
		br.close();
	}
}
