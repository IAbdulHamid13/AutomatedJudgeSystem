## Changes made from last commit


- Implemented TestMarker
    
    - TestMarker uses TestMaker and TestRunner to run tests and generate results
 
  - Results are stored in an array list where data for each test is stored in threes. Eg: (name, marksAwarded, marksWorth, name, MarksAwarded, marksWorth, . . . )
 
    - This required adding functionality to testable: getName, getMarksAwarded and getMarksWorth
   
    - Hence classes that implement Testable also implement these functions

- Added default constructors for testable properties that were missing it


## Next tasks


- Revise overall program to determine if there are any possible improvements

- **Merge GUI branch and ensure GUI is still functional**

