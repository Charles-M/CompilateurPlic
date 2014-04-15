package compilplic.analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%cup
%public

%line
%column
    
%integer
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}


   
%{
    // retourne le symbol lu
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

    // retourne le symbol lu et sa valeur
  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state commentaireLigne
%state commentaireBloc

/* A line terminator is a \r (carriage return), \n (line feed), or \r\n. */
LineTerminator = \r|\n|\r\n
   
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace = {LineTerminator} | [ \t\f]

constEnt = {WhiteSpace}*[1-9][0-9]*{WhiteSpace}*
typePrimitif = {WhiteSpace}*"entier"{WhiteSpace}*
idf = [a-z_][a-zA-Z0-9_]*
operateur = "+" | "-" | "*" | ">" | "<" | "==" | "!="
commentaireLigne = \/\/[^\n]*\n
commentaireBloc = \/\*([^*]|\*+[^*/])*\*+\/

tableau = ({typePrimitif}|{classe}){WhiteSpace}*[\[]{WhiteSpace}*[\]]

%%

{WhiteSpace}*   {}

<YYINITIAL> {operateur}   { 
    switch(yytext()) {
        case "+" :
            return symbol(CodesLexicaux.PLUS, yytext());
        case "-" :
            return symbol(CodesLexicaux.MOINS, yytext());
        case "*" :
            return symbol(CodesLexicaux.MULT, yytext());
        case "<" :
            return symbol(CodesLexicaux.LT, yytext());
        case ">" :
            return symbol(CodesLexicaux.GT, yytext());
        case "==" :
            return symbol(CodesLexicaux.DOUBLE_EQUAL, yytext());
        case "!=" :
            return symbol(CodesLexicaux.DIFF, yytext());
    }
}
<YYINITIAL> {constEnt}	{ return symbol(CodesLexicaux.CSTE_ENT, yytext());}
<YYINITIAL> "("		{ return symbol(CodesLexicaux.PARENTH_OUVRANTE);}
<YYINITIAL> ")"		{ return symbol(CodesLexicaux.PARENTH_FERMANTE);}

<YYINITIAL> "//"		{/*System.out.println("com ligne " + yytext()) ;*/ yybegin(commentaireLigne) ;}
<YYINITIAL> "/*"		{/*System.out.println("com bloc " + yytext()) ;*/ yybegin(commentaireBloc) ;}
						
<commentaireBloc>	"*/"		{yybegin(YYINITIAL) ;}
<commentaireLigne>	"\n"		{yybegin(YYINITIAL) ;}

<YYINITIAL> \n			{/*System.out.println("retour ligne " + yytext());*/}
<YYINITIAL> .			{ System.out.println("ERREUR LEXICAL ligne:"+yyline+" colonne:"+yycolumn+" caractere non lu : "+yytexte()) ; System.exit(0) ; }
