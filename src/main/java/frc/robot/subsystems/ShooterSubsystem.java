package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {

    DoubleSolenoid heightSolenoid,shooterSolenoid;
    VictorSP motor1,motor2;
    Relay windowMotor;
    Timer timer;
    


    public ShooterSubsystem(int heightForward, int heightReverse, int shooterForward, int shooterReverse, int shooterMotor1, int shooterMotor2, int relayPort) {
        heightSolenoid = new DoubleSolenoid(heightForward, heightReverse);
        shooterSolenoid = new DoubleSolenoid(shooterForward, shooterReverse);
        motor1 = new VictorSP(shooterMotor1);
        motor2 = new VictorSP(shooterMotor2);
        windowMotor = new Relay(relayPort);
        timer = new Timer();
    }


    public void liftShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kForward);
        //print("Cross pressed");
    }

    public void dropShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kReverse);
        //print("Circle pressed");
    }

    public void startRelay() {
        windowMotor.set(Relay.Value.kForward);
    }

    public void fire(double modifier1, double modifier2) {
        motor1.setSpeed(.5*modifier1);
        motor2.setSpeed(1*modifier2);
        timer.delay(1F);
        windowMotor.set(Relay.Value.kOff);
        shooterSolenoid.set(DoubleSolenoid.Value.kForward);
        timer.delay(2);
        motor1.setSpeed(0);
        motor2.setSpeed(0);
        windowMotor.set(Relay.Value.kReverse);
        shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
        timer.delay(1);
        windowMotor.set(Relay.Value.kOff);

    }

    public void reload() {
        shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
        motor1.setSpeed(0);
        motor2.setSpeed(0);
        windowMotor.set(Relay.Value.kOff);
    }
    
    public void load() {
        windowMotor.set(Relay.Value.kReverse);
    }

    public void print(String input){
        System.out.println(input);
    }

}