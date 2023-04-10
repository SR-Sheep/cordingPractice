package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
//https://www.acmicpc.net/problem/27943
public class 가지사진찾기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long n = Long.parseLong(br.readLine());
		long left = 1;
		long right = n;
		long mid = (1+n)/2;
		bw.append("? "+mid+"\n");
		bw.flush();
		String gaji = br.readLine(); //가운데는 무조건 가지!
		
		long min = left;
		right = mid;
		//1) 왼쪽 탐색
		while(left<=right) {
			mid = (left+right)/2;
			bw.append("? "+mid+"\n");
			bw.flush();
			String feedback = br.readLine();
			if(feedback.equals(gaji)) {
				right = mid-1;
				min = mid;
			}else {
				left = mid+1;
			}
		}
		long max = n;
		//2) 오른쪽 탐색
		left = (1+n)/2;
		right = n;
		while(left<=right) {
			mid = (left+right)/2;
			bw.append("? "+mid+"\n");
			bw.flush();
			String feedback = br.readLine();
			if(feedback.equals(gaji)) {
				left = mid+1;
				max = mid;
			}else {
				right = mid-1;
			}
		}
		bw.append("! "+min+" "+max+"\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
