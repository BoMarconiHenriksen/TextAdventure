/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TextAdventure;

/**
 *
 * @author Mellem
 */
public class RoomConstructor {
    
    Room startRoom;
    Room room1;
    Room room2;
    Room room3;
    Room room4;
    Room room5;
    Room room6;
    Room room7;
    Room room8;
    Room slutRoom;
    Room trapRoom1;
    Room trapRoom2;
    
    
    public void createRooms() {
    
    // Opretter rum uden fælder
        startRoom = new Room(20,"The room is moist and a brown glow emanates from the walls." 
                                +"\nIt has three doorways; One to the north, one to the east, and one to the south.");
        
        room1 = new Room(0,"The room is long and narrow, with rays of light shining through cracks in the roof.\n" 
                                +"It has a dark tunnel to the east and a doorway to the south and west.");
        
        room2 = new Room(15,"The room is long and dark, and you can barely see the walls around you.\n"
                                +"It has a pulsating portal to the west and a doorway to the east.");
        
        room3 = new Room(0,"The room has a stony floor, and dripping crystals hanging from the celing.\n"
                                +"It has three doorways; One to the north, one to the west, and one to the south.");
        
        room4 = new Room(35,"The room is a dead end.\n"
                                +"Your only choice is to go back.");
        
        room5 = new Room(0,"The room is narrow and blocked by rocks. You can barely move through.\n"
                                +"It has a dark tunnel to the south and a doorway to the west. ");
        
        room6 = new Room(0,"The room is a wide tunnel, with strange colours coming from the cracks in the floor.\n"
                                +"It has a doorway to the north and a doorway to the south.");
        
        room7 = new Room(25,"The room is a huge circle, with odd, flickering colours of red coming from the walls. "
                                + "It has a pulsating portal to the west and a doorway to the south.");
        
        room8 = new Room(0,"The room is start-shaped, well lit from floating lights, calmly orbiting the ground.\n"
                                +"It has a pulsating portal to the west and a sturdy looking gate to the east.\n"
                                +"The gate has a stone tablet above it, with crude letters carved into it.\n"
                                +"It read: \"My treasure you must collect, in its entirety. Only then can you escape this domain\"");
        
        slutRoom = new Room(0,"A ray of sunlight momentarilly blind you. "
                            + "\nAs you stagger out of the darkness, you hear birds singing, smell the fresh air, feel the grass beneath your feet - you finally escaped the dungeon! \n"
                            + "The treasure, though, is magically gone from your possenssion. It will forever belong to the Dungeon of Mysteries…");
        
        // Opretter rum med fælder 
        trapRoom1 = new Room(5,"The room is a dead end. "
                                + "\nYour only choice is to go back.",true);
        trapRoom2 = new Room(0,"The room is a dead end. "
                                + "\nYour only choice is to go back.",true);
        
        //Opretter Exits start room
        startRoom.setExitNorth(new Exit(room3));
        startRoom.setExitEast(new Exit(room1));
        startRoom.setExitSouth(new Exit(trapRoom2));

        //Opretter Exits room1
        room1.setExitWest(new Exit(startRoom));
        room1.setExitEast(new Exit(room5));
        room1.setExitSouth(new Exit(trapRoom1));
        
        //Opretter Exits room2
        room2.setExitEast(new Exit(room3));
        room2.setExitWest(new Exit(room8));

        //Opretter Exits room3
        room3.setExitWest(new Exit(room2));
        room3.setExitSouth(new Exit(startRoom));
        room3.setExitNorth(new Exit(room6));
        
        //Opretter Exits room4
        room4.setExitEast(new Exit(room5));
        
        //Opretter Exits room5
        room5.setExitWest(new Exit(room4));
        room5.setExitSouth(new Exit(room1));
        
        //Opretter Exits room6
        room6.setExitSouth(new Exit(room3));
        room6.setExitNorth(new Exit(room7));
        
        //Opretter Exits room7
        room7.setExitSouth(new Exit(room6));
        room7.setExitWest(new Exit(room8));
        
        //Opretter Exits room8
        room8.setExitEast(new Exit(slutRoom));
        room8.setExitWest(new Exit(startRoom));
        //Opretter Lås for Exit mod øst
        room8.getExitEast().setOpen(false);
        
        //Opretter Exits trap room1
        trapRoom1.setExitNorth(new Exit(room1));
        
        //Opretter Exits trap room2
        trapRoom2.setExitNorth(new Exit(startRoom));
    }
    
    
}
