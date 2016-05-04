package rookie.actions;

import java.util.ArrayList;
import java.util.List;

import battlecode.common.MapLocation;
import battlecode.common.RobotController;
import battlecode.common.RobotInfo;
import battlecode.common.Team;

public class Sensing {
  
  public static RobotInfo findNearest(RobotController rc, List<RobotInfo> robots) {
    RobotInfo current = null;
    int dist = Integer.MAX_VALUE;
    for (int i = robots.size()-1; i >= 0; --i) {
      if (rc.getLocation().distanceSquaredTo(robots.get(i).location) < dist) {
        dist = rc.getLocation().distanceSquaredTo(robots.get(i).location);
        current = robots.get(i);
      }
    }
    return current;
  }
  
  
  public static List<RobotInfo> senseNearbyNeutral(RobotController rc) {
    RobotInfo[] ris = rc.senseNearbyRobots();
    List<RobotInfo> risOut = new ArrayList<>();
    for (int i = ris.length-1; i >= 0; --i) {
      if (ris[i].team == Team.NEUTRAL) {
        risOut.add(ris[i]);
      }
    }
    return risOut;
  }
  
  public static MapLocation[] senseNearbyParts(RobotController rc) {
    return rc.sensePartLocations(rc.getType().sensorRadiusSquared);
  }
  
  public static MapLocation findMaxParts(RobotController rc, MapLocation[] parts) {
    MapLocation location = null;
    double maxParts = Double.MIN_VALUE;
    for (int i = parts.length-1; i >= 0; --i) {
      double partQ = rc.senseParts(parts[i]);
      if (partQ > maxParts) {
        location = parts[i];
        maxParts = partQ;
      }
    }
    return location;
  }
}
