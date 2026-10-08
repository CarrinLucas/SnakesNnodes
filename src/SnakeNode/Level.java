package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.image.Image;
import br.com.davidbuzatto.jsge.image.ImageUtils;
import java.awt.Color;

/**
 *
 * @author lucas
 */

public class Level {
    
    /**
     * cada numero representa um bloco do nível sendo:
     * 1 - chão
     * 2 - zona da morte (limite do mapa ou obstáculo)
     * 3- zona de vitória
     * 4 - porta
     * 5 - maçã (aumenta o tamanho da cobra)
     * 6 - tesoura 
     * 7 - botão
     * 8 - tapete de vitória
     * 9 - porta
     * 10 - chão (coberto pela cobra)
     * 11 - botão (coberto pela cobra)
     * 12 - Veneno (diminui o tamanho da cobra)
     * 13 - Balança
     */
    
    public final int[][] levelOne = {
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 4, 4, 4, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 13,1, 1, 1, 2},
        {2, 1, 1, 5, 1, 1, 1, 1, 1, 1, 12,1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 1, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
        {2, 1, 2, 2, 2, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 12,1, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 2, 2, 2, 1, 2},
        {2, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2} 
    };
    
    public final int[][] levelTwo = {
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 2},
        {2, 1, 5, 1, 5, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 9, 8, 3, 3, 3, 3, 3, 2},
        {2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 4, 8, 3, 3, 3, 3, 3, 2},
        {2, 1, 5, 1, 5, 1, 1, 2, 1, 2, 1, 2, 2, 2, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7, 1, 6, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 1, 5, 1, 5, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 2, 2, 2, 2, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
    };
    
    private final Image imgTile;
    private final Image imgVicTile;
    private final Image imgVicTile2;
    private final Image imgApple;
    private final Image imgButton;
    private final Image imgDoor;
    private final Image imgDoor2;
    private final Image imgScissor;
    private final Image imgScale;
    private final Image imgPoison;
    
    private boolean levelOneDoorUnl = false;
    
    private double gateTimer = 0;
    private boolean isGateClosed = false;
    
