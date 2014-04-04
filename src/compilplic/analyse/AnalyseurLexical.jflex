package paleo.analyse ;

import java_cup.runtime.*;
      
%%
   
%class AnalyseurLexical
%public

%line
%column
    
%type Symbol
%eofval{
        return symbol(CodesLexicaux.EOF) ;
%eofval}

%cup
   
%{
  private Symbol symbol(int type) {
	return new Symbol(type, yyline, yycolumn) ;
  }

  private Symbol symbol(int type, Object value) {
	return new Symbol(type, yyline, yycolumn, value) ;
  }
%}

%state Expression
%state commentaireLigne
%state commentaireBloc

idf = [a-z_][a-zA-Z0-9_]*
typePrimitif = "boolean" | "char" | "int" | "double" | "float" | "short" | "long" | "byte"
classe = [A-Z][a-zA-Z0-9_<>]*
expr = [^;]*

commentaireLigne = \/\/[^\n]*\n
commentaireBloc = \/\*([^*]|\*+[^*/])*\*+\/

/* A line terminator is a \r (carriage return), \n (line feed), or \r\n. */
LineTerminator = \r|\n|\r\n
   
/* White space is a line terminator, space, tab, or line feed. */
WhiteSpace     = {LineTerminator} | [ \t\f]
   
null = {WhiteSpace}*null{WhiteSpace}*

tableau = ({typePrimitif}|{classe}){WhiteSpace}*[\[]{WhiteSpace}*[\]]

void = {idf}[\.]{expr}[;]


%%

<YYINITIAL> {void}				{}

<YYINITIAL> "//"				{/*System.out.println("com ligne " + yytext()) ;*/ yybegin(commentaireLigne) ;}

<YYINITIAL> "/*"				{/*System.out.println("com bloc " + yytext()) ;*/ yybegin(commentaireBloc) ;}

<YYINITIAL> ";"           	   	{ return symbol(CodesLexicaux.POINTVIRGULE); }

<YYINITIAL> "="					{ // changement d'etat
									yybegin(Expression) ;
									return symbol(CodesLexicaux.EGAL) ;
								}

<YYINITIAL> {classe}|{tableau}	{ /*System.out.println("classe ou tableau " + yytext()) ;*/ return symbol(CodesLexicaux.CLASSE, yytext()); }

<YYINITIAL> {typePrimitif}		{ /*System.out.println("type primitif " + yytext()) ;*/ return symbol(CodesLexicaux.TYPEPRIMITIF, yytext()); }

<YYINITIAL> {idf}				{ /*System.out.println("identificateur " + yytext()) ;*/ return symbol(CodesLexicaux.IDF, yytext()) ; }
							 	
<Expression> {null}				{ return symbol(CodesLexicaux.NULL); }

<Expression> {expr}				{ return symbol(CodesLexicaux.EXPR, yytext()) ; }

<Expression> ";"				{ // retour dans YYINITIAL
									yybegin(YYINITIAL) ;
									return symbol(CodesLexicaux.POINTVIRGULE) ;}
						
<commentaireBloc>	"*/"		{yybegin(YYINITIAL) ;}

<commentaireLigne>	"\n"		{yybegin(YYINITIAL) ;}

.			{/*System.out.println("autre " + yytext());*/}
\n			{/*System.out.println("retour ligne " + yytext());*/}

