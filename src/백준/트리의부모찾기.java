package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[] nodes = new int[t+1];
		List<Integer> children = new ArrayList<Integer>();
		for(int i=0;i<t-1;i++) {
			st=new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			nodes[child]=parent;
		}
		
		for(int i=2;i<=t;i++) {
			bw.append(nodes[i]+"\n");
		}
		br.close();
		bw.close();
	}
}
