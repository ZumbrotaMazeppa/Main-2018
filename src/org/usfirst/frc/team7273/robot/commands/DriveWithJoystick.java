package org.usfirst.frc.team7273.robot.commands;

import org.usfirst.frc.team7273.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveWithJoystick extends Command {

	public DriveWithJoystick() {
		requires(Robot.kDrivetrain);
	}
	
	protected void initialize() {}
	
	protected void execute() {
		Robot.kDrivetrain.driveWithJoystick(Robot.m_oi.getJoystick());
	}
	
	protected boolean isFinished() {
		return false;
	}
	
	protected void end() {}
	
	protected void interrupted() {}	
}