Feature: Different Elements Page testing

  Scenario: Different Elements Page testing
    Given I open the JDI-testing home page
    Then URL should be 'https://jdi-testing.github.io/jdi-light/index.html' on the JDI-testing home page
    And Browser title should be equals "Home Page"
    When I perform login as 'Roman' with password 'Jdi1234' on the JDI-testing home page
    Then I should be loggined as 'ROMAN IOVLEV' on the JDI-testing home page
    When I click to Service button on the header on the JDI-testing home page
    And I click to Different Elements button in dropdown on the JDI-testing home page
    Then URL should be 'https://jdi-testing.github.io/jdi-light/different-elements.html' on the Different Elements Page
    When I choose checkboxes 'Water' and 'Wind' on the Different Elements Page
    And I choose radio 'Selen' on the Different Elements Page
    And I choose dropdown 'Yellow' on the Different Elements Page
    Then Logs should be correct for chosen values on the Different Elements Page
    And Chosen values should be as same as expected on the Different Elements Page



#Feature: Different Elements Page testing
#
#  Scenario: Open JDI-testing home page
#    Given I open the JDI-testing home page
#    Then URL should be 'https://jdi-testing.github.io/jdi-light/index.html' on the JDI-testing home page
#    And Browser title should be equals "Home Page"
#
#  Scenario: Perform login
#    Given I am on the JDI-testing home page
#    When I perform login as 'Roman' with password 'Jdi1234' on the JDI-testing home page
#    Then I should be loggined as 'ROMAN IOVLEV' on the JDI-testing home page
#
#  Scenario: Open Different Elements page
#    Given I am on the JDI-testing home page
#    When I click to Service button on the header on the JDI-testing home page
#    And I click to Different Elements button in dropdown on the JDI-testing home page
#    Then URL should be 'https://jdi-testing.github.io/jdi-light/different-elements.html' on the Different Elements Page
#
#  Scenario: Select values on the Different Elements Page
#    Given I am on the Different Elements Page
#    When I choose checkboxes 'Water' and 'Wind' on the Different Elements Page
#    And I choose radio 'Selen' on the Different Elements Page
#    And I choose dropdown 'Yellow' on the Different Elements Page
#    Then Logs should be correct for chosen values on the Different Elements Page
#    And Chosen values should be as same as expected on the Different Elements Page