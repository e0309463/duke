public class Parser {
    /**
     * Reads the first word of user input as command and recognises what type of command
     * the user is looking for
     * @param command first word of user input
     * @return new Command object based on what the user input is
     * @throws DukeException if the user's input is not recognised
     */
    public static Command parse(String command) throws DukeException {
        switch (command){
            case("list"):
                return new ListCommand();

            case("done"):
                return new DoneCommand();

            case ("delete"):
                return new DeleteCommand();

            case("deadline"):
                return new DeadlineCommand();

            case ("event"):
                return new EventCommand();

            case ("todo"):
                return new TodoCommand();

            case ("find"):
                return new FindCommand();

            case ("bye"):
                return new ByeCommand();

            default:
                throw new DukeException("OOPS!!! I'm sorry, but I don't know what that means :-(");

        }
    }
}
