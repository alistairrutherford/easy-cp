setlocal

call C:\development\java\local\settings.bat

call %MAVEN_HOME%\bin\mvn install -Dmaven.test.skip=true install

endlocal