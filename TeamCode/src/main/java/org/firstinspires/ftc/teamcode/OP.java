package org.firstinspires.ftc.teamcode;


import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;

@TeleOp
@Config
public class OP extends LinearOpMode {

    DcMotorEx motorpivot1;

    Pivot piv;
    @Override
    public void runOpMode() throws InterruptedException {
        motorpivot1 = hardwareMap.get(DcMotorEx.class, "motorpiv");
        piv = new Pivot(motorpivot1);

        waitForStart();
        while (opModeIsActive()) {
            if(gamepad1.cross){piv.position0();}
            if(gamepad1.triangle) {piv.positionup();}
            piv.update();
            telemetry =  new MultipleTelemetry(telemetry , FtcDashboard.getInstance().getTelemetry());
            telemetry.addData("Motor Position", piv.currentPos);
            telemetry.addData("Target", piv.target);
            telemetry.addData("Power", piv.power);
            telemetry.update();
            }

        }

    }
