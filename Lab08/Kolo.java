package Lab08;

public class Kolo implements Figura
{
    final double PI = 3.14159265359;
    String nazwa;
    double promien;
    Punkt punkt;

    public Kolo(String nazwa,double promirn,double x,double y)
    {
        this.nazwa=nazwa;
        this.promien=promirn;
        this.punkt = new Punkt(x,y);
    }

   public double pole()
   {
        double pole = PI*promien*promien;

        return pole;
   }

   public double obwod()
   {
       double obwod = 2*PI*promien;

       return obwod;
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
            if(ele.getClass().toString().equals("class Lab08.Kwadrat") || ele.getClass().toString().equals("class Lab08.Prostokat"))
            {
                return -1;
            }
            else
            {
                if(ele.getClass().toString().equals("class Lab08.Kolo"))
                {
                    Kolo pom = (Kolo) ele;

                    if (nazwa.equals(pom.nazwa) &&
                            promien == pom.promien &&
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
        String napis = "Rodzaj Figury: Kolo \n" +
                "Nazwa: " + nazwa + "\n" + "Pole: " + pole() + "\n" + "Obwod: " + obwod() + "\n";

        return napis;
    }


    public boolean przecieciefigur(Kolo e)
    {
        double pom1 = (e.punkt.X-this.punkt.X)*(e.punkt.X-this.punkt.X);
        double pom2 = (e.punkt.Y-this.punkt.Y)*(e.punkt.Y-this.punkt.Y);
        double dlpromieni = Math.sqrt(pom1 + pom2);
        if(Math.abs(this.promien - e.promien) <= dlpromieni && dlpromieni <= (this.promien + e.promien))
        {
            return true;
        }
        return false;
    }

    public boolean przecieciefigur(Prostokat e)
    {
        for (double i = e.punkt.X;i < e.punkt.X+e.bokA;i = i + 0.1)
        {
            if((i-this.punkt.X)*(i-this.punkt.X) + (e.punkt.Y-this.punkt.Y)*(e.punkt.Y-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bokA-this.punkt.X)*(e.punkt.X+e.bokA-this.punkt.X) + (e.punkt.Y-this.punkt.Y)*(e.punkt.Y-this.punkt.Y) <= this.promien*this.promien)
            return true;


        for (double i = e.punkt.X;i < e.punkt.X+e.bokA;i = i + 0.1)
        {
            if((i-this.punkt.X)*(i-this.punkt.X) + (e.punkt.Y+e.bokB-this.punkt.Y)*(e.punkt.Y+e.bokB-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bokA-this.punkt.X)*(e.punkt.X+e.bokA-this.punkt.X) + (e.punkt.Y+e.bokB-this.punkt.Y)*(e.punkt.Y+e.bokB-this.punkt.Y) <= this.promien*this.promien)
            return true;



        for (double i = e.punkt.Y;i < e.punkt.Y+e.bokB;i = i + 0.1)
        {
            if((e.punkt.X-this.punkt.X)*(e.punkt.X-this.punkt.X) + (i-this.punkt.Y)*(i-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X-this.punkt.X)*(e.punkt.X-this.punkt.X) + (e.punkt.Y+e.bokB-this.punkt.Y)*(e.punkt.Y+e.bokB-this.punkt.Y) <= this.promien*this.promien)
            return true;


        for (double i = e.punkt.Y;i < e.punkt.Y+e.bokB;i = i + 0.1)
        {
            if((e.punkt.X+e.bokA-this.punkt.X)*(e.punkt.X+e.bokA-this.punkt.X) + (i-this.punkt.Y)*(i-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bokA-this.punkt.X)*(e.punkt.X+e.bokA-this.punkt.X) + (e.punkt.Y+e.bokB-this.punkt.Y)*(e.punkt.Y+e.bokB-this.punkt.Y) <= this.promien*this.promien)
            return true;

        return false;
    }

    public boolean przecieciefigur(Kwadrat e)
    {
        for (double i = e.punkt.X;i < e.punkt.X+e.bok;i = i + 0.1)
        {
            if((i-this.punkt.X)*(i-this.punkt.X) + (e.punkt.Y-this.punkt.Y)*(e.punkt.Y-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bok-this.punkt.X)*(e.punkt.X+e.bok-this.punkt.X) + (e.punkt.Y-this.punkt.Y)*(e.punkt.Y-this.punkt.Y) <= this.promien*this.promien)
            return true;


        for (double i = e.punkt.X;i < e.punkt.X+e.bok;i = i + 0.1)
        {
            if((i-this.punkt.X)*(i-this.punkt.X) + (e.punkt.Y+e.bok-this.punkt.Y)*(e.punkt.Y+e.bok-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bok-this.punkt.X)*(e.punkt.X+e.bok-this.punkt.X) + (e.punkt.Y+e.bok-this.punkt.Y)*(e.punkt.Y+e.bok-this.punkt.Y) <= this.promien*this.promien)
            return true;



        for (double i = e.punkt.Y;i < e.punkt.Y+e.bok;i = i + 0.1)
        {
            if((e.punkt.X-this.punkt.X)*(e.punkt.X-this.punkt.X) + (i-this.punkt.Y)*(i-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X-this.punkt.X)*(e.punkt.X-this.punkt.X) + (e.punkt.Y+e.bok-this.punkt.Y)*(e.punkt.Y+e.bok-this.punkt.Y) <= this.promien*this.promien)
            return true;


        for (double i = e.punkt.Y;i < e.punkt.Y+e.bok;i = i + 0.1)
        {
            if((e.punkt.X+e.bok-this.punkt.X)*(e.punkt.X+e.bok-this.punkt.X) + (i-this.punkt.Y)*(i-this.punkt.Y) <= this.promien*this.promien)
                return true;
        }

        if((e.punkt.X+e.bok-this.punkt.X)*(e.punkt.X+e.bok-this.punkt.X) + (e.punkt.Y+e.bok-this.punkt.Y)*(e.punkt.Y+e.bok-this.punkt.Y) <= this.promien*this.promien)
            return true;

        return false;
    }
}
