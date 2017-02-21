package org.usfirst.frc.team5554.robot;

import org.usfirst.frc.team5554.Controllers.Motor;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick.AxisType;

public class Driver extends RobotDrive
{
	private Encoder leftEncoder;
	private Encoder rightEncoder;
	private ADXRS450_Gyro gyro;
	private boolean isInvert = true;
	
	private boolean isEnabled = true;
	
	
	/**
	 * The constructor configurates the motors objects to certain ports
	 * @since 15/1/2017
	 * @param MOTOR_LEFT port for left motor
	 * @param MOTOR_RIGHT port for right motor
	 * Author: Gil Meri
	 */
	public Driver(Motor left, Motor right , Encoder leftEnc, Encoder rightEnc, ADXRS450_Gyro gyro) 
	{			
		super(left , right);	
		
		setSafetyEnabled(false);
		
		this.leftEncoder = leftEnc;
		this.rightEncoder = rightEnc;
		
		this.gyro = gyro;		
	}
	
	/**
	 * This function in charge of the movement of the robot with the joystick
	 * @since 15/1/2017
	 * @param y The value of the joystick's y axis
	 * @param x The value of the joystick's x axis (used for turns instead of z)
	 * @param slider The value of the joystick's slider axis
	 * @author Gil Meri
	 */
	public void Moving(double slider, Joystick joy) 
	{
		m_rearLeftMotor.setInverted(false);
		m_rearRightMotor.setInverted(false);
		
		joy.setAxisChannel(AxisType.kX, 2);
		joy.setAxisChannel(AxisType.kZ, 0);
		
		if(isEnabled)
		{
			slider = (-slider+1)/2;
			
			//Gives us freedom to manipulte the front of the robot.
			//If +slider and -slider can change the front of the motor since
			//they determine if the scalar is from 0-1 or from -1 to 0.
			
			if(isInvert == false)
			{
				setMaxOutput(slider);
			}
			else
			{
				setMaxOutput(-slider);
			}
			
			arcadeDrive(joy);
		}
		
	}
	
	public void autonomousDrive(double speed , double curve)
	{
		drive(speed, curve);
	}
	
	
	public void Spin(double degrees , boolean invertLeft, boolean invertRight)
	{			
		if(isEnabled)
		{
			gyro.reset();
		
			((Motor)this.m_rearLeftMotor).SetFeedbackDevice(gyro);
			((Motor)this.m_rearRightMotor).SetFeedbackDevice(gyro);
		
			((Motor)this.m_rearRightMotor).SetPIDType(PIDSourceType.kDisplacement);
			((Motor)this.m_rearLeftMotor).SetPIDType(PIDSourceType.kDisplacement);		
		
			((Motor)this.m_rearRightMotor).SetPID(0.008, 0.0001, 0.003);
			((Motor)this.m_rearLeftMotor).SetPID(0.008, 0.0001, 0.003);
		
			((Motor)this.m_rearRightMotor).GoDistance(degrees , invertRight);
			((Motor)this.m_rearLeftMotor).GoDistance(degrees , invertLeft);
		}
	}	
	
	public void DriveDistance(double leftDistance, double rightDistance, boolean invertDriver)
	{
		if(isEnabled)
		{
			((Motor)this.m_rearRightMotor).SetFeedbackDevice(rightEncoder);
			((Motor)this.m_rearLeftMotor).SetFeedbackDevice(leftEncoder);
			
			((Motor)this.m_rearRightMotor).SetPIDType(PIDSourceType.kDisplacement);
			((Motor)this.m_rearLeftMotor).SetPIDType(PIDSourceType.kDisplacement);
			
			((Motor)this.m_rearRightMotor).SetPID(1, 0.001, 2);
			((Motor)this.m_rearLeftMotor).SetPID(1, 0.001, 2);
			
			((Motor)this.m_rearRightMotor).GoDistance(rightDistance , invertDriver);
			((Motor)this.m_rearLeftMotor).GoDistance(leftDistance , invertDriver);
		}
	}

	public boolean LeftOnTarget(double tolerance)
	{
		return ((Motor)this.m_rearLeftMotor).onTarget(tolerance);
	}
	
	public boolean RightOnTarget(double tolerance)
	{
		return ((Motor)this.m_rearRightMotor).onTarget(tolerance);
	}
	
	public void enable()
	{
		this.isEnabled = true;
	}
	
	public void disable()
	{
		this.isEnabled = false;
	}
	
	public void disController()
	{
		((Motor)this.m_rearRightMotor).disController();
		((Motor)this.m_rearLeftMotor).disController();
	}
	
	public double GetError()
	{
		return ((Motor)this.m_rearRightMotor).GetError();
	}
	
	public double GetAngle()
	{
		return gyro.getAngle();
	}
	
	public void ResetGyro()
	{
		gyro.reset();
	}

}
