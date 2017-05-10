package org.usfirst.frc.team5554.CommandGroups;

import org.usfirst.frc.team5554.CommandGroups.Commands.*;
import org.usfirst.frc.team5554.robot.Driver;
import org.usfirst.frc.team5554.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

public class PlaceFrontGear extends CommandGroup {

    public PlaceFrontGear(Driver driver) 
    {
    	///////////////////////////////RightEnc////////////////////////////////
		driver.CalibrateGyro();
		addSequential(new Timeout(0.1));
		addSequential(new DistanceGyroDrive(0.35, driver , RobotMap.DISTANCE_FROM_ALLIANCE_WALL_TO_AIRSHIP));

//    	///////////////////////////////LeftEnc////////////////////////////////
//		driver.CalibrateGyro();
//		addSequential(new Timeout(0.1));
//		addSequential(new DistanceGyroDrive(0.35, driver , RobotMap.DISTANCE_FROM_ALLIANCE_WALL_TO_AIRSHIP+7.5));

    }
}
