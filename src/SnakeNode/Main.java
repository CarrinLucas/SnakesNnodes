package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import br.com.davidbuzatto.jsge.image.ImageUtils;
import java.awt.Color;

/**
 * Modelo de projeto básico da JSGE.
 * 
 * JSGE basic project template.
 * 
 * @author Prof. Dr. David Buzatto
 */
public class Main extends EngineFrame {
   
    /**
     * Insanciando os objetos globais e sprites a serem usados
     */
    
    private Image logo;   
    
    private Image head;
    private Image body;
    private Image tail;
    private Image curve;
    
    private Image imgMenu;
    private Image imgVic1;
    private Image imgVic2;
    private Image imgGO;
    
    private Snake snake;
    private int positionX;
    private int positionY;
    private int dxDirection;
    private int dyDirection;
    
    private Level level;
    
    private GameState currentState;
    private GameLevel currentLevel;
    
    public static final int BLOCK_SIZE = 32;
    
    public Main() {
        
        super(
            800,                 // largura                      / width
            450,                 // algura                       / height
            "Snakes 'n Nodes",      // título                       / title
            60,                  // quadros por segundo desejado / target FPS
            true,                // suavização                   / antialiasing
            false,               // redimensionável              / resizable
            false,               // tela cheia                   / full screen
            false,               // sem decoração                / undecorated
            false,               // sempre no topo               / always on top
            false                // fundo invisível              / invisible background
        );
        
    }
    
    /**
     * Cria o mundo do jogo.
     * Esse método executa apenas uma vez durante a inicialização da engine.
     * 
     * Creates the game world.
     * This method runs just one time during engine initialization.
     */
    @Override
    public void create() {
        
        head = ImageUtils.loadImage("resources/images/sprites/snakeHead.png");
        body = ImageUtils.loadImage("resources/images/sprites/snakeBody.png");
        tail = ImageUtils.loadImage("resources/images/sprites/snakeTail.png");
        curve = ImageUtils.loadImage("resources/images/sprites/snakeCurve.png");
        
        imgMenu = ImageUtils.loadImage("resources/images/screens/inicialScreen.png");
        imgVic1 = ImageUtils.loadImage("resources/images/screens/victoryScreenLvl1.png");
        imgVic2 = ImageUtils.loadImage("resources/images/screens/victoryScreenLvl2.png");
        imgGO = ImageUtils.loadImage("resources/images/screens/gameOverScreen.png");
        
        head.resize(BLOCK_SIZE, BLOCK_SIZE);
        body.resize(BLOCK_SIZE, BLOCK_SIZE);
        tail.resize(BLOCK_SIZE, BLOCK_SIZE);
        curve.resize(BLOCK_SIZE, BLOCK_SIZE);
        
        logo = ImageUtils.loadImage("resources/images/sprites/snakeHead.png");
        logo.resize( (int) ( logo.getWidth() * 0.1 ), (int) ( logo.getWidth() * 0.1 ) );
        setWindowIcon( logo );
        
        currentState = GameState.MENU;
        currentLevel = GameLevel.LEVEL_1;
        
        level = new Level();
        
        positionX = 3;
        positionY = 11;
        dxDirection = 1;
        dyDirection = 0;
        snake = new Snake(positionX, positionY);
    }

    /**
     * Lê a entrada do usuário e atualiza o mundo do jogo.
     * Os métodos de entrada devem ser usados aqui.
     * Atenção: Você NÃO DEVE usar nenhum dos métodos de desenho da engine aqui.
     * 
     * Reads user input and update game world.
     * Input methods should be used here.
     * Warning: You MUST NOT use any of the engine drawing methods here.
     * 
     * @param delta O tempo passado, em segundos, de um quadro para o outro.
     * Time passed, in seconds, between frames.
     */
    @Override
    public void update( double delta ) {
        
        if(currentState == GameState.MENU){     //controle dos estados do jogo, MENU, RUNNING, VICTORY e GAME_OVER
            if(isKeyPressed(KEY_R)){
                currentState = GameState.RUNNING;
            }
        }else if (currentState == GameState.RUNNING) {
            
            boolean wantsToMove = updateSnakeMovement();
            snake.updateSnake(delta, dxDirection, dyDirection, false, wantsToMove);
            currentState = level.updateLevel(delta, snake, currentLevel);
            
        } else if (currentState == GameState.VICTORY ) {        
            if (isKeyPressed(KEY_ENTER)) {              
                if (currentLevel == GameLevel.LEVEL_1) {
                    currentLevel = GameLevel.LEVEL_2;
                    currentState = GameState.RUNNING;
                    
                    level = new Level(); 
                    snake = new Snake(3, 11);
                    
                } else if (currentLevel == GameLevel.LEVEL_2) {
                    System.exit(0); 
                }
            }
            
        } else if (currentState == GameState.GAME_OVER) {    //após um game over, o jogo reinicia ao apertar R
            if (isKeyPressed(KEY_R)) {
                currentState = GameState.RUNNING;        
                level = new Level(); 
                snake = new Snake(3, 11);
            }
        }
        
    }
    
    /**
     * Desenha o mundo do jogo.
     * Todas as operações de desenho DEVEM ser feitas aqui.
     * 
     * Draws the game world.
     * All drawing related operations MUST be performed here.
     */
    @Override
    public void draw() {
        clearBackground( WHITE );
        
        if(currentState == GameState.MENU){ //desenha a tela baseado no estado do jogo
            imgMenu.draw(this, 0, 0);
        }else if (currentState == GameState.RUNNING){
            drawGameElements();
        }else if (currentState == GameState.GAME_OVER) {
            drawGameElements();
            imgGO.draw(this, 0, 0);
        }else if (currentState == GameState.VICTORY) {
            drawGameElements();
            
            if(currentLevel == GameLevel.LEVEL_1){
                imgVic1.draw(this, 0, 0);
            }else{
                imgVic2.draw(this, 0, 0);
            }
        }
    }
    
    private boolean updateSnakeMovement(){          //controla os movimentos da cobra
        boolean moved = false;
        
        if((isKeyDown(KEY_UP) || isKeyDown(KEY_W)) && dyDirection != 1){
            dxDirection = 0;
            dyDirection = -1;
            moved = true;
        }
        else if((isKeyDown(KEY_DOWN) || isKeyDown(KEY_S)) && dyDirection != -1){
            dxDirection = 0;
            dyDirection = 1;
            moved = true;
        }
        else if((isKeyDown(KEY_RIGHT) || isKeyDown(KEY_D)) && dxDirection != -1){
            dxDirection = 1;
            dyDirection = 0;
            moved = true;
        }
        else if((isKeyDown(KEY_LEFT) || isKeyDown(KEY_A)) && dxDirection != 1){
            dxDirection = -1;
            dyDirection = 0;
            moved = true;
        }
        
        return moved;
    }
    
    private void drawGameElements(){        //desenha o nível e a cobra
        level.drawLevel(this, currentLevel);
        snake.drawDeadSnake(this, body, tail, curve);
        snake.drawSnake(this, dxDirection, dyDirection, head, body, tail, curve);
    }
    
    /**
     * Instancia a engine e a inicia.
     * 
     * Instantiates the engine and starts it.
     */
    public static void main( String[] args ) {
        new Main();
    }
    
}
