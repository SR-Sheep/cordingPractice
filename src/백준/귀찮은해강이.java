package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 귀찮은해강이 {
	//https://www.acmicpc.net/problem/24391
	static int[] Roots;
	
	static int getRoot(int num) {
		if(Roots[num]==num) {
			return num;
		}
		Roots[num]=getRoot(Roots[num]);
		return Roots[num];
	}
	
	static void setRoot(int a, int b) {
		if(a>b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		Roots[getRoot(b)]=getRoot(a);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		
		Roots = new int[n+1];
		for(int i=1;i<=n;i++) {
			Roots[i]=i;
		}
		
		int t=Integer.parseInt(st.nextToken());
		for(int i=0;i<t;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			setRoot(a, b);
		}
		int answer = 0;
		
		st=new StringTokenizer(br.readLine());
		int before=Integer.parseInt(st.nextToken());
		for(int i=2;i<=n;i++) {
			int now=Integer.parseInt(st.nextToken());
			if(getRoot(before) !=getRoot(now)) answer++;
			before=now;
		}
		System.out.println(answer);
		br.close();
	}
}
