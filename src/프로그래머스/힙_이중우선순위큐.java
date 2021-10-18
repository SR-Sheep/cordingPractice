package ���α׷��ӽ�;

import java.util.PriorityQueue;

public class ��_���߿켱����ť {
	/*
	���� �켱���� ť�� ���� ������ �� �� �ִ� �ڷᱸ���� ���մϴ�.

	��ɾ�	���� ž(����)
	I ����	ť�� �־��� ���ڸ� �����մϴ�.
	D 1	ť���� �ִ��� �����մϴ�.
	D -1	ť���� �ּڰ��� �����մϴ�.
	���� �켱���� ť�� �� ���� operations�� �Ű������� �־��� ��, ��� ������ ó���� �� ť�� ��������� [0,0] ������� ������ [�ִ�, �ּڰ�]�� return �ϵ��� solution �Լ��� �������ּ���.
	
	���ѻ���
	operations�� ���̰� 1 �̻� 1,000,000 ������ ���ڿ� �迭�Դϴ�.
	operations�� ���Ҵ� ť�� ������ ������ ��Ÿ���ϴ�.
	���Ҵ� ����ɾ� �����͡� �������� �־����ϴ�.- �ִ�/�ּڰ��� �����ϴ� ���꿡�� �ִ�/�ּڰ��� �� �̻��� ���, �ϳ��� �����մϴ�.
	�� ť�� �����͸� �����϶�� ������ �־��� ���, �ش� ������ �����մϴ�.
	 */
	static class DoublePQ{
		private PriorityQueue<Integer> pq; //���� �켱���� ť(���� ���� ����)
		private PriorityQueue<Integer> rpq; //���� �켱���� ť(ū ���� ����)
		
		//����
		public DoublePQ() {
			pq=new PriorityQueue<Integer>();
			rpq=new PriorityQueue<Integer>((x,y)->y-x);
		}
		
		//��� �Է�
		public void command(String cmd) {
			String[] cmdArr=cmd.split(" ");
			//I�� insert ȣ��
			if(cmdArr[0].equals("I")) {
				insert(Integer.parseInt(cmdArr[1]));
			}else {
				//�� ��(D)�Ͻ� delete ȣ��, 1�̸� max,�� ��(-1) min ����
				if(cmdArr[1].equals("1")) deleteMax();
				else deleteMin();
			}
		}
		//num�� pq�� rpq �Ѵ� insert
		public void insert(int num) {
			pq.add(num);
			rpq.add(num);
		}
		//max �����, rpq���� ���� ���� pq���� ����
		public void deleteMax() {
			pq.remove(rpq.poll());
		}
		//min �����, pq���� ���� ���� rpq���� ����
		public void deleteMin() {
			rpq.remove(pq.poll());
		}
		//�ִ밪 ���
		public int getMax() {
			if(rpq.isEmpty()) return 0; //��������� 0
			return rpq.peek();
		}
		//�ּҰ�
		public int getMin() {
			if(pq.isEmpty()) return 0; //��������� 0
			return pq.peek();
		}
	}
	
	
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        DoublePQ doublePQ = new DoublePQ(); //����
        for(String operation:operations) {
        	doublePQ.command(operation); //��� ����
        }
        answer[0]=doublePQ.getMax(); //�ִ밪
        answer[1]=doublePQ.getMin(); //�ּҰ�
        return answer;
    }
	
	public static void main(String[] args) {
		String[][] ops = {{"I 16","D 1"},{"I 7","I 5","I -5","D -1"}};
		for(String[] op:ops) {
			for(int s: solution(op)) {
				System.out.print(s+" ");
			};
			System.out.println();
			
		} 
	}

}
