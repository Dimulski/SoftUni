package Problem9CollectionHierarchy.models;

import Problem9CollectionHierarchy.contracts.Used;

import java.util.ArrayList;
import java.util.List;

public class MyList extends AddRemoveCollection implements Used {

    private List<String> list;

    public MyList() {
        this.setList(new ArrayList<String>());
    }

    private void setList(List<String> list) {
        this.list = list;
    }

    private List<String> getList() {
        return list;
    }

    public int add(String item) {
        getList().add(0, item);
        return 0;
    }

    @Override
    public String remove() {
        String item = getList().get(0);
        getList().remove(0);
        return item;
    }

    @Override
    public int getSize() {
        return getList().size();
    }
}
