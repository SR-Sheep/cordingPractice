package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;

public class �мǿս��غ� {
	
	//https://www.acmicpc.net/problem/9375
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			int m = Integer.parseInt(br.readLine()); //�غ�� ��ǰ ��
			HashMap<String,Integer> map = new LinkedHashMap<>(); //�� ���� 
			for(int j=0;j<m;j++) {
				st=new StringTokenizer(br.readLine());
				st.nextToken();
				String wear = st.nextToken(); //��ǰ ����
				map.put(wear, map.getOrDefault(wear, 1)+1); //��ǰ ������ ���� +1
			}
			int answer = 1;
			//(�� ��ǰ�� ���� +1) ��� ���ϱ�
			for(String key:map.keySet()) {
				answer*=map.get(key);
			}
			bw.append(answer-1+"\n"); //��� �� ���� �ϴ� ��� 1 ����
		}
		br.close();
		bw.close();
	}
}
