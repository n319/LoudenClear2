import java.util.ArrayList;


public class LLoneGenerator {
	
	private Lexical lexspec;
	
	public LLoneGenerator(String specPath){
		if (Driver.DEBUG){ 
			System.out.println("==============LLONE==============");

//			for (TokenC t:lexspec.getTokens()){
//				System.out.println(t.getTitle());
//			}
		}
		
		lexspec = new Lexical(specPath);
		
	}

	
	public ArrayList<TokenC> firstSet(){
		ArrayList<TokenC> first = new ArrayList<TokenC>();
		
		for (TokenC t:lexspec.getTokens()){
			t.getLegal();
			System.out.println("First Set " + t.getTitle());
		}
		
		return first;
		
	}
	
	public ArrayList<TokenC> followSet(){
		ArrayList<TokenC> follow = new ArrayList<TokenC>();
		return follow;
		
		
	}
	
}
