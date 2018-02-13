
package org.usfirst.frc.team7273.robot.subsystems;

import org.usfirst.frc.team7273.robot.commands.DriveWithJoystick;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class Drivetrain extends Subsystem {
	//re-assign motor controller numbers correctly
	
	public static WPI_TalonSRX motorFrontRight = new WPI_TalonSRX(1);
	public static WPI_TalonSRX motorBackRight = new WPI_TalonSRX(2);
	public static WPI_TalonSRX motorFrontLeft = new WPI_TalonSRX(3);
	public static WPI_TalonSRX motorBackLeft = new WPI_TalonSRX(4);
	
	public static SpeedControllerGroup drivetrainLeft = new SpeedControllerGroup(motorFrontLeft, motorBackLeft);
	public static SpeedControllerGroup drivetrainRight = new SpeedControllerGroup(motorFrontRight, motorBackRight);
	
	public static DifferentialDrive drivetrain = new DifferentialDrive(drivetrainLeft, drivetrainRight);
	
	public void initDefaultCommand() {
		setDefaultCommand(new DriveWithJoystick());
	}
	
	public void driveWithJoystick(Joystick joystick) {
		
		/*
		 * Below for squaring inputs for better
		 * joystick control and correcting for negative values
		 */
		
		double twist = Math.pow(joystick.getTwist(), 2);
		
		if(joystick.getTwist() < 0) {
			twist = twist*-1;
		}
		
		double y = Math.pow(joystick.getY(), 2);
		
		if(joystick.getY() < 0) {
			y = y*-1;
		}
		
		drivetrain.arcadeDrive(-joystick.getY(), joystick.getTwist()*0.75);
	}
}
