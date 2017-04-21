package Constructors;

import Entities.Exit;
import Entities.Inventory;
import Entities.Room;

/**
 * Klassen indeholder beskrivelserne af rummene og opretter exits i rummene.
 * @since 2.0
 */
public class RoomConstructor implements java.io.Serializable {
    
    public Room startRoom, room1, room2, room3 ,room4, room6, room7,
            room8, room9, room11, room12, room13, slutRoom, trapRoom1,
            trapRoom2;
//    Room room1;
//    Room room2;
//    Room room3;
//    Room room4;
//    Room room5;
//    Room room6;
//    Room room7;
//    Room room8;
//    Room room9;
//    Room room10;
//    Room room11;
//    Room room12;
//    Room room13;
//    Room slutRoom;
//    Room trapRoom1;
//    Room trapRoom2;
    
    /**
    *  Laver rum uden fælder
    *  @since 1.0
    */
    public void createRooms() {
        
        startRoom = new Room(new Inventory(),"This is where you woke up. You notice"
                + " a disturbing painting on the far wall. Was it there before?",false);
        
        room1 = new Room(new Inventory(),"This is room 1");
        
        room2 = new Room(new Inventory(),"The room is covered in blue tiles. The color seems out of place."
                + " There is a door to the west,south and east. The South door is yellow and the east door is blue.");
        
        room3 = new Room(new Inventory(),"The room is empty except for a large red carpet on the floor."
                + "The walls are solid rock. There is a blue door to the west, and a red to the east");
        
        room4 = new Room(new Inventory(),"The room is a bright red color. Not for the faint of heart. "
                + "There is a door to the west, south and east. The South door is green and the west door is red."
                + " the east door is covered in blood...");
        
        // room 5 is a trap room
        
        room6 = new Room(new Inventory(),"The room is a bright yellow color. Sickening to the eye..."
                + " There is a door to the west and north. The east door is purple and the north door is blue.");
        
        room7 = new Room(new Inventory(),"The room is purple. A comforting color in your state of distress..."
                + " There is a door to the east, west and south. The west door is yellow and the south door is "
                + "silver. The east door is green");
        
        room8 = new Room(new Inventory(),"The room is a deep green color. Are you going insane...?"
                + "There is a door the west and north. The west door is purple and the north door is red.");
        
        room9 = new Room(new Inventory(),"To your great disappointment, the room is not silver. "
                + "There are mannequins standing all around the edge of the room, looking straight at you."
                + " You sense a movement in the corner of your eye... "
                + "There is a door to the south and north. The north door is silver.");
        
        // room 10 is a trap room
       
        room11 = new Room(new Inventory(),"The room is round with paths in all directions. There is a cradle"
                + "in the middle of the room. You hear a faint sound of a crying baby..."
                + "the door to the west and east are covered in blood. The door to the south is white and "
                + "the door to the north is silver.");
        
        
        room12 = new Room(new Inventory(),"The room is a dead end. When you open the door you see a message "
                + "scribbled on the far wall: HANDS OFF MY GOLD!");
        
        room13 = new Room(new Inventory(),"The room is huge, almost like an arena. There is a giant statue "
                + "in the middle of the room. You see a door behind it to the south. The door is sealed and has"
                + " a small slot for depositing coins");
        
        slutRoom = new Room(new Inventory(),"A ray of sunlight momentarilly blind you. "
                            + "\nAs you stagger out of the darkness, you hear birds singing, smell the fresh air, feel the grass beneath your feet - you finally escaped! \n"
                            + "Your items, though, are magically gone from your possession. It will forever belong to the mysterious mansion…");
        

       
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
        room3.setExitNorth(new Exit(startRoom));
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
        room13.setExitSouth(new Exit(slutRoom,false));

        //Opretter Exits trap room1
        trapRoom1.setExitWest(new Exit(room4));
        
        //Opretter Exits trap room2
        trapRoom2.setExitEast(new Exit(room11));
    }
    
    
}
