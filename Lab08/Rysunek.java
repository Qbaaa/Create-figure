package Lab08;

import java.util.*;

public class Rysunek {
    public static void main(String[] args) {

        TreeSet<Figura> Lista = new TreeSet<Figura>();

        ArrayList<Kwadrat> lk = new ArrayList<Kwadrat>();
        ArrayList<Prostokat> lp = new ArrayList<Prostokat>();
        ArrayList<Kolo> lo = new ArrayList<Kolo>();
        boolean petla = true;

        while (petla) {
            int wybor = -1;
            boolean popDanych = true;

            while (popDanych) {
                System.out.println("Podaj liczbe, ktora oznacza figure chcesz dodac do Listy:");
                System.out.println("1 - Kwadrat");
                System.out.println("2 - Prostokat");
                System.out.println("3 - Kolo");
                System.out.println("4 - Koniec wprowadzenia danych");


                try {
                    wybor = poprawnoscwybor();
                } catch (Exception e) {
                    System.out.println("Blad " + e.toString());
                    wybor = -1;
                }

                if (wybor != -1) {
                    popDanych = false;
                }
            }

            String nazwa;
            double bokA = 0;
            double bokB = 0;
            double x = 0;
            double y = 0;

            Scanner odczyt = new Scanner(System.in);

            switch (wybor) {
                case 1:

                    System.out.print("\nPodaj nazwe dla Kwadratu:");
                    nazwa = odczyt.nextLine();
                    bokA = wyborboku(bokA, "bokA");
                    x = wyborboku(x, "x");
                    y = wyborboku(y, "y");

                    Figura A = new Kwadrat(nazwa, bokA, x, y);

                    if (lk.isEmpty()) {
                        lk.add((Kwadrat) A);
                        Lista.add(A);
                    } else {
                            try {

                                if(!Lista.add(A))
                                    throw new Exception("Istnieje juz ten element w Liscie.");
                            } catch (Exception e) {
                                System.out.println("Blad " + e.toString());
                            }
                    }
                    break;

                case 2:

                    System.out.print("\nPodaj nazwe dla Prostokata:");
                    nazwa = odczyt.nextLine();
                    bokA = wyborboku(bokA, "bokA");
                    bokB = wyborboku(bokB, "bokB");
                    x = wyborboku(x, "x");
                    y = wyborboku(y, "y");

                    Figura B = new Prostokat(nazwa, bokA, bokB, x, y);

                    if (lp.isEmpty()) {
                        lp.add((Prostokat) B);
                        Lista.add(B);
                    } else {
                            try
                            {

                               if(!Lista.add(B))
                                   throw new Exception("Istnieje juz ten element w Liscie.");
                            } catch (Exception e) {
                                System.out.println("Blad " + e.toString());
                            }
                    }
                    break;

                case 3:

                    System.out.print("\nPodaj nazwe dla Kola:");
                    nazwa = odczyt.nextLine();
                    bokA = wyborboku(bokA, "promien");
                    x = wyborboku(x, "x");
                    y = wyborboku(y, "y");

                    Figura C = new Kolo(nazwa, bokA, x, y);

                    if (lo.isEmpty()) {
                        lo.add((Kolo) C);
                        Lista.add(C);
                    } else {

                            try {

                              if(!Lista.add(C))
                                  throw new Exception("Istnieje juz ten element w Liscie.");
                            } catch (Exception e) {
                                System.out.println("Blad " + e.toString());
                            }
                    }
                    break;

                case 4:
                    petla = false;
                    break;

            }
        }

        System.out.println("\nZawartosc Listy: ");
        if (Lista.size() >= 1)
        {
            for (Figura it : Lista)
            {
                System.out.println(it);
            }

            System.out.println("\n\n");

            Figura A = new Kwadrat("t",2,2,2);
            Figura B = new Prostokat("t",2,2,2,2);
            Figura C = new Kolo("t",2,2,2);

            if (Lista.size() >= 2)
            {
                ArrayList<Figura> Lp = new ArrayList<Figura>(Lista);


                for (int i = 0; i < Lp.size(); i++)
                {
                    int licznosc = 0;
                    System.out.println("Z Figura");
                    System.out.println(Lp.get(i));
                    System.out.println("przecinaja sie:");
                    for (int j = i + 1; j < Lp.size(); j++)
                    {
                         if (Lp.get(j).getClass().toString().equals(A.getClass().toString()))
                         {
                             if(Lp.get(i).przecieciefigur((Kwadrat) Lp.get(j)))
                             {
                                 System.out.println(Lp.get(j));
                                 licznosc++;
                             }
                         }
                         else
                         {
                             if(Lp.get(j).getClass().toString().equals(B.getClass().toString()))
                             {
                                 if(Lp.get(i).przecieciefigur((Prostokat) Lp.get(j)))
                                 {
                                     System.out.println(Lp.get(j));
                                     licznosc++;
                                 }
                             }
                             else
                             {
                                 if(Lp.get(j).getClass().toString().equals(C.getClass().toString()))
                                 {
                                     if(Lp.get(i).przecieciefigur((Kolo) Lp.get(j)))
                                     {
                                         System.out.println(Lp.get(j));
                                         licznosc++;
                                     }
                                 }
                             }
                         }
                    }

                    if(licznosc == 0)
                    {
                        System.out.print("Brak takich figur.");
                    }

                    System.out.println("\n\n");
                }
            }
            else
                System.out.println("W liscie nie da sie wyznaczyc przecinajacych sie figur,\n" +
                        "poniewaz jest tylko jedna figura w liscie.");

        }
        else
            System.out.println("Lista Figur jest pusta.");

    }


    public static int poprawnoscwybor() throws Exception {
        Scanner odczyt = new Scanner(System.in);
        int wybor = -1;

            try
            {
                wybor = odczyt.nextInt();
            }
            catch (InputMismatchException n)
            {
                System.out.println("Niepoprawna dana!");
            }

            if (!(1 <= wybor && wybor <= 4)) throw new Exception("wybor musi byc z przedzialu <1,4>");

        return wybor;
    }


    public static double poprawnoscboku(double b, String pytanie)
    {
        Scanner odczyt = new Scanner(System.in);

        double bok = b;

        try
        {
            bok = odczyt.nextInt();
        }
        catch (InputMismatchException n)
        {
            System.out.println("Podano Niepoprawna dana!");
        }


        if (bok < 0 && (pytanie.equals("bokA") || pytanie.equals("bokB"))) throw new IllegalArgumentException("Dlugosc musi byc >=0.");

        return bok;
    }


    public static double wyborboku(double bok,String pytanie)
    {
        boolean petla = true;
        while(petla)
        {
            System.out.println("Podaj " + pytanie );

            try
            {
                bok = poprawnoscboku(bok,pytanie);
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Blad " + e.toString());
                bok=-1;
            }

            if(bok != -1)
            {
                petla=false;
            }
        }

        return bok;
    }



}
