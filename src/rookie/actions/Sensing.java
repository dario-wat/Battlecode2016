package rookie.actions;

import java.util.ArrayList;
import java.util.List;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.Team;

public class Sensing {
  
  public static RobotInfo findNearest(RobotController rc, RobotInfo[] robots) {
    RobotInfo current = null;
    int dist = Integer.MAX_VALUE;
    for (int i = robots.length-1; i >= 0; --i) {
      if (rc.getLocation().distanceSquaredTo(robots[i].location) < dist) {
        dist = rc.getLocation().distanceSquaredTo(robots[i].location);
        current = robots[i];
      }
    }
    return current;
  }
  
  
  public static RobotInfo[] senseNearbyNeutral(RobotController rc) {
    return rc.senseNearbyRobots(rc.getType().sensorRadiusSquared, Team.NEUTRAL);
  }
  
  public static MapLocation[] senseNearbyParts(RobotController rc) {
    return rc.sensePartLocations(rc.getType().sensorRadiusSquared);
  }
  
  // TODO maybe there is a better heuristic for this, check it out, but for now
  // it is a basic working function
  public static MapLocation findMaxNearestParts(RobotController rc, MapLocation[] parts) {
    MapLocation location = null;
    double maxParts = Double.MIN_VALUE;
    int distance = Integer.MAX_VALUE;
    for (int i = parts.length-1; i >= 0; --i) {
      double partQ = rc.senseParts(parts[i]);
      if (partQ >= maxParts && rc.getLocation().distanceSquaredTo(parts[i]) < distance) {
        location = parts[i];
        maxParts = partQ;
        distance = rc.getLocation().distanceSquaredTo(parts[i]);
      }
    }
    return location;
  }
}
