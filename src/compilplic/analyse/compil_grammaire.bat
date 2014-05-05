@echo off


set java_path="C:\Program Files\Java\jre7\bin\java.exe"
if not exist %java_path% set java_path="C:\Program Files (x86)\Java\jre7\bin\java.exe"
if not exist %java_path% set java_path="C:\Programmes\Java\jre7\bin\java.exe" goto error_java

set jdk_path="C:\Program Files\Java\jdk1.7.0_45\bin\javac.exe"
if not exist %jdk_path% set jdk_path="C:\Program Files (x86)\Java\jdk1.7.0_45\bin\javac.exe"
if not exist %jdk_path% set jdk_path="C:\Programmes\Java\jdk1.7.0_45\bin\javac.exe" goto error_jdk

:test_java
if not exist %java_path% goto error_java
goto debut

:error_java
echo Error java.exe location not found, please fill it :
set /P java_path=Java Path ?
goto test_java

:test_jdk
if not exist %java_path% goto error_java
goto debut

:error_jdk
echo Error javac.exe location not found, please fill it :
set /P jdk_path=JDK Path ?
goto test_jdk

:debut
set lib_path="..\..\..\dist\lib\\"
rem echo.
rem echo "libpath : %lib_path%"
echo.
echo.
echo.
echo ==========Realisation de l'analyseur Lexicale==========
echo.
%java_path% -jar %lib_path%JFlex.jar AnalyseurLexical.jflex
echo.
echo.
echo.
echo.
echo ==========Realisation de l'analyseur Syntaxique==========
echo.
%java_path% -jar java-cup-11a.jar -parser AnalyseurSyntaxique -symbols CodesLexicaux Grammaire.cup
echo.
rem cd ..
rem echo "javac analyse/*.java"
rem %jdk_path% -cp java-cup-11a.jar;%lib_path%JFlex.jar analyse/*.java
rem cd analyse
pause