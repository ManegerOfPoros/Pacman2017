package org.usfirst.frc.team5554.CommandGroups;

import org.usfirst.frc.team5554.robot.Driver;
import org.usfirst.frc.team5554.CommandGroups.Commands.*;
import org.usfirst.frc.team5554.robot.RobotMap;
import org.usfirst.frc.team5554.robot.Shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Autonomous_C3 extends CommandGroup {

    public Autonomous_C3(Driver driver, Shooter shooter) {
    	addSequential(new TimedDrive(0.4 , driver , 2));
    	addSequential(new AutoSpin(RobotMap.DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT, driver));
    	addSequential(new AutoShoot(shooter));
    	
    }
}
