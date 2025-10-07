Run tests with Maven:

    mvn test

If you see an error like:

    mvn : The term 'mvn' is not recognized as the name of a cmdlet...

It means Maven is not installed or not in your PATH. Options:

1) Install Maven and add it to PATH (recommended):
   - https://maven.apache.org/install.html
   - After install, open a new terminal and run `mvn -v` to verify.

2) Run tests without Maven using the provided PowerShell script (no install required):
   - In PowerShell run:

       Set-Location 'd:\\Kiểm thử\\Test'
       .\\run-tests.ps1

   The script will download the JUnit console jar, compile sources and run tests.

Files:
- src/main/java/Lottery.java
- src/main/java/MainInteractive.java (optional interactive runner)
- src/test/java/LotteryTest.java (JUnit 5 tests)
- run-tests.ps1 (helper to run tests without Maven)
