import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        List<Animal> listAnimal = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        while (true) {
            System.out.println("Введите команду add/list/exit:");
            String command = in.nextLine();

            String trim = command.toLowerCase().trim();
            if (trim.equals(Command.ADD.getCommand())) {
                System.out.println("Какое животное cat/dog/duck:");
                String typeAnimal = in.nextLine();
                Animal animal = createAnimal(typeAnimal, in);
                if (animal != null) {
                    animal.say();
                    listAnimal.add(animal);
                }
            } else if (trim.equals(Command.LIST.getCommand())) {
                for (int i = 0; i < listAnimal.size(); i++) {
                    listAnimal.get(i).say();
                    System.out.println(listAnimal.get(i).toString());

                }
            } else if (trim.equals(Command.EXIT.getCommand())) {
                System.out.println("Программа закрывается");
                break;
            }
        }
        in.close();
    }

    public static Animal createAnimal(String type, Scanner in) {
        String trim = type.toLowerCase().trim();
        System.out.println("Имя?");
        String nameAnimal = in.nextLine();
        System.out.println("Возраст?");
        String ageAnimal = in.nextLine();
        System.out.println("Вес?");
        String weightAnimal = in.nextLine();
        System.out.println("Цвет?");
        String colorAnimal = in.nextLine();
        if (trim.equals("cat")) {
            return new Cat(nameAnimal, Integer.parseInt(ageAnimal), Integer.parseInt(weightAnimal), colorAnimal);
        } else if (trim.equals("dog")) {
            return new Dog(nameAnimal, Integer.parseInt(ageAnimal), Integer.parseInt(weightAnimal), colorAnimal);
        } else if (trim.equals("duck")) {
            return new Duck(nameAnimal, Integer.parseInt(ageAnimal), Integer.parseInt(weightAnimal), colorAnimal);
        }

        return null;

    }

    enum Command {
        ADD("add"),
        LIST("list"),
        EXIT("exit");

        private final String com;

        Command(String com) {
            this.com = com;
        }

        public String getCommand() {
            return com;
        }
    }

}