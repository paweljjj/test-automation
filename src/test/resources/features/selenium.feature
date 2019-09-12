Feature: Selenium tests with automationpractice.com

    Scenario Outline: New user registration
        Given Automation Practice page is opened
        When I click Sign in button
        Then I can see Authentication Page
        When I enter random email adress
        And I click Create an account button
        Then I can see Create an account page
        When I enter firstName: '<firstName>'
        And I enter lastName: '<lastName>'
        And I enter password: '<password>'
        And I enter firstNameAdress: '<firstNameAdress>'
        And I enter lastNameAdress: '<lastNameAdress>'
        And I enter adressLine1: '<adressLine1>'
        And I enter city: '<city>'
        And I select state: '<state>'
        And I enter zipPostalCode: '<zipPostalCode>'
        And I select country: '<country>'
        And I enter mobilePhone: '<mobilePhone>'
        And I enter adressAlias: '<adressAlias>'
        And I click Register button
        Then I can see My Account page

    Examples:
    | firstName | lastName | password    | firstNameAdress | lastNameAdress | adressLine1 | city     | state         | zipPostalCode | country       | mobilePhone  | adressAlias  |
    | Ricky     | LaFleur  | password123 | Ricky           | LaFleur        | 8th Avenue  | New York | New York      | 11612         | United States | +48123456789 | adressAlias1 |
