package org.firstinspires.ftc.teamcode;

import com.arcrobotics.ftclib.controller.PIDController;
import com.arcrobotics.ftclib.controller.PIDFController;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

public class Drivetrain {
    DcMotorEx FrontRight;
    DcMotorEx FrontLeft;
    DcMotorEx BackLeft;
    DcMotorEx BackRight;
    public Drivetrain(DcMotorEx leftback, DcMotorEx rightback, DcMotorEx leftfront , DcMotorEx rightfront) {
        BackLeft = leftback;
        BackRight = rightback;
        FrontRight = rightfront;
        FrontLeft = leftfront;
    }
    public void update(double x , double y , double rx) {

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx) / denominator;
        double backLeftPower = (y - x + rx) / denominator;
        double backRightPower = (y - x - rx) / denominator;
        double frontRightPower = (y + x - rx) / denominator;

        FrontLeft.setPower(frontLeftPower);
        BackLeft.setPower(backLeftPower);
        FrontRight.setPower(frontRightPower);
        BackRight.setPower(backRightPower);
    }
}