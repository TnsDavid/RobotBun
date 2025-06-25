package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PIDFController;

public class PIDup {

    public PIDup(double kp, double ki, double kd, double kf) {
        PIDFController pidf = new PIDFController(kp, ki, kd, kf);
    }
}
