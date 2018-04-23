package Lab08;

public class Kwadrat extends FiguraForemna
{
     public Kwadrat(String nazwa,double bok,double x,double y)
     {
         super( nazwa, bok, x, y);
     }

     public double pole()
     {
         return (bok*bok);
     }

     public double obwod()
     {
         return (4 * bok);
     }

    @Override
    public int compareTo(Figura ele)
    {
        if(this.pole() > ele.pole())
        {
            return 1;
        }
        else if(this.pole() == ele.pole())
        {
            if(ele.getClass().toString().equals("class Lab08.Kolo") || ele.getClass().toString().equals("class Lab08.Prostokat"))
            {
                return -1;
            }
            else
            {
                if(ele.getClass().toString().equals("class Lab08.Kwadrat"))
                {
                    Kwadrat pom = (Kwadrat) ele;

                    if (nazwa.equals(pom.nazwa) &&
                            bok == pom.bok &&
                            this.punkt.X == pom.punkt.X &&
                            this.punkt.Y == pom.punkt.Y)
                    {
                        return 0;
                    }
                    else
                    {
                        return 1;
                    }
                }
            }

            return 0;







        }
        else
        {
            return -1;
        }
    }


     @Override
     public String toString()
     {
         String napis = new String("Rodzaj Figury: Kwadrat \n"+
                 "Nazwa: "+nazwa+"\n" + "Pole: "+ pole() +"\n"+ "Obwod: "+ obwod() +"\n");

         return napis;
     }

    public boolean przecieciefigur(Kwadrat e)
    {
        if(((this.punkt.X+bok <= e.punkt.X) && (e.punkt.X <= this.punkt.X) ||
                (this.punkt.X+this.bok <= e.punkt.X+e.bok) && (e.punkt.X+e.bok <= this.punkt.X)) &&
                ((this.punkt.Y+bok <= e.punkt.Y) && (e.punkt.Y <= this.punkt.Y) ||
                (this.punkt.Y + this.bok <= e.punkt.Y + e.bok) && (e.punkt.Y +e.bok <= this.punkt.Y)))
            return true;

        return false;
    }

    public boolean przecieciefigur(Prostokat e)
    {
        if(((this.punkt.X+bok <= e.punkt.X) && (e.punkt.X <= this.punkt.X) ||
                (this.punkt.X+this.bok <= e.punkt.X+e.bokA) && (e.punkt.X+e.bokA <= this.punkt.X)) &&
                ((this.punkt.Y+bok <= e.punkt.Y) && (e.punkt.Y <= this.punkt.Y) ||
                        (this.punkt.Y + this.bok <= e.punkt.Y + e.bokB) && (e.punkt.Y +e.bokB <= this.punkt.Y)))
            return true;

        return false;
    }

    public boolean przecieciefigur(Kolo e)
    {
        for (double i = this.punkt.X;i < this.punkt.X+this.bok;i = i + 0.1)
        {
            if((i-e.punkt.X)*(i-e.punkt.X) + (e.punkt.Y-e.punkt.Y)*(e.punkt.Y-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bok-e.punkt.X)*(this.punkt.X+this.bok-e.punkt.X) + (this.punkt.Y-e.punkt.Y)*(this.punkt.Y-e.punkt.Y) <= e.promien*e.promien)
            return true;


        for (double i = this.punkt.X;i < this.punkt.X+this.bok;i = i + 0.1)
        {
            if((i-e.punkt.X)*(i-e.punkt.X) + (this.punkt.Y+this.bok-e.punkt.Y)*(this.punkt.Y+this.bok-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bok-e.punkt.X)*(this.punkt.X+this.bok-e.punkt.X) + (this.punkt.Y+this.bok-e.punkt.Y)*(this.punkt.Y+this.bok-e.punkt.Y) <= e.promien*e.promien)
            return true;



        for (double i = this.punkt.Y;i < this.punkt.Y+this.bok;i = i + 0.1)
        {
            if((this.punkt.X-e.punkt.X)*(this.punkt.X-e.punkt.X) + (i-e.punkt.Y)*(i-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X-e.punkt.X)*(this.punkt.X-e.punkt.X) + (this.punkt.Y+this.bok-e.punkt.Y)*(this.punkt.Y+this.bok-e.punkt.Y) <= e.promien*e.promien)
            return true;


        for (double i = this.punkt.Y;i < this.punkt.Y+this.bok;i = i + 0.1)
        {
            if((this.punkt.X+this.bok-e.punkt.X)*(this.punkt.X+this.bok-e.punkt.X) + (i-e.punkt.Y)*(i-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bok-e.punkt.X)*(this.punkt.X+this.bok-e.punkt.X) + (this.punkt.Y+this.bok-e.punkt.Y)*(this.punkt.Y+this.bok-e.punkt.Y) <= e.promien*e.promien)
            return true;

        return false;
    }

}
