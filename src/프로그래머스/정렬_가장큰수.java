package ���α׷��ӽ�;

import java.util.Arrays;
import java.util.Comparator;

public class ����_����ū�� {
	/*
	0 �Ǵ� ���� ������ ��� �迭 numbers�� �Ű������� �־��� ��,
	������ ���ġ�Ͽ� ���� �� �ִ� ���� ū ���� ���ڿ��� �ٲپ�
	return �ϵ��� solution �Լ��� �ۼ����ּ���.

	���� ����
	numbers�� ���̴� 1 �̻� 100,000 �����Դϴ�.
	numbers�� ���Ҵ� 0 �̻� 1,000 �����Դϴ�.
	������ �ʹ� Ŭ �� ������ ���ڿ��� �ٲپ� return �մϴ�.
	����� ��
	 */
	
	
    public static String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder(); //�� ������ ���� ��Ʈ�� ���� ����
        //��Ʈ�� �迭�� ��ȯ
        String[] sArr= new String[numbers.length];
        for(int i=0;i<numbers.length;i++) {
        	sArr[i]=numbers[i]+"";//
        }
        //����
        Arrays.sort(sArr, new Comparator<String>(){
        	//compareTo�� ��Ʈ���� ����
        	@Override
        	public int compare(String o1, String o2) {
        		return (o2+o1).compareTo(o1+o2);
        	}
        });
        //0���� �����ϸ� 0���� ����
        if(sArr[0].equals("0")) return "0";
        //�� ����
        for(String s:sArr) {
        	sb.append(s);
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		int	[][] questions= {{6,10,2},{3,30,34,5,9}};
		for(int[] question:questions) {
			System.out.println(solution(question));
		}
	}
}
