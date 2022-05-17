package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 듣보잡 {
	//https://www.acmicpc.net/problem/1764
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		
		Map<String, Integer> map = new HashMap<>();//듣도 못한 사람들
		List<String> list = new ArrayList<String>();// 답 제출
		
		//듣도 못한 사람들
		for(int i=0;i<n+m;i++) {
			String name = br.readLine();
			if(!map.containsKey(name)) {
				map.put(name, 1);
			}else {
				list.add(name);
			}
		}
		//출력
		bw.append(list.size()+"\n");
		//정렬
		Collections.sort(list);
		for(String s:list) {
			bw.append(s+"\n");
		}
		bw.close();
		br.close();
	}
}
