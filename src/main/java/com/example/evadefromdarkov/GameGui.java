package com.example.evadefromdarkov;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.example.evadefromdarkov.Launcher.game;

public class GameGui extends Application {
    @Override
    public void start(Stage stage) throws IOException
    {
        File saveFile, northFile, southFile, westFile, eastFile, compassFile, searchFile, grabFile, dropFile, useFile,mapFile,axeFile,shotgunFile,coinFile,dogfoodFile,keyFile,playerFile,traderFile,houndFile,scavengerFile,creatureFile,spawnFile,bunkerFile,boneFile,campFile,houseFile,sheetFile,wildFile;
        {
            saveFile = new File("src/images/saveButton.png");
            northFile = new File("src/images/northButton.png");
            southFile = new File("src/images/southButton.png");
            westFile = new File("src/images/westButton.png");
            eastFile = new File("src/images/eastButton.png");
            compassFile = new File("src/images/compassButton.png");
            searchFile = new File("src/images/searchButton.png");
            grabFile = new File("src/images/grabButton.png");
            dropFile = new File("src/images/dropButton.png");
            useFile = new File("src/images/useButton.png");
            mapFile = new File("src/images/mapImage.png");
            axeFile = new File("src/images/axeImage.png");
            shotgunFile = new File("src/images/shotgunImage.png");
            coinFile = new File("src/images/coinImage.png");
            dogfoodFile = new File("src/images/dogfoodImage.png");
            keyFile = new File("src/images/keyImage.png");
            playerFile = new File("src/images/playerImage.png");
            traderFile = new File("src/images/traderImage.png");
            houndFile = new File("src/images/houndImage.png");
            scavengerFile = new File ("src/images/scavengerImage.png");
            creatureFile = new File("src/images/creatureImage.png");
            spawnFile = new File("src/images/spawnImage.png");
            bunkerFile = new File("src/images/bunkerImage.png");
            boneFile = new File("src/images/boneImage.png");
            campFile = new File("src/images/campImage.png");
            houseFile = new File("src/images/houseImage.png");
            sheetFile = new File("src/images/sheetImage.png");
            wildFile = new File("src/images/treeImage.png");
        }
        ImageView saveImage,loadImage,northImage,southImage,westImage,eastImage,compassImage,searchImage,grabImage,dropImage,useImage,mapImage,axeImage,shotgunImage,coinImage,dogfoodImage,keyImage,playerImage,enemyImage,spawnImage,bunkerImage,boneImage,campImage,houseImage,sheetImage;
        {
            saveImage = new ImageView(new Image(saveFile.toURI().toString()));
            loadImage = new ImageView(new Image(saveFile.toURI().toString()));
            northImage = new ImageView(new Image(northFile.toURI().toString()));
            southImage = new ImageView(new Image(southFile.toURI().toString()));
            westImage = new ImageView(new Image(westFile.toURI().toString()));
            eastImage = new ImageView(new Image(eastFile.toURI().toString()));
            compassImage = new ImageView(new Image(compassFile.toURI().toString()));
            searchImage = new ImageView(new Image(searchFile.toURI().toString()));
            grabImage = new ImageView(new Image(grabFile.toURI().toString()));
            dropImage = new ImageView(new Image(dropFile.toURI().toString()));
            useImage = new ImageView(new Image(useFile.toURI().toString()));
            mapImage = new ImageView(new Image(mapFile.toURI().toString()));
            axeImage = new ImageView(new Image(axeFile.toURI().toString()));
            shotgunImage = new ImageView(new Image(shotgunFile.toURI().toString()));
            coinImage = new ImageView(new Image(coinFile.toURI().toString()));
            dogfoodImage = new ImageView(new Image(dogfoodFile.toURI().toString()));
            keyImage = new  ImageView(new Image(keyFile.toURI().toString()));
            playerImage = new ImageView(new Image(playerFile.toURI().toString()));
            enemyImage = new ImageView();
            spawnImage = new ImageView(new Image(spawnFile.toURI().toString()));
            bunkerImage = new ImageView(new Image(bunkerFile.toURI().toString()));
            boneImage = new ImageView(new Image(boneFile.toURI().toString()));
            campImage = new ImageView(new Image(campFile.toURI().toString()));
            houseImage = new ImageView(new Image(houseFile.toURI().toString()));
            sheetImage = new ImageView(new Image(sheetFile.toURI().toString()));
        }
        ImageView wildImage1, wildImage2, wildImage3, wildImage4, wildImage5, wildImage6, wildImage7, wildImage8, wildImage9, wildImage10, wildImage11,wildImage12,wildImage13,wildImage14,wildImage15,wildImage16,wildImage17,wildImage18,wildImage19,wildImage20,wildImage21;
        {
            wildImage1 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage2 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage3 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage4 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage5 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage6 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage7 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage8 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage9 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage10 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage11 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage12 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage13 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage14 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage15 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage16 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage17 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage18 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage19 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage20 = new ImageView(new Image(wildFile.toURI().toString()));
            wildImage21 = new ImageView(new Image(wildFile.toURI().toString()));
        }
        ImageView[] wildViews = {wildImage1, wildImage2, wildImage3, wildImage4, wildImage5, wildImage6, wildImage7, wildImage8, wildImage9, wildImage10, wildImage11,wildImage12,wildImage13,wildImage14,wildImage15,wildImage16,wildImage17,wildImage18,wildImage19,wildImage20,wildImage21};
        Button saveButton, loadButton, northButton, southButton, westButton, eastButton, compassButton, searchButton, grabButton, dropButton, useButton,mapButton,axeButton,coinButton,dogfoodButton,shotgunButton,keyButton;
        {
            saveButton = new Button("",saveImage);
            loadButton = new Button("",loadImage);
            northButton = new Button("",northImage);
            southButton = new Button("",southImage);
            westButton = new Button("",westImage);
            eastButton = new Button("",eastImage);
            compassButton = new Button("",compassImage);
            searchButton = new Button("",searchImage);
            grabButton = new Button("",grabImage);
            dropButton = new Button("",dropImage);
            useButton = new Button("",useImage);
            mapButton = new Button("",mapImage);
            axeButton = new Button("",axeImage);
            coinButton = new Button("",coinImage);
            dogfoodButton = new Button("",dogfoodImage);
            shotgunButton = new Button("",shotgunImage);
            keyButton = new Button("",keyImage);
        }
        TextArea textBox,healthBox;
        {
            textBox = new TextArea();
            healthBox = new TextArea();
        }
        GridPane mapGrid,inventoryGrid,buttonGridBL, buttonGridBR;
        {
            mapGrid = new GridPane();
            inventoryGrid = new GridPane();
            buttonGridBL = new GridPane();
            buttonGridBR = new GridPane();
        }

        //Node Styling
        {
            textBox.setFont(Font.font("System",25));
            healthBox.setFont(Font.font("System",30));
            textBox.setEditable(false);
            textBox.setWrapText(true);
            healthBox.setEditable(false);

            textBox.setMaxSize(225,275);
            healthBox.setMaxSize(200,80);
            playerImage.setFitWidth(275);
            playerImage.setFitHeight(275);
            enemyImage.setFitWidth(275);
            enemyImage.setFitHeight(275);

            int inventoryXY = 100;
            mapImage.setFitWidth(inventoryXY);
            mapImage.setFitHeight(inventoryXY);
            axeImage.setFitWidth(inventoryXY);
            axeImage.setFitHeight(inventoryXY);
            shotgunImage.setFitWidth(inventoryXY);
            shotgunImage.setFitHeight(inventoryXY);
            coinImage.setFitWidth(inventoryXY);
            coinImage.setFitHeight(inventoryXY);
            dogfoodImage.setFitWidth(inventoryXY);
            dogfoodImage.setFitHeight(inventoryXY);
            keyImage.setFitWidth(inventoryXY);
            keyImage.setFitHeight(inventoryXY);

            saveImage.setFitWidth(50);
            saveImage.setFitHeight(75);
            loadImage.setFitWidth(50);
            loadImage.setFitHeight(75);
            compassImage.setFitWidth(75);
            compassImage.setFitHeight(75);
            compassImage.setScaleX(2.25);
            compassImage.setScaleY(1.75);
            northImage.setFitWidth(75);
            northImage.setFitHeight(75);
            southImage.setFitWidth(75);
            southImage.setFitHeight(75);
            westImage.setFitWidth(75);
            westImage.setFitHeight(75);
            eastImage.setFitWidth(75);
            eastImage.setFitHeight(75);
            searchImage.setFitWidth(100);
            searchImage.setFitHeight(60);
            useImage.setFitWidth(100);
            useImage.setFitHeight(60);
            grabImage.setFitWidth(100);
            grabImage.setFitHeight(75);
            dropImage.setFitWidth(100);
            dropImage.setFitHeight(75);

            int mapX = 50; int mapY = 50;
            spawnImage.setFitWidth(mapX);
            spawnImage.setFitHeight(mapY);
            bunkerImage.setFitWidth(mapX);
            bunkerImage.setFitHeight(mapY);
            boneImage.setFitWidth(mapX);
            boneImage.setFitHeight(mapY);
            campImage.setFitWidth(mapX);
            campImage.setFitHeight(mapY);
            houseImage.setFitWidth(mapX);
            houseImage.setFitHeight(mapY);
            sheetImage.setFitWidth(mapX);
            sheetImage.setFitHeight(mapY);
            for (ImageView images : wildViews){
                images.setFitWidth(mapX);
                images.setFitHeight(mapY);
            }

            mapGrid.setAlignment(Pos.TOP_RIGHT);

            inventoryGrid.setAlignment(Pos.CENTER_LEFT);

            buttonGridBL.setAlignment(Pos.BOTTOM_LEFT);
            buttonGridBL.setHgap(10);
            buttonGridBL.setVgap(10);
            buttonGridBL.add(searchButton,0,0);
            buttonGridBL.add(useButton,1,0);
            buttonGridBL.add(grabButton,0,1);
            buttonGridBL.add(dropButton,1,1);

            buttonGridBR.setAlignment(Pos.BOTTOM_RIGHT);
            buttonGridBR.setHgap(20);
            buttonGridBR.setVgap(20);
            buttonGridBR.add(compassButton,1,1);
            buttonGridBR.add(northButton,1,0);
            buttonGridBR.add(southButton,1,2);
            buttonGridBR.add(westButton,0,1);
            buttonGridBR.add(eastButton,2,1);
        }

        //Button Actions
        {
            Node[] allNodes = {textBox,healthBox,mapGrid,inventoryGrid,buttonGridBL,buttonGridBR,saveButton,loadButton,compassButton,northButton,southButton,westButton,eastButton,searchButton,grabButton,dropButton,useButton,mapButton,axeButton,shotgunButton,coinButton,dogfoodButton,keyButton,playerImage,enemyImage};
            Button[] itemButtons = {mapButton,axeButton,shotgunButton,coinButton,dogfoodButton,keyButton};
            ImageView[] mapIcons = {spawnImage,sheetImage,houseImage,boneImage,wildImage2, bunkerImage, wildImage3, wildImage4, wildImage5, wildImage6, wildImage7, wildImage8, wildImage9, wildImage10, wildImage11,wildImage12,wildImage13,wildImage14,wildImage15,wildImage16,wildImage17,wildImage18,wildImage19,campImage,wildImage21};
            File[] itemFiles = {mapFile, axeFile, shotgunFile, coinFile, dogfoodFile};
            File[] enemyImageFiles = {traderFile,houndFile,scavengerFile,scavengerFile,creatureFile};

            for (Node nodes : allNodes) {
                nodes.setStyle("-fx-background-color: transparent;");
                nodes.setOnMouseClicked((event) -> {
                    if (!GameState.Dead.state && !game.escaped()) {
                        game.combatCheck();
                    }
                    displayTextOutput(textBox,healthBox);
                    displayVisualOutput(inventoryGrid,itemButtons,enemyImage,enemyImageFiles,itemFiles,mapGrid,mapIcons);
                });
            }

            Map<Button, String> mainButtonMap = new HashMap<>();
            mainButtonMap.put(saveButton,"save");
            mainButtonMap.put(loadButton,"load");
            mainButtonMap.put(compassButton,"compass");
            mainButtonMap.put(northButton, "north");
            mainButtonMap.put(southButton, "south");
            mainButtonMap.put(eastButton,  "east");
            mainButtonMap.put(westButton,  "west");
            mainButtonMap.put(searchButton, "search");
            mainButtonMap.put(grabButton, "grab");
            mainButtonMap.put(dropButton, "drop");
            mainButtonMap.put(useButton, "use");
            mainButtonMap.put(mapButton, "map");
            mainButtonMap.put(axeButton, "axe");
            mainButtonMap.put(shotgunButton, "shotgun");
            mainButtonMap.put(coinButton, "coin");
            mainButtonMap.put(dogfoodButton, "dogfood");
            mainButtonMap.put(keyButton, "key");

            mainButtonMap.forEach((button, text) -> {
                button.setOnAction(event -> {
                    buttonPressedDown(button);

                    if (!game.escaped() && !GameState.Dead.state) {
                        game.processCommand(text);
                    }
                });
            });
        }

        AnchorPane anchorPane = new AnchorPane();
        Scene scene = new Scene(anchorPane,800,600);

        //AnchorPane anchors
        {
            anchorPane.setStyle("-fx-background-color: #FFFFFF;");
            AnchorPane.setTopAnchor(saveButton,0.0);
            AnchorPane.setLeftAnchor(saveButton,0.0);
            AnchorPane.setTopAnchor(loadButton,0.0);
            AnchorPane.setLeftAnchor(loadButton,50.0);
            AnchorPane.setBottomAnchor(healthBox, 500.0);
            AnchorPane.setLeftAnchor(healthBox, 125.0);
            AnchorPane.setBottomAnchor(textBox, 0.0);
            AnchorPane.setLeftAnchor(textBox, 250.0);
            AnchorPane.setLeftAnchor(inventoryGrid, 0.0);
            AnchorPane.setTopAnchor(inventoryGrid, 100.0);
            AnchorPane.setLeftAnchor(buttonGridBL, 10.0);
            AnchorPane.setBottomAnchor(buttonGridBL, 10.0);
            AnchorPane.setRightAnchor(buttonGridBR, 10.0);
            AnchorPane.setBottomAnchor(buttonGridBR, 10.0);
            AnchorPane.setTopAnchor(playerImage, 25.0);
            AnchorPane.setLeftAnchor(playerImage, 225.0);
            AnchorPane.setTopAnchor(enemyImage, 25.0);
            AnchorPane.setLeftAnchor(enemyImage, 500.0);
            AnchorPane.setTopAnchor(mapGrid,25.0);
            AnchorPane.setLeftAnchor(mapGrid,525.0);
            anchorPane.getChildren().addAll(mapGrid,inventoryGrid,textBox,healthBox,saveButton,loadButton,buttonGridBL,buttonGridBR,playerImage,enemyImage);
        }

        //Finalisation
        {
            stage.setTitle("Evade From Darkov");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        }
    }

