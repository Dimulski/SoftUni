package problem8CustomListSorter;

class CommandInterpreter {

    private CustomList customList;
    private Sorter sorter;

    CommandInterpreter(CustomList customList, Sorter sorter) {
        this.setCustomList(customList);
        this.setSorter(sorter);
    }

    private CustomList getCustomList() {
        return this.customList;
    }

    private Sorter getSorter() {
        return this.sorter;
    }

    private void setCustomList(CustomList customList) {
        this.customList = customList;
    }

    private void setSorter(Sorter sorter) {
        this.sorter = sorter;
    }

    @SuppressWarnings("unchecked")
    void interpretCommand(String command) {
        String[] commandParams = command.split("\\s+");

        switch (commandParams[0]) {
            case "Add":
                getCustomList().add(commandParams[1]);
                break;
            case "Remove":
                getCustomList().remove(Integer.parseInt(commandParams[1]));
                break;
            case "Contains":
                System.out.println(getCustomList().contains(commandParams[1]));
                break;
            case "Swap":
                getCustomList().swap(Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
                break;
            case "Greater":
                System.out.println(getCustomList().countGreaterThan(commandParams[1]));
                break;
            case "Max":
                System.out.println(getCustomList().getMax());
                break;
            case "Min":
                System.out.println(getCustomList().getMin());
                break;
            case "Print":
                getCustomList().getList().stream().forEach(System.out::println);
                break;
            case "Sort":
                getSorter().sort(getCustomList());
            default:
                break;
        }
    }
}
