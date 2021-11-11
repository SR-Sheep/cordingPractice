package 프로그래머스;

import java.util.HashMap;

public class 카카오_1차뉴스클러스터링 {
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
        	//map1과 map2에 존재하면
        	if(map1.containsKey(key)) {
        		//교집합(작은 수를 취함)
        		intersection.put(key, Math.min(map1.get(key), map2.get(key)));
        		//합집합(큰 수를 취함)
        		union.put(key, Math.max(map1.get(key), map2.get(key)));
        	}else {
    		//map1에 없으면 합집합에 추가
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
