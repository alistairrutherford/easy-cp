setlocal

call C:\development\java\local\settings.bat

call %MAVEN_HOME%\bin\mvn eclipse:clean

call %MAVEN_HOME%\bin\mvn eclipse:eclipse

endlocal