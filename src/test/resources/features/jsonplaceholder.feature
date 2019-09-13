Feature: Rest tests with jsonplaceholder

  Scenario: /posts GET request should return HTTP 200 OK
    When I send GET request
    Then Http response status is 200 OK
    And Last post has userId: 10

  Scenario: /posts?userId= GET request for selected userId should return HTTP 200 OK
    When I send GET request for userId=10
    Then Http response status is 200 OK
    And Last post for selected user has Id: 10

  Scenario Outline: /comments POST request for returned post Id
    Given I send GET request for userId=10
    When I send POST request for returned Id with name: '<name>' email: '<email>' body: '<body>'
    Then Http response status is 201 CREATED

    Examples:
      | name  | email            | body         |
      | Ricky | ricky@domain.com | Comment body |
