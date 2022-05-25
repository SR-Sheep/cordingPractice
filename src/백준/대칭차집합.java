package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 대칭차집합 {
	//https://www.acmicpc.net/problem/1269
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		//교집합의 개수
		int count = 0;
		Set<Integer> set = new HashSet<>();
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st=new StringTokenizer(br.readLine());
		//set에 존재하면 교집합
		for(int i=0;i<m;i++) {
			if(set.contains(Integer.parseInt(st.nextToken()))) {
				count++;
			}
		}
		//(n-교집합)+(m-교집합) 출력
		System.out.println(n+m-2*count);
		br.close();
	}
}
