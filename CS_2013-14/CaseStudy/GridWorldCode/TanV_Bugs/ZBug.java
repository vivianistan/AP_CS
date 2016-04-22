import info.gridworld.actor.Bug;

public class ZBug extends Bug

{
   private int steps;
   private int sideLength;
   int sideNum, total;
    
   public ZBug(int size)
   {
      steps = 0; 
      sideLength = size; 
      sideNum = 0;
      total = (sideLength)*3 ;
  
   }

   public void act()
   {

      
      
      
      if (steps < sideLength && canMove() && total>0)
      {
         if(getDirection() == 0)
         {
            turn();
            turn();
         }
         move(); 
         
         steps++;
         total--;
      } 
      
      else
      {
         if(getDirection()==90 && sideNum<2 && total>0)
         {
            sideNum++;
            turn();
            turn();
            turn(); 
         }
         
         else if( sideNum<2 && total>0)
         {
            setDirection(90);
            sideNum++;
         }
         
         else if(total>0)
         {
            sideNum=0; 
            move();
            total--;
         }
         else if(!canMove())
         {
         }
            
         steps=0; 
      }
   }
}

