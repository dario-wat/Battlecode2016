package rookie.actions;

import battlecode.common.Direction;
import battlecode.common.GameActionException;
import battlecode.common.RobotController;

public class Movement {

  public static void tryMove(RobotController rc, Direction dir) throws GameActionException {
    if (rc.isCoreReady() && rc.canMove(dir)) {
      rc.move(dir);
    }
  }
  
  public static void tryUnsafeMove(RobotController rc, Direction dir) throws GameActionException {
    if (rc.canMove(dir)) {
      rc.move(dir);
    }
  }
  
  public static void tryMove3(RobotController rc, Direction dir) throws GameActionException {
    if (!rc.isCoreReady()) {
      return;
    }
    if (rc.canMove(dir)) {
      rc.move(dir);
    } else if (rc.canMove(dir.rotateLeft())) {
      rc.move(dir.rotateLeft());
    } else if (rc.canMove(dir.rotateRight())) {
      rc.move(dir.rotateRight());
    }
  }
  
  public static void tryUnsafeMove3(RobotController rc, Direction dir) throws GameActionException {
    if (rc.canMove(dir)) {
      rc.move(dir);
    } else if (rc.canMove(dir.rotateLeft())) {
      rc.move(dir.rotateLeft());
    } else if (rc.canMove(dir.rotateRight())) {
      rc.move(dir.rotateRight());
    }
  }
  
  public static void tryMove5(RobotController rc, Direction dir) throws GameActionException {
    if (!rc.isCoreReady()) {
      return;
    }
    if (rc.canMove(dir)) {
      rc.move(dir);
    } else if (rc.canMove(dir.rotateLeft())) {
      rc.move(dir.rotateLeft());
    } else if (rc.canMove(dir.rotateRight())) {
      rc.move(dir.rotateRight());
    } else if (rc.canMove(dir.rotateLeft().rotateLeft())) {
      rc.move(dir.rotateLeft().rotateLeft());
    } else if (rc.canMove(dir.rotateRight().rotateRight())) {
      rc.move(dir.rotateRight().rotateRight());
    }
  }
  
  public static void tryUnsafeMove5(RobotController rc, Direction dir) throws GameActionException {
    if (rc.canMove(dir)) {
      rc.move(dir);
    } else if (rc.canMove(dir.rotateLeft())) {
      rc.move(dir.rotateLeft());
    } else if (rc.canMove(dir.rotateRight())) {
      rc.move(dir.rotateRight());
    } else if (rc.canMove(dir.rotateLeft().rotateLeft())) {
      rc.move(dir.rotateLeft().rotateLeft());
    } else if (rc.canMove(dir.rotateRight().rotateRight())) {
      rc.move(dir.rotateRight().rotateRight());
    }
  }

}
