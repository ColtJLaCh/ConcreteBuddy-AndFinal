package coltonlachance.com.concretecalculator;

/**Listings
 * A pojo for a concrete listing
 * @author Colton LaChance
 */
public class Listings {
    private String name;
    private String definition;
    private String price;

    public Listings(String name, String definition, String price) {
        this.name = name;
        this.definition = definition;
        this.price = price;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
