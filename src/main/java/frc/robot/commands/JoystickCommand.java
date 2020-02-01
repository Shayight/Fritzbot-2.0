package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.utils.OI;

public class JoystickCommand extends CommandBase {

    public Joystick dualShock;
    public OI oi;
    private DriveSubsystem driveSys;
    // private ShooterSubsystem shooterSys;
    // private ShootingCommand scomm;

    public JoystickCommand(DriveSubsystem driveSys, OI oi) {
        driveSys = this.driveSys;
        // shooterSys = this.shooterSys; // Buggy code
        oi = this.oi;
        // scomm = this.scomm;
            /**
            new JoystickButton(dualShock, 1)
              .whenPressed(() -> driveSys.highGear());
            new JoystickButton(dualShock, 2)
              .whenPressed(() -> toggleShooter());
            new JoystickButton(dualShock, 3)
              .whenPressed(() -> toggleRelay());
            new JoystickButton(dualShock, 4)
              .whenPressed(() -> driveSys.lowGear());
            new JoystickButton(dualShock, 5)
              .whenPressed(() -> scomm.execute());
            new JoystickButton(dualShock, 6)
              .whenPressed(() -> driveSys.resetGyro());
            //new JoystickButton(dualShock, 7)
            //  .whenPressed(() -> limelight.setLedMode(LightMode.eOff));
            */
            if(oi.getSquare())
              driveSys.highGear();
            // else if(oi.getCross())
            //   toggleShooter();
            // else if(oi.getCircle())
            //   toggleRelay();
            else if(oi.getTriangle())
              driveSys.lowGear();
            // else if(oi.getlBumper())
            //   scomm.execute();
            else if(oi.getrBumper())
              driveSys.resetGyro();

    }

    // public void toggleShooter() {
    //     //isLifted = !isLifted;
    //     if(!shooterSys.isUp()) {
    //       shooterSys.liftShooter();
    //     }else {
    //       shooterSys.dropShooter();
    //     }
    //   }
    
      // public void toggleRelay() {
      //   if(!shooterSys.isRelayOn()){
      //     shooterSys.startRelay();
      //   }else {
      //     shooterSys.stopRelay();
      //   }
      // }

    // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
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