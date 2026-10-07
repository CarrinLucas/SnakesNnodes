package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import java.awt.Color;

/**
 *
 * @author lucas
 */
public class Level {
    public final int[][] levelOne = {
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 4, 4, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
        {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };
    
    public final int[][] levelTwo = {
    {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
    {2, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 2},
    {2, 1, 5, 1, 5, 1, 1, 2, 1, 2, 2, 2, 2, 2, 2, 2, 1, 4, 3, 3, 3, 3, 3, 3, 2},
    {2, 1, 1, 1, 1, 1, 1, 2, 1, 2, 1, 1, 1, 1, 1, 2, 1, 4, 3, 3, 3, 3, 3, 3, 2},
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
    
    private double gateTimer = 0;
    private boolean isGateClosed = false;
    
    public void drawLevel(EngineFrame e, GameLevel level){
        
        switch (level) {
            case LEVEL_1:
                for(int row = 0; row < levelOne.length; row++){
                    for(int col = 0; col < levelOne[row].length; col++){
                        int posX = col * Main.BLOCK_SIZE;
                        int posY = row * Main.BLOCK_SIZE;

                        if(levelOne[row][col] == 1){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.GREEN);
                        }else if(levelOne[row][col] == 2){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.RED);
                        }else if(levelOne[row][col] == 3){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.BLUE);
                        } else if(levelOne[row][col] == 4){
                            if(isGateClosed){
                                e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.RED);
                            }else{
                                e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.WHITE);
                            }
                        }
                    }
                }
                break;
                
            case LEVEL_2:
                for(int row = 0; row < levelTwo.length; row++){
                    for(int col = 0; col < levelTwo[row] .length; col++){
                        int posX = col * Main.BLOCK_SIZE;
                        int posY = row * Main.BLOCK_SIZE;
                        
                        if(levelTwo[row][col] == 1){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.GREEN);
                        }else if(levelTwo[row][col] == 2){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.RED);
                        }else if(levelTwo[row][col] == 3){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.BLUE);
                        }else if(levelTwo[row][col] == 4){
                            if(isGateClosed){
                                e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.RED);                               
                            }else{
                                e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.WHITE);
                            }                           
                        }else if(levelTwo[row][col] == 5){ //Maça 
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.ORANGE);
                        }else if (levelTwo[row][col] == 6){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.MAGENTA); //Item que corta a cobra
                        }else if (levelTwo[row][col] == 7){
                            e.fillRectangle(posX, posY, Main.BLOCK_SIZE, Main.BLOCK_SIZE, Color.DARK_GRAY); //Botão que precisa apertar
                        }
                    }                  
                }
                break;
            case LEVEL_3:
                break;
        }
    }
    
    public GameState updateLevel(double delta, Snake s, GameLevel l){
        
        switch (l){
            case LEVEL_1:
                gateTimer += delta;
                if(gateTimer >= 3.0){
                    isGateClosed = !isGateClosed;
                    gateTimer = 0;
                }

                int headX = s.getHeadX();
                int headY = s.getHeadY();

                int currentTile = getTile(headX, headY, l);
                
                if(currentTile == 2){
                    return GameState.GAME_OVER;
                } else if(currentTile == 4 && isGateClosed){
                    return GameState.GAME_OVER;
                }else if (currentTile == 3){
                    return GameState.VICTORY;
                }
                
                if(!s.getState()){
                    return GameState.GAME_OVER;
                }

                return GameState.RUNNING;
                
            case LEVEL_2:
                int headX2 = s.getHeadX();
                int headY2 = s.getHeadY();

                int currentTile2 = getTile(headX2, headY2, l);
                
                if(currentTile2 == 2){
                    return GameState.GAME_OVER;
                }else if(currentTile2 == 5){ 
                      levelTwo[headY2][headX2] = 1;
                      
                      s.CrescimentoCobra();
                }else if (currentTile2 == 6){
                    levelTwo[headY2][headX2] = 1;
                }else if(currentTile2 == 4 && isGateClosed){
                    return GameState.GAME_OVER;
                }else if (currentTile2 == 3){
                    return GameState.VICTORY;
                }
                
                if(!s.getState()){
                    return GameState.GAME_OVER;
                }

                return GameState.RUNNING;
        }
        
        return GameState.MENU;
    }
    
    private int getTile(int gridX, int gridY, GameLevel l){
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
