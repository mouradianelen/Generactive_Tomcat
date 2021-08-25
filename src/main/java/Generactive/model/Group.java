package Generactive.model;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private int ID;
    private String name;
    private Group parentGroup;
    private List<Group> subGroups = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public Group(int ID, String name){
        this.ID=ID;
        this.name=name;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setParentGroup(Group parentGroup) {
        this.parentGroup = parentGroup;
    }

    public Group getParentGroup() {
        return parentGroup;
    }

    public void addSubGroup(Group group){
        this.subGroups.add(group);
        group.setParentGroup(this);

    }
    public void addItem(Item item) {
        this.items.add(item);
        item.setGroup(this);
    }
    public void addItems(List<Item> items) {
        for (Item item : items) {
            addItem(item);
        }
    }
    public void print(int level){
        System.out.printf("GROUP - id: {%d} {%s}%n", ID, name);
        printSubGroups(++level);
        printItems(level);
    }
    private void printSubGroups(int level){
        String subLevelPrefix = "  ".repeat(level);
        for (Group group : subGroups) {
            System.out.print(subLevelPrefix);
            group.print(level);
        }
    }
    private void printItems(int level) {
        String subLevelPrefix = "  ".repeat(level);
        for (Item item : items) {
            System.out.print(subLevelPrefix);
            item.print();
        }
    }
}
