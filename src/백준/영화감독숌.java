package 백준;

import java.io.*;
import java.util.*;

public class 영화감독숌 {
	public static int solution(int n) {
		int num=666;
		List<Integer> list = new ArrayList<Integer>();
		while(list.size()<n) {
			if(Integer.toString(num).contains("666")) list.add(num);
			num++;
		}
		return list.get(n-1);
	}
	
	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int n = Integer.parseInt(st.nextToken());
//		br.close();
//		System.out.println(solution(n));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) list.add(Integer.parseInt(br.readLine()));
        br.close();
        Collections.sort(list);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i:list) bw.write(i+"\n");;
		bw.close();
	}
}
