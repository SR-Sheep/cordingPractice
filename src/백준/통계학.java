package ����;

import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class ����� {
	//https://www.acmicpc.net/problem/2108
	//1) ������ 2) �߾Ӱ� 3) �ֺ� 4) ����
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		//1) ������ 2) �߾Ӱ� 3) �ֺ� 4) ����
		float average = 0;
		int median=0,mode=0,range=0; 
		int max=-4001,min=4001;
		HashMap<Integer, Integer> map  = new HashMap<Integer, Integer>();
		for(int i=0;i<n;i++) {
			int num = Integer.parseInt(br.readLine());
			//�߾� �� �ֺ�
			map.put(num, map.getOrDefault(num, 0)+1);
			//���
			average+= num;
			//����
			max=Math.max(max, num);
			min=Math.min(min, num);
		}
		br.close();
		if(n!=1) {
			//���
			average= Math.round(average/n);
			//�߾� �� �ֺ�
			List<Entry<Integer,Integer>> list = new ArrayList<>(map.entrySet());
			//�߾�
			Collections.sort(list,Entry.comparingByKey());
			int v=0;
			for(Entry<Integer,Integer> e:list) {
				v+=e.getValue();
				if(v>n/2) {
					median=e.getKey();
					break;
				}
			}
			//�ֺ�
			Collections.sort(list,new Comparator<Entry<Integer,Integer>>() {
				@Override
				public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
					if(o1.getValue()>o2.getValue()) return -1;
					else if(o1.getValue()<o2.getValue()) return 1;
					else {
						if(o1.getKey()<o2.getKey()) return -1;
						else if(o1.getKey()>o2.getKey()) return 1;
						else return 0;
					}
				}
			});
			if(list.get(0).getValue()!=list.get(1).getValue()) mode=list.get(0).getKey();
			else mode=list.get(1).getKey();
			//����
			range=max-min;
			System.out.println(list);
		}else {
			mode=median=(int)average;
			range=0;
		}
		//���
		bw.write((int)average+"\n");
		bw.write(median+"\n");
		bw.write(mode+"\n");
		bw.write(range+"\n");
		bw.close();
	}
}
