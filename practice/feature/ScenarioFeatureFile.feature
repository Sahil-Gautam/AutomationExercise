Feature: My Store application

Background: Successful login with valid credentials
 Given User is on Shopping website homepage
 When User sign in by submitting valid email and password
 Then User dashboard is displayed 
 
Scenario: Successful T-shirt Order placement and order history check
 Given User navigate to T-Shirt section
 And Add T-shirt in the cart 
 When User make payment for selected T-shirt
 And Navigate to order history page
 Then Placed order is visible in order history

Scenario: Update Personal Information (First Name) in My Account
 Given User navigate to Personal Information page in My Account section
 When User update First Name under Personal Information
 Then Successful message is displayed