    private void displayTextOutput(TextArea textBox,TextArea healthBox) {
        textBox.clear();
        for (String string : game.getOutput()) {
            textBox.appendText(string + "\n");
        }

        healthBox.clear();

        if (game.getPlayerHealth() >= 0){
            healthBox.setPromptText(String.valueOf(game.getPlayerHealth()));
        }
        else {healthBox.setPromptText(String.valueOf(0));}
    }

    private void displayVisualOutput(GridPane inventoryGrid, Button[] itemButtons, ImageView enemyImage, File[] enemyFiles, File[] itemFiles, GridPane mapGrid, ImageView[] mapIcons) {
        inventoryGrid.getChildren().clear();
        mapGrid.getChildren().clear();
        enemyImage.setImage(null);

        if (game.getInventory().contains("map")){
            inventoryGrid.add(itemButtons[0],0,0);
        }
        if (game.getInventory().contains("axe")){
            inventoryGrid.add(itemButtons[1],1,0);
        }
        if (game.getInventory().contains("shotgun")){
            inventoryGrid.add(itemButtons[2],0,1);
        }
        if (game.getInventory().contains("coin")){
            inventoryGrid.add(itemButtons[3],1,1);
        }
        if (game.getInventory().contains("dogfood")){
            inventoryGrid.add(itemButtons[4],0,2);
        }
        if (game.getInventory().contains("key")){
            inventoryGrid.add(itemButtons[5],1,2);
        }

        if (!GameState.MapLook.state && game.getCurrentEnemyNumber() >= 0 && game.getCurrentEnemyNumber() <= 4){
            enemyImage.setImage(new Image(enemyFiles[game.getCurrentEnemyNumber()].toURI().toString()));
        }
        else if (GameState.MapLook.state){
            for (int falseY = 0; falseY < 5; falseY++) {
                for (int x = 0; x < 5; x++) {
                    int trueY = 0;
                    switch (falseY) {
                        case 0:
                            trueY = 4;
                            break;
                        case 1:
                            trueY = 3;
                            break;
                        case 2:
                            trueY = 2;
                            break;
                        case 3:
                            trueY = 1;
                            break;
                        case 4:
                            trueY = 0;
                            break;
                    }
                    mapGrid.add(mapIcons[game.getMap()[x][falseY].getRoomNumber()], x, trueY);
                }
            }
        }
        /*else if (game.getPosition().getItems() != null){
            switch (game.getPosition().getItems().getLast().getName()){
                case "map":
                    enemyImage.setImage(new Image(itemFiles[0].toURI().toString()));
                    break;
                case "axe":
                    enemyImage.setImage(new Image(itemFiles[1].toURI().toString()));
                    break;
                case "shotgun":
                    enemyImage.setImage(new Image(itemFiles[2].toURI().toString()));
                    break;
                case "coin":
                    enemyImage.setImage(new Image(itemFiles[3].toURI().toString()));
                    break;
                case "dogfood":
                    enemyImage.setImage(new Image(itemFiles[4].toURI().toString()));
                    break;
            }
        }*/
    }

    private void buttonPressedDown(Button button) {
        button.setScaleX(button.getScaleX() / 1.1);
        button.setScaleY(button.getScaleY() / 1.1);

        PauseTransition pause = new PauseTransition(Duration.millis(150));
        pause.setOnFinished(event -> {
            button.setScaleX(button.getScaleX() * 1.1);
            button.setScaleY(button.getScaleY() * 1.1);
        });

        pause.play();
    }

    //Unused file choosing code
    /*public void fileChoosing(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            game.loadGameFiles();
        }
    }*/
}