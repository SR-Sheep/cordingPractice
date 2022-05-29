package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Strfry {
	//https://www.acmicpc.net/problem/11328
	
	public static boolean isStrfry(String before, String after) {
		int[] letters = new int[26];
		if(before.length()!=after.length()) return false;
		
		for(char c:before.toCharArray()) {
			int idx = c-'a';
			letters[idx]++;
		}
		for(char c:after.toCharArray()) {
			int idx = c-'a';
			if(letters[idx]--==0) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] answer = {"Possible","Impossible"};
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			String before = st.nextToken();
			String after = st.nextToken();
			bw.append(isStrfry(before, after)?answer[0]:answer[1]).append("\n");
		}
		bw.close();
		br.close();
	}
}
