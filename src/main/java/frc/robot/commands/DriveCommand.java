package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.JoystickSubsystem;

public class DriveCommand extends CommandBase {

    private DriveSubsystem driveSys;
    private JoystickSubsystem joySys;

    public DriveCommand(DriveSubsystem driveSys, JoystickSubsystem joySys) {
        this.driveSys = driveSys;
        this.joySys = joySys;
        addRequirements(joySys);
        addRequirements(driveSys);
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    joySys.controlsInit();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    driveSys.control(joySys.getlStickV(), joySys.getrStickV(), 1);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}