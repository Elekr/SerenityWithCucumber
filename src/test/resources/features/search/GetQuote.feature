Feature: Getting a quote for a car using registration

  Scenario Outline: As a Customer, I need to enter my car details to get a quote

  #Looking up the car
    Given The user has accessed the website
    And user has accepted the cookies
    When the user enters "<testPlate>" as the registation number
    And click submit
    Then the website will show the users car "<carType>"
    And the users car "<carDesc>"

  #Accessing the modified car info
    Given The user wants to check if their car has been modified
    When the user clicks the more info button
    Then the more info text will be shown to the user

  #If the user does not know their car registration
    Given The user doesn't know their car registration
    When the user enters their car make
    And the user answers the quote questions
    And the user enters their car worth
    And the user enters their estimated mileage

    Examples:
      | testPlate | carType |                 carDesc                   |
      | GF21 WSN  | NIU NQI |   2021, 0CC, SCOOTER, AUTOMATIC, ELECTRIC |