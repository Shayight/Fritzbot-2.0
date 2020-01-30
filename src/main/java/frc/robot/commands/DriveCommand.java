package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.utils.OI;

public class DriveCommand extends CommandBase {

    private DriveSubsystem driveSys;
    private OI oi;

    public DriveCommand(DriveSubsystem driveSys, OI oi) {
        this.driveSys = driveSys;        
        addRequirements(driveSys);

        this.oi = oi;
        oi = new OI();
    }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    oi.controlsInit();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    
    driveSys.control(oi.getlStickV(), oi.getrStickV(), 1);
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