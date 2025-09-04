package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.Servo;

public class Incheietura {

    Servo incheietura;
     public Incheietura(Servo wrist) {
         incheietura = wrist;
     }
     public enum Pos {
         HORIZONTAL, VERTICAL ;
    }

   public void setPos(){
         incheietura.setPosition(0);
   }


}
