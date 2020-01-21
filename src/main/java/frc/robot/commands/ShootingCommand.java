package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.JoystickSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

public class ShootingCommand extends SequentialCommandGroup {
    private ShooterSubsystem shootSys;
    private JoystickSubsystem joySys;
    public ShootingCommand() {
        addCommands(
            new SpoolMotors(shootSys, joySys), new FireDisc(shootSys)
        );
    }
    
}