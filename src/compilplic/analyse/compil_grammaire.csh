#! /bin/csh

cd analyse/
echo ""
echo "java java_cup.Main -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup\n"
echo ""
java java_cup.Main -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup
echo ""
echo "java JFlex.Main AnalyseurLexical.jflex\n"
echo ""
java JFlex.Main AnalyseurLexical.jflex
exit(0)
echo ""
cd ..
echo "javac analyse/*.java"
#javac analyse/*.java
echo ""
echo "java analyse/TestAnalyse code"
echo ""
#java analyse/TestAnalyse code
echo ""

