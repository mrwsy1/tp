package seedu.duke.ui;

import seedu.duke.Bus;
import seedu.duke.BusStops;
import seedu.duke.DiningOptions;
import seedu.duke.exceptions.CustomException;
import seedu.duke.exceptions.ExceptionType;

import java.util.ArrayList;
import java.util.Scanner;

public class Ui {

    private static Scanner in = new Scanner(System.in);

    public static String getCommand() {
        return in.nextLine();
    }

    public static void printWelcomeMessage() {
        printLine();
        String logo = " _       _       ____     __       __\n"
                + "| |\\ \\  | |     / /\\ \\    \\ \\     / /\n"
                + "| | \\ \\ | |    / /__\\ \\    \\ \\   / /\n"
                + "| |  \\ \\| |   / /----\\ \\    \\ \\ / /\n"
                + "|_|   \\ \\_|  / /      \\ \\    \\_V_/    @NUS\n";
        System.out.println("Hello from\n" + logo);
        System.out.println("How can I help?");
        printMostSearchedBusStop();
        printLine();
    }

    public static void printLine() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    public static void showError(Exception error) {
        printLine();
        System.out.println(error);
        printLine();
    }

    public static void printHelp() {
        printLine();
        System.out.println("Here are the range of commands:\n"
                + "1./route : Displays possible direct bus from point to point\n"
                + "2./routemap: Displays the route map with its intermediate bus stops\n"
                + "3./bus: Displays buses available at each bus stop\n"
                + "4./allbus: Lists all buses available in NUS Zone a\n"
                + "5./liststops: Lists all bus stops in NUS Zone a\n"
                + "6./dine: Search for dining options within a faculty\n"
                + "7./dineinfo: Search for a specific dining outlet\n"
                + "8./exit: Exit program\n"
                + "9./help: List all available commands");
        printLine();
    }

    public static void printExitMessage() {
        printLine();
        System.out.println("So long buddy!");
        printLine();
    }

    public static void printRouteMessage(ArrayList<Bus> options) {
        printLine();
        int optionNo = 1;
        boolean isPossible = false;
        int count = 0;
        System.out.println("The buses you can take with their intermediate stops are: ");
        for (Bus option : options) {
            if (option.toString() != null) {
                if (count != 0) {
                    System.out.println();
                    count = 0;
                }
                System.out.println(optionNo + ". " + option.toString());
                optionNo++;
                count++;
                isPossible = true;
            }
        }
        if (!isPossible) {
            System.out.println("none.\nThere are no direct bus routes. :(");
        }
        printLine();
    }

    public static void printFullRoute(Bus busCode) {
        if (busCode != null) {
            printLine();
        }
        System.out.println("Here is the " + busCode.getBusNumber() + " route that you have requested:\n" + busCode);
        printLine();
    }

    public static void printResetSearchFreqMessage() {
        printLine();
        System.out.println("The search frequencies of all bus stops have been reset to 0!");
        printLine();
    }

    private static void printMostSearchedBusStop() {
        if (BusStops.mostSearchedBusStop() != null) {
            System.out.println("Your most searched bus stop is: " + BusStops.mostSearchedBusStop().getName());
        }
    }

    public static void printAllBusMessage(ArrayList<Bus> allBuses) {
        printLine();
        System.out.println("The buses available in NUS are: ");
        int count = allBuses.size();
        for (Bus bus : allBuses) {
            System.out.println(bus.toString());
            count--;
            if (count != 0) {
                System.out.println();
            }
        }
        printLine();
    }

    public static void printPossibleLocsMessage(ArrayList<String> possibleLocs) {
        printLine();
        System.out.println("Hmm, did you mean any of these locations?");
        for (String location : possibleLocs) {
            System.out.println(location);
        }
        System.out.println("Please type the command again with the correct location.");
        printLine();
    }

    public static int printDineResult(int displayCount, String tempFaculty, ArrayList<DiningOptions> foodPlaceInfo) {
        System.out.println("The dining options available at " + tempFaculty + " are:");
        for (DiningOptions info : foodPlaceInfo) {
            displayCount++;
            System.out.println(displayCount + ". " + info.getName());
        }
        return displayCount;
    }

    public static void printDineInfoResult(ArrayList<DiningOptions> searchList) {
        if (searchList.size() == 0) {
            System.out.println("No match found.");
        } else {
            System.out.println("The stores that match your search:");
            for (DiningOptions item : searchList) {
                System.out.println("\n" + item.toString());
            }
        }
    }

}
