package ����;

import java.io.*;
import java.util.*;

public class ��Ʈ�λ���Ʈ {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] tmp = br.readLine().split("");
		int[] arr = new int[tmp.length];
		for(int i=0;i<tmp.length;i++) {
			arr[i]=Integer.parseInt(tmp[i]);
		}
		Arrays.sort(arr);
		for(int i=arr.length-1;i>=0;i--) bw.append(arr[i]+"");
		bw.append("\n");
		br.close();
		bw.close();
	}
}
