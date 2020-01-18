/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
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
  public ADXRS450_Gyro gyro;
  

  public DriveSubsystem(int FLPos, int FRPos, int RLPos, int RRPos) {
    FL = new Talon(FLPos);
    FR = new Talon(FRPos);
    RL = new Talon(RLPos);
    RR = new Talon(RRPos);
    gyro = new ADXRS450_Gyro();
    
    leftSide = new SpeedControllerGroup(FL, RL);
    rightSide = new SpeedControllerGroup(FR, RR);
    solenoid = new DoubleSolenoid(0, 7);
    

    drive = new DifferentialDrive(leftSide, rightSide);
    gyro.calibrate();
    gyro.reset();
    
    

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void control(double inputL, double inputR, double modifier, double time) {
    if (drive.isSafetyEnabled() == true) {
      drive.setSafetyEnabled(true);
    }
    if ((time != 0)&&(time>=0)){
    drive.setExpiration(time);
    }
    else {
    drive.setExpiration(5);
    }
    drive.tankDrive(inputL*modifier, inputR*modifier);
    double x = gyro.getAngle();
    //System.out.println(x);
    drive.setExpiration(.1);
  }
  public void auto(){
    Boolean ismoving = false;
    
    if (drive.isSafetyEnabled() == true) {
      drive.setSafetyEnabled(true);
    }
    solenoid.set(DoubleSolenoid.Value.kForward);
    if (ismoving == false){
      ismoving = true;
    control(-1,-1,1,5);
    Timer.delay(3);
    control(0,0,1,5);
    }
    ismoving = false;
  } 
  public void autoCont() {
    double time;
    time = 3;
    if (drive.isSafetyEnabled() == true) {
      drive.setSafetyEnabled(true);
    }

    solenoid.set(DoubleSolenoid.Value.kForward);
    drive.setExpiration(time);
    control(-1,-1,1,5);
    System.out.println("Movement");
    Timer.delay(3);
    control(0, 0, 1,5);
    System.out.println("Movement two");
    drive.setExpiration(.1);
  }

  public void lowGear(){
      solenoid.set(DoubleSolenoid.Value.kForward);
  }
  public void highGear(){
    solenoid.set(DoubleSolenoid.Value.kReverse);
}
  public void resetGyro(){
    gyro.reset();
  }
  
}
