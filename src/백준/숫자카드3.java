package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 숫자카드3 {
	//https://www.acmicpc.net/problem/21394
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		//테스트 수
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			StringBuilder sb=new StringBuilder();
			//숫자를 담을 배열 (0~9, 0은 사용 안함)
			int[] nums = new int[10];
			int sum = 0;
			for(int j=1;j<10;j++) {
				int num = Integer.parseInt(st.nextToken());
				sum+=num;
				//6은 9로 사용
				if(j==6) {
					nums[9]+=num;
				}else {
					nums[j]+=num;
				}
				
			}
			boolean isLeft = false;
			if(sum%2==1) isLeft=true;
			//1부터 시작
			int idx = 1;
			while(idx<10) {
				while(nums[idx]>0) {
					//왼쪽에 위치하면 맨 앞에 숫자 넣기
					if(isLeft) {
						sb.insert(0, idx+" ");
					//오른쪽에 위치하면 맨 뒤에 숫자 넣기
					}else {
						sb.append(idx+" ");
					}
					//위치 반전
					isLeft=!isLeft;
					nums[idx]--;
				}
				//숫자 증가
				idx++;
			}
			bw.append(sb.append("\n"));
		}
		bw.close();
		br.close();
	}
}
