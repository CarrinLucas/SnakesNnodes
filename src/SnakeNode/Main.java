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
    
    private Image logo;   
    
    private Image head;
    private Image body;
    private Image tail;
    private Image curve;
    
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
        
        head.resize(BLOCK_SIZE, BLOCK_SIZE);
        body.resize(BLOCK_SIZE, BLOCK_SIZE);
        tail.resize(BLOCK_SIZE, BLOCK_SIZE);
        curve.resize(BLOCK_SIZE, BLOCK_SIZE);
        
        logo = ImageUtils.loadImage("resources/images/sprites/snakeHead.png");
        logo.resize( (int) ( logo.getWidth() * 0.1 ), (int) ( logo.getWidth() * 0.1 ) );
        setWindowIcon( logo );
        
        currentState = GameState.RUNNING;
        currentLevel = GameLevel.LEVEL_1;
        
        level = new Level();
        
        positionX = 3;
        positionY = 11;
        dxDirection = 1;
        dyDirection = 0;
        snake = new Snake(positionX, positionY);
        System.out.println("TESTE: A cobra nasceu em X=" + positionX + " e Y=" + positionY);
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
        
        if(currentState == GameState.RUNNING){
            updateSnakeMovement();
        }else if (currentState == GameState.GAME_OVER){
            if(isKeyPressed(KEY_R)){
                currentState = GameState.RUNNING;
            }
        }
        if(isKeyDown(KEY_C)){
           snake.updateSnake(delta, dxDirection, dyDirection, true);
        }else{
           snake.updateSnake(delta, dxDirection, dyDirection, false); 
        }
        currentState = level.updateLevel(delta, snake, currentLevel);
        
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

        if (currentState == GameState.RUNNING) {
            drawGameElements();
        }else if (currentState == GameState.GAME_OVER) {
            drawGameElements();
            
            fillRectangle(0, 0, 800, 450, new Color(0, 0, 0, 150));
            drawText("GAME OVER", 310, 200, 40, RED);
        }else if (currentState == GameState.VICTORY) {
            drawGameElements();
            
            fillRectangle(0, 0, 800, 450, new Color(0, 0, 0, 150));
            drawText("VICTORY!", 330, 200, 40, BLUE);
        }
    }
    
    private void updateSnakeMovement(){
        if(isKeyPressed(KEY_UP) || isKeyPressed(KEY_W) ){
            if(dyDirection != 1){
                dxDirection = 0;
                dyDirection = -1;   
            }
        }else if(isKeyPressed(KEY_DOWN) || isKeyPressed(KEY_S)){
            if(dyDirection != -1){
                dxDirection = 0;
                dyDirection = 1;
            }
        }else if(isKeyPressed(KEY_RIGHT) || isKeyPressed(KEY_D) ){
            if(dxDirection != -1){
                dxDirection = 1;
                dyDirection = 0;
            }
        }else if(isKeyPressed(KEY_LEFT) || isKeyPressed(KEY_A)){
            if(dxDirection != 1){
                dxDirection = -1;
                dyDirection = 0;
            }
        }
    }
    
    private void drawGameElements(){
        level.drawLevel(this, currentLevel);
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
