package ���α׷��ӽ�;

import java.util.ArrayList;
import java.util.List;

public class ��������_�������ڴ½Ⱦ� {
	/*
	���� ����
	�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�.
	�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�.
	��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�.
	
	���� ���,
	arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
	arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
	
	�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.

	���ѻ���
	�迭 arr�� ũ�� : 1,000,000 ������ �ڿ���
	�迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����
	*/
	
    public List<Integer> solution(int []arr) {
        List<Integer> answer= new ArrayList<>();
        int before = -1; //���� ��
        for(int i:arr){
            if(before!=i){ //�������� �ٸ���
                before=i; //������ = ���簪
                answer.add(i); //����Ʈ�� ����
            } 
        }
        return answer;
    }
}
