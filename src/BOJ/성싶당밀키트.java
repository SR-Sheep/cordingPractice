package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 성싶당밀키트 {
	
	static List<Item> Main;
	static List<Item> Sub;
	static long K; //취하는 부재료
	
	static class Item{
		private long speed, exp;
		public Item(long s, long l) {
			this.speed = s;
			this.exp=l;
		}
		private long getGrems(long day) {
			long count = day - exp;
			if(count<=1) return speed;
			return speed*count;
		}
	}
	public static long germCount(long day) {
		long count = 0;
		PriorityQueue<Long> pq = new PriorityQueue<Long>();
		for(Item item:Main) {
			count+=item.getGrems(day);
		}
		for(Item item:Sub) {
			pq.add(item.getGrems(day));
		}
		for(int i=0;i<K;i++) {
			count+=pq.poll();
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		Main=new ArrayList<>();
		Sub=new ArrayList<>();
		
		int n=Integer.parseInt(st.nextToken());
		Long g=Long.parseLong(st.nextToken()); //세균 허용 범위, 이하 취식 가능
		long k=Long.parseLong(st.nextToken()); //뺄 수 있는 부재료 수
		
		long max = 0;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine());
			Long s=Long.parseLong(st.nextToken());
			Long l=Long.parseLong(st.nextToken());
			Long o=Long.parseLong(st.nextToken());
			if(o==1) {
				Sub.add(new Item(s, l));
			}else {
				Main.add(new Item(s, l));
			}
			max = Math.max(max, l);
		}
		K=Sub.size()-k; //취할 수 있는 부재료 수
		if(K<1) K=0; //1보다 작으면 0
		
		long answer = 0;
		long left = 0, right = Integer.MAX_VALUE, mid = -1;
		while(left<=right) {
			mid=(left+right)/2;
			if(germCount(mid)<=g) {
				answer=mid;
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		System.out.println(answer+" "+germCount(2)+" "+K);
		br.close();
	}
}
