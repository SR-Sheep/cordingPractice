package 백준;

import java.io.*;
import java.util.*;

public class 단어정렬 {
	//https://www.acmicpc.net/problem/1181
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		
		Set<String> set = new HashSet<String>(); //중복제거를 위한 set
		
		for(int i=0;i<n;i++) {
			set.add(br.readLine()); //단어 추가
		}
		
		String[] s = new String[set.size()];
		int idx=0;
		for(String str:set) {
			s[idx++]=str; //배열에 단어 저장
		}
		//정렬
		Arrays.sort(s,new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				//길이가 짧으면 앞으로
				if(o1.length()>o2.length()) return 1;
				else if(o1.length()<o2.length()) return -1;
				//길이가 같으면 사전 순
				return o1.compareTo(o2);
			}
		});
		//출력
		for(String str:s) bw.append(str+"\n");
		br.close();
		bw.close();
	}
}
