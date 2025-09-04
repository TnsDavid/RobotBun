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


    public static double CKp = 0.002;
    public static double CKi = 0;
    public static double CKd = 0.00001;
    public static double CKf = 0.05;
    public enum Pos{
        UP, DOWN
    }
    Pos pos= Pos.DOWN;
    public double power = 0.5;

    public static double target=0;
    public double currentPos;
    DcMotorEx motorpivot1;

    PIDup controllerbasket;
    PIDFController pidf;

    public void pivot0() {
        target = 0;
        pos= Pos.DOWN;
    }

    public void pivotup() {
        target = 1065;
        pos= Pos.UP;
    }
    public Pivot(DcMotorEx motor1){
        motorpivot1 = motor1;
        motorpivot1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motorpivot1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        pidf = new PIDFController(CKp,CKi,CKd,0);
    }

    public void update() {
        if(pos == Pos.UP)
        {
              CKp = 0.002;
              CKi = 0;
              CKd = 0.0001;
              CKf = 0.05;
        }
        else {
            CKp = 0;
            CKi = 0;
            CKd = 0;
            CKf = 0;
        }
        currentPos = motorpivot1.getCurrentPosition();
        power = pidf.calculate(currentPos, target)+CKf*Math.cos(Math.toRadians((currentPos*90)/1100));
        motorpivot1.setPower(power);
    }


}

