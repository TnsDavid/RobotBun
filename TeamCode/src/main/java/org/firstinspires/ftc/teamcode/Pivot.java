package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.PIDdown.Kd;
import static org.firstinspires.ftc.teamcode.PIDdown.Kf;
import static org.firstinspires.ftc.teamcode.PIDdown.Ki;
import static org.firstinspires.ftc.teamcode.PIDdown.Kp;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Config
public class Pivot {
 public static int mode = 1;

    public static double CKp = 0.0001;
    public static double CKi = 0;
    public static double CKd = 0.0000001;
    public static double CKf = 0;

    public double power;

    public static double target=0;
    public double currentPos;
    DcMotorEx motorpivot1;

    PIDup controllerbasket;
    PIDdown controllercoborare;
    PIDFController pidf;

    public void position0() {
        target = 0;
    }

    public void positionup() {
        target = 1065;
    }
    public Pivot(DcMotorEx motor1){
        motorpivot1 = motor1;
        motorpivot1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motorpivot1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        pidf = new PIDFController(CKp,CKi,CKd,0);
    }

    public void update() {
        currentPos = motorpivot1.getCurrentPosition();
        power = pidf.calculate(currentPos, target) + CKf*Math.cos(Math.toRadians((currentPos*90)/1065));
        motorpivot1.setPower(power);
    }


}

