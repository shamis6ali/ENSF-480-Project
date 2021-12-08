package Model;
import java.util.*;
public class Search {
    private String type;
    private int bed;
    private int bath;
    private boolean furn;
    private String quad;
   // private Database accessDb;

    public Search(String type, int bed, int bath, boolean furn, String quad) {
        this.type = type;
        this.bed = bed;
        this.bath = bath;
        this.furn = furn;
        this.quad = quad;
    }

}
