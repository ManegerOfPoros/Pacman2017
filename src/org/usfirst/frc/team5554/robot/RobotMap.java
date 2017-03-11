package org.usfirst.frc.team5554.robot;

import edu.wpi.first.wpilibj.SPI;

public class RobotMap {

/*******************Motor Ports**************************************************************************/
    
	public final static int MOTOR_LEFT = 0;
    public final static int MOTOR_RIGHT = 1;
    public final static int MOTOR_FEEDER = 3;
    public final static int MOTOR_SHOOTER_ZERO = 0;
    public final static int MOTOR_SHOOTER_ONE = 1;
    public final static int MOTOR_SCRAMBLE = 2;
	public final static int MOTOR_CLIMBER_ONE = 4;
	public final static int MOTOR_CLIMBER_TWO = 5;
    
/*******************Joystick Ports***************************************************************/
   
	public final static int DRIVER_JOYSTICK_PORT = 0;
    public final static int DRIVER_XBOXJOYSTICK_PORT = 1;
    
/****************************IO for Joysticks*******************************************************/    
  
    //Joystick Controller
    public final static int JOYSTICK_Y_AXIS = 1; // Forward and backward joystick axis
    public final static int JOYSTICK_Z_AXIS = 2; // Spinning joystick controller axis
	public final static int JOYSTICK_X_AXIS = 0;
    public final static int JOYSTICK_SLIDER_AXIS = 3; // Slider
    public final static int JOYSTICK_FEEDER_BUTTON = 1; // Joystick trigger
    public final static int JOYSTICK_FEEDER_REVERSE_BUTTON = 6; // Joystick Button for realising stuck balls
    public final static int JOYSTICK_CAM_SWITCH = 2; // Thumb button
    public final static int JOYSTICK_SHOW_GEARGL = 3;
    public final static int JOYSTICK_SHOW_SYSCAM = 4;
    
    //XBOX Controller
    public final static int XBOX_JOYSTICK_SYS_CAMERA = 1;
    public final static int XBOX_JOYSTICK_AUTO_SHOOT = 3; // RT Axis
    public final static int XBOX_JOYSTICK_SHOOTER_BACKWARD = 6;  // RB Button
    public final static int XBOX_JOYSTICK_SCRAMBLE_FORWARD = 2; // LT Axis
    public final static int XBOX_JOYSTICK_SCRAMBLE_BACKWARD = 5; // LB Button
    public final static int XBOX_JOYSTICK_SHOOTER_DASHBOARD_GUIDELINES = 1; // A Button
    public final static int XBOX_CLIMB_BUTTON = 4; // Start Button
    public final static int XBOX_REVERSE_CLIMB_BUTTON = 7;
    
/*******************Sensors ports****************************************************************/
    
    public final static int LEFT_ENCODER_CHANNELA = 0;
    public final static int LEFT_ENCODER_CHANNELB = 1;
    public final static int RIGHT_ENCODER_CHANNELA = 2;
    public final static int RIGHT_ENCODER_CHANNELB = 3;
    public final static int SHOOTER_ENCODER_CHANNELA = 1;
    public final static int SHOOTER_ENCODER_CHANNELB = 2;
    public final static int GEAR_MICROSWITCH_PORT =  8;
    public final static int LEDS_PORT =  7;
    public static final SPI.Port GYRO_PORT  = SPI.Port.kOnboardCS0;
    
/*****************Encoder Values*********************************************************/
    
    public final static double PERIMETER_OF_LEFT = 21*3.14;
    public final static double PERIMETER_OF_RIGHT = 24*3.14;
    public final static double ENCODER_ROUNDS_PER_REVOLUTION = 360;
    public final static double PID_VALUE_P = 0.08746; //0.08746
    public final static double PID_VALUE_I = 0;	//0.00
    public final static double PID_VALUE_D = 0.015; //0.014
    public final static double PID_VALUE_F = 0.1;
    public final static double PID_SPEED = 0.57;    //0.62
    
/*******************Autonomous Measurement***********************************************/
   
    public final static double DISTANCE_TO_AIRSHIP_FROM_SIDE = 281.35;
    public final static int DISTANCE_TO_BASELINE_FROM_START = 237;
    public final static int DISTANCE_TO_AIRSHIP_FROM_BASELINE = 44;
    public final static int DISTANCE_TO_HOPPER_FROM_BASELINE = 0; //TODO: Add a real measured value!
    public final static int ROBOT_WIDTH = 101;
    public final static int ROBOT_LENGTH = 91;
    public final static int ROBOT_HEIGHT = 60;
    public final static int DEGREES_TO_TURN_FROM_SIDES_TO_SHOOT = 0; //TODO: Add a real measured value!
    public final static int DEGREES_TO_TURN_TO_AIRSHIP = 0; //TODO: Add a real measured value!
    
/*******************Cameras Values***************************************************/
    
    public final static int NUMBER_OF_CAMERAS = 3;
    public final static int FRONT_CAMERA_IDX = 1;
    public final static int SYSTEMS_CAMERA_IDX = 0;
    public final static int SHOOTER_CAMERA_IDX = 2;
    public final static double FOCAL_LENGTH = 334.595;
    public final static double BOILER_WIDTH = 61;

}

