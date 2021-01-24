# Prime Printer

Clean code episode 3 refactoring exercise.  

This program generates a five page report of the first 1,000 prime numbers. Each page has 4 columns and 50 lines for a total of 200 prime numbers per page. 

The test checks that the file generated, lead, is the same as a previously generated correct file, gold. 
This is a classic technique from Michael Feathers book, *Working Effectively with Legacy Code*, 
called a *characterization test*.  

A characterization test is useful when you need to refactor legacy code, and you have no tests. 
However, the test is fragile. You might throw the test away after the code is refactored, 
and you have 'real' tests.  

The large function is refactored to be 3 separate classes.

## Installation 
1. If needed, [install Maven](https://maven.apache.org/install.html).
2. Install the project with Maven
   ```sh
   mvn install
   ```
3. To see program output, can run jar with Maven exec plugin
   ```sh
   mvn exec:java
   ```
