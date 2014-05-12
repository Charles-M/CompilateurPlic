/* The following code was generated by JFlex 1.4.3 on 12/05/14 19:41 */

package compilplic.analyse ;

import java_cup.runtime.*;
import compilplic.exception.LexicalException;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 12/05/14 19:41 from the specification file
 * <tt>AnalyseurLexical.jflex</tt>
 */
public class AnalyseurLexical implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int commentaireBloc = 4;
  public static final int YYINITIAL = 0;
  public static final int commentaireLigne = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\1\1\2\1\0\1\1\1\1\22\0\1\1\1\24\1\4"+
    "\2\0\1\21\2\0\1\34\1\35\1\22\1\21\1\32\1\21\1\36"+
    "\1\25\12\3\1\0\1\31\1\21\1\23\1\21\2\0\32\20\1\0"+
    "\1\0\1\0\3\0\1\27\1\14\1\26\1\20\1\5\1\33\2\20"+
    "\1\10\2\20\1\15\1\20\1\6\1\20\1\12\1\16\1\11\1\30"+
    "\1\7\1\13\1\17\4\20\uff85\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\1\1\2\1\3\1\4\1\1\1\5\1\4\4\6"+
    "\1\7\1\10\1\4\1\7\1\6\1\11\1\12\1\6"+
    "\1\13\1\14\1\2\1\15\1\3\2\0\1\16\5\6"+
    "\1\17\1\20\2\6\1\21\6\6\1\22\4\6\1\23"+
    "\6\6\1\24\1\25\1\26\1\6\1\27";

  private static int [] zzUnpackAction() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\37\0\76\0\135\0\174\0\233\0\272\0\331"+
    "\0\370\0\u0117\0\u0136\0\135\0\u0155\0\u0155\0\u0174\0\u0193"+
    "\0\135\0\135\0\u01b2\0\135\0\135\0\u01d1\0\135\0\u01f0"+
    "\0\u020f\0\272\0\u022e\0\u024d\0\u026c\0\u028b\0\u02aa\0\u02c9"+
    "\0\135\0\135\0\u02e8\0\u0307\0\135\0\u0326\0\u0345\0\u0364"+
    "\0\u0383\0\u03a2\0\u03c1\0\370\0\u03e0\0\u03ff\0\u041e\0\u043d"+
    "\0\370\0\u045c\0\u047b\0\u049a\0\u04b9\0\u04d8\0\u04f7\0\370"+
    "\0\370\0\370\0\u0516\0\370";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\6\1\7\1\10\4\11\1\12\2\11"+
    "\1\13\3\11\2\14\1\15\1\16\1\17\1\20\2\11"+
    "\1\21\1\22\1\23\1\24\1\25\1\4\2\26\1\27"+
    "\34\26\22\30\1\31\2\30\1\0\6\30\43\0\2\5"+
    "\37\0\1\6\33\0\4\32\1\33\32\32\3\0\1\11"+
    "\1\0\1\11\1\34\12\11\5\0\1\35\2\11\2\0"+
    "\1\11\6\0\1\11\1\0\14\11\5\0\3\11\2\0"+
    "\1\11\6\0\1\11\1\0\4\11\1\36\1\11\1\37"+
    "\5\11\5\0\3\11\2\0\1\11\6\0\1\11\1\0"+
    "\3\11\1\40\10\11\5\0\3\11\2\0\1\11\26\0"+
    "\1\14\35\0\1\41\2\0\1\42\14\0\1\11\1\0"+
    "\10\11\1\43\3\11\5\0\3\11\2\0\1\11\6\0"+
    "\1\11\1\0\3\11\1\44\10\11\5\0\3\11\2\0"+
    "\1\11\3\0\2\26\1\0\34\26\22\30\1\0\2\30"+
    "\1\0\6\30\30\0\1\45\15\0\1\32\35\0\1\11"+
    "\1\0\2\11\1\46\11\11\5\0\3\11\2\0\1\11"+
    "\6\0\1\11\1\0\4\11\1\47\7\11\5\0\3\11"+
    "\2\0\1\11\6\0\1\11\1\0\3\11\1\50\10\11"+
    "\5\0\3\11\2\0\1\11\6\0\1\11\1\0\7\11"+
    "\1\51\4\11\5\0\3\11\2\0\1\11\6\0\1\11"+
    "\1\0\4\11\1\52\7\11\5\0\3\11\2\0\1\11"+
    "\6\0\1\11\1\0\14\11\5\0\1\11\1\53\1\11"+
    "\2\0\1\11\6\0\1\11\1\0\1\11\1\54\12\11"+
    "\5\0\3\11\2\0\1\11\6\0\1\11\1\0\3\11"+
    "\1\55\10\11\5\0\3\11\2\0\1\11\6\0\1\11"+
    "\1\0\3\11\1\56\10\11\5\0\3\11\2\0\1\11"+
    "\6\0\1\11\1\0\12\11\1\57\1\11\5\0\3\11"+
    "\2\0\1\11\6\0\1\11\1\0\10\11\1\60\3\11"+
    "\5\0\3\11\2\0\1\11\6\0\1\11\1\0\1\61"+
    "\13\11\5\0\3\11\2\0\1\11\6\0\1\11\1\0"+
    "\14\11\5\0\2\11\1\62\2\0\1\11\6\0\1\11"+
    "\1\0\1\63\13\11\5\0\3\11\2\0\1\11\6\0"+
    "\1\11\1\0\4\11\1\64\7\11\5\0\3\11\2\0"+
    "\1\11\6\0\1\11\1\0\1\65\13\11\5\0\3\11"+
    "\2\0\1\11\6\0\1\11\1\0\3\11\1\66\10\11"+
    "\5\0\3\11\2\0\1\11\6\0\1\11\1\0\14\11"+
    "\5\0\2\11\1\67\2\0\1\11\6\0\1\11\1\0"+
    "\4\11\1\70\7\11\5\0\3\11\2\0\1\11\6\0"+
    "\1\11\1\0\1\71\13\11\5\0\3\11\2\0\1\11"+
    "\6\0\1\11\1\0\1\72\13\11\5\0\3\11\2\0"+
    "\1\11\6\0\1\11\1\0\11\11\1\73\2\11\5\0"+
    "\3\11\2\0\1\11\6\0\1\11\1\0\1\74\13\11"+
    "\5\0\3\11\2\0\1\11\6\0\1\11\1\0\6\11"+
    "\1\65\5\11\5\0\3\11\2\0\1\11\3\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1333];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\1\1\11\7\1\1\11\4\1\2\11\1\1\2\11"+
    "\1\1\1\11\1\1\2\0\6\1\2\11\2\1\1\11"+
    "\27\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[60];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    // retourne le symbol lu
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

    // retourne le symbol lu et sa valeur
  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public AnalyseurLexical(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public AnalyseurLexical(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 110) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 18: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_FIN,yytext()) ;
          }
        case 24: break;
        case 20: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.TYPE,yytext()) ;
          }
        case 25: break;
        case 7: 
          { switch(yytext()) {
        case "+" :
            return symbol(CodesLexicaux.PLUS, yytext());
        case "-" :
            return symbol(CodesLexicaux.MOINS, yytext());
        case "*" :
            return symbol(CodesLexicaux.MULT, yytext());
        case "/" :
            return symbol(CodesLexicaux.DIV, yytext());
        case "<" :
            return symbol(CodesLexicaux.LT, yytext());
        case "%" :
            return symbol(CodesLexicaux.MOD, yytext());
        case ">" :
            return symbol(CodesLexicaux.GT, yytext());
        case "==" :
            return symbol(CodesLexicaux.DOUBLE_EQUAL, yytext());
        case "!=" :
            return symbol(CodesLexicaux.DIFF, yytext());
    }
          }
        case 26: break;
        case 3: 
          { /*System.out.println("com bloc contenu : "+yytext()) ;*/
          }
        case 27: break;
        case 19: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_LIRE,yytext()) ;
          }
        case 28: break;
        case 2: 
          { /*System.out.println("com ligne contenu : "+yytext()) ;*/
          }
        case 29: break;
        case 12: 
          { return symbol(CodesLexicaux.PARENTH_FERMANTE);
          }
        case 30: break;
        case 15: 
          { /*System.out.println("com bloc " + yytext()) ;*/ yybegin(commentaireBloc) ;
          }
        case 31: break;
        case 4: 
          { System.err.println("ERREUR LEXICAL ligne:"+yyline+" colonne:"+yycolumn+" caractere non lu : "+yytext()) ;
          }
        case 32: break;
        case 8: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.EQUAL,yytext()) ;
          }
        case 33: break;
        case 13: 
          { /*System.out.println("fin com ligne ") ;*/ yybegin(YYINITIAL) ;
          }
        case 34: break;
        case 23: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_CLASSE,yytext()) ;
          }
        case 35: break;
        case 6: 
          { /*System.out.println("idf : " + yytext()) ;*/ return symbol(CodesLexicaux.IDF,yytext()) ;
          }
        case 36: break;
        case 22: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.STATUT,yytext()) ;
          }
        case 37: break;
        case 5: 
          { return symbol(CodesLexicaux.CSTE_ENT, yytext());
          }
        case 38: break;
        case 17: 
          { /*System.out.println("fin com bloc ") ;*/ yybegin(YYINITIAL) ;
          }
        case 39: break;
        case 14: 
          { /*System.out.println("string "+yytext()) ;*/ return symbol(CodesLexicaux.CSTE_CHAINE, yytext());
          }
        case 40: break;
        case 10: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.VIRGULE,yytext()) ;
          }
        case 41: break;
        case 11: 
          { return symbol(CodesLexicaux.PARENTH_OUVRANTE);
          }
        case 42: break;
        case 21: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_ECRIRE,yytext()) ;
          }
        case 43: break;
        case 1: 
          { 
          }
        case 44: break;
        case 9: 
          { /*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.POINT_VIRGULE,yytext()) ;
          }
        case 45: break;
        case 16: 
          { /*System.out.println("com ligne " + yytext()) ;*/ yybegin(commentaireLigne) ;
          }
        case 46: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {         return symbol(CodesLexicaux.EOF) ;
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
