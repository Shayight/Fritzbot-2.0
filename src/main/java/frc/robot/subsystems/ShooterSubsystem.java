package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    DoubleSolenoid heightSolenoid,shooterSolenoid;
    VictorSP motor1,motor2;
    


    public ShooterSubsystem(int heightForward, int heightReverse, int shooterForward, int shooterReverse, int shooterMotor1, int shooterMotor2) {
        heightSolenoid = new DoubleSolenoid(heightForward, heightReverse);
        shooterSolenoid = new DoubleSolenoid(shooterForward, shooterReverse);
        motor1 = new VictorSP(shooterMotor1);
        motor2 = new VictorSP(shooterMotor2);
    }


    public void liftShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kForward);
        //print("Cross pressed");
    }

    public void dropShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kReverse);
        //print("Circle pressed");
    }

    public void fire(double modifier1, double modifier2) {
        shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
        motor1.setSpeed(.5*modifier1);
        motor2.setSpeed(1*modifier2);
    }

    public void reload() {
        shooterSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void print(String input){
        System.out.println(input);
    }

}