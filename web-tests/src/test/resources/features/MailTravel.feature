Feature: MailTravel booking test

  @web @test0
  Scenario Outline: Able to verify the payment amount for the selected accomodations 
    Given I am on Mailtravel.co.uk home page and verify <title> as the title
    When I search for the text <searchString> in the Search Box and I click more info on the <link>
    And I make sure that it is displaying <days> days, price as <price> and phone number as <phone>
    And I select the departure date as click on Book Online link
    And I select the Double Room for 2 adults and continue
    And I fill the passenger details and continue
    Then I verify payment amount is as per the accommodation selected for 2 adults	
Examples:	
	| title 								 | searchString	|link 												 	 | days| price  | phone				|amount|
	| Mail Travel Home Page |	India					|11 Days - Classic Escorted Tours| 11 	 | £1,849 |08082396459 |£4,198|
		
