package org.usfirst.frc.team6201.robot.commands;

import org.usfirst.frc.team6201.robot.Robot;
import org.usfirst.frc.team6201.robot.RobotMap;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 * @author David Matthews
 */

//TODO: add comments, clean up
public class DriveTimeCmd extends Command {

	
	private double calibrated;
	// how long have we been driving?
	private Timer timer = new Timer ();
	
	// how long do we want to drive?
	private double drivingTime;
	
    public DriveTimeCmd(double drivingTime) {
        this.drivingTime = drivingTime;
        requires(Robot.dt);
    }

    protected void initialize() {
    	//we start driving
    	timer.start ();

// replaced with calibration in  int of robot.    	
//    	// this was added after reading. Untesting on the Field management system.
//    	Robot.dt.calibrateGyro();

    	timer.reset();
    	dataLogger.DataCollator.state.setVal("DriveTimeCmdInit");
    }

    protected void execute() {
    	dataLogger.DataCollator.state.setVal("DriveTimeCmdExecute");
    	
    	while(timer.get()< drivingTime){
    		calibrated = ((0.8 - 0.05*Robot.dt.getGyroRate())*0.05); // uses the gyro as a feedback loop to drive at the desired turn rate. 
    		System.out.println("driving");
    		Robot.dt.driveLR(0.50, 0.5);
    	}

    }

    protected boolean isFinished() {
        
  // have we been driving as long as we want to
    	return true;
    }

    protected void end() {
    	System.out.println("Done");
    	Robot.dt.stop();
    }


    protected void interrupted() {
    	this.end();
    }
}
