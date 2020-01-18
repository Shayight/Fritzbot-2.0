package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;;

public class ShootCommand extends CommandBase { 

    private final ShooterSubsystem m_shootSys;

    public ShootCommand(ShooterSubsystem shootSys) {

        m_shootSys = shootSys;

        addRequirements(shootSys);

        initialize(shootSys); 
    }

    public void initialize(ShooterSubsystem shootSys) {
        shootSys.spoolMotors(1,1);
    }

}