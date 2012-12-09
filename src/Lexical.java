import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


/**
 * Lexical class serves as a wrapper class for TokenCs and CharacterCs
 * This is done to make returning and passing parameters easier.
 *
 */
public class Lexical {
	private ArrayList<TokenC> tokens;
	private HashMap<String, CharacterC> characters;
	
	public Lexical(){
		tokens = new ArrayList<TokenC>();
		characters = new HashMap<String,CharacterC>();
	}
	/**
	 * Constructor
	 * @param toks TokenCs to set
	 * @param chars CharacterCs to set
	 */
	public Lexical(ArrayList<TokenC> toks, HashMap<String, CharacterC> chars)
	{
		this.tokens = toks;
		this.characters = chars;
	}
	
	/**
	 * Returns TokenC's
	 * @return tokens TokenC's to return
	 */
	public ArrayList<TokenC> getTokens()
	{
		return tokens;
	}
	
	/**
	 * Returns CharacterCs
	 * @return characters CharacterCs to return
	 */
	public HashMap<String, CharacterC> getCharacters()
	{
		return characters;
	}
}