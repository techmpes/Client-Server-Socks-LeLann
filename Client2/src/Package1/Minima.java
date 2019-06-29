package Package1;

import java.io.Serializable;

public class Minima implements Serializable{
    
    private String minima;
    
    public Minima(String minima)
    {
        this.minima=minima;
    }
    public String getMinima()
    {
        return minima;
    }
}