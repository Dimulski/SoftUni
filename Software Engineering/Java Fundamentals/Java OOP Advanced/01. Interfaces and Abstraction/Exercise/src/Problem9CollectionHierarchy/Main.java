package Problem9CollectionHierarchy;

import Problem9CollectionHierarchy.models.AddCollection;
import Problem9CollectionHierarchy.models.AddRemoveCollection;
import Problem9CollectionHierarchy.models.MyList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyList myList = new MyList();

        StringBuilder result = new StringBuilder();
        StringBuilder addCollectionSb = new StringBuilder();
        StringBuilder addRemoveCollectionSb = new StringBuilder();
        StringBuilder myListSb = new StringBuilder();
        StringBuilder addRemoveCollectionRemoveSb = new StringBuilder();
        StringBuilder myListRemoveSb = new StringBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] stringsToAdd = reader.readLine().split("\\s+");
        for (String string : stringsToAdd) {
            addCollectionSb.append(String.format("%s ", addCollection.add(string)));
            addRemoveCollectionSb.append(String.format("%s ", addRemoveCollection.add(string)));
            myListSb.append(String.format("%s ", myList.add(string)));

        }

        int itemsToRemove = Integer.parseInt(reader.readLine());
        for (int i = 0; i < itemsToRemove; i++) {
            addRemoveCollectionRemoveSb.append(String.format("%s ", addRemoveCollection.remove()));
            myListRemoveSb.append(String.format("%s ", myList.remove()));
        }
        result.append(String.format("%s%s", addCollectionSb.toString(), System.lineSeparator()));
        result.append(String.format("%s%s", addRemoveCollectionSb.toString(), System.lineSeparator()));
        result.append(String.format("%s%s", myListSb.toString(), System.lineSeparator()));
        result.append(String.format("%s%s", addRemoveCollectionRemoveSb.toString(), System.lineSeparator()));
        result.append(String.format("%s%s", myListRemoveSb.toString(), System.lineSeparator()));

        System.out.println(result.toString());
    }
}
