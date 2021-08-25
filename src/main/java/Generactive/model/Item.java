package Generactive.model;

public abstract class Item {

    private int ID;
    private int basePrice;
    private String name;
    private String imageUrl;
    private Group group;

    public Item(int id, int basePrice, String name) {
        this.ID = id;
        this.basePrice = basePrice;
        this.name = name;
    }

    public int getId() {
        return ID;
    }

    public void setId(int id) {
        this.ID = id;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public abstract int calculatePrice(Configuration configuration);

    public void print() {
        System.out.printf("ITEM(%s) - id: {%d} {%s} {%d}%n",
                this.getClass().getSimpleName(), ID, name, basePrice);
    }

}
