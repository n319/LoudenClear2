import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class StateTable {

	private static ArrayList<tableRow> stateTable = new ArrayList<tableRow>(0);
	private Integer currState = 0;
	private ArrayList<Integer> NFAState = new ArrayList<Integer>(0); 
	private boolean accepted = false;
	private tableRow removedRow;
	private Integer acceptedState;
	private enum TableType {NFA,DFA};
	
	
	public StateTable(){
		
	}
	
	public tableRow getTableRow(int i){
		return stateTable.get(i);
	}
	/**
	 * 
	 * @param map - transitions
	 * @param name
	 * @param index - if table size is less than index, it will REPLACE the current table entry
	 * @return boolean, if a row is replaced true is returned an the replaced row is stored in a removedRow
	 */
	public boolean addState(Map<String, Integer> map, String name,int index){
		tableRow newRow = new tableRow(map, name); //create
		boolean replace = false;
		
		if (stateTable.size() < index && index >=0){ //append at index
			stateTable.add(index, newRow);
		}
		else if(stateTable.size() > index){ //REPLACE CURRENT TABLEROW AT INDEX
			removedRow = stateTable.remove(index);
			stateTable.add(index, newRow);
			replace = true;
		}
		else if(index < 0){ //append to end
			stateTable.add(newRow);
		}
		return replace;
	}
	
	/**
	 * 
	 * @return a list of integers that are currently listed as next states
	 */
	public ArrayList<Set<Entry<String, Integer>>> getSuccessorStates(){
		Set<Entry<String, Integer>> rowvalues;
		ArrayList<Set<Entry<String,Integer>>> values = new ArrayList<Set<Entry<String,Integer>>>(0);
		
		for (tableRow row : stateTable){
			rowvalues = row.successorStates.entrySet();
			values.add(rowvalues);
		}
		return values;
	}
	
	/**
	 * 
	 * @return a list of strings that are currently listed as next states
	 */
	public ArrayList<ArrayList<String>> getSuccessorTransitions(){
		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
		
		for (tableRow row : stateTable){
			values.add((ArrayList<String>) row.successorStates.keySet());
		}
		
		return values;
	}
	
//	public ArrayList<Map<Integer,String>> getMagic(){
//		ArrayList<ArrayList<String>> values = new ArrayList<ArrayList<String>>();
//		
//		for (tableRow row : stateTable){
//			values.add((ArrayList<String>) row.successorStates.keySet());
//		}
//		
//		return values;
//	}
	
	/**EXTRA CREDIT
	 * 
	 * @param c
	 */
	public void NFAlookUp(String c){
		ArrayList<Integer> next = new ArrayList<Integer>(0);
		Integer nextState;
		
		for (Integer state : NFAState){//
			nextState = stateTable.get(state).getNextState(c);
			if (nextState != null){
				next.add(nextState);
			}
		}
		for (Integer state : next){//follows epsilon transitions
			nextState = stateTable.get(state).getNextState("@");
			if(nextState != null){
				next.add(nextState);
			}
		}
		
		for(Integer state : next){//checks for accepting state
			if(stateTable.get(state).accept()){
				accepted = true;
				acceptedState = state;
			}
		}
		NFAState = next;
		
	}
	
	//this will tell us if the symbol has a valid translation from the currentState to another state in the table
	public boolean DFAlookUp(String c){
		Integer nextState; //state table index
		boolean val = false;
		nextState = stateTable.get(currState).getNextState(c);
		if (nextState != null){
			currState = nextState;
		}
		if (stateTable.get(currState).accept()){
			accepted = true;
		}
		return val;
	}
	
	/**this will likely get broken into it's own class heirarchy
	 * but i dont know it yet. so it is here for convenience while editing the stateTable itself
	 * @author nick
	 *
	 */
	public class tableRow{
		//Map of strings to tableRows
		private Map<String,Integer> successorStates;
		private boolean accept;
		private String name;
		
		public tableRow(Map<String,Integer> nextStates, String n){
			successorStates = nextStates;
			name = n;
		}
		
		public Integer getNextState(String c){
			return successorStates.get(c);
		}
		
		public boolean accept(){
			return accept;
		}
		
	}
}
