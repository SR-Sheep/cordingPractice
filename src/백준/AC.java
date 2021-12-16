package ����;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class AC {
	//https://www.acmicpc.net/problem/5430
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			ArrayDeque<Integer> dq = new ArrayDeque<Integer>();
			char[] cmds = br.readLine().toCharArray();
			int m = Integer.parseInt(br.readLine());
			String tmp = br.readLine();
			String[] tmpArr= tmp.substring(1,tmp.length()-1).split(",");
			try {
				for(String s:tmpArr) {
					dq.add(Integer.parseInt(s));
				}
			} catch (Exception e) {
			}	
			try {
				boolean isBackward = false;
				for(char c:cmds) {
					//R�� ���, ���� ��ȯ
					if(c=='R') {
						isBackward=!isBackward;
					//�������ϰ��
					}else if(isBackward){
						dq.removeLast(); //�ڿ��� ����
					//�������ϰ��
					}else {
						dq.removeFirst(); //�տ��� ����
					}
				}
				StringBuilder sb = new StringBuilder("[");
				//���� �������� ���
				if(isBackward) {
					while(!dq.isEmpty()) {
						sb.append(dq.pollLast()).append(",");
					}
				//���� �������� ���	
				}else {
					while(!dq.isEmpty()) {
						sb.append(dq.pollFirst()).append(",");
					}
				}
				if(sb.length()>1) sb.deleteCharAt(sb.length()-1);
				sb.append("]\n"); //������ �޸� ������ ���ȣ �ݱ�
				bw.append(sb);
			} catch (Exception e) {
				bw.append("error\n"); //������ ���� ǥ��
			}
		}
		br.close();
		bw.close();
	}
}
