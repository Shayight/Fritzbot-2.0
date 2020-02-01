/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.AnalogEncoder;
import edu.wpi.first.wpilibj.AnalogInput;

public class TurretSubsystem extends SubsystemBase {
  public VictorSP m_turret;
  public AnalogInput e_turret;
   // public Encoder e_turret;
  // public Talon m_feeder;
  double turretVal;
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {
    m_turret = new VictorSP(0);
    e_turret = new AnalogInput(0);
    //e_turret = new AnalogEncoder(new AnalogInput(0));
    // e_turret.setDistancePerRotation(360/5);
    
    // m_feeder = new Talon(5);
  }

  public void resetEncoder() {
    e_turret.resetAccumulator();
  }

  public void turret(double axis){
    if(getEncoderVal() < 45 && getEncoderVal() > -45)
      m_turret.set(axis);
    else
      m_turret.set(0);
  }
 
  public double getEncoderVal(){
    turretVal = e_turret.getValue();
    turretVal = turretVal - 425;
    System.out.println(turretVal);
    return turretVal;
  }

  // public void feeder(double speed){
  //   m_feeder.set(speed);
  // }
  


}
