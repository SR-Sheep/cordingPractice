package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class �׷���_���� {
	
	/*
	���� ����
	n���� ���������� ���� ��ȸ�� �����߰� ���� 1������ n������ ��ȣ�� �޾ҽ��ϴ�.
	���� ���� 1��1 ������� ������ �ǰ�, ���� A ������ B �������� �Ƿ��� ���ٸ� A ������ B ������ �׻� �̱�ϴ�.
	������ �־��� ��� ����� ������ �������� ������ �ű�� �մϴ�.
	������ ��� ��� ����� �н��Ͽ� ��Ȯ�ϰ� ������ �ű� �� �����ϴ�.
	
	������ �� n, ��� ����� ���� 2���� �迭 results�� �Ű������� �־��� ��
	��Ȯ�ϰ� ������ �ű� �� �ִ� ������ ���� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	
	���ѻ���
	������ ���� 1�� �̻� 100�� �����Դϴ�.
	��� ����� 1�� �̻� 4,500�� �����Դϴ�.
	results �迭 �� �� [A, B]�� A ������ B ������ �̰�ٴ� �ǹ��Դϴ�.
	��� ��� ������� ����� �����ϴ�.
	 
	 */
	
	static class Fighter{
		int num;
		private List<Fighter> parents, children;
		
		public Fighter(int number) {
			this.num=number;
			parents=new ArrayList<>();
			children=new ArrayList<>();
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public List<Fighter> getParents() {
			return parents;
		}

		public void setParents(List<Fighter> parents) {
			this.parents = parents;
		}

		public List<Fighter> getChildren() {
			return children;
		}

		public void setChildren(List<Fighter> children) {
			this.children = children;
		}
				
	}
	
	
    public static int solution(int n, int[][] results) {
        int answer = 0;
        
        List<Fighter> list = new ArrayList<>();
        //����Ʈ�� Fight ��ü ����
        for(int i=0;i<n+1;i++) {
        	list.add(new Fighter(i)); 
        }
        
        //�� ��ü�� ����(parent)�� ����(losser) ����
        for(int[] result:results) {
        	int winner = result[0];
        	int losser = result[1];
        	list.get(winner).getChildren().add(list.get(losser));
        	list.get(losser).getParents().add(list.get(winner));
        }
        
        //����Ʈ ��ȸ
        for(int i=1;i<list.size();i++) {
        	int count=0;
        	//���ڵ�� ���ڵ�
        	List<Fighter> parents=list.get(i).getParents();
        	List<Fighter> children=list.get(i).getChildren();
        	//ť
        	Queue<List<Fighter>> q = new LinkedList<List<Fighter>>(); 
        	//ť�� �θ�� ����
        	q.add(parents);
        	//�湮���� üũ
        	boolean[] visited1 = new boolean[n+1];
        	
        	while(!q.isEmpty()) {
        		List<Fighter> now = q.poll();
        		for(Fighter parent :now) {
        			//�湮������ ��Ƽ��
        			if(visited1[parent.getNum()]) continue;
        			//�湮 ǥ�� ��, ���� ����
        			visited1[parent.getNum()]=true;
        			count++;
        			//ť�� �θ��� �θ� �ֱ�
        			q.add(list.get(parent.getNum()).getParents());
        		}
        	}
        	//ť�� �ڽĵ� ����
        	q.add(children);
        	//�湮 ���� üũ
        	boolean[] visited2 = new boolean[n+1];
        	
        	while(!q.isEmpty()) {
        		List<Fighter> now = q.poll();
        		for(Fighter child :now) {
        			//�湮������ ��Ƽ��
        			if(visited2[child.getNum()]) continue;
        			//�湮 ǥ�� ��, ���� ����
        			visited2[child.getNum()]=true;
        			count++;
        			//ť�� �ڽ��� �ڽĵ� �ֱ�
        			q.add(list.get(child.getNum()).getChildren());
        		}
        	}
        	//�θ�� + �ڽļ� = n-1�̸� ��� ������ ����������� ���� ���� ���� -> �� ����
        	if(count==n-1) answer++;
        }
        
        return answer;
    }
    //�׷����� Ǯ��
    public static int solution2(int n, int[][] results) {
        int answer = 0;
        //�湮 ���� Ȯ��
        boolean[][] chk = new boolean[n + 1][n + 1];
        //��� ������ true;
        for(int i = 0; i < results.length; i++) {
            chk[results[i][0]][results[i][1]] = true;
        }
        //�߰���
        for(int k = 1; k < n + 1; k++) {
            //���۰�
        	for(int i = 1; i < n + 1; i++) {
                //����
        		for(int j = 1; j < n + 1; j++) {
        			//���۰� ���� �ٸ���
        			//���� - �߰�, �߰�-�� �� ��Ⱑ ������
                    if(i != j && chk[i][k] && chk[k][j]) {
                    	//���� - ���� ��⸦ �Ѱų� �ٸ�����
                        chk[i][j] = true;
                    }
                }
            }
        }
        
        //�湮���� ��ȸ
        //���۰�
        for(int i = 1; i < n + 1; i++) {
            boolean pass = true;
            //����
            for(int j = 1; j < n + 1; j++) {
                //���۰� ���� �ٸ���
            	//���� - �� �̳� �� - ������ ��� ����� ������
            	if(i != j && !(chk[i][j] || chk[j][i])) {
                    //�н� �Ұ�
            		pass = false;
                    break;
                }
            }
            //�н��ϸ�(��� ��⸦ ������)
            if(pass) {
            	//�� ����
                answer++;
            }
        }

        return answer;
    }
    
	
	public static void main(String[] args) {
		int n=5;
		int[][] r = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(n, r));
	}
}
