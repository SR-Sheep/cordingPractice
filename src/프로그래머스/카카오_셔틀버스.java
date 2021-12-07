package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class īī��_��Ʋ���� {
	
	//https://programmers.co.kr/learn/courses/30/lessons/17678
	
    public static int bus(int n, int t){
        return 9*60+(n-1)*t; 
    }
    
    public static String solution(int n, int t, int m, String[] timetable) {
        int answer=-1;
        List<Integer> list = new ArrayList<>(); //�ð��� ������ ����Ʈ ����
        for(String time:timetable){
            String[] hs = time.split(":");
            int dep = Integer.parseInt(hs[0])*60+Integer.parseInt(hs[1]);
            list.add(dep); //�ʷ� ��ȯ �� ����Ʈ�� �ֱ�
        }
        Collections.sort(list); //���� �� ����
        for(int i=1;i<n;i++){
            int busTime = bus(i,t); //������ ���� �ð�
            for(int j=0;j<m;j++){
            	//���� �ð����� ���� �� ũ�簡 ������ ž��
                if(busTime<list.get(0)) break;
                list.remove(0);
            }
        }
        //������ ���� �ð�
        int lastBusTime = bus(n,t);
        int count = 0;
        //���� �� �°� �� ����
        for(int time:list){
            if(time<=lastBusTime){
                count++;
            }else{
                break;
            }
        }
        //�ڸ��� ������ ������ �����ð��� ž��
        if(m>count) answer = lastBusTime;
        //�ڸ��� �ȳ����� ������ �°����� 1�� ���� ž��
        else answer = list.get(m-1)-1;
        //00:00 �������� ����
        return String.format("%02d:%02d",answer/60,answer%60);
    }
    public static void main(String[] args) {
		int n=2, t=10, m=2;
		String[] timetable = {"09:10", "09:09", "08:00"};
		System.out.println(solution(n, t, m, timetable));
	}
}
