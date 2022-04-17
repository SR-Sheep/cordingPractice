package 백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class 패션왕신해빈 {
	
	//https://www.acmicpc.net/problem/9375
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine()); //케이스 개수
			//옷의 종류 수를 저장할 맵, 각 종류의 기본값은 아무것도 착용하지 않는 경우인 1
			HashMap<String,Integer> map = new LinkedHashMap<>();
			for(int j=0;j<m;j++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken(); //의류 이름, 필요 없음
				String wear = st.nextToken(); //의류 종류
				//종류 : 기본값 1 에서 1씩 증가
				map.put(wear, map.getOrDefault(wear, 1)+1);
			}
			int answer = 1;
			//value의 값을 모두 곱함
			for(String key:map.keySet()) {
				answer*=map.get(key);
			}
			bw.append(answer-1+"\n"); //모두 미착용하는 경우 제외 (-1)
		}
		br.close();
		bw.close();
	}
}
