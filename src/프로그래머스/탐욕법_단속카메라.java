package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ž���_�ܼ�ī�޶� {
	/*
	��ӵ��θ� �̵��ϴ� ��� ������ ��ӵ��θ� �̿��ϸ鼭 �ܼӿ� ī�޶� �� ���� �������� ī�޶� ��ġ�Ϸ��� �մϴ�.

	��ӵ��θ� �̵��ϴ� ������ ��� routes�� �Ű������� �־��� ��,
	��� ������ �� ���� �ܼӿ� ī�޶� �������� �Ϸ���
	�ּ� �� ���� ī�޶� ��ġ�ؾ� �ϴ����� return �ϵ��� solution �Լ��� �ϼ��ϼ���.

	���ѻ���

	������ ����� 1�� �̻� 10,000�� �����Դϴ�.
	routes���� ������ �̵� ��ΰ� ���ԵǾ� ������ routes[i][0]���� i��° ������ ��ӵ��ο� ������ ����,
	routes[i][1]���� i��° ������ ��ӵ��ο��� ���� ������ ���� �ֽ��ϴ�.
	������ ����/���� ������ ī�޶� ��ġ�Ǿ� �־ ī�޶� ���������� �����մϴ�.
	������ ���� ����, ���� ������ -30,000 �̻� 30,000 �����Դϴ�.

	*/
	
	public static int solution(int[][] routes) {
        int answer = 0;
        //���� ������ ������ ����
        Arrays.sort(routes,(x,y)->x[1]-y[1]);
        //list�� ����ֱ�
        List<int[]> list = new ArrayList<>();
        for(int[] route:routes) list.add(route);
        
        while(!list.isEmpty()) {
        	int[] now=list.get(0);
        	int camera = now[1];//������ ������ ī�޶� ��ġ
        	for(int i=0;i<list.size();i++) {
        		int[] car = list.get(i);
                //�������<=ī�޶������̸� �ش� ������ ����� �ٽ� ����
        		if(car[0]<=camera) list.remove(i--); 
        	}  
            //ī�޶� �� ����
        	answer++;
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[][] routes= {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
		System.out.println(solution(routes));
		
	}

}
