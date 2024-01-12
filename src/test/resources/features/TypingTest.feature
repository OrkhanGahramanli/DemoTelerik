Feature: TypingTest

  Scenario: Verify Typing Test with correct input
    Given User is in Typing-test page
    When User clicks on Typing Test mode
    And User fills text input line
    Then Each word should change to green color

  Scenario: Verify Typing Test with incorrect input
    Given User is in Typing-test page
    When User clicks on Typing Test mode
    And User fills incorrect text in input line
    Then Each word should change to red color

    @Highlight
  Scenario: Verify highlighting next word in text
    Given User is in Typing-test page
    When User clicks on Typing Test mode
    Then Next word in text should be highlighted

      @Highlight-Wrong
  Scenario: Verify highlighting wrong input text
    Given User is in Typing-test page
    When User clicks on Typing Test mode
    When User fills wrong keys in text input
    Then Current word highlighting red color
