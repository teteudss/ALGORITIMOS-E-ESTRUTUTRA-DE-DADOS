package bruteforce;

public class Pesquisa {
    
    public static boolean search(String text, String pattern){
 
		int lengthOfText = text.length();
		int lengthOfPattern = pattern.length();
 
		for( int i = 0; i <= lengthOfText - lengthOfPattern ; i++){
 
			int j;
 
			for( j=0;j<lengthOfPattern;j++){
				if( text.charAt(i+j) != pattern.charAt(j)){
					break;
				}
			}
 
			if( j == lengthOfPattern ) return true ;
		}
 
		return false;
                
    }
    long tempoFinal = System.currentTimeMillis();


}
