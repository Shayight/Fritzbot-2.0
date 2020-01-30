package frc.robot.utils;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class OI extends SubsystemBase {
    public Joystick joy;
    public boolean square,cross,circle,triangle,lBumper,rBumper,lTrigger,rTrigger,
    select,start,lsButton,rsButton,touchpad;
    public double lStickV,rStickV;
    

    public void controlsInit() {
        joy = new Joystick(0);
    }

    public boolean getSquare() {
        return joy.getRawButton(1);
    }

    public boolean getCross() {
        return joy.getRawButton(2);
    }

    public boolean getCircle() {
        return joy.getRawButton(3);
    }

    public boolean getTriangle() {
        return joy.getRawButton(4);
    }

    public boolean getlBumper() {
        return joy.getRawButton(5);
    }

    public boolean getrBumper() {
        return joy.getRawButton(6);
    }

    public boolean getlTrigger() {
        return joy.getRawButton(7);
    }

    public boolean getrTrigger() {
        return joy.getRawButton(8);
    }

    public boolean getSelect() {
        return joy.getRawButton(9);
    }

    public boolean getStart() {
        return joy.getRawButton(10);
    }

    public boolean getLsButton() {
        return joy.getRawButton(11);
    }

    public boolean getRsButton() {
        return joy.getRawButton(12);
    }

    public boolean getTouchpad() {
        return joy.getRawButton(13);
    }

    public double getlStickV() {
        return joy.getRawAxis(1);
    }

    public double getrStickV() {
        return joy.getRawAxis(5);
    }
    public double getLeftTurretAxis(){
        return joy.getRawAxis(3);
    }
    public double getRightTurretAxis(){
        return joy.getRawAxis(4);
    }
}