package Lab08;

public class Prostokat implements Figura
{
    String nazwa;
    Punkt punkt;
    double bokA;
    double bokB;

    Prostokat(String nazwa, double bokA, double bokB, double x, double y)
    {
        this.bokA=bokA;
        this.bokB=bokB;
        this.nazwa=nazwa;
        this.punkt=new Punkt(x,y);
    }

    public double pole()
    {
        return (bokA*bokB);
    }

    public double obwod()
    {
        return ((2 * bokA)+(2*bokB));
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

            if(ele.getClass().toString().equals("class Lab08.Kwadrat") || ele.getClass().toString().equals("class Lab08.Kolo"))
            {
                return -1;
            }
            else
            {
                if(ele.getClass().toString().equals("class Lab08.Prostokat"))
                {
                    Prostokat pom = (Prostokat) ele;

                    if (nazwa.equals(pom.nazwa) &&
                            bokA == pom.bokA &&
                            bokB == pom.bokB &&
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
        String napis = "Rodzaj Figury: Prostokat \n"+
                "Nazwa: "+nazwa+"\n" + "Pole: "+ pole() +"\n"+ "Obwod: "+ obwod() +"\n";

        return napis;
    }

    public boolean przecieciefigur(Prostokat e)
    {
        if(((this.punkt.X+ bokA <= e.punkt.X) && (e.punkt.X <= this.punkt.X) ||
                (this.punkt.X+this.bokA <= e.punkt.X+e.bokA) && (e.punkt.X+e.bokA <= this.punkt.X)) &&
                ((this.punkt.Y+this.bokB <= e.punkt.Y) && (e.punkt.Y <= this.punkt.Y) ||
                        (this.punkt.Y + this.bokB <= e.punkt.Y + e.bokB) && (e.punkt.Y +e.bokB <= this.punkt.Y)))
            return true;

        return false;
    }

    public boolean przecieciefigur(Kwadrat e)
    {
        if(((this.punkt.X+this.bokA <= e.punkt.X) && (e.punkt.X <= this.punkt.X) ||
                (this.punkt.X+this.bokA <= e.punkt.X+e.bok) && (e.punkt.X+e.bok <= this.punkt.X)) &&
                ((this.punkt.Y+this.bokB <= e.punkt.Y) && (e.punkt.Y <= this.punkt.Y) ||
                        (this.punkt.Y + this.bokB <= e.punkt.Y + e.bok) && (e.punkt.Y +e.bok <= this.punkt.Y)))
            return true;

        return false;
    }

    public boolean przecieciefigur(Kolo e)
    {
        for (double i = this.punkt.X;i < this.punkt.X+this.bokA;i = i + 0.1)
        {
            if((i-e.punkt.X)*(i-e.punkt.X) + (e.punkt.Y-e.punkt.Y)*(e.punkt.Y-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bokA-e.punkt.X)*(this.punkt.X+this.bokA-e.punkt.X) + (this.punkt.Y-e.punkt.Y)*(this.punkt.Y-e.punkt.Y) <= e.promien*e.promien)
            return true;


        for (double i = this.punkt.X;i < this.punkt.X+this.bokA;i = i + 0.1)
        {
            if((i-e.punkt.X)*(i-e.punkt.X) + (this.punkt.Y+this.bokB-e.punkt.Y)*(this.punkt.Y+this.bokB-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bokA-e.punkt.X)*(this.punkt.X+this.bokA-e.punkt.X) + (this.punkt.Y+this.bokB-e.punkt.Y)*(this.punkt.Y+this.bokB-e.punkt.Y) <= e.promien*e.promien)
            return true;



        for (double i = this.punkt.Y;i < this.punkt.Y+this.bokB;i = i + 0.1)
        {
            if((this.punkt.X-e.punkt.X)*(this.punkt.X-e.punkt.X) + (i-e.punkt.Y)*(i-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X-e.punkt.X)*(this.punkt.X-e.punkt.X) + (this.punkt.Y+this.bokB-e.punkt.Y)*(this.punkt.Y+this.bokB-e.punkt.Y) <= e.promien*e.promien)
            return true;


        for (double i = this.punkt.Y;i < this.punkt.Y+this.bokB;i = i + 0.1)
        {
            if((this.punkt.X+this.bokA-e.punkt.X)*(this.punkt.X+this.bokA-e.punkt.X) + (i-e.punkt.Y)*(i-e.punkt.Y) <= e.promien*e.promien)
                return true;
        }

        if((this.punkt.X+this.bokA-e.punkt.X)*(this.punkt.X+this.bokA-e.punkt.X) + (this.punkt.Y+this.bokB-e.punkt.Y)*(this.punkt.Y+this.bokB-e.punkt.Y) <= e.promien*e.promien)
            return true;

        return false;
    }
}
