Feature: Login Application



Scenario Outline: Positive test Validating login
Given Initialize the browser with chrome
And Navigate to "http://qaclickacademy.com" site
And Click on login link in home page to land on Secure sign in page
When User enters <username> and <password> and logs in
And close browser


Examples:

|username				|password	|
|mikekulio@gmail.com	|Verite#2	|
|test99@gmail.com		|45678		|
