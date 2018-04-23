package Lab08;

public interface Figura extends Comparable<Figura>
{
    double pole();
    double obwod();

    boolean przecieciefigur(Kwadrat e);
    boolean przecieciefigur(Prostokat e);
    boolean przecieciefigur(Kolo e);

}
