package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 가장긴증가하는부분수열2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());
		List<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for(int i=0;i<n;i++) {
			int num=Integer.parseInt(st.nextToken());
			if(list.get(list.size()-1)<num) list.add(num);
			else {
				//이분 탐색으로 list의 적당한 자리 찾기
				int left = 0, right = list.size()-1, mid =-1, idx = 0;
				while(left<=right) {
					mid = (left+right)/2;
					if(list.get(mid)>=num) {
						right = mid -1;
						idx = mid;
					}else {
						left = mid +1;
					}
				}
				list.set(idx, num);
			}
		}
		System.out.println(list.size()-1);
		br.close();
	}
}
