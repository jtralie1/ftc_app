package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 1/3/2017.
 */

@TeleOp(name = "Arm", group = "test")

public class strongArm extends OpMode
{

    //6 servos declared
    Servo shoulder;
    Servo rotator;
    Servo elbow;
    Servo wrist;
    Servo claw;
    Servo servo6;

    public void init()
    {

        shoulder = hardwareMap.servo.get("shoulder");
        rotator = hardwareMap.servo.get("rotator");
        elbow = hardwareMap.servo.get("elbow");
        wrist = hardwareMap.servo.get("wrist");
        claw = hardwareMap.servo.get("claw");
 //       flap = hardwareMap.servo.get("flap");
        servo6 = hardwareMap.servo.get("servo6");
        elbow.setDirection(Servo.Direction.REVERSE);

    }

    public void loop()
    {

        //binds booleans to buttons
        float shoulderStick = gamepad1.right_stick_y;
        float rotatorStick = gamepad1.left_stick_x;
        boolean moveElbow = gamepad1.dpad_up;
        boolean reverseElbow= gamepad1.dpad_down;
        boolean moveWrist = gamepad1.b;
        boolean reverseWrist = gamepad1.a;
        boolean moveClaw = gamepad1.x;
        boolean reverseClaw = gamepad1.y;
        boolean moveServo6 = gamepad1.left_bumper;
        boolean reverseServo6 = gamepad1.right_bumper;

        //Shoulder controls (continuous)
        if (shoulderStick > .3)
            shoulder.setPosition(1);
        else if(shoulderStick < -.3)
            shoulder.setPosition(0);
        else
            shoulder.setPosition(0.5);

        //Rotator controls (continuous)
        if (rotatorStick > .3)
            rotator.setPosition(1);
        else if(rotatorStick < -.3)
            rotator.setPosition(0);
        else
            rotator.setPosition(0.5);

        //Elbow controls (continuous)
        if (moveElbow)
            elbow.setPosition(1);
        else if(reverseElbow)
            elbow.setPosition(0);
        else
            elbow.setPosition(0.5);

        //Wrist controls
        if(moveWrist)
            wrist.setPosition(1);
        else if(reverseWrist)
            wrist.setPosition(0);

        //Claw controls
        if(moveClaw)
            claw.setPosition(1);
        else if(reverseClaw)
            claw.setPosition(0);

        //Servo6 controls (continuous)
        if (moveServo6)
            servo6.setPosition(1);
        else if(reverseServo6)
            servo6.setPosition(0);
        else
            servo6.setPosition(0.5);

    }
}
