package TextAdventure;

/**
 * Klassen indeholder beskrivelserne af rummene og opretter exits i rummene.
 * @since 2.0
 */
public class RoomConstructor implements java.io.Serializable {
    
    Room startRoom;
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room room9;
    Room room10;
    Room room11;
    Room room12;
    Room room13;
    Room slutRoom;
    Room trapRoom1;
    Room trapRoom2;
    
    /**
    *  Laver rum uden fælder
    *  @since 1.0
    */
    public void createRooms() {
        
        startRoom = new Room(new Inventory(),"This is the startroom",false);
        
        room1 = new Room(new Inventory(),"This is room 1");
        
        room2 = new Room(new Inventory(),"This is room 2");
        
        room3 = new Room(new Inventory(),"This is room 3");
        
        room4 = new Room(new Inventory(),"This is room 4");
        
        // room 5 is a trap room
        
        room6 = new Room(new Inventory(),"This is room 6");
        
        room7 = new Room(new Inventory(),"This is room 7");
        
        room8 = new Room(new Inventory(),"This is room 8");
        
        room9 = new Room(new Inventory(),"This is room 9");
        
        // room 10 is a trap room
        
        room11 = new Room(new Inventory(),"This is room 11");
        
        room12 = new Room(new Inventory(),"This is room 12");
        
        room13 = new Room(new Inventory(),"This is room 13");
        
        slutRoom = new Room(new Inventory(),"A ray of sunlight momentarilly blind you. "
                            + "\nAs you stagger out of the darkness, you hear birds singing, smell the fresh air, feel the grass beneath your feet - you finally escaped the dungeon! \n"
                            + "The treasure, though, is magically gone from your possenssion. It will forever belong to the Dungeon of Mysteries…");
        

       
        // Opretter rum med fælder 
        trapRoom1 = new Room(new Inventory(),"The room is a dead end. "
                                + "\nYour only choice is to go back.",true);
        trapRoom2 = new Room(new Inventory(), "The room is a dead end. "
                                + "\nYour only choice is to go back.",true);
        
        //Opretter Exits start room
        startRoom.setExitSouth(new Exit(room3));

        //Opretter Exits room1
        room1.setExitEast(new Exit(room2));
      
        
        //Opretter Exits room2
        room2.setExitEast(new Exit(room3));
        room2.setExitWest(new Exit(room1));
        room2.setExitSouth(new Exit(room6));

        //Opretter Exits room3
        room3.setExitWest(new Exit(room2));
        room3.setExitEast(new Exit(room4));
        
        
        //Opretter Exits room4
        room4.setExitEast(new Exit(trapRoom1));
        room4.setExitWest(new Exit(room3));
        room4.setExitSouth(new Exit(room8));
        
        
        //Opretter Exits room6
        room6.setExitEast(new Exit(room7));
        room6.setExitNorth(new Exit(room2));
        
        //Opretter Exits room7
        room7.setExitSouth(new Exit(room9));
        room7.setExitWest(new Exit(room6));
        room7.setExitEast(new Exit(room8));
        
        //Opretter Exits room8
        room8.setExitNorth(new Exit(room4));
        room8.setExitWest(new Exit(room7));
        
        //Opretter Exits room9
        room9.setExitNorth(new Exit(room7));
        room9.setExitSouth(new Exit(room11));
        
       
        
        //Opretter Exits room11
        room11.setExitNorth(new Exit(room9));
        room11.setExitSouth(new Exit(room13));
        room11.setExitEast(new Exit(room12));
        room11.setExitWest(new Exit(trapRoom2));
        
        //Opretter Exits room12
        room12.setExitWest(new Exit(room11));
        
        //Opretter Exits room13
        room13.setExitNorth(new Exit(room11));
        room13.setExitSouth(new Exit(slutRoom));

 
        
        //Opretter Exits trap room1
        trapRoom1.setExitWest(new Exit(room4));
        
        //Opretter Exits trap room2
        trapRoom2.setExitEast(new Exit(room11));
    }
    
    
}
