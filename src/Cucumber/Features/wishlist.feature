Feature: Adding a trip to the wishlist
  # Funkcja: Dodawanie wycieczki do listy życzeń

  Scenario: User adds a windsurfing trip to the wishlist and checks if it was added
    # Scenariusz: Użytkownik dodaje wycieczkę windsurfingową do listy życzeń i sprawdza, czy została dodana

    Given the user opens the homepage
    # Założenie: Użytkownik otwiera stronę główną

    When the user clicks on the "Windsurfing" category
    # Kiedy: Użytkownik klika w kategorię "Windsurfing"

    And the user searches for the trip "Egipt - El Gouna"
    # I: Użytkownik wyszukuje wycieczkę "Egipt - El Gouna"

    And the user adds the trip to the wishlist
    # I: Użytkownik dodaje wycieczkę do listy życzeń

    And the user sees a confirmation message that the trip was added to the wishlist
    # I: Użytkownik widzi komunikat potwierdzający dodanie wycieczki do listy życzeń

    And the user navigates to the wishlist
    # I: Użytkownik przechodzi do listy życzeń

    Then the trip "Egipt - El Gouna" should be in the wishlist
    # Wtedy: Wycieczka "Egipt - El Gouna" powinna znajdować się na liście życzeń

    And the user verifies that the "Remove from Wishlist" button is visible for the trip
    # I: Użytkownik sprawdza, czy przycisk "Usuń z listy życzeń" jest widoczny przy tej wycieczce

    And the user closes the browser
    # I: Użytkownik zamyka przeglądarkę
