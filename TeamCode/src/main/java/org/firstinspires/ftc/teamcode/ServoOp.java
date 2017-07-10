package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


/**
 * Created by UDRI1 on 9/27/2016.
 */
@TeleOp(name = "ServoTester1", group = "test")

public class ServoOp extends OpMode{
    Servo open;
    double position = 0;


    @Override
    public void init(){

        open = hardwareMap.servo.get("open");
        //close = hardwareMap.servo.get("servo_close");
        open.setPosition(0);
    }

    public void loop(){
        position = open.getPosition();
        boolean down = gamepad1.dpad_down;
        boolean up = gamepad1.dpad_up;

        if(down && open.getPosition()>0.0){
            position-=.1;
            open.setPosition(position);
            telemetry.addData("down", down);
        }
        else if (up && open.getPosition()<.95){
            position+=.1;
            open.setPosition(position);
            telemetry.addData("up", up);
        }

    }

}