package exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    private static DayPlanner dayPlanner;

    public static void main(String[] args) throws NoActivityForDayException {
        dayPlanner = new DayPlanner(List.of(new DaySchedule(Day.MONDAY, new ArrayList<>()),
                new DaySchedule(Day.TUESDAY, new ArrayList<>()),
                new DaySchedule(Day.WEDNESDAY, null),
                new DaySchedule(Day.THURSDAY, new ArrayList<>()),
                new DaySchedule(Day.FRIDAY, new ArrayList<>()),
                new DaySchedule(Day.SATURDAY, new ArrayList<>()),
                new DaySchedule(Day.SUNDAY, new ArrayList<>())
        ));

        menu();

    }

    public static void menu() throws NoActivityForDayException {
        printOptions();
        Scanner scanner = new Scanner(System.in);
        boolean b = true;
        int choice;
        while (b) {

            choice = scanner.nextInt();
            switch (choice) {

                case 1:
                    System.out.println("Please select a day and then add an activity for that day.");
                    dayPlanner.addActivity(Day.valueOf(scanner.next().toUpperCase()), scanner.next());
                    break;
                case 2:
                    System.out.println("Please select a day and then write the activity that you want to remove it.");
                    dayPlanner.removeActivity(Day.valueOf(scanner.next().toUpperCase()), scanner.next());
                    break;
                case 3:
                    System.out.println("Please select a day to see the list of all the  activities for that day");
                    System.out.println(dayPlanner.getActivities(Day.valueOf(scanner.next().toUpperCase())));
                    break;
                case 4:
                    System.out.println("Please select a day to see the map with all the activities for that day");
                    System.out.println(dayPlanner.endPlanning(Day.valueOf(scanner.next().toUpperCase())));
                    break;
                case 5:
                    dayPlanner.printPlanner();
                    break;

                case 6:
                    b = false;
                    break;

                default:
                    System.out.println("not the right option");
                    break;

            }

        }
    }

    private static void printOptions() {
        System.out.println("----PLANNER----\n");
        System.out.println("Please select one of the following options: ");
        System.out.println("1.  Add an activity");
        System.out.println("2.  Remove an activity");
        System.out.println("3.  List of all activities for a specific day");
        System.out.println("4.  End planning");
        System.out.println("5.  Print all planner activities");

        System.out.println("6.  Quit");
    }
}
