package 프로그래머스;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class 카카오_파일명정렬 {
    static class Name implements Comparable<Name>{
    	private String name,head,tail;
    	private int number;
    	public Name(String name) {
    		this.name=name;
    		String[] tmp = name.toLowerCase().split("[0-9]+",2);
    		this.head = tmp[0];
    		this.tail = tmp[1];
    		this.number=Integer.parseInt(name.split("[^0-9]+")[1]);
		}
    	@Override
    	public int compareTo(Name o) {
    		if(this.head.compareTo(o.head)>0) return 1;
    		else if(this.head.compareTo(o.head)<0) return -1;
    		else {
    			if(this.number<o.number) return -1;
    			else if(this.number>o.number) return 1;
    			else return 0;
    		}
    	}
    	
//    	@Override
//    	public String toString() {
//    		return this.name+" : "+this.head+" "+this.number+" "+this.tail+"\n";
//    	}
    }
	
	
	public static String[] solution(String[] files) {
        List<Name> list = new ArrayList<>();
        for(String file:files) list.add(new Name(file));
        list.sort(null);
        for(int i=0;i<files.length;i++) {
        	files[i]=list.get(i).name;
        }
        return files;
    }
    
    public static void main(String[] args) {
		String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
		for(String s:solution(files)) {
			System.out.println(s);
		}
		
	}
}
