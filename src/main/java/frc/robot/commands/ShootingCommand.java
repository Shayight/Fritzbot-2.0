// package frc.robot.commands;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.subsystems.ShooterSubsystem;

// public class ShootingCommand extends SequentialCommandGroup {
    
//     private ShooterSubsystem shootSys;
    
//     public ShootingCommand(ShooterSubsystem shootSys) {
//         this.shootSys = shootSys;

//         addRequirements(shootSys);

//         addCommands(
//             new SpoolMotors(shootSys), 
//             new FireDisc(shootSys)
//         );

//     }
    
// }