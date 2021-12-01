package ���α׷��ӽ�;

public class ��������_���������������ϱ� {
	//https://programmers.co.kr/learn/courses/30/lessons/12935
	//������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
	//��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���.
	//������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.
	
    public static int[] solution(int[] arr) {
        if(arr.length==1) return new int[]{-1}; //���̰� 1�̸� -1 ����
        int[] answer = new int[arr.length-1];
        int min=Integer.MAX_VALUE; //�ּҰ�
        int minIdx=-1; //�ּҰ� ��ġ
        for(int i=0;i<arr.length;i++){
            if(min>arr[i]){ //�ּҰ����� ������
                min=arr[i]; //�ּҰ� ������Ʈ
                minIdx=i; //�ּҰ� �ε��� ����
            }
        }
        int idx=0;
        for(int i=0;i<arr.length;i++){
            if(i!=minIdx){
                answer[idx++]=arr[i]; //�ּҰ� �ε��� �����ϰ� ��
            }
        }
        
        return answer;
    }
	public static void main(String[] args) {
		int[] arr= {5,4,3,2,1};
		for(int i:solution(arr)) {
			System.out.print(i+" ");
		}
	}
}
