package 백준;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 와이파이 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int answer = 0;
		int[] wifi = new int[n];
		List<int[]> list = new ArrayList<int[]>();
		
		for(int i=0;i<n;i++) {
			int[] tmp = new int[3];
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				tmp[j]=Integer.parseInt(st.nextToken());
			}
			list.add(tmp);
		}
		for(int i=0;i<list.size();i++) {
			int[] curr =list.get(i);
			wifi[i]-=curr[2];
			for(int j=0;j<list.size();j++) {
				int[] other = list.get(j);
				int p= curr[2];
				int x = curr[0]-other[0];
				int y = curr[1]-other[1];
				if(x<0) x*=-1;
				if(y<0) y*=-1;
				p-=(x+y);
				if(p>0) {
					wifi[j]-=p;
				}
			}
		}
		for(int i:wifi) {
			answer=Math.max(answer, i);
		}
		if(answer==0) bw.append("IMPOSSIBLE\n");
		else bw.append(answer+"\n");
		
		
		br.close();
		bw.close();
	}
}
