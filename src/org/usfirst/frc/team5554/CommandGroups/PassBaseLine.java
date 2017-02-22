package org.usfirst.frc.team5554.CommandGroups;

import org.usfirst.frc.team5554.CommandGroups.Commands.*;
import org.usfirst.frc.team5554.robot.Driver;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class PassBaseLine extends CommandGroup
{
	public PassBaseLine(Driver driver)
	{
		addSequential(new TimedGyroDrive(0.5, driver , 2.5));
		
	}
}
