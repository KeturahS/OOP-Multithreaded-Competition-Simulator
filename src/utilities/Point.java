package utilities;

public class Point {
    private double x;
    private double y;

    private final double x_min= 0;
    private final double x_max= 1000000000;
    private final double y_min= 0;
    private final double y_max= 2000;



    public Point()
    {
        this.x=0;
        this.y=0;
    }

    public Point(double X,double Y)
    {
        //צריך לבדוק שזרקנו חריגות לפי הההנחיות
        if(X>=x_min && X<=x_max)
            this.x=X;
        else
            throw new IllegalArgumentException(" X Value cannot be less than 0 or more than 1000000");


        if(Y>=y_min && Y<=y_max)
            this.y=Y;
        else
            throw new IllegalArgumentException(Y+" Y Value cannot be less than 0 or more than 900");

    }


    public Point(Point other)
    {
        this.x=other.x;
        this.y=other.y;

    }


    public double getX() {
        return x;
    }


    public double getY() {
        return y;
    }

    public void set_x(double x)
    {
        if(x>=x_min && x<=x_max)
            this.x=x;
        else
            throw new IllegalArgumentException("Value cannot be less than 0 or more than 1000000");

    }





   public void set_y(double y)
    {
        if(y>=y_min && y<=y_max)
            this.y=y;
        else
            throw new IllegalArgumentException("Value cannot be less than 0 or more than 900");

    }


    public String toString() {
        return "Point{x=" + x + ", y=" + y + "}";
    }


    @Override
    public boolean equals(Object other) {
        boolean ans = false;
        if(other instanceof Point)
        {
            ans =( this.x==((Point)other).x && this.y==((Point)other).y);

        }
        return ans;

    }



}
