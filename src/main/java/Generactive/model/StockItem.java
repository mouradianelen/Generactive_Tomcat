package Generactive.model;

public class StockItem extends Item {

    public StockItem(int id, int basePrice, String name) {
        super(id, basePrice, name);
    }

    @Override
    public int calculatePrice(Configuration configuration) {
        return getBasePrice() * configuration.getResolution().getCoefficient();
    }

    @Override
    public boolean equals(Object obj) {
        final StockItem other = (StockItem) obj;
        if ((this.getName() == null) ? (other.getName() != null) :
                !this.getName().equals(other.getName())) {
            return false;
        }

        if (this.getBasePrice() != other.getBasePrice()) {
            return false;
        }
        if (this.getId() != other.getId()) {
            return false;
        }

        return true;
    }
}




