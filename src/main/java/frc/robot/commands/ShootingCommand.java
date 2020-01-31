/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
//this command enaables the feeder and then the shooter in order to shoot them lemons, aim first
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj.Talon;



public class ShootingCommand extends CommandBase {
  public Talon m_feeder;
  //public Talon m_shooterLeft;
  //public Talon m_shooterRight;
  public ShootingCommand() {
   m_feeder = new Talon(5);
   //m

  }

  // Called just before this Command runs the first time
  @Override
  public void initialize() {
    //set feeder motor to max

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  public void execute() {
    //continue setting feeder motor to max
    //set shooting motors, one to max, one to max reversed
  }


  // Called once after isFinished returns true
  @Override
  public void end(boolean interrupted) {
    //set all 3 motors to zero

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  public boolean isFinished() {
    return false;
  }

}
