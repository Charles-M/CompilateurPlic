@echo off

set java_path="C:\Program Files (x86)\Java\jre7\bin\java.exe"
if not exist %java_path% set java_path="C:\Program Files\Java\jre7\bin\java.exe"
if not exist %java_path% set java_path="C:\Programmes\Java\jre7\bin\java.exe"

:test_java
if not exist %java_path% goto error_java
goto debut

:error_java
echo Error java.exe location not found, please fill it :
set /P java_path=Java Path ?
goto test_java

:error_src
echo Error source file was not found
goto usage

:error_dest
echo Error destination file or directory was not found
goto usage

:error_param
echo Error need at least one argument

:usage
echo.
echo Script usage : plicc sourcefile [destinationfile]
echo.
echo destinationfile : if not given source filename is used, with ".asm" extension
echo.
goto end

:debut
if "%1"=="" goto error_param
set chemin_src=%~dp0%1
echo.
echo Source File :
echo %chemin_src%
if not exist %chemin_src% goto error_src

if "%2"=="" goto launch2

set chemin_dest=%~dp0%2
echo.
echo Destination File :
echo %chemin_dest%
rem if not exist %chemin_dest% goto error_dest

:launch
echo.
%java_path% -jar dist/CompilPlic.jar %chemin_src% %chemin_dest%
goto end

:launch2
echo.
%java_path% -jar dist/CompilPlic.jar %chemin_src%


:end
