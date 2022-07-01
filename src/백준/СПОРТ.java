package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class СПОРТ  {
	static boolean[] Visited;
	static char[] SArr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	public static void getString (int l, String s, int count) throws IOException {
		if(count==l) {
			bw.append(s+"\n");
			return;
		}
		for(int i=0;i<l;i++) {
			if(!Visited[i]) {
				Visited[i]=true;
				getString(l, s+SArr[i], count+1);
				Visited[i]=false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		SArr = s.toCharArray();
		Arrays.sort(SArr);
		int l = s.length();
		Visited = new boolean[l];
		getString(l, "", 0);
		bw.close();
		br.close();
	}
}
