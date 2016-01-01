package org.ansj.solr;
 
import org.apache.lucene.analysis.util.TokenizerFactory;
import org.apache.lucene.util.AttributeFactory;
 
import java.io.IOException;
import java.io.Reader;
import java.util.Map;
 
 
public class ANSJTokenizerFactory extends TokenizerFactory {
 
    private ThreadLocal<ANSJTokenizer> tokenizerLocal = new ThreadLocal<ANSJTokenizer>();
      
     
  /** Creates a new ANSJTokenizerFactory */
  public ANSJTokenizerFactory(Map<String,String> args) {
    super(args);
    assureMatchVersion();
    if (!args.isEmpty()) {
      throw new IllegalArgumentException("Unknown parameters: " + args);
    }
  }
 
  @Override
  public ANSJTokenizer create(AttributeFactory factory, Reader input) {
       
    ANSJTokenizer tokenizer = tokenizerLocal.get();     
    if(tokenizer == null) {
        tokenizer = newTokenizer(factory, input);       
    }
    try {
            tokenizer.setReader(input);
    } catch (IOException e) {
            tokenizer = newTokenizer(factory, input);
    }
  
    return tokenizer;
     
  }
   
  private ANSJTokenizer newTokenizer(AttributeFactory factory, Reader input) {
      ANSJTokenizer tokenizer = new ANSJTokenizer(factory, input);
      tokenizerLocal.set(tokenizer);
      return tokenizer;
}
}