#@waveaccessibility
#Feature: Successful login to CCCHS application
  #Demo feature for User Can Successful login
 #
#		
  #Scenario Outline: Check WAVE accessibility on Login page
 #	Given I open the login page
 #	When I enter '<username>' and '<password>'
 #	Then I click WAVE image
 #	Then I show WAVE errors
 #	And I show WAVE alerts
 #	And I show WAVE features
 #	And I show WAVE structural elements
 #	And I show WAVE html5 and aria
 #	And I show WAVE contrast errors
 #	Then I take screenshot of wave page
 #	
 #	Examples:
#	|username 	|password	|
#	|TESTA		|Password1	|
#
#
  #Scenario Outline: Check WAVE accessibility on Home page
 #	Given I open the login page
 #	When I enter '<username>' and '<password>'
 #	Then I click the button "login"
 #	And I click WAVE image
 #	And I show WAVE errors
 #	And I show WAVE alerts
 #	And I show WAVE features
 #	And I show WAVE structural elements
 #	And I show WAVE html5 and aria
 #	And I show WAVE contrast errors
 #	Then I take screenshot of wave page
 #	
 #	Examples:
#	|username 	|password	|
#	|TESTB		|Password1	|
#	
#	
  #Scenario Outline: Check WAVE accessibility on Search page
 #	Given I open the login page
 #	When I enter '<username>' and '<password>'
    #Then I click the button "login" 
    #And I am redirected to "home" page
    #Then I click the tab "search" 
    #And I am redirected to "search" page
    #Then I click WAVE image
 #	And I show WAVE errors
 #	And I show WAVE alerts
 #	And I show WAVE features
 #	And I show WAVE structural elements
 #	And I show WAVE html5 and aria
 #	And I show WAVE contrast errors
 #	Then I take screenshot of wave page
 #	
 #	Examples:
#	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary														|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
#	|TESTA		|Password1	|test			|Telephone	|0 			|CMP999197789	|ICTec		|15		|01/01/2016	|Customer may be able to refer the complaint to the Ombudsman	|yes	|1		|1		|1		|1		|2			|2			|
#	