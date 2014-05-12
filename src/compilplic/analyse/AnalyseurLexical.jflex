package compilplic.analyse ;

import java_cup.runtime.*;
import compilplic.exception.LexicalException;

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

constEnt = [0-9]+
constChaine = \"(\"\"|[^\"])*\"
typePrimitif = "entier"
statut = "publique" | "privee"
idf = [a-zA-Z][a-zA-Z0-9]*
operateur = "+" | "-" | "*" | ">" | "<" | "==" | "!=" | "/" | "%"
commentaireLigne = \/\/[^\n]*\n
commentaireBloc = \/\*([^*]|\*+[^*/])*\*+\/

tableau = ({typePrimitif}|{classe}){WhiteSpace}*[\[]{WhiteSpace}*[\]]

%%

<YYINITIAL> {WhiteSpace}*   {}

<YYINITIAL> "classe"    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_CLASSE,yytext()) ;}
<YYINITIAL> "="    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.EQUAL,yytext()) ;}
<YYINITIAL> ";"    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.POINT_VIRGULE,yytext()) ;}
<YYINITIAL> ","    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.VIRGULE,yytext()) ;}
<YYINITIAL> "fin"    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_FIN,yytext()) ;}
<YYINITIAL> "lire"    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_LIRE,yytext()) ;}
<YYINITIAL> "ecrire"    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.S_ECRIRE,yytext()) ;}
<YYINITIAL> {statut}    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.STATUT,yytext()) ;}
<YYINITIAL> {typePrimitif}    {/*System.out.println("token : " + yytext()) ;*/ return symbol(CodesLexicaux.TYPE,yytext()) ;}
<YYINITIAL> {idf}    {/*System.out.println("idf : " + yytext()) ;*/ return symbol(CodesLexicaux.IDF,yytext()) ;}

<YYINITIAL> "//"		{/*System.out.println("com ligne " + yytext()) ;*/ yybegin(commentaireLigne) ;}
<YYINITIAL> "/*"		{/*System.out.println("com bloc " + yytext()) ;*/ yybegin(commentaireBloc) ;}

<YYINITIAL> {operateur}   { 
    switch(yytext()) {
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

<YYINITIAL> {constEnt}	{ return symbol(CodesLexicaux.CSTE_ENT, yytext());}
<YYINITIAL> {constChaine}	{ /*System.out.println("string "+yytext()) ;*/ return symbol(CodesLexicaux.CSTE_CHAINE, yytext());}
<YYINITIAL> "("		{ return symbol(CodesLexicaux.PARENTH_OUVRANTE);}
<YYINITIAL> ")"		{ return symbol(CodesLexicaux.PARENTH_FERMANTE);}
			
<commentaireBloc>	"*/"		{/*System.out.println("fin com bloc ") ;*/ yybegin(YYINITIAL) ;}
<commentaireBloc>	[^(*/).]*	{/*System.out.println("com bloc contenu : "+yytext()) ;*/}
<commentaireLigne>	"\n"		{/*System.out.println("fin com ligne ") ;*/ yybegin(YYINITIAL) ;}
<commentaireLigne>	.*		{/*System.out.println("com ligne contenu : "+yytext()) ;*/}

<YYINITIAL> .			{ System.err.println("ERREUR LEXICAL ligne:"+yyline+" colonne:"+yycolumn+" caractere non lu : "+yytext()) ; }
