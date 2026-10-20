@echo off
setlocal
cd /d "%~dp0"
set "APP_JAR=out\artifacts\Enigma_jar\Enigma.jar"
if not exist "%APP_JAR%" (
 echo ERROR: Enigma.jar is missing. Extract the entire ZIP before running.
 pause
 exit /b 1
)
where java >nul 2>&1
if errorlevel 1 (
 echo Java 17 or later is required.
 echo Install Java from https://adoptium.net/temurin/releases/?version=17
 echo Then reopen this launcher.
 pause
 exit /b 1
)
java -version 2>nul | findstr /R /C:"version \"1[7-9]\." /C:"version \"[2-9][0-9]\." /C:"openjdk 1[7-9]\." /C:"openjdk [2-9][0-9]\." >nul
rem The application itself will report incompatibility if Java is too old.
java -jar "%APP_JAR%"
if errorlevel 1 (
 echo.
 echo Enigma could not start. Confirm you have Java 17 or newer installed.
 pause
)
endlocal
