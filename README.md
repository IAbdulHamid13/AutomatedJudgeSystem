# Branch Purpose

This branch was made in order to implement and test JUnit's DynamicTests

## Changes made from last commit


- Migrated SpecCreation, TestCreation and Views folders to test folder for the purpose of using JUnit DynamicTests

- Modified generateTest in Testable (and for every class that implements it) to return DynamicTest

- Implemented generateTest for AssignmentAttribute


## Next tasks


- Implement generateTest for AssignmentConstructor, AssignmentMethod, AssignmentProperty and AssignmentJava

- Determine if AssignmentConstructor is necessary

- Create functionality for running DynamicTests
