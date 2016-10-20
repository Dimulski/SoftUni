package Problem9CollectionHierarchy.models;

import Problem9CollectionHierarchy.contracts.Addable;

import java.util.ArrayList;
import java.util.List;

public class AddCollection implements Addable {

    private List<String> list;

    public AddCollection() {
        this.setList(new ArrayList<String>());
    }

    private void setList(List list) {
        this.list = list;
    }

    private List getList() {
        return this.list;
    }

    @Override
    public int add(String item) {
        int index = this.list.size();
        this.list.add(item);
        return index;
    }
}
