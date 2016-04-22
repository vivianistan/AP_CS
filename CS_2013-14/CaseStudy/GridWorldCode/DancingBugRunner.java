
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;

import java.awt.Color;

public class DancingBugRunner
{
   public static void main(String[] args)
   {
      int [] steps = {1,1,2,3};
      ActorWorld world = new ActorWorld();
      DancingBug dancer =  new DancingBug(steps); 
      world.add(new Location(5, 5), dancer); 
        
      world.show();
   }
}