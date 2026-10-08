package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.image.Image;

/**
 *
 * @author lucas
 */
public class Snake {
    
    /**
     * Classe Snake com a classe Node aninhada, para fazer a lista encadeada
     */
    
    public class Node {
    
        public int x;
        public int y;
        public Node  next;

        public Node (int x, int y){
            this.x = x;
            this.y = y;
            this.next = null;
        }
    }
    
    private int snakeGrowth = 0;
    private double timer = 0.2;
    private double moveTime = 0.2;
    private boolean isAlive = true;
    
    private Node visualTail;
    private Node visualHead;
    private Node deadNodes = null;
    private int size;

    
    public Snake (int startX, int startY){
        Node inicialNode = new Node(startX, startY);
        this.visualTail = inicialNode;
        this.visualHead = inicialNode;
        this.size = 1;
    }
    
    public void growHead(int newX, int newY){ //acresce um nó no topo da lista
        Node newNode = new Node(newX, newY);
        
        this.visualHead.next = newNode;
        this.visualHead = newNode;
        this.size++;
    }
    
    public void removeTail(){ //remove o último nó da lista
        if(this.size <= 1) return;
        
        this.visualTail = this.visualTail.next;
        this.size--;
    }
    
    public void snakeGrowth(){ //adiciona um nó antes do primeiro
        this.snakeGrowth++;
    }
    
    public void moveSnake(int endX, int endY, boolean caughtFood){ //controla o movimento da cobra e verifica se ela "comeu algo"
        growHead(endX, endY);
        
        if(this.snakeGrowth > 0){
            this.snakeGrowth--;
        }else if(!caughtFood)removeTail();
    }
    
    public int  getHeadX(){ //retorna a posição X do primeiro nó
        return this.visualHead.x;
    }
    
    public int getHeadY(){ //retorna a posição Y do primeiro nó
        return this.visualHead.y;
    }
    
    public boolean getState(){ //retorna se a cobra colidiu com alguma zona de morte
        return this.isAlive;
    }
    
