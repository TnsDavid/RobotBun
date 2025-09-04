package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Forbar {

    Servo servo1;
    Servo servo2;
    Servo servo3;
    public enum Positions{
        BASKET(0,0.8795,0.611), SUBMERSIBLE(0.6535,0.9505,0.3695), COLLECT(0.275,0.713,0.4355), WALL(-0.515,-0.3955,-0.438);
        double s1, s2, c;
         Positions(double s1, double s2, double c){
            this.s1 = s1;
            this.s2= s2;
            this.c= c;
        }
    }
    public void setPos(Positions pos){
        servo1.setPosition(pos.c);
        servo2.setPosition(pos.s2);
        servo3.setPosition(pos.s1);
    }


    public void turn4bUp() {
     setPos(Positions.SUBMERSIBLE);
    }

    public void turn4bDown() {
        setPos(Positions.COLLECT);
    }

    public void turn4b90(){
        setPos(Positions.BASKET);
    }
    public void turn4bwall(){
        setPos(Positions.WALL);
    }

    public Forbar(Servo left, Servo right, Servo curea) {
        servo3 = right; servo1 = curea; servo2 = left;
        servo2.setDirection(Servo.Direction.REVERSE);
    }
}