package org.usfirst.frc.team5554.CommandGroups.Commands;

import org.usfirst.frc.team5554.robot.Driver;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutoSpin extends Command 
{
	
	int degrees;
	Driver driver;
	
    public AutoSpin(int degrees, Driver driver)
    {
    	super("Auto Spin");
    	this.degrees = degrees;
    	this.driver = driver;
    }

	@Override
    protected void initialize() 
	{
    	driver.Spin(degrees , true, false);
    }

	@Override
	protected boolean isFinished()
	{
		if(driver.LeftOnTarget(0.1) && driver.RightOnTarget(0.1))
		{
	    	System.out.printf("Spinned %d degrees", degrees);
			return true;
		}
		else 
		{
			return false;
		}
	}

}
