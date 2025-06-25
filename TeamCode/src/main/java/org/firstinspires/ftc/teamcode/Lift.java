package org.firstinspires.ftc.teamcode;


import static org.firstinspires.ftc.teamcode.PIDdown.Kd;
import static org.firstinspires.ftc.teamcode.PIDdown.Kf;
import static org.firstinspires.ftc.teamcode.PIDdown.Ki;
import static org.firstinspires.ftc.teamcode.PIDdown.Kp;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@Config
public class Lift {


    public static double LKp = 0.0001;
    public static double LKi = 0;
    public static double LKd = 0.0000001;
    public static double LKf = 0;

    public double power;

    public static double target=0;
    public double currentPos;
    DcMotorEx motorlift1;
    DcMotorEx motorlift2;
    PIDdown controller_lift_down;

    public Lift(DcMotorEx motor1, DcMotorEx motor2){
        motorlift1 = motor1;
        motorlift2 = motor2;
        motorlift1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motorlift2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motorlift1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorlift2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        controller_lift_down = new PIDdown( Kp, Ki, Kd, Kf);
    }

    public void update() {
        currentPos = motorlift1.getCurrentPosition();
        motorlift1.setPower(power);
        power = controller_lift_down.calculate(currentPos, target);

    }

    }

