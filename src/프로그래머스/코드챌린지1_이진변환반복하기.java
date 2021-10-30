package ���α׷��ӽ�;

public class �ڵ�ç����1_������ȯ�ݺ��ϱ� {
	/*
	 * ���� ����
	0�� 1�� �̷���� � ���ڿ� x�� ���� ���� ��ȯ�� ������ ���� �����մϴ�.
	
	x�� ��� 0�� �����մϴ�.
	x�� ���̸� c��� �ϸ�, x�� "c�� 2�������� ǥ���� ���ڿ�"�� �ٲߴϴ�.
	���� ���, x = "0111010"�̶��, x�� ���� ��ȯ�� ���ϸ� x = "0111010" -> "1111" -> "100" �� �˴ϴ�.
	
	0�� 1�� �̷���� ���ڿ� s�� �Ű������� �־����ϴ�.
	s�� "1"�� �� ������ ����ؼ� s�� ���� ��ȯ�� ������ ��,
	���� ��ȯ�� Ƚ���� ��ȯ �������� ���ŵ� ��� 0�� ������ ���� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.
	
	���ѻ���
	s�� ���̴� 1 �̻� 150,000 �����Դϴ�.
	s���� '1'�� �ּ� �ϳ� �̻� ���ԵǾ� �ֽ��ϴ�.
	 */
	static int Count=0,Zero=0;
	
	public static void binaryTranfer(String s) {
		//1�̸� ����
		if(s.equals("1")) return;
		//0 Ƚ�� ����
		int count=0;
		for(char c:s.toCharArray()) if(c=='0') count++;
		//0Ƚ�� ����
		Zero+=count;
		//���� Ƚ�� ����
		Count++;
		//���
		binaryTranfer(Integer.toBinaryString(s.length()-count));
	}
	
    public static int[] solution(String s) {
    	binaryTranfer(s);
        return new int[] {Count, Zero};
    }
	public static void main(String[] args) {
		String s = "110010101001";
		System.out.println(solution(s));
		System.out.println(Count+" "+Zero);
	}
}
