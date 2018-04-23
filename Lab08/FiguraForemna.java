package Lab08;

public abstract class FiguraForemna implements Figura
{
    String nazwa;
    double bok;
    Punkt punkt;

    FiguraForemna(String nazwa,double bok,double x,double y)
    {
        this.nazwa=nazwa;
        this.bok=bok;
        this.punkt = new Punkt(x,y);
    }
}
