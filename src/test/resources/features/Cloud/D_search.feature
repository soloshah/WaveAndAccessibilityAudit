@search @regression @cipipeline
Feature: Search functionality


  Scenario Outline: Verify the Search page
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I click the link "Back" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|
	|TESTA		|Password1	|
	
	
  Scenario Outline: Search error message
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    And I click the button "Search"
    Then I will get error message as '<error_msg>' with '<error_msg_id>'
    Then I click the link "Back" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	| error_msg 								| error_msg_id	|
	|TESTA		|Password1	| Please enter at least one search term! 	| error-message	|
	

  Scenario Outline: Create a New Customer By different Name
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by name
    And I send address details
    And I send contact details  
    And I click the button "saveNewCustomer" 
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
	
	
  Scenario Outline: Create a New Customer By entering different Surname
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    And I click the button "Create New Customer" 
    And I send customer details by surname
    And I send address details
    And I send contact details  
   	And I click the button "saveNewCustomer" 
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
	
	
  Scenario Outline: Amend an Existing Customer for Customer Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Surname" by '<SearchSurname>'
    And I click the button "Search"
    Then I click the link "customerReference"
	Then I click the link "editCustomer"
    And I send updated customer details
    And I click the button "SaveCustomer"
    And I am redirected to "search" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchSurname 	|
	|TESTA		|Password1	|test			|
	

	
  Scenario Outline: Amend an Existing Customer for Contact Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
	Then I search for "Postcode" by '<SearchPostcode>'
	And I click the button "Search"
    Then I click the link "customerReference"
	Then I click the link "editCustomer"
    And I send updated contact details
    And I click the button "SaveCustomer"
    And I am redirected to "search" page
    Then I click the link "Dashboard"
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchPostcode	|
	|TESTA		|Password1	|DH				|
	
	

  Scenario Outline: Amend an Existing Customer for Address Details only
 	Given I open the login page
 	When I enter '<username>' and '<password>'
    And I click the button "login" 
    And I am redirected to "home" page
    Then I click the tab "search" 
    And I am redirected to "search" page
    Then I search for "Name" by '<SearchName>'
    And I click the button "Search"
    Then I click the link "customerReference"
	Then I click the link "editCustomer"
    And I send updated address details
    And I click the button "SaveCustomer"
    And I am redirected to "search" page
    Then I click the link "Dashboard" 
    And I am redirected to "home" page
    And I click the button "logout" 
    And I am redirected to "logout" page
 	
 	Examples:
	|username 	|password	|SearchName |
	|TESTA		|Password1	|test		|
