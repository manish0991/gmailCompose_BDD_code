Feature: Login and compose Feature


Scenario Outline: Send email with an attachtment 

Given user is already on Login Page
When user enters "<username>" and "<password>"
And user clicks on next button
And user click on compose button 
Then user Attached file and enter email in To filed 
And  user clicks on send button 
And Close the browser


Examples:
	| username | password |
	| testautomation1327@gmail.com  | automation1327 |
 