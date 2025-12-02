package com.example.evadefromdarkov;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class EFDGame
{
    File AllText = new File("com/example/evadefromdarkov/AllText.json");
    Random random = new Random();

    //Player and NPC creation
    private Player player;
    private Trader trader;
    private Dog dog;
    private Scavenger scavenger1;
    private Scavenger scavenger2;
    private Creature creature;

    //Item creation
    Item map, coin;
    {
        map = new Item("map","a tattered piece of paper etched with random drawings");
        coin = new Item("coin","a rusted copper coin");
    }
    Weapon axe,shotgun;
    {
        axe = new Weapon("axe","an old wood cutting axe",20);
        shotgun = new Weapon("shotgun","a model 1912 winchester shotgun",40);
    }
    Tool dogfood, key;
    {
        dogfood = new Tool("dogfood","a sealed tin of dog food",25);
        key = new Tool("key","a shiny titanium key",1);
    }

    Room[][] tilesLayout = new Room[5][5];
    ArrayList<String> outputStrings = new ArrayList<String>();

    static final int secretSuccessiveSearchRequirement = 10;
    static int secretSuccessiveSearches;

    public EFDGame() {
        createWorld();
    }

    private void createWorld() {
        //Room creation
        Room spawn,traderSpot,abandonedHouse,dogKennel,zone,bunker,wilderness1,wilderness2,wilderness3,wilderness4,minefield,wilderness6,wilderness7,wilderness8,wilderness9,wildernessA,wildernessB,wildernessC,wildernessD,wildernessE,wildernessG,wildernessH,wildernessI,scavengerCamp,wildernessK;
        {
            spawn = new Room(0,"your first memory of this place",new ArrayList<Item>());
            traderSpot = new Room(1,"an old man laying under a sheet of metal",new ArrayList<Item>());
            abandonedHouse = new Room(2,"an old abandoned and barricaded house",new ArrayList<Item>());
            dogKennel = new Room(3,"a dog kennel",new ArrayList<Item>());
            zone = new Room(4,"a mysterious green glow",new ArrayList<Item>());
            bunker = new Room(5,"a locked 1970s fallout bunker",new ArrayList<Item>());
            wilderness1 = new Room(6,"an old oak tree",new ArrayList<Item>());
            wilderness2 = new Room(7,"a few dead bushes",new ArrayList<Item>());
            wilderness3 = new Room(8,"a cold empty field",new ArrayList<Item>());
            wilderness4 = new Room(9,"a small forest",new ArrayList<Item>());
            minefield = new Room(10,"a sign saying minefield",new ArrayList<Item>());
            wilderness6 = new Room(11,"a small collapsed well",new ArrayList<Item>());
            wilderness7 = new Room(12,"a bed of mushrooms",new ArrayList<Item>());
            wilderness8 = new Room(13,"a small pond",new ArrayList<Item>());
            wilderness9 = new Room(14,"a puddle of brown water",new ArrayList<Item>());
            wildernessA = new Room(15,"an abandoned tractor",new ArrayList<Item>());
            wildernessB = new Room(16,"a dead sheep covered in flies",new ArrayList<Item>());
            wildernessC = new Room(17,"a dead cow",new ArrayList<Item>());
            wildernessD = new Room(18,"a field of rotten wheat",new ArrayList<Item>());
            wildernessE = new Room(19,"a mysterious shed",new ArrayList<Item>());
            wildernessG = new Room(20,"an abandoned car",new ArrayList<Item>());
            wildernessH = new Room(21,"what is left of a dirt road",new ArrayList<Item>());
            wildernessI = new Room(22,"the remainder of a dog's meal",new ArrayList<Item>());
            scavengerCamp = new Room(23,"a scavenger's camp",new ArrayList<Item>());
            wildernessK = new Room(24,"a lone ash tree",new ArrayList<Item>());}
        int[] xSpawn = new int[25];
        int[] ySpawn = new int[25];

        //Item allocation
        spawn.getItems().add(map);
        wilderness1.getItems().add(axe);
        wildernessI.getItems().add(dogfood);
        wilderness6.getItems().add(coin);
        zone.getItems().add(shotgun);

        Room[] roomChoices = {spawn, traderSpot, abandonedHouse, dogKennel, zone,bunker,wilderness1,wilderness2,wilderness3,wilderness4,minefield,wilderness6,wilderness7,wilderness8,wilderness9,wildernessA,wildernessB,wildernessC,wildernessD,wildernessE,wildernessG,wildernessH,wildernessI,scavengerCamp,wildernessK};

        //Room placement
        for (int spawnOrder = 0; spawnOrder < xSpawn.length; spawnOrder++) {
            xSpawn[spawnOrder] =random.nextInt(5);
            ySpawn[spawnOrder] =random.nextInt(5);
            while (tilesLayout[xSpawn[spawnOrder]][ySpawn[spawnOrder]] != null)
            {
                xSpawn[spawnOrder] =random.nextInt(5);
                ySpawn[spawnOrder] =random.nextInt(5);
            }
            tilesLayout[xSpawn[spawnOrder]][ySpawn[spawnOrder]] = roomChoices[spawnOrder];
        }

        //Exit creation
        for (int spawns = 0; spawns < xSpawn.length; spawns++) {
            if (ySpawn[spawns] + 1 < 5) {
                tilesLayout[xSpawn[spawns]][ySpawn[spawns]].setExit("north",tilesLayout[xSpawn[spawns]][ySpawn[spawns]+1]);
            }
            if (ySpawn[spawns] - 1 >= 0) {
                tilesLayout[xSpawn[spawns]][ySpawn[spawns]].setExit("south",tilesLayout[xSpawn[spawns]][ySpawn[spawns]-1]);
            }
            if (xSpawn[spawns] - 1 >= 0) {
                tilesLayout[xSpawn[spawns]][ySpawn[spawns]].setExit("west",tilesLayout[xSpawn[spawns]-1][ySpawn[spawns]]);
            }
            if (xSpawn[spawns] + 1 < 5) {
                tilesLayout[xSpawn[spawns]][ySpawn[spawns]].setExit("east",tilesLayout[xSpawn[spawns]+1][ySpawn[spawns]]);
            }
        }

        //Player and NPC creation
        player = new Player("player",spawn,new ArrayList<Item>());
        trader = new Trader("trader",traderSpot,30,0);
        trader.getInventory().add(key);
        dog = new Dog("a rabid irradiated german shepperd",dogKennel,20,5);
        scavenger1 = new Scavenger("a tall sickly young man holding a knife",scavengerCamp,20,10,new ArrayList<Item>());
        scavenger2 = new Scavenger("a short stumbling old man",scavengerCamp,30,10,new ArrayList<Item>());
        creature = new Creature("a large screaming irradiated beast",bunker,100,15);
    }

    private void goRoom(String direction) {
        Room nextRoom = player.getCurrentRoom().getExit(direction);

        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            outputStrings.add(player.getCurrentRoom().getLongDescription());
        } else {outputStrings.addLast("to the "+direction+" is a large unsurpassable wall");}
    }

    private void printItems() {
        try{
            if (!player.getCurrentRoom().getItems().isEmpty()) {
                for (Item item : player.getCurrentRoom().getItems()) {
                    outputStrings.addLast(item.getDescription());
                }
            } else {outputStrings.addLast("Nothing to see here");}
        } catch (Exception e) {System.out.println("Something went wrong");}
    }

    private void revealSecretItem(){
        if (player.getCurrentRoom().getRoomNumber() == 0) {
            player.getCurrentRoom().getItems().add(key);
            player.getCurrentRoom().getItems().add(shotgun);
            trader.getInventory().remove(key);
            outputStrings.add("wait a minute");
        }
    }

    private void grabItems() {
        try {
            if (!player.getCurrentRoom().getItems().isEmpty()) {
                player.getInventory().add(player.getCurrentRoom().getItems().getLast());
                outputStrings.addLast(player.getCurrentRoom().getItems().getLast().getName()+" grabbed");
                player.getCurrentRoom().getItems().removeLast();
            }
            else {outputStrings.addLast("Nothing to see here");}
        } catch (Exception e) {System.out.println("Something went wrong");}
    }

    private void dropItems(String itemName) {
        try {
            for (Item items : player.getInventory()){
                if (items.getName().equals(itemName)){
                    player.getInventory().remove(items);
                    player.getCurrentRoom().getItems().addLast(items);
                    outputStrings.addLast(items.getName()+" dropped");
                }
            }
        }catch (Exception e){}
    }

    private void useItems(String itemName) {
        int randDif = random.nextInt(20);

        switch (itemName){
            case "map":
                outputStrings.add("looking at map");
                GameState.MapLook.state = true;
                break;
                case "axe":
                    switch(getCurrentEnemyNumber()) {
                        case 0:
                            trader.changeHealth(-(axe.getDamage()+randDif));
                            outputStrings.add("trader chopped");
                            break;
                        case 1:
                            dog.changeHealth(-(axe.getDamage()+randDif));
                            outputStrings.add("dog chopped");
                            break;
                        case 2:
                            scavenger1.changeHealth(-(axe.getDamage()+randDif));
                            outputStrings.add("scav 1 chopped");
                            break;
                        case 3:
                            scavenger2.changeHealth(-(axe.getDamage()+randDif));
                            outputStrings.add("scav 2 chopped");
                            break;
                        case 4:
                            creature.changeHealth(-(axe.getDamage()+randDif));
                            outputStrings.add("creature chopped");
                            break;
                    }
                    break;
                    case "shotgun":
                        switch(getCurrentEnemyNumber()){
                            case 0:
                                trader.changeHealth(-(shotgun.getDamage()+randDif));

                                if (trader.getHealth() > 0){
                                    outputStrings.add("trader shot");
                                }else {
                                    outputStrings.add("trader killed");
                                    trader.dropItems();
                                }
                                break;
                                case 1:
                                    dog.changeHealth(-(shotgun.getDamage()+randDif));
                                    outputStrings.add("dog shot");
                                    break;
                                    case 2:
                                        scavenger1.changeHealth(-(shotgun.getDamage()+randDif));
                                        outputStrings.add("scav 1 shot");
                                        break;
                                        case 3:
                                            scavenger2.changeHealth(-(shotgun.getDamage()+randDif));
                                            outputStrings.add("scav 2 shot");
                                            break;
                                            case 4:
                                                creature.changeHealth(-(shotgun.getDamage()+randDif));
                                                outputStrings.add("creature shot");
                                                break;
                        }
                        break;
                        case "dogfood":
                            if (getCurrentEnemyNumber() == 1){
                                dog.setTame(true);
                                outputStrings.add("dog tamed");
                            }
                            else {
                                player.changeHealth(dogfood.getStat());
                                outputStrings.add("dog food eaten");
                            }
                            player.getInventory().remove(dogfood);
                            break;
                            case "coin":
                                if (getCurrentEnemyNumber() == 0){
                                    outputStrings.add("coin traded");
                                }
                                player.getInventory().remove(coin);
                                trader.getInventory().add(coin);
                                player.getCurrentRoom().getItems().add(trader.getInventory().getFirst());
                                break;
            case "key":
                if (key.getStat() >= 0){
                    if (player.getCurrentRoom().getRoomNumber() == 5){
                        outputStrings.add("bunker unlocked");
                        key.changeStat(-1);
                        if (key.getStat() <= 0){
                            player.getInventory().remove(key);
                        }
                        creature.setReleased(true);
                    }
                }
                else {outputStrings.add("key broken");}
                break;
        }
    }

    public void processCommand(String command) {
        GameState.MapLook.state = false;
        if (GameState.Using.state) {
            useItems(command);
            GameState.Using.state = false;
        } else if (GameState.Dropping.state) {
            dropItems(command);
            GameState.Dropping.state = false;
        } else {
            switch (command) {
                case "north", "south", "west", "east":
                    goRoom(command);
                    break;
                case "search":
                    printItems();
                    if (secretSuccessiveSearches == secretSuccessiveSearchRequirement){
                        revealSecretItem();
                    }
                    break;
                case "grab":
                    grabItems();
                    break;
                case "drop":
                    outputStrings.add("drop what?");
                    GameState.Dropping.state = true;
                    GameState.Fighting.state = false;
                    break;
                case "use":
                    outputStrings.add("use what?");
                    GameState.Using.state = true;
                    GameState.Fighting.state = false;
                    break;
                case "map":
                    outputStrings.add(map.getDescription());
                    break;
                case "axe":
                    outputStrings.add(axe.getDescription());
                    break;
                case "shotgun":
                    outputStrings.add(shotgun.getDescription());
                    break;
                case "coin":
                    outputStrings.add(coin.getDescription());
                    break;
                case "dogfood":
                    outputStrings.add(dogfood.getDescription());
                    break;
                case "key":
                    outputStrings.add(key.getDescription());
                    break;
            }
        }

        if (command == "search") {
            secretSuccessiveSearches++;
        }
        else {secretSuccessiveSearches = 0;}
    }

    public void combatCheck() {
        if (player.getHealth() > 0 && GameState.Fighting.state) {
            int randDif = random.nextInt(20);

            if (getCurrentEnemyNumber() == 1 && dog.getHealth() > 0 && !dog.getTame()){
                player.changeHealth(-(dog.getDamage()+randDif));
            }
            else if (getCurrentEnemyNumber() == 2 && scavenger1.getHealth() > 0){
                player.changeHealth(-(scavenger1.getDamage()+randDif));
            }
            else if (getCurrentEnemyNumber() == 3 && scavenger2.getHealth() > 0){
                player.changeHealth(-(scavenger2.getDamage()+randDif));
            }
            else if (getCurrentEnemyNumber() == 4 && creature.getHealth() > 0 && creature.getReleased()){
                player.changeHealth(-(creature.getDamage()+randDif));
            }
        }
        else if (player.getHealth() <= 0)
        {
            GameState.Dead.state = true;
        }
    }

    public boolean escaped(){
        if (player.getHealth() > 0 && creature.getHealth() <= 0 && player.getCurrentRoom().getRoomNumber() == 5) {
            outputStrings.add("you have escaped from darkov");
            GameState.Escaped.state = true;
            return true;
        }
        return false;
    }

    public int getCurrentEnemyNumber(){
        GameState.Fighting.state = true;
        if (player.getCurrentRoom() == creature.getCurrentRoom() && creature.getHealth() > 0 && creature.getReleased()) {
            return 4;
        }
        if (player.getCurrentRoom() == scavenger2.getCurrentRoom() && scavenger2.getHealth() > 0) {
            return 3;
        }
        if (player.getCurrentRoom() == scavenger1.getCurrentRoom() && scavenger1.getHealth() > 0) {
            return 2;
        }
        if (player.getCurrentRoom() == dog.getCurrentRoom() && dog.getHealth() > 0) {
            return 1;
        }
        if (player.getCurrentRoom() == trader.getCurrentRoom() && trader.getHealth() > 0) {
            return 0;
        }
        GameState.Fighting.state = false;
        return -1;
    }

    public ArrayList<String> getOutput(){
        if (GameState.Dead.state) {
            outputStrings.add("you have died");
        }
        while (outputStrings.size() > 1){
            outputStrings.removeFirst();
        }
        return outputStrings;
    }

    public int getPlayerHealth(){
        return player.getHealth();
    }

    public void getPosition(){
        outputStrings.addLast(player.getCurrentRoom().getLongDescription());
    }

    public ArrayList<String> getInventory(){
        ArrayList<String> inventory = new ArrayList<>();

        for (Item item : player.getInventory()) {
            inventory.add(item.getName());
        }

        return inventory;
    }

    public boolean getMapState(){
        return GameState.MapLook.state;
    }

    public Room[][] getMap() {
        return tilesLayout;
    }

    public void saveGameFiles() {
        saveData(tilesLayout,"tilesLayout.save");
        saveData(player,"player.save");
        saveData(dog,"dog.save");
        saveData(trader,"trader.save");
        saveData(scavenger1,"scav1.save");
        saveData(scavenger2,"scav2.save");
        saveData(creature,"creature.save");
        outputStrings.add("game saved");
    }

    public void loadGameFiles(){
        tilesLayout = loadData("tilesLayout.save");
        player = loadData("player.save");
        dog = loadData("dog.save");
        trader = loadData("trader.save");
        scavenger1 = loadData("scav1.save");
        scavenger2 = loadData("scav2.save");
        creature = loadData("creature.save");

        outputStrings.add("game loaded");

        //Relinkage of NPCs and Rooms
        for (int x = 0; x < 5; x++){
            for (int y = 0; y < 5; y++){
                if (tilesLayout[x][y].getRoomNumber() == dog.currentRoomNumber){
                    System.out.println("trying to link dog");
                    dog.setCurrentRoom(tilesLayout[x][y]);
                }
                if (tilesLayout[x][y].getRoomNumber() == trader.currentRoomNumber){
                    System.out.println("trying to link trader");
                    trader.setCurrentRoom(tilesLayout[x][y]);
                }
                if (tilesLayout[x][y].getRoomNumber() == creature.currentRoomNumber){
                    System.out.println("trying to link creature");
                    creature.setCurrentRoom(tilesLayout[x][y]);
                }
                if (tilesLayout[x][y].getRoomNumber() == scavenger1.currentRoomNumber){
                    System.out.println("trying to link scavs");
                    scavenger1.setCurrentRoom(tilesLayout[x][y]);
                    scavenger2.setCurrentRoom(tilesLayout[x][y]);
                }
            }
        }
    }

    private <T> void saveData(T obj, String file) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file))) {
            out.writeObject(obj);
            System.out.println("Object has been serialized to saveData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T loadData(String file) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}