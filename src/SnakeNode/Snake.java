package SnakeNode;

import br.com.davidbuzatto.jsge.core.engine.EngineFrame;
import br.com.davidbuzatto.jsge.image.Image;

/**
 *
 * @author lucas
 */
public class Snake {
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
    
    private double timer = 0;
    private double moveTime = 0.2;
    private boolean isAlive = true;
    
    private Node visualTail;
    private Node visualHead;
    private int size;
    
    public Snake (int startX, int startY){
        Node inicialNode = new Node(startX, startY);
        this.visualTail = inicialNode;
        this.visualHead = inicialNode;
        this.size = 1;
    }
    
    public void growHead(int newX, int newY){
        Node newNode = new Node(newX, newY);
        
        this.visualHead.next = newNode;
        this.visualHead = newNode;
        this.size++;
    }
    
    public void removeTail(){
        if(this.size <= 1) return;
        
        this.visualTail = this.visualTail.next;
        this.size--;
    }
    
    public void moveSnake(int endX, int endY, boolean caughtFood){
        growHead(endX, endY);
        
        if(!caughtFood)removeTail();
    }
    
    public int  getHeadX(){
        return this.visualHead.x;
    }
    
    public int getHeadY(){
        return this.visualHead.y;
    }
    
    public boolean getState(){
        return this.isAlive;
    }
    
    public void drawSnake(EngineFrame e, int dxDirection, int dyDirection, Image imgHead, Image imgBody, Image imgTail, Image imgCurve){
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
    
    private double calculateAngle(int dx, int dy){
        if (dx == 1) return 90;
        if (dy == 1) return 180;
        if (dx == -1) return 270;
        if (dy == -1) return 0; 
        return 0;
    }
    
    private double calculateCurveAngle(int prevDx, int prevDy, int nextDx, int nextDy){
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
    
    private boolean checkSelfCollision(int targetX, int targetY){
        
        Node current = this.visualTail;
        
        while(current !=null){
            if(current.x == targetX && current.y == targetY){
                return true;
            } 
            current = current.next;
        }
        
        return false;
    }
    
    public void updateSnake(double delta, int dxDirection, int dyDirection, boolean caughtFood){
        if(!isAlive) return;
        
        this.timer += delta;
        
        if(this.timer >= this.moveTime){
            int newX = this.visualHead.x + dxDirection;
            int newY = this.visualHead.y + dyDirection;
            
            if(checkSelfCollision(newX, newY)){
                this.isAlive = false;
                return;
            }
            
            moveSnake(newX, newY, caughtFood);
            this.timer = 0;
        }
    }
    
}
