package org.usfirst.frc.team6201.robot.subsystems;

import org.usfirst.frc.team6201.robot.RobotMap;

import dataLogger.DataCollator;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

/**
 *
 *@author David Matthews
 *@author Max Nadeau
 *
 * The subsystem for controlling the ball picking up device. 
 */
public class Roller extends PIDSubsystem {
	private Spark motor = new Spark (RobotMap.ROLLER);
	public Timer timer = new Timer();
	
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	public static double P = 0;
	public static double I = 0;
	public static double D = 0;
	public Roller(){
		super ("Roller", P, I, D);
	}
	
    public void initDefaultCommand() {

    }
    
    public void roll(double power){
    	motor.set(power);
    	DataCollator.motorRoller.setVal(power);
    }
    
    public void stop(){
    	roll(0.0);
    }

	@Override
	protected double returnPIDInput() {
		return 0;
	}

	@Override
	protected void usePIDOutput(double arg0) {
	}
}

