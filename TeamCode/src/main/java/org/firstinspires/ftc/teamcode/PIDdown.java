package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.util.ElapsedTime;

public class PIDdown {
    public static double Kp;
    public static double Ki;
    public static double Kd;

    public static double Kf;


    ElapsedTime timer = new ElapsedTime();

    double lastError = 0;
    double integralSum = 0;
    public PIDdown(double kp, double ki, double kd, double kf){
        Kp= kp;
        Ki = ki;
        Kd = kd;
        Kf = kf;
    }

    public double calculate(double current, double target ){
        double error = target - current;
        integralSum += error * timer.seconds();
        double derivative =(error - lastError)/timer.seconds();
        lastError = error;

        return (Kp * error) + (Ki * integralSum) + (Kd * derivative);
    }


}

