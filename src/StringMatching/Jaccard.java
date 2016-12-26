package StringMatching;

import java.util.HashSet;
import java.util.Set;

public class Jaccard {
	public static void main(String args[]){
		float j = jaccard("dave","dae");
		int p = o("dave","dae");
		System.out.println(p);
		System.out.println(j);
	}
	
	public static int o(String word1, String word2) {
		Set<String> set1 = set(word1);
		Set<String> set2 = set(word2);
		Set<String> o = new HashSet<String>();
		o.addAll(set1);
		o.retainAll(set2);
		return o.size();
	}
	
	public static float jaccard(String word1, String word2){
		
		Set<String> set1 = set(word1);
		Set<String> set2 = set(word2);
		Set<String> inter = new HashSet<String>();
		
		inter.addAll(set1);
		inter.retainAll(set2);
		
		Set<String> union = new HashSet<String>();
		union.addAll(set1);
		union.addAll(set2);
		
		float interSize = inter.size();
		float unionSize = union.size();
		
		return interSize/unionSize;
	}
	
	public static Set<String> set(String x) {
		Set<String> set = new HashSet<String>();
		
		set.add("#"+x.charAt(0));
		set.add(x.charAt(x.length()-1)+"#");
		
		for(int i = 0; i < x.length()-1; i++){
			set.add(x.charAt(i)+""+x.charAt(i+1));
		}
		return set;
	}

}