    public Level(){
        imgTile = ImageUtils.loadImage("resources/images/sprites/tile.png");
        imgVicTile = ImageUtils.loadImage("resources/images/sprites/victoryTile.png");
        imgVicTile2 = ImageUtils.loadImage("resources/images/sprites/victoryTile2.png");
        imgApple = ImageUtils.loadImage("resources/images/sprites/apple.png");
        imgButton = ImageUtils.loadImage("resources/images/sprites/button.png");
        imgDoor = ImageUtils.loadImage("resources/images/sprites/door.png");
        imgDoor2 = ImageUtils.loadImage("resources/images/sprites/door2.png");
        imgScissor = ImageUtils.loadImage("resources/images/sprites/scissor.png");
        imgScale = ImageUtils.loadImage("resources/images/sprites/scale.png");
        imgPoison = ImageUtils.loadImage("resources/images/sprites/poison.png");
        
        imgTile.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);
        imgVicTile.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgVicTile2.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgApple.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgButton.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgDoor.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgDoor2.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgScissor.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgScale.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
        imgPoison.resize(Main.BLOCK_SIZE, Main.BLOCK_SIZE);   
    }
    
    public void drawLevel(EngineFrame e, GameLevel level){
        
        switch (level) { //desenha o nível a partir do array bidimensional de inteiros
            case LEVEL_1:
               for(int row = 0; row < levelOne.length; row++){
                    for(int col = 0; col < levelOne[row].length; col++){
                        
                        int posX = col * Main.BLOCK_SIZE;
                        int posY = row * Main.BLOCK_SIZE;
                        int tileType = levelOne[row][col];
                        
                        drawTile(e, posX, posY, tileType, level);
                    }
                }
                break;
                
            case LEVEL_2:
                for(int row = 0; row < levelTwo.length; row++){
                    for(int col = 0; col < levelTwo[row].length; col++){
                        
                        int posX = col * Main.BLOCK_SIZE;
                        int posY = row * Main.BLOCK_SIZE;
                        int tileType = levelTwo[row][col];
                        
                        drawTile(e, posX, posY, tileType, level);
                    }
                }
        }
    }
    
    private void drawTile(EngineFrame e, int posX, int posY, int tileType, GameLevel level) { //a partir de cada posição do array desenha o bloco
        
        switch(level){
            case LEVEL_1:
                if (tileType == 1) {
                    imgTile.draw(e, posX, posY);
                } else if (tileType == 2) {
                    e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY);
                } else if (tileType == 5) {
                imgTile.draw(e, posX, posY);
                imgApple.draw(e, posX, posY);
            } else if (tileType == 12) {
                imgTile.draw(e, posX, posY);
                imgPoison.draw(e, posX, posY);
            } else if (tileType == 13) {
                imgScale.draw(e, posX, posY);
            } else if  (tileType == 3){
                imgVicTile.draw(e, posX, posY);
            } else if(tileType == 4){
                if(!levelOneDoorUnl){
                    e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY);
                }else{
                    imgTile.draw(e, posX, posY);
                }    
            }
            break;
            
            case LEVEL_2:
                if(tileType == 1){
                    imgTile.draw(e, posX, posY);
                }else if(tileType == 2){
                    e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY);
                }else if(tileType == 3){
                    imgTile.draw(e, posX, posY);
                }else if(tileType == 8){
                    imgVicTile2.draw(e, posX, posY);
                }else if(tileType == 4){
                    if(isGateClosed){
                        e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY);
                        imgDoor.draw(e, posX, posY);                               
                    }else{
                        imgTile.draw(e, posX, posY);
                    }                           
                }else if(tileType == 5){ //Maça 
                    imgTile.draw(e, posX, posY);
                    imgApple.draw(e, posX,posY);
                }else if(tileType == 9){
                    if(isGateClosed){
                        e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY);
                        imgDoor2.draw(e, posX, posY);                               
                    }else{
                        imgTile.draw(e, posX, posY);
                    }  
                }else if (tileType == 6){
                    imgScissor.draw(e, posX, posY);
                }else if (tileType == 7){
                    imgButton.draw(e, posX, posY);
                } else if (tileType == 10) {
                    imgTile.draw(e, posX, posY);
                } else if (tileType == 11) {
                    imgButton.draw(e, posX, posY);
                }  
        break;
        }        
    }
    
    public GameState updateLevel(double delta, Snake s, GameLevel l){ 
        
        /**
         * controla e atualiza os níveis
         * verica colisões e os puzzles do nível retornando os estados de jogo
         */
        
        switch (l){
            case LEVEL_1:
                int headX = s.getHeadX();
                int headY = s.getHeadY();
                int currentTile = getTile(headX, headY, l);

                boolean isScalePressed = s.isOccupying(20, 3);
                int tamanhoReal = s.getSize();
                
                if (isScalePressed && tamanhoReal > 4) {
                    return GameState.GAME_OVER; 
                }
                
                if (isScalePressed && tamanhoReal == 4) {
                    this.levelOneDoorUnl = true;
                }
                
                this.isGateClosed = !this.levelOneDoorUnl;

                if (currentTile == 2) {
                    return GameState.GAME_OVER;
                }  else if (currentTile == 5) {
                    levelOne[headY][headX] = 1; 
                    s.snakeGrowth();
                } else if (currentTile == 12) {
                    levelOne[headY][headX] = 1;
                    s.removeTail(); 
                } else if (currentTile == 4 && isGateClosed) {
                    return GameState.GAME_OVER;
                } else if (currentTile == 3) {
                    return GameState.VICTORY;
                }
                
                if (!s.getState()) {
                    return GameState.GAME_OVER;
                }

                return GameState.RUNNING;
                
            case LEVEL_2:
                int headX2 = s.getHeadX();
                int headY2 = s.getHeadY();
                int currentTile2 = getTile(headX2, headY2, l);

                boolean isButtonPressed = s.isOccupying(11, 5) || getTile(11, 5, l) == 11;
                this.isGateClosed = !isButtonPressed;

                if (currentTile2 == 2 || currentTile2 == 10) {
                    return GameState.GAME_OVER;
                } else if(currentTile2 == 5) { 
                    levelTwo[headY2][headX2] = 1;
                    s.snakeGrowth();
                } else if (currentTile2 == 6) {
                    levelTwo[headY2][headX2] = 1;
                    s.cutSnake(levelTwo);
                } else if ((currentTile2 == 4 || currentTile2 == 9) && isGateClosed) {
                    return GameState.GAME_OVER;
                } else if (currentTile2 == 3 || currentTile2 == 8) {
                    return GameState.VICTORY;
                }
                
                if(!s.getState()){
                    return GameState.GAME_OVER;
                }

                return GameState.RUNNING;
        }
        
        return GameState.MENU;
    }
    
    private int getTile(int gridX, int gridY, GameLevel l){ //retorna o bloco atual
        switch (l){
            case LEVEL_1:
                if(gridY < 0 || gridY >= levelOne.length || gridX < 0 || gridX >= levelOne[0].length){
                    return 2;
                }
                return levelOne[gridY][gridX];
                
            case LEVEL_2:
                if(gridY < 0 || gridY >= levelTwo.length || gridX < 0 || gridX >= levelTwo[0].length){
                    return 2;
                }
                return levelTwo[gridY][gridX];
        }
        
        return -1;
    }
}
