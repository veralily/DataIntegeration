package StringMatching;

import javax.lang.model.type.IntersectionType;

public class NeedlemanWunch {
	private static int[][] scoreTable = new int[26][26];
	private static int gap = 1;
	
	public static void main(String args[]){
		String word1 = "dva";
		String word2 = "dave";
		initializeTable(1);
		System.out.println("length: " + needleManWunch(word1, word2));
		
	}
	
	public static void initializeTable(int blankGap){
		gap = blankGap;
		 for (int i = 0; i < 26; i++){
			 for (int j = 0; j < 26; j++){
				 scoreTable[i][j] = 0;
			 }
		 }
		 
		 for (int i = 0; i < 26; i++){
			 for (int j = 0; j < 26; j++){
				 scoreTable[i][j] = -1;
			 }
		 }
		 
		 scoreTable[index('d')][index('d')] = 2;
		 scoreTable[index('a')][index('a')] = 2;
		 scoreTable[index('v')][index('v')] = 2;
		 scoreTable[index('e')][index('e')] = 2;
	}
	
	public static int index(char c){
		return c-'a';
	}
	
	public static int needleManWunch(String word1, String word2){
		int len1 = word1.length();
		int len2 = word2.length();
		int[][] dp = new int[len1+1][len2+1];
		
		for (int i = 0; i <= len1; i++ ){
			dp[i][0] = -i;
		}
		for (int j = 0; j <= len2; j++){
			dp[0][j] = -j;
		}
		
		for (int i = 0; i < len1; i++){
			for (int j = 0; j < len2; j++){
				char c1 = word1.charAt(i);
				char c2 = word2.charAt(j);
				
				int gap1 = dp[i][j+1] - gap;
				int gap2 = dp[i+1][j] - gap;
				int match = dp[i][j] + scoreTable[index(c1)][index(c2)];
				
				int max = Math.max(gap1, gap2);
				max = Math.max(max, match);
				dp[i+1][j+1] = max;
				
			}
		}
		
		System.out.println("This is the table: ");
		for (int i = 0; i< word1.length()+1; i++){
			for (int j = 0; j <word2.length()+1; j++){
				System.out.printf("%4d\t|", dp[i][j]);
			}
			System.out.println();
		}
		return dp[len1][len2];
		
	}

}
