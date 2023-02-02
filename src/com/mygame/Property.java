
public class Property {
    private String name;
    private int price;
    private Player owner;
    private int region;
    private int rent;
    private int id;

    public Property(String string, int i, int reg)
    {
        this.name = string;
        this.region = reg;
        this.price = i;
    }

    public Property(int id, String string, int i, int reg)
    {
        this.name = string;
        this.region = reg;
        this.price = i;
        this.id = id;
    }

    public int getRegion() {
        return region;
    }

    public void setRegion(int region) {
        this.region = region;
    }

    public int getPrice() {
        return price;
    }

    public void setOwner(Player player)
    {
        this.owner = player;
    }

    public Player getOwner() {
        return owner;
    }


    public String getName() {
        return name;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    
}
