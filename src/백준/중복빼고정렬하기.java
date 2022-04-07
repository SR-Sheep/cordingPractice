package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class 중복빼고정렬하기 {
	//https://www.acmicpc.net/problem/10867
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		//1) set 이용
//		Set<Integer> set = new HashSet<>();
//		for(int i=0;i<n;i++) {
//			int num=Integer.parseInt(st.nextToken());
//			set.add(num);
//		}
//		List<Integer> list = new ArrayList<>();
//		for(Integer i:set) {
//			list.add(i);
//		}
//		Collections.sort(list);
//		for(Integer i:list) {
//			bw.append(i+" ");
//		}
		//2) 배열 이용
		int[] nums = new int[2001]; //-1000 ~ 1000
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			nums[num+1000]=1;
		}
		for(int i=0;i<2001;i++) {
			if(nums[i]!=0) {
				bw.append((i-1000)+" ");
			}
		}
		br.close();
		bw.close();
	}
}
