### INSTRUKCJA URUCHOMIENIA PROJEKTU

1. Z głównego poziomu projektu przechodzimy do FamilyApp i uruchamiamy komendę Maven:
   ``` mvn clean package ``` w celu zbudowania aplikacji FamilyApp
2. Z głównego poziomu projektu przechodzimy do FamilyMemberApp i uruchamiamy komendę Maven
   ``` mvn clean package ``` w celu zbudowania aplikacji FamilyMemberApp
3. Z głównego poziomu projektu Family uruchamiamy skrypt Docker
   ``` docker-compose up ``` w celu opublikowania obrazów i kontenerów w Doker
4. Uruchomienie poszczególnych kontenerów FamilyApp oraz FamilyMemberApp w Doker poprzez UI
5. Wykonanie zapytań z kolekcji Postman familyRequest.postman_collection.json