
public class Player {
    private String name;
    private int money;
    private int position;
    private boolean jailed = false;

    public boolean is_jail()
    {
        return jailed;
    }

    public void set_jail(boolean jailed)
    {
        this.jailed = jailed;
    }

    Player(String name, int money) {
        this.name = name;
        this.money = money;
    }
    
    Player(String name) {
        this.name = name;
        this.money = 0;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setmoney(int money)
    {
        this.money = money;
    }

    public String getName()
    {
        return name;
    }
    public int getMoney()
    {
        return money;
    }

    public void setMoney(int i) {
        this.money = i;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int newPosition)
    {
        this.position = newPosition;
    }


}
