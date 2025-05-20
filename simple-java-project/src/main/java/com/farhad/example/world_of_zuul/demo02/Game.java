package com.farhad.example.world_of_zuul.demo02;

public class Game {

    private Parser parser;
    // private Room currentRoom;
    private Player currentPlayer;

    public Game() {
        parser = new Parser();
        Room startRoom = createRooms();
        currentPlayer = createPlayer();
        currentPlayer.enterRoom(startRoom);
    }

    public Player createPlayer() {
        return new Player("player");
    }

    private Room createRooms() {
        Room outside, theatre, pub, lab, office, cellar;

        // create the rooms
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theatre = new Room("in a lecture theatre");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        // put items in the room
        pub.addItem(new Item("beer", "a tasty beer", 0.5));
        pub.addItem(new Item("wine", "a dusty bottle of old wine", 0.75));
        lab.addItem(new Item("computer", "a brand new computer", 30));
        theatre.addItem(new Item("cookie", "a magic cookie", 0.1));

        // initialise room exits
        outside.setExit("east", theatre);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theatre.setExit("west", outside);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);

        office.setExit("west", lab);

        return outside;
    }

    public void play() {
        printWelcome();
        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("look")) {
            look();
        } else if (commandWord.equals("take")) {
            take(command);
        } else if (commandWord.equals("drop")) {
            drop(command);
        } else if (commandWord.equals("items")) {
            printItems();
        } else if (commandWord.equals("eat")) {
            eat(command);
        } else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }

        return wantToQuit;
    }

    private void printItems() {
        System.out.println(currentPlayer.getItemsString());
    }

    private void drop(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("What do you want to drop?");
            return;
        }
        String itemName = command.getSecondWord();
        Item item = currentPlayer.dropItem(itemName);
        if (item == null) {
            System.out.println("You don't carry the item: " + itemName);
        } else {
            System.out.println("Dropped " + item.getDescription());
        }
    }

    private void take(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("What do you want to take?");
            return;
        }
        String itemName = command.getSecondWord();
        Item item = currentPlayer.pickUpItem(itemName);
        if (item == null) {
            System.out.println("Can't pick up the item: " + itemName);
        } else {
            System.out.println("Picked up " + item.getDescription());
        }
    }

    private void eat(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("What do you want to eat?");
            return;
        }
        String itemName = command.getSecondWord();
        Item item = currentPlayer.eat(itemName);
        if (item == null) {
            System.out.println("Could not eat " + itemName);
        } else {
            System.out.println("Ate " + item.getDescription());
        }
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentPlayer.getCurrentRoom().getExit(direction);
        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentPlayer.enterRoom(nextRoom);
            System.out.println(currentPlayer.getLongDescription());
        }
    }

    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * 
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if (command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        } else {
            return true;
        }
    }

    private void look() {
        System.out.println(currentPlayer.getCurrentRoom().getLongDescription());
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        System.out.println(currentPlayer.getCurrentRoom().getLongDescription());
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        System.out.println(parser.getCommands());
    }

}
