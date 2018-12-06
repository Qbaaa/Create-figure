# Lab_8

Napisz program pozwalający na tworzenie figur w dwuwymiarowej przestrzeni kartezjańskiej. Pierwszą przygotowaną klasą będzie klasa Punkt. Punkt posiadać będzie dwa pola – double pozycjaX oraz double pozycjaY pozwalając na umiejscowienie punktu w przestrzeni kartezjańskiej. Przygotuj odpowiednie metody do manipulowania polami tej klasy. Przygotuj interfejs Figura, która posiadać będzie metody:
pole – obliczająca polę figury;
obwod – obliczająca obwód figury.
Kolejnym etapem będzie przygotowanie Abstrakcyjnej klasa FiguraForemna, będącej implementacją interfejsu Figura posiadać bedzię 3 pola – double bok, string nazwa oraz Punkt punkt.
Stwórz także zwykłą klasę Koło, która zaimplementuje interfejs figura oraz odpowiedni uzupełni metody obliczające pole oraz obwód, bok dla Koła będzie przechowywał promień Koła, przygotuj stałą PI o wartości 3.14159265359.
Przygotuj następnie klasę Kwadrat, która będzie dziedziczyć po klasie FiguraForemna, tak jak w przypadku koła uzupełnij odpowiednio metody obliczające pole oraz obwód.
Przygotuj klasę Prostokąt, która będzie implementować interfejs figura. Dodaj pola: Punkt punkt, double bokA, double bokB; oraz uzupełnij metody obliczające pole oraz obwód.
Przeciąż metodę toString w klasach, umieść w nim przynajmniej takie informacje jak: nazwa, obwód, pole, rodzaj figury (koło, kwadrat lub prostokąt).

Utwórz klasę Rysunek, w której będzie program główny pozwalający na tworzenie figur. Figury umieść w kontenerze TreeSet,jako typ przyjmij Figura – tak aby koło, prostokąt oraz kwadrat mogły znaleźć się na jednym kontenerze.
Przygotuj menu pozwalające na wprowadzanie figur ze standardowego wejścia (klawiatury).
Danymi wejściowymi dla koła jest: promień, wsp X oraz wsp Y punktu
Danymi wejściowymi dla kwadratu jest: bok, wsp X oraz wsp Y lewego dolnego punktu
Danymi wejściowymi dla prostokąta jest: bokA, bokB, wsp X oraz wsp Y lewego dolnego punktu.
Użytkownik może podać dowolną liczbę figur, w Menu pozostaw opcję na zakończenie wprowadzania danych.
Przygotuj przechwytywanie wyjątków
- jeśli użytkownik poda literę zamiast liczby dla danych wejściowych;
- jeśli użytkownik poda wartość ujemną dla boku lub promienia;
- jeśli użytkownik spróbuje podać już istniejący element;
program rzuci wyjątek i jako obsługa poinformuje o tym co zaszło nie tak (podano literę zamiast liczby, podano wartość ujemną dla boku lub promienia, podano istniejący element).
Przy użyciu Comparable lub Comparator posortuj figury rosnąco według wielkości Pola figury. Wypisz tak uporządkowaną listę za pomocą for each przy użyciu odpowiedniego iteratora.
Na koniec przygotuj program tak aby był w stanie przeliczyć które figury się ze sobą przecinają i wypisać je. Jeśli będzie kilka grup to każdą z nich wypisze oddzielnie. Aby wykonać tę część zadania odpowiednio zmodyfikuj wcześniejsze klasy tak, aby była możliwość weryfikacji takich zależności. Jak dokonać weryfikacji? np. Koło z kołem przecina się jak dwa punkty (ich środki) leżą bliżej niż suma ich promieni. Analogicznie można wykonać obliczenia dla pozostałych figur.
