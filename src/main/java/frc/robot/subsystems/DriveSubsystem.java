/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class DriveSubsystem extends SubsystemBase {
  /**
   * Creates a new DriveSubsystem.
   */
  public Talon FL,FR,RL,RR;
  public DifferentialDrive drive;
  public SpeedControllerGroup leftSide,rightSide;
  public DoubleSolenoid solenoid;

  public DriveSubsystem(int FLPos, int FRPos, int RLPos, int RRPos) {
    FL = new Talon(FLPos);
    FR = new Talon(FRPos);
    RL = new Talon(RLPos);
    RR = new Talon(RRPos);
    
    leftSide = new SpeedControllerGroup(FL, RL);
    rightSide = new SpeedControllerGroup(FR, RR);
    solenoid = new DoubleSolenoid(0, 7);

    drive = new DifferentialDrive(leftSide, rightSide);
    drive.setSafetyEnabled(false);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void control(double inputL, double inputR, double modifier) {
    drive.tankDrive(inputL*modifier, inputR*modifier);
  }
}
