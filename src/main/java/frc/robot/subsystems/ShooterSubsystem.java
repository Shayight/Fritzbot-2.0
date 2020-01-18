package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard; 

public class ShooterSubsystem extends SubsystemBase {

    DoubleSolenoid heightSolenoid,shooterSolenoid;
    VictorSP motor1,motor2;
    Relay windowMotor;
    Timer timer;
    I2C.Port i2c;
    ColorSensorV3 colorSensor;
    SmartDashboard dashboard;


    public ShooterSubsystem(int heightForward, int heightReverse, int shooterForward, int shooterReverse, int shooterMotor1, int shooterMotor2, int relayPort) {
        heightSolenoid = new DoubleSolenoid(heightForward, heightReverse);
        shooterSolenoid = new DoubleSolenoid(shooterForward, shooterReverse);
        motor1 = new VictorSP(shooterMotor1);
        motor2 = new VictorSP(shooterMotor2);
        windowMotor = new Relay(relayPort);
        timer = new Timer();
        i2c = I2C.Port.kOnboard;
        colorSensor = new ColorSensorV3(i2c);
    }


    public void liftShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kForward);
        heightSolenoid.get();
        //print("Cross pressed");
    }

    public boolean isUp() {
        return heightSolenoid.get() == DoubleSolenoid.Value.kForward;
    }

    public boolean isRelayOn() {
        return windowMotor.get() == Relay.Value.kReverse;
    }

    public void dropShooter() {
        heightSolenoid.set(DoubleSolenoid.Value.kReverse);
        //print("Circle pressed");
    }

    public void startRelay() {
        windowMotor.set(Relay.Value.kReverse);
    }

    public void stopRelay() {
        windowMotor.set(Relay.Value.kOff);
    }

    public void spoolMotors(double modifier1, double modifier2) {
        motor1.setSpeed(.5*modifier1);
        motor2.setSpeed(1*modifier2);
    }

    public void fireFrisbee() {
        shooterSolenoid.set(DoubleSolenoid.Value.kForward);
    }

    public void resetShooter() {
        motor1.setSpeed(0);
        motor2.setSpeed(0);
        shooterSolenoid.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void load() {
        windowMotor.set(Relay.Value.kReverse);
    }

    public void ColorSensor() {
        Color detectedColor = colorSensor.getColor();
        double IR = colorSensor.getIR();
        double r = detectedColor.red;
        double g = detectedColor.green;
        double b = detectedColor.blue;
        dashboard.putNumber("Red", r);
        dashboard.putNumber("Green", g);
        dashboard.putNumber("Blue", b);
        dashboard.putNumber("IR Value", IR);

    }

    public void Proximity() {
        int proximity = colorSensor.getProximity();
        dashboard.putNumber("Proximity", proximity);
    }

    public void print(String input){
        System.out.println(input);
    }

}