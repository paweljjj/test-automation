Feature: Selenium tests with automationpractice

  Scenario Outline: New user registration
    Given Automation Practice page is opened
    When I click Sign in button on the Main Page
    Then I can see Authentication Page
    When I enter random email address in Create an account panel
    And I click Create an account button
    Then I can see Create an account page
    When I enter firstName: '<firstName>'
    And I enter lastName: '<lastName>'
    And I enter password: '<password>'
    And I enter firstNameAdress: '<firstNameAdress>'
    And I enter lastNameAdress: '<lastNameAdress>'
    And I enter addressLine1: '<adressLine1>'
    And I enter city: '<city>'
    And I select state: '<state>'
    And I enter zipPostalCode: '<zipPostalCode>'
    And I select country: '<country>'
    And I enter mobilePhone: '<mobilePhone>'
    And I enter addressAlias: '<adressAlias>'
    And I click Register button
    Then I can see My Account page

    Examples:
      | firstName | lastName | password    | firstNameAdress | lastNameAdress | adressLine1 | city     | state         | zipPostalCode | country       | mobilePhone  | adressAlias  |
      | Ricky     | LaFleur  | password123 | Ricky           | LaFleur        | 8th Avenue  | New York | New York      | 11612         | United States | +48123456789 | adressAlias1 |
      | Julian    | Tremblay | password456 | Mike            | Smith          | 12th Avenue | Boston   | Massachusetts | 02222         | United States | +48987654321 | adressAlias2 |

  Scenario Outline: New user authorization
    Given Automation Practice page is opened
    When I click Sign in button on the Main Page
    Then I can see Authentication Page
    When I enter email: '<email>' for an existing account
    And I enter password: '<password>' for an existing account
    And I click Sign in button on the Authentication Page
    Then I can see My Account page

    Examples:
      | email                 | password    |
      | KBWjAkFKrl@domain.com | password123 |
      | GhVeYDzHcn@domain.com | password456 |

  Scenario: Your shopping cart is empty information is visible on the Card when we do no not add anything to the Basket
    Given Automation Practice page is opened
    When I click Cart on the Main Page
    Then I can see Order Page
    And I can see error message Your shopping cart is empty
