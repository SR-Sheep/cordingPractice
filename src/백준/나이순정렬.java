package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 나이순정렬 {
	//https://www.acmicpc.net/problem/10814
	//클래스 이용
	static class Member implements Comparable<Member>{
		private int age; //나이
		private String name; //이름
		public Member(StringTokenizer st) {
			this.age = Integer.parseInt(st.nextToken()); //나이 저장
			this.name = st.nextToken(); //이름 저장
		}
		@Override //출력
		public String toString() {
			return age+" "+name;
		}
		@Override //순서
		public int compareTo(Member o) {
			return this.age-o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //반복수
		StringTokenizer st;
		List<Member> members = new ArrayList<>(); //저장할 리스트
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			Member member = new Member(st); //생성
			members.add(member); //리스트에 추가
		}
		Collections.sort(members); //정렬
		for(Member m:members) bw.append(m+"\n"); //출력
		br.close();
		bw.close();
	}
}
