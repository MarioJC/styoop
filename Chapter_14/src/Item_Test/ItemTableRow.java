/**
 *
 * @author  Tony Sintes STYOOP
 * @version 1.0
 */
public class ItemTableRow implements ItemDisplayFormatter {

    private int    quantity;
    private int    id;
    private float  unitPrice;
    private float  discount;
    private String description;
    private float  adjPrice;
    
    public void quantity( int quantity ) {
        this.quantity = quantity;
    }
    
    public void id( int id ) {
        this.id = id;
    }
    
    public void unitPrice( float unitPrice ) {
        this.unitPrice = unitPrice;
    }
    
    public void discount( float discount ) {
        this.discount = discount;
    }
    
    public void description( String description ) {
        this.description = description;
    }
    
    public void adjustedPrice( float total ) {
        this.adjPrice = total;
    }
    
    public String format() {
        String row = "<tr>";
        row = row + "<td>" + id          + "</td>";
        row = row + "<td>" + quantity    + "</td>";
        row = row + "<td>" + description + "</td>";
        row = row + "<td>" + unitPrice   + "</td>";
        row = row + "<td>" + adjPrice    + "</td>";
        row = row + "</tr>";
        return row;
    }
}