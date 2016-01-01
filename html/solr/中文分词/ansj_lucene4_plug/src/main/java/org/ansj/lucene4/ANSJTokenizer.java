package org.ansj.solr;
  
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
 
import org.apache.lucene.analysis.Tokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
import org.apache.lucene.analysis.tokenattributes.TypeAttribute;
import org.apache.lucene.util.AttributeFactory;
 
import org.ansj.domain.Term;
import org.ansj.splitWord.Analysis;
import org.ansj.splitWord.analysis.ToAnalysis;
 
public final class ANSJTokenizer extends Tokenizer {
 
    Analysis udf = null;
 
    private int offset = 0, bufferIndex=0, dataLen=0;
    private final static int MAX_WORD_LEN = 255;
    private final static int IO_BUFFER_SIZE = 1024;
    private final char[] buffer = new char[MAX_WORD_LEN];
    private final char[] ioBuffer = new char[IO_BUFFER_SIZE];
 
    private int length;
    private int start;
 
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
    private final TypeAttribute typeAtt = (TypeAttribute)addAttribute(TypeAttribute.class);
     
    public ANSJTokenizer(Reader in) {
        super(in);        
      }
 
      public ANSJTokenizer(AttributeFactory factory, Reader in) {
        super(factory, in);
      }
       
      public Analysis getAnalysis()
      {
          udf = new ToAnalysis(input);   
          return udf;
      }
       
    private final boolean flush() {
 
        if (length>0) {
            //System.out.println(new String(buffer, 0,
            //length));
          termAtt.copyBuffer(buffer, 0, length);
          offsetAtt.setOffset(correctOffset(start), correctOffset(start+length));
          return true;
        }
        else
            return false;
    }
 
    @Override
    public boolean incrementToken() throws IOException {
        clearAttributes();
        if(udf == null)
        {
            udf = getAnalysis();
        }
         
        Term term = udf.next();
          
        if(term != null) {
                termAtt.copyBuffer(term.getName().toCharArray(), 0, term.getName().length());                                
                 
                //if the text has newline, then the first word in the newly started line will have start position 1, which will 
                //cause the if condition failed, in original code, it can cause serious problem. 
                if(term.getTo().getOffe() < term.getOffe() || term.getTo().getOffe() < 0)
                {
                    offsetAtt.setOffset(term.getOffe(), term.getOffe() +term.getName().length());
                    typeAtt.setType("word");
                    return true;
                }         
                else
                {
                    offsetAtt.setOffset(term.getOffe(), term.getTo().getOffe());
                    typeAtt.setType("word");
                    return true;
                }                
        } else {
                end();
                return false;
        }
    }
     
    @Override
    public final void end() throws IOException {
      super.end();
      // set final offset
      final int finalOffset = correctOffset(offset);
      this.offsetAtt.setOffset(finalOffset, finalOffset);
    }
 
    @Override
    public void reset() throws IOException {
      super.reset();
      offset = bufferIndex = dataLen = 0;     
      udf = new ToAnalysis(input);      
    }
     
    @Override
    public void close() throws IOException {
      super.close();
      offset = bufferIndex = dataLen = 0;
       
    }
     
}