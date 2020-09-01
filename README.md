README.MD
=====================

TRADE STORE PROJECT
====================

Technologies used 

1. JAVA 11.0 - Tested with Open JDK
2. Maven 3.5.4
3. Spring BOOT 2.2.5 uses spring core 5.2.4
3. Spring JPA and Hibernate validator 6.1.5 for enabling validator factory. This can be replaced with any other implementations or custom implementations.
4. Uses H2 DB for testing

Design
=======
1. Uses Rest Based design.
2. TDD approach used by designing test case before code for most part of the code. 
3. Uses the approach of rules based validator. Designed a generic validation framework which is extensibile. 
	** Designed to use now only for CLASS based designed.
	** extensible to use groovy script, Query and API based validations as well
	** Validation design uses chain of responsibility pattern , other patterns used are  factory, singleton and command pattern etc.
4. Uses Task scheduler based design for updating the expiring the trades exceeding maturity date. Uses the spring scheduler approach .
5. Not implemented - overriding the trade record which has the same version as that of existing record.	

Issues::
--------
1. Issues with maven sure-fire plugin. Does not execute the test case on using maven. All the test cases tested through the IntelliJ studio

Exclusions
===========
1. PMD, Checkstyle and Findbugs are integrated thru IDE. Not integrated to Maven plugin
