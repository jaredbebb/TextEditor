package document;

import java.util.List;

/** 
 * A naive implementation of the Document abstract class. 
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class BasicDocument extends Document 
{
	//Java icons can be found at http://help.eclipse.org/mars/index.jsp?topic=%2Forg.eclipse.jdt.doc.user%2Freference%2Fref-icons.htm
	
	/** Create a new BasicDocument object
	 * 
	 * @param text The full text of the Document.
	 */
	//TODO--> did; made new basic document object, called it NewObjectBasicDoc

	
	public BasicDocument(String text)
	{
		super(text);
	}

	
	/**
	 * Get the number of words in the document.
	 * A "word" is defined as a contiguous string of alphabetic characters
	 * i.e. any upper or lower case characters a-z or A-Z.  This method completely 
	 * ignores numbers when you count words, and assumes that the document does not have 
	 * any strings that combine numbers and letters. 
	 * 
	 * Check the examples in the main method below for more information.
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of words in the document.
	 */
	@Override
	public int getNumWords()
	{
		//TODO: Implement this method in week 1 according to the comments above.  
		// See the Module 1 support videos if you need help.

		//non white space character, andy non white space, any non white space, needs to be any non white space non number
		List<String> scrapeTokens = getTokens("[a-zA-Z]+");
		int sizeScrape = scrapeTokens.size();
		return sizeScrape;
	    //commented out default return 0 statemetn
		//return 0;
	}

	/**
	 * Get the number of sentences in the document.
	 * Sentences are defined as contiguous strings of characters ending in an 
	 * end of sentence punctuation (. ! or ?) or the last contiguous set of 
	 * characters in the document, even if they don't end with a punctuation mark.
	 * 
	 * Check the examples in the main method below for more information.  
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of sentences in the document.
	 */
	@Override
	public int getNumSentences()
	{
	    //TODO: Implement this method.  See the Module 1 support videos 
        // if you need help.
		//"." one or more times, match "?" one or more times. match "!" one or more times. match any character at end of line
		List<String> scrapeTokens = getTokens("[^!?.]+");
		int sizeScrape = scrapeTokens.size();
		return sizeScrape;
        //return 0;
	}
	
	/**
	 * Get the total number of syllables in the document (the stored text). 
	 * To count the number of syllables in a word, it uses the following rules:
	 *       Each contiguous sequence of one or more vowels is a syllable, 
	 *       with the following exception: a lone "e" at the end of a word 
	 *       is not considered a syllable unless the word has no other syllables. 
	 *       You should consider y a vowel.
	 *       
	 * Check the examples in the main method below for more information.  
	 * 
	 * This method should process the entire text string each time it is called.  
	 * 
	 * @return The number of syllables in the document.
	 */
	@Override
	public int getNumSyllables()
	{
	    //TODO: Implement this method in week 1.  See the Module 1 support videos 
        // if you need help.  And note that there is no need to use a regular
		// expression for the syllable counting.  We recommend you implement 
		// the helper function countSyllables in Document.java using a loop, 
		// and then call it here on each word.
		// We provide for you two solutions: One that uses multiple 
				// regexs to calculate the number of syllables and the other
				// that finds words using a loop.  The regex solution is commented 
				// out here at the top.

				/* Our solution using regex's.  Uncoment here to run it*/
				/*
				List<String> tokens = getTokens("[aeiouyAEIOUY]+");
				List<String> loneEs = getTokens("[^aeiouyAEIOUY]+[eE]\\b");
				List<String> singleEs = getTokens("\\b[^aeiouyAEIOUY]*[eE]\\b");
				
				
				return tokens.size() - (loneEs.size() - singleEs.size());
				*/
				
				/* Our solution that does NOT use regexs to find syllables */
				List<String> tokens = getTokens("[a-zA-Z]+");
				int totalSyllables = 0;
				for (String word : tokens)
				{
					totalSyllables += countSyllables(word);
				}
				return totalSyllables;
	}
	
	
	/* The main method for testing this class. 
	 * You are encouraged to add your own tests.  */
	public static void main(String[] args)
	{
		/* Each of the test cases below uses the method testCase.  The first 
		 * argument to testCase is a Document object, created with the string shown.
		 * The next three arguments are the number of syllables, words and sentences 
		 * in the string, respectively.  You can use these examples to help clarify 
		 * your understanding of how to count syllables, words, and sentences.
		 */
		testCase(new BasicDocument("This is a test.  How many???  "
		        + "Senteeeeeeeeeences are here... there should be 5!  Right?"),
				16, 13, 5);
		testCase(new BasicDocument(""), 0, 0, 0);
		testCase(new BasicDocument("sentence, with, lots, of, commas.!  "
		        + "(And some poaren)).  The output is: 7.5."), 15, 11, 4);
		testCase(new BasicDocument("many???  Senteeeeeeeeeences are"), 6, 3, 2);
		testCase(new BasicDocument("Here is a series of test sentences. Your program should "
				+ "find 3 sentences, 33 words, and 49 syllables. Not every word will have "
				+ "the correct amount of syllables (example, for example), "
				+ "but most of them will."), 49, 33, 3);
		testCase(new BasicDocument("Segue"), 2, 1, 1);
		testCase(new BasicDocument("Sentence"), 2, 1, 1);
		testCase(new BasicDocument("Sentences?!"), 3, 1, 1);
		testCase(new BasicDocument("Lorem ipsum dolor sit amet, qui ex choro quodsi moderatius, nam dolores explicari forensibus ad."),
		         32, 15, 1);
		
		//Testing
	}
	
}