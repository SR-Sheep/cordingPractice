package ����;

import java.io.*;
import java.util.*;

public class �ܾ����� {
	
	//https://www.acmicpc.net/problem/1181
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>(); //�ߺ����Ÿ� ���� ��
		
		for(int i=0;i<n;i++) {
			set.add(br.readLine()); //�¿� �Է�
		}
		
		String[] s = new String[set.size()];
		int idx=0;
		for(String str:set) {
			s[idx++]=str; //�迭�� �ű��
		}
		//����
		Arrays.sort(s,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if(o1.length()>o2.length()) return 1; //���̰� ª�� ��
				else if(o1.length()<o2.length()) return -1;
				return o1.compareTo(o2); //
			}
		});
		
		for(String str:s) bw.append(str+"\n");
		br.close();
		bw.close();
	}
}
