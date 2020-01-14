/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.CameraSubsystem.CameraMode;
import frc.robot.subsystems.CameraSubsystem.LightMode;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;



/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
  public Joystick dualShock;
  public Joystick dualShock2;
  //public Talon FL,FR,RL,RR;
  //public DifferentialDrive drive;
  //public SpeedControllerGroup leftSide;
  //public SpeedControllerGroup rightSide;
  private RobotContainer m_robotContainer;
  private DriveSubsystem driveSys;
  private ShooterSubsystem shooterSys;
  private CameraSubsystem limelight;

  /**public static enum LightMode {
		eOn, eOff, eBlink
  }
  
	public static enum CameraMode {
		eVision, eDriver
	} */




  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_robotContainer = new RobotContainer();
    dualShock = new Joystick(0);
    dualShock2 = new Joystick(1);
    driveSys = new DriveSubsystem(4, 1, 3, 2);
    shooterSys = new ShooterSubsystem(2, 3, 5, 6, 5, 0, 0);
    limelight = new CameraSubsystem();
    limelight.Vision();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
  }

  /**
   * This autonomous runs the autonomous command selected by your {@link RobotContainer} class.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getAutonomousCommand();

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }

    limelight.setPipeline(0);
    limelight.setCameraMode(CameraMode.eVision);
    limelight.setLedMode(LightMode.eOff);

  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    driveSys.autoCont();

    //driveSys.lowGear();
    double leftAdjust = 0.0;
    double rightAdjust = 0.0;

    //leftAdjust += limelight.aimbot();
    //rightAdjust -= limelight.aimbot();


    //driveSys.control(leftAdjust,rightAdjust,1);
    
    //System.out.println(leftAdjust + " , " +  rightAdjust);
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    controls();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    } 
    shooterSys.dropShooter();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    double inputL = dualShock.getRawAxis(1);
    double inputR = dualShock.getRawAxis(5); 
    double modifier = 1; 

    driveSys.control(inputL, inputR, modifier);
    shooterSys.ColorSensor();
    shooterSys.Proximity();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  public void controls() {
    new JoystickButton(dualShock, 1)
      .whenPressed(() -> driveSys.highGear());
    new JoystickButton(dualShock, 2)
      .whenPressed(() -> toggleShooter());
    new JoystickButton(dualShock, 3)
      .whenPressed(() -> toggleRelay());
    new JoystickButton(dualShock, 4)
      .whenPressed(() -> driveSys.lowGear());
    new JoystickButton(dualShock, 5)
      .whenPressed(() -> shooterSys.fire(1,1));
    new JoystickButton(dualShock, 6)
      .whenPressed(() -> driveSys.resetGyro());
    new JoystickButton(dualShock, 7)
      .whenPressed(() -> limelight.setLedMode(LightMode.eOff));
  }
  
  public void toggleShooter() {
    //isLifted = !isLifted;
    if(!shooterSys.isUp()) {
      shooterSys.liftShooter();
    }else {
      shooterSys.dropShooter();
    }
  }

  public void toggleRelay() {
    if(!shooterSys.isRelayOn()){
      shooterSys.startRelay();
    }else {
      shooterSys.stopRelay();
    }
  }

  public double aimbot() {
    float kp = -1f;
    float minCommand = .05f;
    float steeringAdjust = 0.5f;
    //double txEntry = getValue("tx").getDouble(0.0);
    float tx = (float) NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
    //SmartDashboard.setDefaultNumber("TX", tx);
    float headingError = -tx;

    if(tx > 1) {
        steeringAdjust = kp*headingError -minCommand;
    }else if (tx < 1){
        steeringAdjust = kp*headingError + minCommand;
    }
    
    return steeringAdjust;


}


}
