package com.example.evadefromdarkov;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

@SuppressWarnings("unchecked"+"redundant")
public class EFDGame
{
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
        map = new Item("map","a tattered piece of paper etched with random drawings",0);
        coin = new Item("coin","a rusted copper coin",1);
    }
    Weapon axe,shotgun;
    {
        axe = new Weapon("axe","an old wood cutting axe",2,20);
        shotgun = new Weapon("shotgun","a model 1912 winchester shotgun",3,40);
    }
    Tool dogfood, key;
    {
        dogfood = new Tool("dogfood","a sealed tin of dog food",4,25);
        key = new Tool("key","a shiny titanium key",5,1);
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
        Room spawn,traderSpot,abandonedHouse,dogKennel,oakTree,deadBushes,emptyField,smallForest,collapsedWell,mushrooms,smallPond,brownPuddle,abandonedTractor,deadSheep,deadCow,wheatField,shed,abandonedCar,dirtRoad,dogMeal,scavengerCamp,ashTree;
        {
            spawn = new Room(0,"your first memory of this place",new ArrayList<Item>());
            traderSpot = new Room(1,"an old man laying under a sheet of metal",new ArrayList<Item>());
            abandonedHouse = new Room(2,"an old abandoned and barricaded house",new ArrayList<Item>());
            dogKennel = new Room(3,"a dog kennel",new ArrayList<Item>());
            oakTree = new Room(6,"an old oak tree",new ArrayList<Item>());
            deadBushes = new Room(7,"a few dead bushes",new ArrayList<Item>());
            emptyField = new Room(8,"a cold empty field",new ArrayList<Item>());
            smallForest = new Room(9,"a small forest",new ArrayList<Item>());
            collapsedWell = new Room(11,"a small collapsed well",new ArrayList<Item>());
            mushrooms = new Room(12,"a bed of mushrooms",new ArrayList<Item>());
            smallPond = new Room(13,"a small pond",new ArrayList<Item>());
            brownPuddle = new Room(14,"a puddle of brown water",new ArrayList<Item>());
            abandonedTractor = new Room(15,"an abandoned tractor",new ArrayList<Item>());
            deadSheep = new Room(16,"a dead sheep covered in flies",new ArrayList<Item>());
            deadCow = new Room(17,"a dead cow",new ArrayList<Item>());
            wheatField = new Room(18,"a field of rotten wheat",new ArrayList<Item>());
            shed = new Room(19,"a mysterious shed",new ArrayList<Item>());
            abandonedCar = new Room(20,"an abandoned car",new ArrayList<Item>());
            dirtRoad = new Room(21,"what is left of a dirt road",new ArrayList<Item>());
            dogMeal = new Room(22,"the remainder of a dog's meal",new ArrayList<Item>());
            scavengerCamp = new Room(23,"a scavenger's camp",new ArrayList<Item>());
            ashTree = new Room(24,"a lone ash tree",new ArrayList<Item>());}
        StorageRoom bunker;
        {
            bunker = new StorageRoom(5,"a locked 1970s fallout bunker",new ArrayList<Item>());
        }
        DangerRoom zone, mineField;
        {zone = new DangerRoom(4,"a mysterious green glow",5,new ArrayList<Item>());
            mineField = new DangerRoom(10,"a sign saying minefield",10,new ArrayList<Item>());}
        int[] xSpawn = new int[25];
        int[] ySpawn = new int[25];

        //Item allocation
        spawn.getItems().add(map);
        oakTree.getItems().add(axe);
        dogMeal.getItems().add(dogfood);
        collapsedWell.getItems().add(coin);
        zone.getItems().add(shotgun);

        Room[] roomChoices = {spawn,traderSpot,abandonedHouse,dogKennel,zone,bunker,oakTree,deadBushes,emptyField,smallForest,mineField,collapsedWell,mushrooms,smallPond,brownPuddle,abandonedTractor,deadSheep,deadCow,wheatField,shed,abandonedCar,dirtRoad,dogMeal,scavengerCamp,ashTree};

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
        scavenger2 = new Scavenger("a short stumbling old man",dirtRoad,30,10,new ArrayList<Item>());
        creature = new Creature("a large screaming irradiated beast",null,100,15);
        bunker.addEnemy(creature);
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
        if (player.getCurrentRoom().getID() == 0) {
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
        switch (itemName){
            case "map":
                outputStrings.add("looking at map");
                GameState.MapLook.state = true;
                break;
                case "axe":
                    if (player.getCurrentRoom().getID() == 2) {
                        outputStrings.add("barricades removed");
                        player.getCurrentRoom().getItems().add(shotgun);
                    }else {attackEnemy(axe);}
                    break;
                    case "shotgun":
                        attackEnemy(shotgun);
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
                            player.getInventory().removeIf(item -> item.getID() == dogfood.getID());
                            break;
                            case "coin":
                                if (getCurrentEnemyNumber() == 0){
                                    outputStrings.add("coin traded");
                                }
                                player.getInventory().removeIf(item -> item.getID() == coin.getID());
                                trader.getInventory().add(coin);
                                player.getCurrentRoom().getItems().add(trader.getInventory().getFirst());
                                break;
            case "key":
                if (key.getStat() >= 0){
                    if (player.getCurrentRoom().getID() == 5){
                        outputStrings.add("bunker unlocked");
                        key.changeStat(-1);
                        if (key.getStat() <= 0){
                            player.getInventory().remove(key);
                        }
                        if (((StorageRoom<Enemy>) player.getCurrentRoom()).getEnemy().equals(creature)){
                            creature.setReleased(true);
                            ((StorageRoom<Enemy>) player.getCurrentRoom()).removeEnemy(creature);
                        }
                    }
                }
                else {outputStrings.add("key broken");}
                break;
        }
    }

    private void attackEnemy(Weapon weapon){
        int randDif = random.nextInt(20);
        switch(getCurrentEnemyNumber()){
            case 0:
                trader.changeHealth(-(weapon.getDamage()+randDif));
                if (trader.getHealth() > 0){
                    outputStrings.add("trader hit");
                }else {
                    outputStrings.add("trader killed");
                    trader.dropItems();
                }
                break;
            case 1:
                dog.changeHealth(-(weapon.getDamage()+randDif));
                if (dog.getHealth() > 0){
                    outputStrings.add("dog hit");
                }else {
                    outputStrings.add("dog killed");
                    dog.dropItems();
                }
                break;
            case 2:
                scavenger1.changeHealth(-(weapon.getDamage()+randDif));
                if (scavenger1.getHealth() > 0){
                    outputStrings.add("scavenger hit");
                }else {
                    outputStrings.add("scavenger killed");
                    scavenger1.dropItems();
                }
                break;
            case 3:
                scavenger2.changeHealth(-(weapon.getDamage()+randDif));
                if (scavenger2.getHealth() > 0){
                    outputStrings.add("scavenger hit");
                }else {
                    outputStrings.add("scavenger killed");
                    scavenger2.dropItems();
                }
                break;
            case 4:
                creature.changeHealth(-(weapon.getDamage()+randDif));
                if (creature.getHealth() > 0){
                    outputStrings.add("creature hit");
                }else {
                    outputStrings.add("creature killed");
                    creature.dropItems();
                }
                break;
        }
    }

    public void processCommand(String command) {
        GameState.MapLook.state = false;

        if (creature.getReleased() && !GameState.Dropping.state && !GameState.Using.state) {
            creature.move(player.getCurrentRoom());
        }

        if (GameState.Using.state && command != "use") {
            useItems(command);
            combatCheck();
            GameState.Using.state = false;
        } else if (GameState.Dropping.state && command != "drop") {
            dropItems(command);
            combatCheck();
            GameState.Dropping.state = false;
        } else {
            switch (command) {
                case "save":
                    saveGameFiles();
                    break;
                    case "load":
                        loadGameFiles();
                case "north", "south", "west", "east":
                    combatCheck();
                    goRoom(command);
                    break;
                case "compass":
                    outputStrings.add(player.getCurrentRoom().getDescription());
                    break;
                case "search":
                    printItems();
                    if (secretSuccessiveSearches == secretSuccessiveSearchRequirement){
                        revealSecretItem();
                    }
                    combatCheck();
                    break;
                case "grab":
                    grabItems();
                    combatCheck();
                    break;
                case "drop":
                    outputStrings.add("drop what?");
                    GameState.Using.state = false;
                    GameState.Dropping.state = true;
                    break;
                case "use":
                    outputStrings.add("use what?");
                    GameState.Dropping.state = false;
                    GameState.Using.state = true;
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
            else if (getCurrentEnemyNumber() == 5){
                player.changeHealth(-player.getCurrentRoom().getDamage());
            }
        }
        else if (player.getHealth() <= 0)
        {
            GameState.Dead.state = true;
        }
    }

    public boolean escaped(){
        if (player.getHealth() > 0 && creature.getHealth() <= 0 && player.getCurrentRoom().getID() == 5) {
            outputStrings.add("you have escaped from darkov");
            GameState.Escaped.state = true;
            return true;
        }
        return false;
    }

    public int getCurrentEnemyNumber(){
        GameState.Fighting.state = true;
        if (player.getCurrentRoom().getID() == 4 || player.getCurrentRoom().getID() == 10) {
            System.out.println("Room damage");
            return 5;
        }
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

    public ArrayList<String> getInventory(){
        ArrayList<String> inventory = new ArrayList<>();

        for (Item item : player.getInventory()) {
            inventory.add(item.getName());
        }

        return inventory;
    }

    public Room[][] getMap() {
        return tilesLayout;
    }

    private void saveGameFiles() {
        GameSaver gameSaver = new GameSaver();
        gameSaver.tilesLayout = this.tilesLayout;
        gameSaver.player = this.player;
        gameSaver.trader = this.trader;
        gameSaver.dog = this.dog;
        gameSaver.scavenger1 = this.scavenger1;
        gameSaver.scavenger2 = this.scavenger2;
        gameSaver.creature = this.creature;
        saveData(gameSaver);
        outputStrings.add("game saved");
    }

    private void loadGameFiles(){
        GameSaver gameSaver = loadData();
        this.tilesLayout = gameSaver.tilesLayout;
        this.player = gameSaver.player;
        this.trader = gameSaver.trader;
        this.dog = gameSaver.dog;
        this.scavenger1 = gameSaver.scavenger1;
        this.scavenger2 = gameSaver.scavenger2;
        this.creature = gameSaver.creature;
        outputStrings.add("game loaded");
    }

    private <T> void saveData(T obj) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("game.save"))) {
            out.writeObject(obj);
            System.out.println("Object has been serialized to saveData");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private <T> T loadData() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("game.save"))) {
            return (T) in.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}