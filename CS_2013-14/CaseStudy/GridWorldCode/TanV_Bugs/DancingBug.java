import info.gridworld.actor.Bug;

public class DancingBug extends Bug

{

   private int steps;
   private int[] turns; 
       
   public DancingBug(int[] t)
   {
      turns = t; 
      steps = 0; 
   }
   
   public void turn(int numTurns)
   {
      
      for(int x = 0; x< numTurns; x++)
         super.turn(); 
      
      
   }

   public void act()
   {
      if(steps==(turns.length))
         steps=0;
         
         turn(turns[steps]);
         steps++;
      
      
      super.act(); 
   }

}