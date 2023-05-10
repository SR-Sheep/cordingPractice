package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/26069
public class 붙임성좋은총총이 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		set.add("ChongChong"); //총총이는 먼저 춤을 춘다
		StringTokenizer st;
		while(n-->0) {
			st=new StringTokenizer(br.readLine());
			String tokki1 = st.nextToken(); //토끼1
			String tokki2 = st.nextToken(); //토끼2
			//토끼1이 춤을 추고 있다면
			if(set.contains(tokki1)) {
				set.add(tokki2); //토끼1을 set에 추가
			//토끼2이 춤을 추고 있다면
			}else if(set.contains(tokki2)) {
				set.add(tokki1); //토끼2를 set에 추가
			}
		}
		//춤추는 토끼 집단의 크기를 출력
		System.out.println(set.size());
		br.close();
	}
}
