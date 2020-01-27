// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.CommandBase;
// import frc.robot.subsystems.ShooterSubsystem;

// public class FireDisc extends CommandBase {
//     private ShooterSubsystem shootSys;
   
//     public FireDisc(ShooterSubsystem shootSys) {
//         this.shootSys = shootSys;
//     }
    
//       // Called when the command is initially scheduled.
//   @Override
//   public void initialize() {
//       shootSys.fireFrisbee();
//   }

//   // Called every time the scheduler runs while the command is scheduled.
//   @Override
//   public void execute() {
//   }

//   // Called once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) {
//     shootSys.spoolMotors(0, 0);
//     shootSys.resetShooter();
//   }

//   // Returns true when the command should end.
//   @Override
//   public boolean isFinished() {
//     return true;
//   }

// }