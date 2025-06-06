package 프로그래머스;

import java.util.PriorityQueue;

public class 힙_이중우선순위큐 {
	/*
	이중 우선순위 큐는 다음 연산을 할 수 있는 자료구조를 말합니다.

	명령어	수신 탑(높이)
	I 숫자	큐에 주어진 숫자를 삽입합니다.
	D 1	큐에서 최댓값을 삭제합니다.
	D -1	큐에서 최솟값을 삭제합니다.
	이중 우선순위 큐가 할 연산 operations가 매개변수로 주어질 때, 모든 연산을 처리한 후 큐가 비어있으면 [0,0] 비어있지 않으면 [최댓값, 최솟값]을 return 하도록 solution 함수를 구현해주세요.
	
	제한사항
	operations는 길이가 1 이상 1,000,000 이하인 문자열 배열입니다.
	operations의 원소는 큐가 수행할 연산을 나타냅니다.
	원소는 “명령어 데이터” 형식으로 주어집니다.- 최댓값/최솟값을 삭제하는 연산에서 최댓값/최솟값이 둘 이상인 경우, 하나만 삭제합니다.
	빈 큐에 데이터를 삭제하라는 연산이 주어질 경우, 해당 연산은 무시합니다.
	 */
	static class DoublePQ{
		private PriorityQueue<Integer> pq; //기존 우선순위 큐(작은 수가 먼저)
		private PriorityQueue<Integer> rpq; //역순 우선순위 큐(큰 수가 먼저)
		
		//선언
		public DoublePQ() {
			pq=new PriorityQueue<Integer>();
			rpq=new PriorityQueue<Integer>((x,y)->y-x);
		}
		
		//명령 입력
		public void command(String cmd) {
			String[] cmdArr=cmd.split(" ");
			//I면 insert 호출
			if(cmdArr[0].equals("I")) {
				insert(Integer.parseInt(cmdArr[1]));
			}else {
				//그 외(D)일시 delete 호출, 1이면 max,그 외(-1) min 제거
				if(cmdArr[1].equals("1")) deleteMax();
				else deleteMin();
			}
		}
		//num을 pq와 rpq 둘다 insert
		public void insert(int num) {
			pq.add(num);
			rpq.add(num);
		}
		//max 지우기, rpq에서 뽑은 값을 pq에서 삭제
		public void deleteMax() {
			pq.remove(rpq.poll());
		}
		//min 지우기, pq에서 뽑은 값을 rpq에서 삭제
		public void deleteMin() {
			rpq.remove(pq.poll());
		}
		//최대값 얻기
		public int getMax() {
			if(rpq.isEmpty()) return 0; //비어있으면 0
			return rpq.peek();
		}
		//최소값
		public int getMin() {
			if(pq.isEmpty()) return 0; //비어있으면 0
			return pq.peek();
		}
	}
	
	
    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        DoublePQ doublePQ = new DoublePQ(); //선언
        for(String operation:operations) {
        	doublePQ.command(operation); //명령 수행
        }
        answer[0]=doublePQ.getMax(); //최대값
        answer[1]=doublePQ.getMin(); //최소값
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
