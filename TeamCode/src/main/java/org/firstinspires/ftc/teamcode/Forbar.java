package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class Forbar {

    Servo servo;
    public Forbar(Servo srv){
        servo = srv;
    }

    public void position0(){
        servo.setPosition(0);
    }
}
