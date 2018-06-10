public class Vertices implements Comparable<Vertices> {
    private int x, y;

    public Vertices(int x, int y)
    { this.x = x;
        this.y = y;
    }

    public int getX()
    { return x; }

    public int getY()
    { return y; }

    public void setX(int el)
    { x = el; }

    public void setY(int el)
    { y = el; }

    public String toString()
    {  return "(" + x + ", " + y + ")";  }

    public int compareTo(Vertices ip)
    {
        if (x != ip.getX())
            return (x - ip.getX());
        else
            return (y - ip.getY());
    }

}