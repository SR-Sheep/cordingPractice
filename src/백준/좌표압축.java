package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 좌표압축 {
	//https://www.acmicpc.net/problem/18870
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		int[] nums = new int[n];
		for(int i=0;i<n;i++) {
			nums[i]=Integer.parseInt(st.nextToken());
		}
		int[] order = nums.clone();
		Arrays.sort(order);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int idx=0;
		for(int i:order) {
			if(!map.containsKey(i)) {
				map.put(i, idx++);
			}
		}
		for(int i:nums) {
			bw.append(map.get(i)+" ");
		}
		br.close();
		bw.close();
	}
}
