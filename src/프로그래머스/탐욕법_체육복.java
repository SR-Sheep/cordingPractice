package ���α׷��ӽ�;

import java.util.*;

public class Ž���_ü���� {
	static class Ex{
		private int n;
		private int[] lost, reserve;
		
		public Ex(int n, int[] lost, int[] reserve) {
			this.n=n;
			this.lost=lost;
			this.reserve=reserve;
		}

		public int getN() {
			return n;
		}

		public void setN(int n) {
			this.n = n;
		}

		public int[] getLost() {
			return lost;
		}

		public void setLost(int[] lost) {
			this.lost = lost;
		}

		public int[] getReserve() {
			return reserve;
		}

		public void setReserve(int[] reserve) {
			this.reserve = reserve;
		}
		 
	}
	
	
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        //������ �ִ� �л��� ������ �迭, �ִ� �л��� 30��
        boolean[] student =new boolean[30];
        Arrays.sort(lost);//�л� ��ȣ ����
        //������ ������ true
        for(int r:reserve) {
        	int idx=r-1;
        	student[idx]=true;
        }
        //�Ҿ���� �л��� ���� list
        List<Integer> list = new ArrayList<Integer>();
        
        for(int l:lost) {
        	int idx=l-1;
        	//�Ҿ�������� ������ ������
        	//�ڽ��� �԰� �� ����
        	if(student[idx]) {
        		answer++;
        		student[idx]=false;
        	}else {
        		//���� ���� �� ����Ʈ�� �߰�
        		list.add(idx);
        	}
        }
        
        for(int idx:list) {
        	//�� �չ�ȣ ü���� ������ �ش� ������ ������ ����
        	if(idx-1>=0&&student[idx-1]) {
        		student[idx-1]=false;
        		answer++;
    		//�ջ�� ������ �� �޹�ȣ�� ü������ ������ �ش� ������ ������ ����
        	}else if(idx+1<30&&student[idx+1]) {
        		student[idx+1]=false;
        		answer++;
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		List<Ex> list = new ArrayList<>();
		list.add(new Ex(5,new int[] {2,4},new int[] {1,3,5})); //5
		list.add(new Ex(5,new int[] {2,4},new int[] {3})); //4
		list.add(new Ex(3,new int[] {3},new int[] {1})); //2
		list.add(new Ex(5,new int[] {1,2,3},new int[] {2,3,4})); //4
		list.add(new Ex(5,new int[] {2,3,4},new int[] {1,2,3})); //4
		for(Ex ex:list) {
			System.out.println(solution(ex.getN(), ex.getLost(), ex.getReserve()));
		}
	}
}
