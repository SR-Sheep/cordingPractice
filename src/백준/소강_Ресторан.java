package ����;

import java.io.*;
import java.util.HashMap;

public class �Ұ�_���֬����Ѭ� {
	
	//https://www.acmicpc.net/problem/23738
	
	public static void main(String[] args) throws IOException {
		//�� �غ�
		HashMap<Character, String> map = new HashMap<>();
		map.put('A',"a");
		map.put('B',"v");
		map.put('E',"ye");
		map.put('K',"k");
		map.put('M',"m");
		map.put('H',"n");
		map.put('O',"o");
		map.put('P',"r");
		map.put('C',"s");
		map.put('T',"t");
		map.put('Y',"u");
		map.put('X',"h");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s = br.readLine();
		//���� ����� ��Ʈ������
		StringBuilder sb = new StringBuilder();
		//�ʿ��� �ش� ���� ���̱�
		for(char c:s.toCharArray()) {
			sb.append(map.get(c));
		}
		//���
		bw.append(sb.toString()+"\n");
		br.close();
		bw.close();
	}
}
