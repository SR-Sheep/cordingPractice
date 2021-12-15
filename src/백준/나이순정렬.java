package ����;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ���̼����� {
	//https://www.acmicpc.net/problem/10814
	//Ŭ���� �̿�
	static class Member implements Comparable<Member>{
		private int age; //����
		private String name; //�̸�
		public Member(StringTokenizer st) {
			this.age = Integer.parseInt(st.nextToken()); //���� ����
			this.name = st.nextToken(); //�̸� ����
		}
		@Override //���
		public String toString() {
			return age+" "+name;
		}
		@Override //����
		public int compareTo(Member o) {
			return this.age-o.age;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine()); //�ݺ���
		StringTokenizer st;
		List<Member> members = new ArrayList<>(); //������ ����Ʈ
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			Member member = new Member(st); //����
			members.add(member); //����Ʈ�� �߰�
		}
		Collections.sort(members); //����
		for(Member m:members) bw.append(m+"\n"); //���
		br.close();
		bw.close();
	}
}
