package rookie;

import java.util.List;

import battlecode.common.Clock;
import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import rookie.actions.Movement;
import rookie.actions.Sensing;

public class Archon {

  public static void run(RobotController rc) throws GameActionException {
    //TODO remember that you can have stuff that is ran only once in the beginning and then
    // for loop that cna have several steps, before, main and after and so on whatever
    while (true) {   
//    int byc = Clock.getBytecodeNum(); 
    //TODO maybe use single isCoreReady and then unsafe functions
    RobotInfo[] robots = Sensing.senseNearbyNeutral(rc);
    RobotInfo nearestNeutral = Sensing.findNearest(rc, robots);
    if (nearestNeutral != null) {
      if (rc.isCoreReady() && rc.getLocation().isAdjacentTo(nearestNeutral.location)) {
        rc.activate(nearestNeutral.location);
      } else {
        Movement.tryMove3(rc, rc.getLocation().directionTo(nearestNeutral.location));
      }
      Clock.yield();
    } else {
      MapLocation[] parts = Sensing.senseNearbyParts(rc);
      MapLocation maxParts = Sensing.findMaxNearestParts(rc, parts);
      if (maxParts != null) {
        Movement.tryMove3(rc, rc.getLocation().directionTo(maxParts));
      } else { 
        Movement.tryMove3(rc, Direction.EAST);
      }
      
    Clock.yield();
    }
      try {
//        Movement.tryMove3(rc, Direction.EAST);
//        Clock.yield();
//          int fate = rand.nextInt(1000);
//          // Check if this ARCHON's core is ready
//          if (fate % 10 == 2) {
//              // Send a message signal containing the data (6370, 6147)
//              rc.broadcastMessageSignal(6370, 6147, 80);
//          }
//          Signal[] signals = rc.emptySignalQueue();
//          if (signals.length > 0) {
//              // Set an indicator string that can be viewed in the client
//              rc.setIndicatorString(0, "I received a signal this turn!");
//          } else {
//              rc.setIndicatorString(0, "I don't any signal buddies");
//          }
//          if (rc.isCoreReady()) {
//              if (fate < 800) {
//                  // Choose a random direction to try to move in
//                  Direction dirToMove = directions[fate % 8];
//                  // Check the rubble in that direction
//                  if (rc.senseRubble(rc.getLocation().add(dirToMove)) >= GameConstants.RUBBLE_OBSTRUCTION_THRESH) {
//                      // Too much rubble, so I should clear it
//                      rc.clearRubble(dirToMove);
//                      // Check if I can move in this direction
//                  } else if (rc.canMove(dirToMove)) {
//                      // Move
//                      rc.move(dirToMove);
//                  }
//              } else {
//                  // Choose a random unit to build
//                  RobotType typeToBuild = robotTypes[fate % 8];
//                  // Check for sufficient parts
//                  if (rc.hasBuildRequirements(typeToBuild)) {
//                      // Choose a random direction to try to build in
//                      Direction dirToBuild = directions[rand.nextInt(8)];
//                      for (int i = 0; i < 8; i++) {
//                          // If possible, build in this direction
//                          if (rc.canBuild(dirToBuild, typeToBuild)) {
//                              rc.build(dirToBuild, typeToBuild);
//                              break;
//                          } else {
//                              // Rotate the direction to try
//                              dirToBuild = dirToBuild.rotateLeft();
//                          }
//                      }
//                  }
//              }
//          }
//
//          Clock.yield();
      } catch (Exception e) {
          System.out.println(e.getMessage());
          e.printStackTrace();
      }
  }

  }
}
