package ����;

import java.io.*;
import java.util.*;


public class �������� {
	//https://www.acmicpc.net/problem/23348
	static class Place{
		private String place;
		private int start, end;
		
		public Place(String place, int start,int end) {
			this.place = place;
			this.start = start;
			this.end=end;
		}
	}
	 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<String> names = new ArrayList<>();
		HashMap<String, int[]> map = new HashMap<>();
		List<Place> list = new ArrayList<>();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name=st.nextToken();
			if(names.contains(name)) continue; //�̸��� �����ϸ� ��Ƽ��
			names.add(name); //�̸� �߰�
			String place=st.nextToken();
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new Place(place, start, end)); //����Ʈ�� Ŭ���� ���·� ����
		} 
		br.close();
		//�̸��� ����
		Collections.sort(list,(x,y)->(x.place.compareTo(y.place)));
		
		//�ʱⰪ ����
		int max=0;
		String title="";
		int s=0;
		int e=0;
		//����Ʈ Ž��
		for(Place p:list) {
			//�ð� �迭 ����, �̹� �����ϸ� �ش� �迭�� ������
			int[] time=map.getOrDefault(p.place, new int[50001]);
			//����~������ �� ����
			for(int j=p.start;j<p.end;j++) {
				time[j]++;
				//�ִ밪���� ũ�� �ش� ��ҿ� max�� ������Ʈ
				if(max<time[j]) {
					title = p.place;
					max=time[j];
				}
			}
			map.put(p.place, time);
		}
		//�� ����� �ð� �迭
		int[] tmp = map.get(title);

		boolean flag =false;
		for(int i=1;i<50001;i++) {
			//ó������ max���� ������ s�� ����
			if(tmp[i]==max&&!flag) {
				s=i;
				flag=true;
			//ó������ max���� ���� ���� ������ e�� ���� �� break;
			}else if(tmp[i]<max&&flag){
				e=i;
				flag=false;
				break;
			}
		}
		//���� ������ �������� �ִ밪�� 50000���� ������Ʈ
		if(flag) e=50000;
		//���
		System.out.println(title+" "+s+" "+e);
		
	}
}
