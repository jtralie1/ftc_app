package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by UDRI1 on 10/5/2016.
 */
@TeleOp(name = "motorServoTest", group = "Test")
public class motorServoTest extends OpMode{
    Servo open;
   // Servo close;
   // DcMotor testMotor;

    @Override
    public void init(){
        open = hardwareMap.servo.get("servo_open");
        open.setPosition(0);
       // close = hardwareMap.servo.get("servo_close");
       // testMotor = hardwareMap.dcMotor.get("test_motor_run");
    }
    @Override
    public void loop(){

        boolean isOpen = gamepad1.x;


        if(isOpen){
            open.setPosition(1);
        }
        else
            open.setPosition(0);
       // while(isClose){
         //   close.setPosition(0);
        //}

     //   while(forward){
          //  testMotor.setPower(1);
       // }
        telemetry.addData("isOpen: ", isOpen);
    }

}
