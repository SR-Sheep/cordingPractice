package ���α׷��ӽ�;

import java.util.HashMap;

public class īī��_1������Ŭ�����͸� {
    public static int solution(String str1, String str2) {
        str1=str1.toLowerCase();
        str2=str2.toLowerCase();
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();
        HashMap<String, Integer> map2 = new HashMap<String, Integer>();
        HashMap<String, Integer> intersection = new HashMap<String, Integer>();
        HashMap<String, Integer> union = new HashMap<String, Integer>();
        for(int i=1;i<str1.length();i++){
            String tmp=str1.substring(i-1,i+1);
            if(!tmp.matches("^[a-z]*")) continue;
            map1.put(tmp, map1.getOrDefault(tmp, 0)+1);
        }
        for(int i=1;i<str2.length();i++){
        	String tmp=str2.substring(i-1,i+1);
        	if(!tmp.matches("^[a-z]*")) continue;
        	map2.put(tmp, map2.getOrDefault(tmp, 0)+1);
        }
        union.putAll(map1);
        
        for(String key:map2.keySet()) {
        	//map1�� map2�� �����ϸ�
        	if(map1.containsKey(key)) {
        		//������(���� ���� ����)
        		intersection.put(key, Math.min(map1.get(key), map2.get(key)));
        		//������(ū ���� ����)
        		union.put(key, Math.max(map1.get(key), map2.get(key)));
        	}else {
    		//map1�� ������ �����տ� �߰�
        		union.put(key, map2.get(key));
        	}
        }
        float sumInter=0.0f, sumUnion=0.0f;
        for(int v:intersection.values()) sumInter+=v;
        for(int v:union.values()) sumUnion+=v;
        
        int answer = sumUnion==0?65536:(int)(sumInter/sumUnion * 65536);
        
        
        return answer; 
    }
	
	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "shake hands";
		System.out.println(solution(str1, str2));
	}
}
