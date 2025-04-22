# 🧳 Wishlist Feature Test - Egipt El Gouna Trip

## 📋 Description (Opis scenariusza)

This test scenario automates the process of adding a travel product to a wishlist on the FakeStore website using Selenium WebDriver and Cucumber.  
(It verifies the "Add to Wishlist" feature for a trip product and ensures proper UI feedback.)

Ten scenariusz automatycznie testuje dodanie wycieczki do listy życzeń w sklepie internetowym FakeStore.  
Sprawdza, czy użytkownik może dodać wycieczkę do wishlisty, zobaczyć potwierdzenie i czy produkt rzeczywiście się tam pojawia.

---

## 🎯 Scenario Steps

```gherkin
Feature: Adding a trip to the wishlist
  # Funkcja: Dodawanie wycieczki do listy życzeń

  Scenario: User adds a windsurfing trip to the wishlist and checks if it was added
    # Scenariusz: Użytkownik dodaje wycieczkę windsurfingową do listy życzeń i sprawdza, czy została dodana

    Given the user opens the homepage
    # (Użytkownik otwiera stronę główną)

    When the user clicks on the "Windsurfing" category
    # (Użytkownik klika w kategorię "Windsurfing")

    And the user searches for the trip "Egipt - El Gouna"
    # (Użytkownik wyszukuje wycieczkę "Egipt - El Gouna")

    And the user adds the trip to the wishlist
    # (Użytkownik dodaje wycieczkę do listy życzeń)

    And the user sees a confirmation message that the trip was added to the wishlist
    # (Użytkownik widzi komunikat potwierdzający dodanie wycieczki do listy życzeń)

    And the user navigates to the wishlist
    # (Użytkownik przechodzi do listy życzeń)

    Then the trip "Egipt - El Gouna" should be in the wishlist
    # (Wycieczka powinna znajdować się na liście życzeń)

    And the user verifies that the "Remove from Wishlist" button is visible for the trip
    # (Użytkownik sprawdza, czy przycisk "Usuń z listy życzeń" jest widoczny)

    And the user closes the browser
    # (Użytkownik zamyka przeglądarkę)
