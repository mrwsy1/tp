package seedu.duke.exceptions;

public enum ExceptionType {
    INVALID_COMMAND("I do not understand!!"),
    INVALID_BUS("Sorry,there is no such bus in our database!"),
    NO_ROUTE_DELIMITER("Oops! You are missing the delimiter."),
    NO_LOCATIONS("Oh dear! I don't have all locations."),
    MISSING_BUS_CODE("Oh no! You seem to have missed typing in the bus code!"),
    SAME_LOCATIONS("You don't need a bus to get there...You are right there!"),
    INVALID_BUS_STOP("Oh no! I do not understand which bus stop you are looking for"),
    INVALID_FACULTY("Oh no! Please enter a faculty."),
    INVALID_FOODPLACE("Oh no! I cannot detect any inputs."),
    INVALID_FAVOURITE("Oh no! I cannot seem to detect the command you want to store as your favourite."),
    DUPLICATE_FAVOURITE("Oh no! This command is already saved as your favourite."),
    UPDATE_FILE_FAIL("Sorry to inform you that the update of frequency list is unsuccessful."),
    READ_FILE_FAIL("It is unfortunate that the program is unable to read the file");

    private String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
