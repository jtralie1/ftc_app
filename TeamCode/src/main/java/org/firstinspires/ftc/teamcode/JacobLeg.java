package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 2/8/2017.
 */

@TeleOp(name = "JacobLeg", group = "test")
public class JacobLeg extends OpMode{

    Servo left;
    Servo right;
    DcMotor motor;

    public void init(){

        left = hardwareMap.servo.get("left");
        right = hardwareMap.servo.get("right");
        motor = hardwareMap.dcMotor.get("motor");

    }

    public void loop(){

        float rightY = gamepad1.right_stick_y;

        boolean forward = gamepad1.dpad_up;
        boolean backward = gamepad1.dpad_down;

        if(forward){
            left.setPosition(1);
            right.setPosition(-1);
        }

        if(backward){
            left.setPosition(0);
            right.setPosition(0);
        }

        //Right stick controls for motor
        if(rightY > .3)
            motor.setPower(1);
        else if(rightY < -.3)
            motor.setPower(-1);
        else
            motor.setPower(0);

    }

}
