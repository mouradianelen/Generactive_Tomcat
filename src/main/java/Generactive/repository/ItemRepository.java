package Generactive.repository;

import Generactive.model.Group;
import Generactive.model.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemRepository {
    private static ItemRepository sInstance;

    private final List<Item> items = new ArrayList<>();

    public static ItemRepository getInstance() {
        if (sInstance == null) {
            sInstance = new ItemRepository();
        }

        return sInstance;
    }

    public Item addItem(Item item) {
        this.items.add(item);
        return item;
    }

    public void deleteItemById(int id) {
        items.remove(findItemById(id));
    }

    public void clear() {
        items.clear();
    }

    public void addItemAll(List<Item> items) {
        this.items.addAll(items);
    }

    public Item findItemById(int groupId) {

        for (Item item : items) {
            if (item.getId() == groupId) {
                return item;
            }
        }
        return null;
    }

    public Item existsById(int id) {
        for (Item item : items) {
            if (item.getId() == id)
                if (item != null)
                    return item;
        }
        return null;
    }

    public List<Group> getGroups() {
        List<Group> parents = new ArrayList<>();

        for (Item item : items) {
            if (item.getGroup() == null) {
                parents.add(item.getGroup());
            }
        }

        return parents;
    }

    private ItemRepository() {

    }

    public int getSize() {
        return this.items.size();
    }
}
