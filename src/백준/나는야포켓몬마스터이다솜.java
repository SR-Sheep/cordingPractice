package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 나는야포켓몬마스터이다솜 {
	//https://www.acmicpc.net/problem/1620
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Map<String, Integer> pocketmonNumbers = new HashMap<>();
		String[] pocketmons = new String[n+1];
		
		for(int i=1;i<=n;i++) {
			String pocketmon = br.readLine();
			pocketmonNumbers.put(pocketmon, i);
			pocketmons[i]=pocketmon;
		}
		for(int j=0;j<m;j++) {
			String q = br.readLine();
			try {
				int num = Integer.parseInt(q);
				bw.append(pocketmons[num]+"\n");
			} catch (Exception e) {
				bw.append(pocketmonNumbers.get(q)+"\n");
			}
		}
		bw.close();
		br.close();
	}
}
