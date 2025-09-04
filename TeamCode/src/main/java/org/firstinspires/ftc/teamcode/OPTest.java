package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp
@Config
public class OPTest extends LinearOpMode {


    DcMotorEx motorpivot1;
    DcMotorEx motorlift1;
    DcMotorEx motorlift2;
    Pivot piv;
    Lift lift;

    Servo servo1;
    Servo servo2;
    Servo servo3;
    Servo gr;

    Gheara gheara;
    Forbar forbar;

    @Override
    public void runOpMode() throws InterruptedException {
        motorpivot1 = hardwareMap.get(DcMotorEx.class, "motorpiv");
        motorlift1 = hardwareMap.get(DcMotorEx.class, "motorl1");
        motorlift2 = hardwareMap.get(DcMotorEx.class, "motorl2");

       servo1 = hardwareMap.get(Servo.class, "curea");
       servo2 = hardwareMap.get(Servo.class, "st");
       servo3 = hardwareMap.get(Servo.class, "dr");
          gr = hardwareMap.get(Servo.class, "gheara");
        motorlift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorlift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

          forbar = new Forbar(servo1, servo2, servo3);
        piv = new Pivot(motorpivot1);
        lift = new Lift(motorlift1, motorlift2);
        gheara = new Gheara(gr);
        waitForStart();
        while (opModeIsActive()) {
//            if (gamepad1.cross) {
//                piv.pivot0();
//            }
            if (gamepad1.triangle) {
                piv.pivotup();
            }
            if (gamepad1.square) {
                lift.liftup();
            }
            if (gamepad1.circle) {
                lift.lift0();
            }
            if (gamepad1.dpad_left) {
                forbar.turn4bUp();
            }
            if (gamepad1.dpad_down) {
                forbar.turn4bDown();
            }
            if (gamepad1.dpad_up) {
                forbar.turn4b90();
            }
            if (gamepad1.dpad_right) {
                forbar.turn4bwall();
            }
            if(gamepad1.cross)
            {
                gheara.ghearaup();
            }
//            if(gamepad1.cross)
//            {gheara.ghearadown();}


            piv.update();
            lift.update();
            telemetry = new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry());
            telemetry.addData("pivot Position", piv.currentPos);
            telemetry.addData("pivot Target", piv.target);
            telemetry.addData("pivot Power", piv.power);
            telemetry.addData("lift Position", lift.currentPos);
            telemetry.addData("lift Target", lift.target);
            telemetry.addData("lift Power", lift.power);
            telemetry.update();
        }
    }
}






