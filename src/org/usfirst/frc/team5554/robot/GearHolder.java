package org.usfirst.frc.team5554.robot;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;

public class GearHolder {

	private int indicatorTimer;
	private boolean indicator = false;
	private boolean startCounting = false;
	private DigitalInput LMicroSwitch;
	private DigitalInput RMicroSwitch;
	private DigitalOutput LEDs;
	private int timer = 0;
	
	public GearHolder(int LeftMicroSwitchPort, int RightMicroSwitchPort, int LEDS_PORTS,  int indicatorTime)
	{
		LMicroSwitch = new DigitalInput(LeftMicroSwitchPort);
		RMicroSwitch = new DigitalInput(RightMicroSwitchPort);
		LEDs = new DigitalOutput(LEDS_PORTS);
		indicatorTimer = indicatorTime;
	}
	
	public void isGearIn()
	{

		if (LMicroSwitch.get() || RMicroSwitch.get()) // micro is pressed and indicator false
		{
			indicator = true; // gear is in
			startCounting = true;
			timer = 0;

		}
		else if(timer > (indicatorTimer*30))
		{
			indicator = false;
			timer = 0;
		}

		
		if(indicator)
		{
			LEDs.set(false);
		}
		else
		{
			LEDs.set(true);
		}
		
		if(startCounting)
		{
			timer++;
		}

	}
	
	
	public void SetLeds(boolean state)
	{
		LEDs.set(state);
	}
	
	
}
