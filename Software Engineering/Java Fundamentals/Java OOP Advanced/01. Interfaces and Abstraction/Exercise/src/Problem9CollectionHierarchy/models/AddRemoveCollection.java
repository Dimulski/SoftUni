package Problem9CollectionHierarchy.models;

import Problem9CollectionHierarchy.contracts.Removable;

import java.util.ArrayList;
import java.util.List;

public class AddRemoveCollection extends AddCollection implements Removable {

    private List<String> list;

    public AddRemoveCollection() {
        this.setList(new ArrayList<>());
    }

    private void setList(List<String> list) {
        this.list = list;
    }

    private List<String> getList() {
        return this.list;
    }

    @Override
    public int add(String item) {
        getList().add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        int index = getList().size() - 1;
        String item = getList().get(index);
        getList().remove(index);
        return item;
    }
}
