package StringMatching;

public class Soundex {
	private static final char[] mapping = {
			'0','1','2','3','0','1','2','0','0','2','2','4','5',
			'5','0','1','2','6','2','3','0','1','0','2','0','2'
	};
	
	private static char index(char c) {
		return mapping[c-'a'];
	}
	
	private static final int CODE_LENGTH = 4;
	
	public static void main(String args[]){
		String word1 = "Gough";
		String soundex = getSoundex(word1);
		System.out.println("soundex of word1: " + soundex);
	}
	
	public static String getSoundex(String word) {
		char[] retChar = new char[CODE_LENGTH];
		
		retChar[0] = word.charAt(0);
		int index = 1;
		char pre = '?';
		
		char[] charArray = word.toCharArray();
		for (int i = 1; i < charArray.length && index < CODE_LENGTH; i++){
			if (charArray[i] == 'W' || charArray[i] == 'H'){
				continue;
			}
			char c = index(charArray[i]);
			
			if ( c == pre || c == '0')
				continue;
			retChar[index++] = c;
			pre = c;
		}
		while(index < CODE_LENGTH){
			retChar[index++] = 'o';
		}
		return new String(retChar);
	}

}
