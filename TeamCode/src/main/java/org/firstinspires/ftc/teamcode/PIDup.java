package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;

public class PIDup {

    public PIDup(double kp, double ki, double kd, double kf) {
        PIDFController pidf = new PIDFController(kp, ki, kd, kf);
        PIDController pid = new PIDController(kp, ki, kd);
    }
}
