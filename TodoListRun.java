package Z_GFG.ToDoAgain;


import java.util.*;

public class TodoListRun {

    static Scanner in = new Scanner(System.in);
    static ArrayList<String> listNames = new ArrayList<>();
    static ArrayList<String> listOne = new ArrayList<>();
    static ArrayList<ArrayList<String>> listTasks = new ArrayList<>();
    static ArrayList<String> currentList;
    static int index;

    static class ToDoChoice {

        static void ToDoChoice() {
            System.out.println("ToDoList" + '\n' + "Choice :");
            System.out.println("1. Create ToDo List");
            System.out.println("2. Use ToDo List");
            System.out.println("3. Remove ToDo List");
            System.out.println("4. Quit");
            System.out.println("Enter the choice number : ");
        }
    }

    static class CreateToDoList {
        public void CreateToDoList() {

            while (true) {

                Scanner in = new Scanner(System.in);
                ArrayList<String> listOne = new ArrayList<>();
                System.out.println("Enter List Name to be added :");
                System.out.println("(Enter 'quit' to stop)");

                String name = in.nextLine();
                if (name.equals("quit")) {
                    break;
                }
                listNames.add(name);

                System.out.println("Enter task to be added :");
                System.out.println("(Enter 'quit' to stop.)");
                while (true) {
                    String a = in.next();
                    if (a.equals("quit")) {
                        break;
                    }
                    listOne.add(a);
                }
                listTasks.add(listOne);
                System.out.println("List tasks :" + listTasks);
                currentList = listOne;
            }
        }

            public void repeated(){

                    listOfToDo();
                    while (true) {

                        choice();
                        int no = in.nextInt();

                        if (no == 4) {
                            break;
                        }

                        switch (no) {
                            case 1:
                                addTask();
                                System.out.println(currentList);
                                break;

                            case 2:
                                removeTask();
                                break;

                            case 3:
                                mark();
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Invalid input. Try again!");
                        }
                    }
                }
            }

    static class UseToDoList extends CreateToDoList {

        public void useToDo() {

            if (listNames.isEmpty()) {
                System.out.println("No list exits");
                return;
            }
            repeated();
        }
    }

    static class RemoveToDoList {

        static void remove() {
            if (listNames.isEmpty()) {
                System.out.println("No list exits");
                return;
            }
            listOfToDo();
            listNames.remove(index);
            listTasks.remove(index);
            System.out.println("Remaining lists :" +listNames);
            System.out.println(listTasks);
        }
    }

    static void listOfToDo() {
        Scanner n = new Scanner(System.in);
        System.out.println("List Names :" + listNames);
        System.out.println("Enter List Name to work on: ");
        System.out.println("Enter 'quit' to stop");
        String lName = n.nextLine();
        if (lName.equals("quit")){
            return;
        }
        int index = listNames.indexOf(lName);
        currentList = listTasks.get(index);
        System.out.println(currentList);
    }

    static void mark() {
        System.out.println("Enter task number to be marked completed \u2705 : ");
        int m = in.nextInt();
        String n = currentList.get(m-1);
        currentList.set(m-1, n + "\u2705");
        System.out.println(currentList);
    }

    static void removeTask() {
        System.out.println("Enter task number to be removed : ");
        int t = in.nextInt();
        currentList.remove(currentList.get(t - 1));
        System.out.println(currentList);
    }

    static void addTask() {
        System.out.println("Enter task :");
        System.out.println("(Enter 'quit' to stop.)");
        while (true) {
            String p = in.next();
            if (p.equals("quit")) {
                break;
            }
            currentList.add(p);
        }
    }

    static void choice() {
        System.out.println("Choice :" + '\n' + "1. Add task" + '\n' +"2. Remove task"
                + '\n' + "3. Mark as completed"  + '\n' + "4. quit"+ '\n' +
                "Enter choice number :");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ToDoChoice menu = new ToDoChoice();
        while (true) {
            menu.ToDoChoice();
            int n = in.nextInt();
            if (n == 4) {
                System.out.println("ToDo List closed...");
                break;
            }
            switch (n) {

                case 1:
                    CreateToDoList create = new CreateToDoList();
                    create.CreateToDoList();
                    create.repeated();
                    break;

                case 2:
                    UseToDoList use = new UseToDoList();
                    use.useToDo();
                    break;

                case 3:
                    RemoveToDoList r = new RemoveToDoList();
                    r.remove();

                default:
                    System.out.println("Invalid input. Try again!");
            }
        }
    }
}
