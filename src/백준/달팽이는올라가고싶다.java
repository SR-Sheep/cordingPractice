package ����;

import java.io.*;
import java.util.StringTokenizer;

public class �����̴¿ö󰡰�ʹ� {
	
	//https://www.acmicpc.net/problem/2869
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int up = Integer.parseInt(st.nextToken()); //�ö󰡱�
		int down = Integer.parseInt(st.nextToken()); //�̲�������
		int length = Integer.parseInt(st.nextToken()); //�ö󰡾� �ϴ� �Ÿ�
		length-=up; //������ �ö󰡱� ����, �� 1 ����
		int diff = up-down; //����
		int answer = (int)Math.ceil((double)length/(double)diff)+1; //���� / ���� + 1
		
		bw.append(answer+"\n");
		br.close();
		bw.close();
	}

}
