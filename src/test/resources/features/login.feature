Feature: Login Feature


  Scenario: wifi
    Given click on preference at Home Page
    And click on preferences dependencies at Preference Page
    When set wifi name "Armağan" at Preference Dependencies Page

  Scenario: longpress
    Given click on views at Home Page
    And click on expendable lists at Views Page
    And click on custom adapter at Expendable Lists Page
    When longpress on people names at Custom Adapter Page
    Then assert that title "Sample menu" is seen on long press at Custom Adapter Page
    Then assert that text "Sample action" is seen on long press at Custom Adapter Page


 #Scenario: scroll
 #  Given scroll

 #Scenario: swipe
 #  Given swipe

 #Scenario: browser
 #  Given browser