
package secondInterface;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import edu.mit.jwi.Dictionary;
import edu.mit.jwi.IDictionary;
import edu.mit.jwi.item.IIndexWord;
import edu.mit.jwi.item.ISynset;
import edu.mit.jwi.item.ISynsetID;
import edu.mit.jwi.item.IWord;
import edu.mit.jwi.item.IWordID;
import edu.mit.jwi.morph.WordnetStemmer;
import edu.mit.jwi.item.POS;
public class Synonyms {

	/*IDictionary is the main interface for acessing WordNet dictionary Files. 
	 * Dictionary class implements IDictionary interface.
	*/
	public static IDictionary dictionary = null;
	
        Synonyms()
	{
		try
		{
			  /*'path' holds the loaction of the WordNet dictionary files. In this code it is assumed 
			   * that the dictionary files are located under "WordNet/dict3.0/" directory. With the
			   * WordNet directory  & this class present in same directory
			   * 
			   */
		      String path = "C:\\Users\\hp\\Documents\\NetBeansProjects\\OpinionMining" + File.separator + "dict";
		      URL url = new URL("file", null, path);
	
		      // construct the dictionary object and open it
		      dictionary = new Dictionary(url);
		      dictionary.open();
		}catch (Exception e)
	    {
		      e.printStackTrace();
		}
	}
	
	public static StringBuilder searchWord(String key)
	{
		
		/*  A word is having a different WordId in different synsets. Each Word is having a
		 *  unique Index.  
		*/
		//Get  the index associated with the word, 'book' with Parts of Speech NOUN.
		IIndexWord idxWord = dictionary.getIndexWord(key, POS.NOUN);
		if(idxWord==null)
                    idxWord=dictionary.getIndexWord(key, POS.ADJECTIVE);
                if(idxWord==null)
                    idxWord=dictionary.getIndexWord(key, POS.ADVERB);
                if(idxWord==null)
                    idxWord=dictionary.getIndexWord(key, POS.VERB);
		
		int i=1;
		
		/*getWordIDs() returns all the WordID associated with a index 
		 * 
		 */	
                StringBuilder sb=new StringBuilder("");
                if(!(idxWord == null)){
		for(IWordID wordID : idxWord.getWordIDs())
		{
			//Construct an IWord object representing word associated with wordID  
			IWord word = dictionary.getWord(wordID);
			//System.out.println("SENSE->"+i);
			//System.out.println("---------");
			
			//Get the synset in which word is present.
			ISynset wordSynset = word.getSynset();
			
			//System.out.print("Synset "+i+" {");
			
			//Returns all the words present in the synset wordSynset
			for(IWord synonym : wordSynset.getWords())
			{
                            //System.out.println("offset: "+synonym.getSynset().toString());
				//System.out.print(synonym.getLemma()+", ");
                            sb.append(synonym.getLemma()+",");
			}
			//System.out.print("}"+"\n");
			
			//Returns the gloss associated with the synset.
			//System.out.println("GLOSS -> "+wordSynset.getGloss());
			
			//System.out.println();
			i++;
		} 
	}
                if(!sb.toString().isEmpty())
                return sb;
                else
                    return sb.append(",");
}
        /*public static void main(String[] args) {
        Synonyms s=new Synonyms();
        StringBuilder sb=s.searchWord("book");
            String s1[]=sb.toString().split(",");
            for(String syn: s1)
                System.out.println(syn);
    }
*/
}
