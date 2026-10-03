package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.core.utils.CoreUtils;
import br.com.davidbuzatto.jsge.core.utils.DrawingUtils;
import br.com.davidbuzatto.jsge.geom.Rectangle;
import br.com.davidbuzatto.jsge.image.Image;
import br.com.davidbuzatto.jsge.image.ImageUtils;

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
    private int posicaoX = 12; //era pra colocar a imagem no meio (não funcionou)
    private int posicaoY = 7;
    private int dxDirection = 1;
    private int dyDirection = 0;
    private double timer = 0;
    private double TempoMovimento = 0.2;
    
    
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
        
        logo = ImageUtils.loadImage("resources/images/sprites/snakeHead.png");
        logo.resize( (int) ( logo.getWidth() * 0.1 ), (int) ( logo.getWidth() * 0.1 ) );
        setWindowIcon( logo );
        
        snake = new Snake(posicaoX, posicaoY);
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
        
        if(isKeyPressed(KEY_UP) && dyDirection != 1){
            dxDirection = 0;
            dyDirection = -1;
        }
        else if(isKeyPressed(KEY_DOWN) && dyDirection != -1){
            dxDirection = 0;
            dyDirection = 1;
        }
        else if(isKeyPressed(KEY_RIGHT) && dxDirection != -1){
            dxDirection = 1;
            dyDirection = 0;
        }
        else if(isKeyPressed(KEY_LEFT) && dxDirection != 1){
            dxDirection = -1;
            dyDirection = 0;
        }
        
        timer += delta;
        
       if ( timer >= TempoMovimento ) {
             
        int cabecaAtualX = snake.getHeadX();
        int cabecaAtualY = snake.getHeadY();
        
        int novoX = cabecaAtualX + dxDirection;
        int novoY = cabecaAtualY + dyDirection;
        
        snake.moveSnake(novoX, novoY, false);
       
        timer = 0;
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

        snake.drawSnake(this, 32, dxDirection, dyDirection, head, body, tail, curve);
               
        drawFPS( 20, 20 );
    
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
