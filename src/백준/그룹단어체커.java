package 백준;

import java.io.*;
import java.util.*;

public class 그룹단어체커 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int answer=0;
		for(int i=0;i<n;i++) {
			String s = br.readLine();
			List<Character> list = new ArrayList<>();
			char before = s.charAt(0);
			list.add(before);
			boolean isGroup = true;
			for(int j=1;j<s.length();j++) {
				if(before!=s.charAt(j)) {
					if(list.contains(s.charAt(j))) {
						isGroup=false;
						break;
					}else {
						list.add(s.charAt(j));
					}
				}
				before = s.charAt(j);
			}
			if(isGroup) answer++;
		}
		br.close();
		bw.append(answer+"\n");
		bw.close();
	}
}
