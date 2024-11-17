## Changes made from last commit


- Implemented TestRunner.java for running tests created by TestMaker

- Modified TestMaker to work with AssignmentJava's 'generateTests' function

  - As a result, AssignmentJava no longer implements Testable or 'generateTest'
 
  - TestMaker previously returned void but now returns a nested ArrayList of DynamicTests
 
      - This is because TestMaker iterates through AssignmentJavas which act as an assignment file
   
      - Recall that 'generateTests' in AssignmentJava returns an **ArrayList** of DynamicTests
   
      - Hence, since TestMaker's 'createTests' operates on many AssignmentJavas, the results of generateTests are stored in a **nested** list, therefore each list represents the tests for an Assignment file
   
  - TestRunner accepts the nested ArrayList created by TestMaker and runs each test, generating simple output (the test's name and whether or not or passed or failed)

- Modified code in App.java to use AssignmentSpec, TestMaker and TestRunner as opposed to running tests using it's own code


## Next tasks

- Determine if when running each test, the test should or shouldn't display the AssignmentJava and AssignmentSpec it belongs to

- **Merge GUI branch and ensure GUI is still functional**

