package org.firstinspires.ftc.teamcode;




import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Config
public class Lift {


    public static double LKp = 0;
    public static double LKi = 0;
    public static double LKd = 0;
    public static double LKf = 0;

    public double power;

    public static double target=0;
    public double currentPos;
    DcMotorEx motorlift1;
    DcMotorEx motorlift2;
    PIDFController pidf;

    public void liftup() {
        target = 1000;
    }

    public void lift0() {
        target = 0;
    }

    public Lift(DcMotorEx motor1, DcMotorEx motor2){
        motorlift1 = motor1;
        motorlift2 = motor2;
        motorlift1.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        motorlift2.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        motorlift1.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        motorlift2.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

       //motorlift1.setDirection(DcMotorSimple.Direction.REVERSE);
       motorlift2.setDirection(DcMotorSimple.Direction.REVERSE);

        pidf = new PIDFController(LKp,LKi,LKd,0);
    }

    public void update() {
        currentPos = motorlift1.getCurrentPosition();
        power = pidf.calculate(currentPos, target)+ LKf*Math.cos(Math.toRadians((currentPos*90)/1000));
        motorlift1.setPower(power);
        motorlift2.setPower(power);
    }
    }

