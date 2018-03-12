@regression @amber
Feature: Create New Complaint for Local Resolution with Active status


@cipipeline
  Scenario Outline: AMBER - Create a New Complaint for Telephone for Local Resolution
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary														|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Telephone	|0 			|CMP777197789	|smith		|11		|01/01/2016	|Customer may be able to refer the complaint to the Ombudsman	|yes	|1		|1		|1		|1		|2			|2			|
	


	Scenario Outline: AMBER - Create a New Complaint for Letter for Local Resolution
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
   	Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Letter		|0 			|CMP81197789 	|Bravo		|12		|01/01/2018	|Customer not happy and may be able to refer the complaint to the manager	|yes	|7		|2		|2		|1		|2			|2			|
	


  Scenario Outline: AMBER - Create a New Complaint for Email for Local Resolution
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Email		|0 			|CMP01597789	|alpha		|10		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|



  Scenario Outline: AMBER - Create a New Complaint for Social Media for Local Resolution
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint"
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Email		|0 			|CMP01597777	|phaaa		|18		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|

	
	
	
@cipipeline
  Scenario Outline: AMBER - Create a New Complaint for Telephone for MP
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary														|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Telephone	|1 			|CMP777197789	|Sprnt		|13		|01/01/2016	|Customer may be able to refer the complaint to the Ombudsman	|yes	|7		|2		|2		|1		|2			|2			|
	


  Scenario Outline: AMBER - Create a New Complaint for Letter for MP
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
   	Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Letter		|1 			|CMP81197789 	|Bravo		|02		|01/01/2018	|Customer not happy and may be able to refer the complaint to the manager	|yes	|7		|2		|2		|1		|2			|2			|
	


  Scenario Outline: AMBER - Create a New Complaint for Email for MP
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    Then I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint" 
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type		|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|Email		|1 			|CMP01597789	|IrMan		|99		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|



  Scenario Outline: AMBER - Create a New Complaint for Social Media for MP
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
    And I click the button "NewComplaint" 
    Then I populate AMBER complaint with '<Type>' and '<Priority>' and '<Reference>' and '<AssignedBy>' and '<Team>' and '<OpenedDate>' and '<Summary>' and '<Upheld>' and '<Outcome>' and '<Option1>' and '<Option2>' and '<Status>' and '<MICategory>' and '<MIOption>'
    And I click the button "SaveComplaint"
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName		|Type			|Priority	|Reference		|AssignedBy	|Team	|OpenedDate	|Summary																	|Upheld	|Outcome|Option1|Option2|Status	|MICategory	|MIOption	|
	|TESTA		|Password1	|test			|SocialMedia	|1 			|CMP11597789	|XXMEN		|56		|05/09/2017	|Customer not happy and may be able to refer the complaint to the manager	|yes	|5		|1		|2		|1		|2			|2			|
	