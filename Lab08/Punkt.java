package Lab08;

class Punkt
{
    double X;
    double Y;

    Punkt(double x, double y){
            this.X = x;
            this.Y = y;
        }

        String wypisz()
        {
            String tekst="("+X+","+Y+")";
            return tekst;
        }
}
