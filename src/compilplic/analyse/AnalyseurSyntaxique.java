
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Mon Apr 14 00:37:36 CEST 2014
//----------------------------------------------------

package compilplic.analyse;

import compilplic.lexique.Instruction;
import compilplic.lexique.Lexique;
import compilplic.lexique.expression.Binaire;
import compilplic.lexique.expression.Equal;
import compilplic.lexique.expression.Expression;
import compilplic.lexique.expression.GreaterThan;
import compilplic.lexique.expression.LowerThan;
import compilplic.lexique.expression.Multiplication;
import compilplic.lexique.expression.Nombre;
import compilplic.lexique.expression.NonEqual;
import compilplic.lexique.expression.Somme;
import compilplic.lexique.expression.Soustraction;

/** CUP v0.11a beta 20060608 generated parser.
<<<<<<< HEAD
  * @version Mon Apr 14 00:37:36 CEST 2014
=======
  * @version Sat Apr 12 02:48:19 CEST 2014
>>>>>>> master
  */
public class AnalyseurSyntaxique extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public AnalyseurSyntaxique() {super();}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public AnalyseurSyntaxique(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\014\000\002\002\004\000\002\002\003\000\002\002" +
    "\005\000\002\002\004\000\002\002\005\000\002\003\003" +
    "\000\002\003\003\000\002\003\003\000\002\003\003\000" +
    "\002\003\003\000\002\003\003\000\002\003\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\010\005\004\013\007\015\005\001\002\000" +
    "\010\005\004\013\007\015\005\001\002\000\024\002\000" +
    "\004\000\005\000\006\000\007\000\010\000\011\000\012" +
    "\000\014\000\001\002\000\022\002\023\004\015\005\020" +
    "\006\013\007\016\010\021\011\014\012\017\001\002\000" +
    "\010\005\004\013\007\015\005\001\002\000\022\004\015" +
    "\005\020\006\013\007\016\010\021\011\014\012\017\014" +
    "\012\001\002\000\010\005\004\013\007\015\005\001\002" +
    "\000\024\002\uffff\004\uffff\005\uffff\006\uffff\007\uffff\010" +
    "\uffff\011\uffff\012\uffff\014\uffff\001\002\000\010\005\ufffa" +
    "\013\ufffa\015\ufffa\001\002\000\010\005\ufff7\013\ufff7\015" +
    "\ufff7\001\002\000\010\005\ufffc\013\ufffc\015\ufffc\001\002" +
    "\000\010\005\ufff9\013\ufff9\015\ufff9\001\002\000\010\005" +
    "\ufff6\013\ufff6\015\ufff6\001\002\000\010\005\ufffb\013\ufffb" +
    "\015\ufffb\001\002\000\010\005\ufff8\013\ufff8\015\ufff8\001" +
    "\002\000\024\002\ufffd\004\015\005\020\006\013\007\016" +
    "\010\021\011\014\012\017\014\ufffd\001\002\000\004\002" +
    "\001\001\002\000\024\002\ufffe\004\ufffe\005\ufffe\006\ufffe" +
    "\007\ufffe\010\ufffe\011\ufffe\012\ufffe\014\ufffe\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\004\002\005\001\001\000\004\002\023\001" +
    "\001\000\002\001\001\000\004\003\010\001\001\000\004" +
    "\002\007\001\001\000\004\003\010\001\001\000\004\002" +
    "\021\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\002\001\001\000\002\001\001\000\002\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\010" +
    "\001\001\000\002\001\001\000\004\003\010\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$AnalyseurSyntaxique$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$AnalyseurSyntaxique$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$AnalyseurSyntaxique$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}




    /* Change the method report_error so it will display the line and column of where the error
       occurred in the input as well as the reason for the error which is passed into the method
       in the String 'message'. */
    public void report_error(String message , Object info) {
   
        /* Create a StringBuffer called 'm' with the string 'Error' in it. */
        StringBuffer m = new StringBuffer("Error");
   
        /* Check if the information passed to the method is the same type as the type 
           java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the information in the object 
               info that is being typecasted as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);
   
            /* Check if the line number in the input is greater or equal to zero. */
            if (s.left >= 0) {                
                /* Add to the end of the StringBuffer error message the line number of the error 
                   in the input. */
                m.append(" in line "+(s.left+1));   
                /* Check if the column number in the input is greater or equal to zero. */
                if (s.right >= 0)                    
                    /* Add to the end of the StringBuffer error message the column number of the 
                       error in the input. */
                    m.append(" , column "+(s.right+1));
            }
        }
   
        /* Add to the end of the StringBuffer error message created in this method the message that
           was passed into this method. */
        m.append(" : "+message);
   
        /* Print the contents of the StringBuffer 'm' , which contains an error message , out on 
           a line. */
        System.err.println(m);
    }
   
    /* Change the method report_fatal_error so when it reports a fatal error it will display the 
       line and column number of where the fatal error occurred in the input as well as the reason
       for the fatal error which is passed into the method in the object 'message' and then exit.*/
    public void report_fatal_error(String message , Object info) {
        report_error(message , info);
        System.exit(1);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$AnalyseurSyntaxique$actions {

 public Lexique lexique = new Lexique() ;
 private Instruction inst ;
	    
  private final AnalyseurSyntaxique parser;

  /** Constructor */
  CUP$AnalyseurSyntaxique$actions(AnalyseurSyntaxique parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$do_action(
    int                        CUP$AnalyseurSyntaxique$act_num,
    java_cup.runtime.lr_parser CUP$AnalyseurSyntaxique$parser,
    java.util.Stack            CUP$AnalyseurSyntaxique$stack,
    int                        CUP$AnalyseurSyntaxique$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$AnalyseurSyntaxique$result;

      /* select the action based on the action number */
      switch (CUP$AnalyseurSyntaxique$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // OPER ::= DIFF 
            {
              Binaire RESULT =null;
		 System.out.println("syn : !=") ; 
            RESULT = new NonEqual(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // OPER ::= DOUBLE_EQUAL 
            {
              Binaire RESULT =null;
		 System.out.println("syn : ==") ; 
            RESULT = new Equal(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // OPER ::= LT 
            {
              Binaire RESULT =null;
		 System.out.println("syn : <") ; 
            RESULT = new LowerThan(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // OPER ::= GT 
            {
              Binaire RESULT =null;
		 System.out.println("syn : >") ; 
            RESULT = new GreaterThan(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // OPER ::= MULT 
            {
              Binaire RESULT =null;
		 System.out.println("syn : *") ; 
            RESULT = new Multiplication(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // OPER ::= MOINS 
            {
              Binaire RESULT =null;
		 System.out.println("syn : -") ; 
            RESULT = new Soustraction(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // OPER ::= PLUS 
            {
              Binaire RESULT =null;
		 System.out.println("syn : +") ; 
            RESULT = new Somme(null, null) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("OPER",1, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // EXP ::= EXP OPER EXP 
            {
              Expression RESULT =null;
		int e1left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).right;
		Expression e1 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)).value;
		int exprleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int exprright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Binaire expr = (Binaire)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e2 = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 System.out.println("syn : expr1 op expr2") ;
            System.out.println("test : e1 = "+e1+"   e2 = "+e2) ;
            expr.setGauche(e1) ;
            RESULT = expr ;
            if(e2 instanceof Nombre) expr.setDroite(e2) ;
            else {
                System.out.println("Remontage") ;
                expr.setDroite(((Binaire)e2).getGauche()) ;
                ((Binaire)e2).setGauche(expr) ;
                RESULT = e2 ;
            }
          
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // EXP ::= MOINS EXP 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 System.out.println("syn : - expr") ; 
            RESULT = new Soustraction(new Nombre(0), e) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // EXP ::= PARENTH_OUVRANTE EXP PARENTH_FERMANTE 
            {
              Expression RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression e = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		 System.out.println("syn : ("+e+")") ; 
            RESULT = e ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-2)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // EXP ::= CSTE_ENT 
            {
              Expression RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()).right;
		String i = (String)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.peek()).value;
		 System.out.println("syn : "+i) ; 
            RESULT = new Nombre(Integer.parseInt(i.trim())) ; 
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("EXP",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          return CUP$AnalyseurSyntaxique$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= EXP EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).right;
		Expression start_val = (Expression)((java_cup.runtime.Symbol) CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)).value;
		RESULT = start_val;
              CUP$AnalyseurSyntaxique$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.elementAt(CUP$AnalyseurSyntaxique$top-1)), ((java_cup.runtime.Symbol)CUP$AnalyseurSyntaxique$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$AnalyseurSyntaxique$parser.done_parsing();
          return CUP$AnalyseurSyntaxique$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

