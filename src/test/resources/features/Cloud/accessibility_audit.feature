@accessibilityaudit
Feature: Runs accessibility report and provides meaningful report
    
    
    Scenario Outline: Accessibility audit on Search page 
    Given I open the login page
 	When I enter '<username>' and '<password>'
 	Then I run accessibility audit report
 	And I am able to run the scanner successfully
 	And I take screenshot of audit page
 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|

 	
  Scenario Outline: Accessibility audit on Search page 
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "login"
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    And I run accessibility audit
    Then I am able to run the scanner successfully
    And I take screenshot of audit page
    
    Examples:
	|username 	|password	|
	|TESTA		|Password1	|
    
    
  Scenario Outline: Accessibility audit on Dashboard page 
	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "login"
    And I run accessibility audit
    Then I am able to run the scanner successfully
    And I take screenshot of audit page
    
    Examples:
	|username 	|password	|
	|TESTB		|Password1	|