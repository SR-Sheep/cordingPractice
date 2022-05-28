package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class 서로다른부분문자열의개수 {
	//https://www.acmicpc.net/problem/11478
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] arr = br.readLine().toCharArray();
		int l = arr.length;
		
		Set<String> set = new HashSet<>();
		
		for(int i=0;i<l;i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=i;j<l;j++) {
				sb.append(arr[j]);
				set.add(sb.toString());
			}
		}
		
		System.out.println(set.size());
		
		br.close();
	}
}
