package spelling;

import java.util.LinkedList;


/**
 * A class that implements the Dictionary interface using a LinkedList
 *
 */
public class DictionaryLL implements Dictionary 
{

	private LinkedList<String> dict;
	
	//made this int size, looks like I might need it
	public int size;
	
    // TODO: Add a constructor
	//welp here goes nothing, not sure what kind of constructor to add..
	public DictionaryLL()
	{
		dict = new LinkedList<String>();
		/*this.size = 0;
		this.value = value;
		this.left = left;
		this.right = right;*/
	}


    /** Add this word to the dictionary.  Convert it to lowercase first
     * for the assignment requirements.
     * @param word The word to add
     * @return true if the word was added to the dictionary 
     * (it wasn't already there). */
    public boolean addWord(String word) {
    	// TODO: Implement this method
    	//welp here goes nothing
    	String defWord = word.toLowerCase();
    	
    	if(dict.contains(defWord)){
    		return false;
    	}
    	else{
    	//add word to dict, if it's not already there
    	dict.add(defWord);
    	return true;
    	}
    	
    }


    /** Return the number of words in the dictionary */
    public int size()
    {
        // TODO: Implement this method
    	return dict.size();
    }

    /** Is this a word according to this dictionary? */
    public boolean isWord(String s) {
    	
    	String sToLower = s.toLowerCase();
    	if(dict.contains(sToLower)){
    		return true;
    	}
    	
    	else{
        //TODO: Implement this method
        return false;
    	}
        
    }

    
}
