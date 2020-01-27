// package frc.robot.commands;

// import edu.wpi.first.wpilibj.Timer;
// import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj2.command.CommandBase;
// // import frc.robot.subsystems.ShooterSubsystem;
// import frc.robot.subsystems.JoystickSubsystem;

// public class SpoolMotors extends CommandBase { 

//     // private ShooterSubsystem shootSys;
//     private Timer timer;
//     private Shuffleboard sb;

//     public SpoolMotors(ShooterSubsystem shootSys) {
      
//       this.shootSys = shootSys;

//       addRequirements(this.shootSys);
//     }

//  // Called when the command is initially scheduled.
//  @Override
//  public void initialize() {
//     timer = new Timer();
//  }

//  // Called every time the scheduler runs while the command is scheduled.
//  @Override
//  public void execute() {
//   shootSys.spoolMotors(1, 1);
//   timer.start();
//   SmartDashboard.putNumber("Timer", timer.get());
//  }

//  // Called once the command ends or is interrupted.
//  @Override
//  public void end(boolean interrupted) {
    
//  }

//  // Returns true when the command should end.
//  @Override
//  public boolean isFinished() {
//    return timer.get() >= 2;
//  }

// }