    public int getSize() { //retorna o tamanha da lista
        int count = 0;
        Node current = this.visualTail;
        
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
    
    public void drawSnake(EngineFrame e, int dxDirection, int dyDirection, Image imgHead, Image imgBody, Image imgTail, Image imgCurve){ //desenha a cobra
        Node previous = null;
        Node current = this.visualTail;
        
        double pivotCenter = Main.BLOCK_SIZE / 2.0;
        
        while(current != null){
            Node next = current.next;
            
            double drawX = current.x * Main.BLOCK_SIZE;
            double drawY = current.y * Main.BLOCK_SIZE;
            
            if(previous == null && next != null){
                int nextDx = next.x - current.x;
                int nextDy = next.y - current.y;
                
                double angle = calculateAngle(nextDx, nextDy);
                imgTail.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
            }else if(next == null){
                double angle = calculateAngle(dxDirection, dyDirection);
                imgHead.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
            } else if(previous != null && next != null){
                int prevDx = current.x - previous.x;
                int prevDy = current.y - previous.y;
                int nextDx = next.x - current.x;
                int nextDy = next.y - current.y;
                
                if(prevDx == nextDx || prevDy == nextDy){
                    double angle = calculateAngle(nextDx, nextDy);
                    imgBody.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
                }else{
                    double angleCurve = calculateCurveAngle(prevDx, prevDy, nextDx, nextDy);
                    imgCurve.draw(e, drawX, drawY, pivotCenter, pivotCenter, angleCurve);
                }
            }
            
            previous = current;
            current = current.next;
            
        }
    }
    
    private double calculateAngle(int dx, int dy){ //calcula o angulo para rotacionar os sprites 
        if (dx == 1) return 90;
        if (dy == 1) return 180;
        if (dx == -1) return 270;
        if (dy == -1) return 0; 
        return 0;
    }
    
    private double calculateCurveAngle(int prevDx, int prevDy, int nextDx, int nextDy){ //calcula o angulo para rotacionar o sprite de curva
        if((prevDy == 1 && nextDx == 1) || (prevDx == -1 && nextDy == -1)){
            return 0;
        } else if((prevDy == -1 && nextDx == 1) || (prevDx == -1 && nextDy == 1)){
        return 90;
        }else if((prevDy == -1 && nextDx == -1) || (prevDx == 1 && nextDy == 1)){
            return 180;
        }else if((prevDy == 1 && nextDx == -1) || (prevDx == 1 && nextDy == -1)){
            return 270;
        }
        return 0;
    }
    
    private boolean checkSelfCollision(int targetX, int targetY){ //verifica se ela bateu em si mesma
        
        Node current = this.visualTail;
        
        while(current !=null){
            if(current.x == targetX && current.y == targetY){
                return true;
            } 
            current = current.next;
        }
        
        return false;
    }

    public void updateSnake(double delta, int dxDirection, int dyDirection, boolean caughtFood, boolean wantsToMove) { //atualiza o movimento e o estado da cobra
        if (!isAlive) return;
        
        this.timer += delta;
        
        if (this.timer >= this.moveTime) {
            
            if (wantsToMove) {
                int newX = this.visualHead.x + dxDirection;
                int newY = this.visualHead.y + dyDirection;
                
                if (checkSelfCollision(newX, newY)) {
                    this.isAlive = false;
                    return;
                }
                
                moveSnake(newX, newY, caughtFood);
                this.timer = 0;
                
            } else {
                this.timer = this.moveTime;
            }
        }
    }
    
    public boolean isOccupying(int targetX, int targetY) { //verifica se ela está em determinado bloco
        Node current = this.visualTail;
        while(current != null){
            if(current.x == targetX && current.y == targetY){
                return true;
            } 
            current = current.next;
        }
        return false;
    }
    
    public void cutSnake(int[][] map) { //divide a lista
        if (this.size <= 1) return;
        
        this.deadNodes = this.visualTail;
        
        Node current = this.visualTail;
        while (current != this.visualHead) { 
            
            int dropX = current.x;
            int dropY = current.y;
            
            if (map[dropY][dropX] == 7) {
                map[dropY][dropX] = 11;
            } else if (map[dropY][dropX] == 1) {
                map[dropY][dropX] = 10;
            }
            
            if (current.next == this.visualHead) {
                current.next = null;
                break;
            }
            current = current.next;
        }
        
        this.visualTail = this.visualHead;
        this.size = 1;
    }
    
    public void drawDeadSnake(EngineFrame e, Image imgBody, Image imgTail, Image imgCurve) { //desenha o pedaço da lista que foi cortado
        if (this.deadNodes == null) return;
        
        Node previous = null;
        Node current = this.deadNodes;
        double pivotCenter = Main.BLOCK_SIZE / 2.0;
        
        while (current != null) {
            Node next = current.next;
            double drawX = current.x * Main.BLOCK_SIZE;
            double drawY = current.y * Main.BLOCK_SIZE;
            
            if (previous == null && next != null) {
                int nextDx = next.x - current.x;
                int nextDy = next.y - current.y;
                double angle = calculateAngle(nextDx, nextDy);
                imgTail.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
            } else if (next == null && previous != null) { 
                int prevDx = current.x - previous.x;
                int prevDy = current.y - previous.y;
                double angle = calculateAngle(prevDx, prevDy);
                imgBody.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
            } 
            else if (previous != null && next != null) { 
                int prevDx = current.x - previous.x;
                int prevDy = current.y - previous.y;
                int nextDx = next.x - current.x;
                int nextDy = next.y - current.y;
                
                if (prevDx == nextDx || prevDy == nextDy) {
                    double angle = calculateAngle(nextDx, nextDy);
                    imgBody.draw(e, drawX, drawY, pivotCenter, pivotCenter, angle);
                } else {
                    double angleCurve = calculateCurveAngle(prevDx, prevDy, nextDx, nextDy);
                    imgCurve.draw(e, drawX, drawY, pivotCenter, pivotCenter, angleCurve);
                }
            } else if (previous == null && next == null) { 
                imgBody.draw(e, drawX, drawY);
            }
            
            previous = current;
            current = current.next;
        }
    }
    
}
