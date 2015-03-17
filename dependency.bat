setlocal

call C:\development\java\local\settings.bat

call %MAVEN_HOME%\bin\mvn dependency:tree

endlocal