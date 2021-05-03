import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Human> humans = new ArrayList<>();
    public static ArrayList<String> commands = new ArrayList<>();
    public static void main(String[] args)
    {
        init();
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Enter Command - ");
            String command = scanner.nextLine();
            checkCommand(command);
        }
    }

    public static void init()
    {
        commands.add("addHuman");
        commands.add("remove");
        commands.add("addJob");
        commands.add("showHumans");
        commands.add("checkHuman");
    }

    public static void getHelp()
    {
            System.out.println("COMMANDS |");
            for(int i = 0; i < commands.size();i++)
            {
                System.out.println(commands.get(i));
            }
            System.out.println();
    }

    public static void checkCommand(String command)
    {
        Scanner scanner = new Scanner(System.in);
        switch (command) {
            case "addHuman":
                System.out.println("ENTER HUMAN NAME");
                humans.add(new Human(scanner.nextLine()));
                System.out.println("ADDED HUMAN");
                break;
            case "help":
                System.out.println();
                getHelp();
                break;
            case "remove":
                try {
                    System.out.println("ENTER HUMAN NAME");
                    Human human = new Human(scanner.nextLine());
                    humans.remove(human);
                    System.out.println("REMOVED HUMAN");
                } catch (Exception e) {
                    System.out.println("HUMAN NOT FOUND IN SYSTEM");
                }
                break;
            case "showHumans":
                System.out.println();
                for(int i = 0; i < humans.size();i++)
                {
                    System.out.println(i + "." + humans.get(i).name);
                }
                System.out.println();
                break;
            case "addJob":
                System.out.println("ENTER HUMAN NUMBER");
                try {
                    int num = scanner.nextInt();
                    Human human = humans.get(num);
                    System.out.println("ENTER JOB NAME");
                    Scanner scanner1 = new Scanner(System.in);
                    String job = scanner1.nextLine();
                    human.addJob(job);
                }
                catch (Exception e)
                {
                    System.out.println("NO HUMAN WITH THAT NUMBER FOUND IN THE SYSTEM");
                }
                break;
            case "checkHuman":
                System.out.println("ENTER HUMAN NUMBER");
                int num = scanner.nextInt();
                Human human = humans.get(num);
                System.out.println();
                System.out.println(human.name + "'s JOBS |");
                for(int i = 0; i < human.getJobs().size();i++)
                {
                    System.out.println(human.getJobs().get(i));
                }
                System.out.println();
                break;
        }
    }


}
