package problem7CustomList;

class CommandInterpreter {

    private CustomList customList;

    CommandInterpreter(CustomList customList) {
        this.setCustomList(customList);
    }

    private CustomList getCustomList() {
        return this.customList;
    }

    private void setCustomList(CustomList customList) {
        this.customList = customList;
    }

    void interpretCommand(String command) {
        String[] commandParams = command.split("\\s+");
        switch (commandParams[0]) {
            case "Add":
                getCustomList().add((String) commandParams[1]);
                break;
            case "Remove":
                getCustomList().remove(Integer.parseInt(commandParams[1]));
                break;
            case "Contains":
                System.out.println(getCustomList().contains((String) commandParams[1]));
                break;
            case "Swap":
                getCustomList().swap(Integer.parseInt(commandParams[1]), Integer.parseInt(commandParams[2]));
                break;

            case "Greater":

                System.out.println(getCustomList().countGreaterThan((String) commandParams[1]));
                break;
            case "Max":
                System.out.println(getCustomList().getMax());
                break;
            case "Min":
                System.out.println(getCustomList().getMin());
                break;
            case "Print":
                //getCustomList().getList().stream().forEach(System.out::println);
                break;
            default:
                break;
        }
    }
}
