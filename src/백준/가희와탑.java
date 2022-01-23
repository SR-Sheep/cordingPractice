package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 가희와탑 {
	//https://www.acmicpc.net/problem/24337
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int gahui=Integer.parseInt(st.nextToken());
		int danbi=Integer.parseInt(st.nextToken());
		//배열 생성
		int[] buildings = new int[n+1];
		//가희와 단비의 합이 n+1이 넘으면 불가(최대 중복건물 수는 1이므로 n+1이 최대)
		if(gahui+danbi>n+1) {
			bw.append("-1\n");
		}else {
			int max = Math.max(gahui, danbi);
			//맥스의 위치
			int idx = gahui==1?1:n-danbi+1;
			//맥스 값 설정
			buildings[idx]=max;
			//맥스값 왼쪽부터 gahui의 값 감소시키며 채우기, 1보다 작은 경우는 1 채우기
			for(int i=idx-1;i>=1;i--) {
				buildings[i]=gahui>1?--gahui:1;
			}
			//맥스값 오른쪽부터 n-danbi+1 까지 1 채우기
			for(int i=idx+1;i<=n-danbi+1;i++) {
				buildings[i]=1;
			}
			//맨 오른쪽 끝에서부터 1,2..danbi-1 까지 채우기
			for(int i=n-danbi+2;i<=n;i++) {
				buildings[i]=--danbi;
			}
			//출력
			for(int i=1;i<=n;i++) {
				bw.append(buildings[i]+" ");
			}
		}
		br.close();
		bw.close();
	}
}
