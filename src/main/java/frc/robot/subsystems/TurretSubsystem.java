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

public class TurretSubsystem extends SubsystemBase {
  public VictorSP m_turret;
  public Encoder e_turret;
  int turretVal;
  /**
   * Creates a new TurretSubsystem.
   */
  public TurretSubsystem() {
    m_turret = new VictorSP(0);
    e_turret = new Encoder(0,1);
    

  }

  public void turret(double axis){
    m_turret.set(axis);
  }
 
  public int getEncoderVal(){
    turretVal = e_turret.get();
    System.out.println(turretVal);
    return turretVal;

  }
}
