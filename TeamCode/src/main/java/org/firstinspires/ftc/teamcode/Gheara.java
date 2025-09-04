package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class Gheara {
    Servo gheara;

    public void ghearaup() {
        gheara.setPosition(1);
    }
    public void ghearadown(){
        gheara.setPosition(0);
    }

    public Gheara(Servo servo_gr) {
        gheara = servo_gr;
    }

}
