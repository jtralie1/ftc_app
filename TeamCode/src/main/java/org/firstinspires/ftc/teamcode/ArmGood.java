package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DavidArm", group = "Test")
public class ArmGood extends OpMode{
    DcMotor bmotor;


    DcMotor lsmotor;
    DcMotor rsmotor;
    DcMotor emotor;

    Servo rotator;
    Servo wrist;
    Servo claw;

    public double posR = 0;
    public double posW = 0;
    public double posC = .75;
    public void init(){
        bmotor = hardwareMap.dcMotor.get("base_motor");
        lsmotor = hardwareMap.dcMotor.get("left_shoulder_motor");
        rsmotor = hardwareMap.dcMotor.get("right_shoulder_motor");
        emotor = hardwareMap.dcMotor.get("elbow_motor");
        rotator = hardwareMap.servo.get("rotating_wrist");
        wrist = hardwareMap.servo.get("up_down_wrist");
        claw = hardwareMap.servo.get("finger");

        rsmotor.setDirection(DcMotor.Direction.REVERSE);
    }
    public void loop(){
        boolean turnBaseLeft = gamepad1.dpad_left;
        boolean turnBaseRight = gamepad1.dpad_right;
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        boolean moveRotator = gamepad1.left_bumper;
        boolean moveWrist = gamepad1.b;
        boolean reset = gamepad1.right_stick_button;
        boolean moveClaw = gamepad1.y;
        boolean stopClaw = gamepad1.a;
        boolean reverseRotator = gamepad1.right_bumper;
        boolean reverseWrist = gamepad1.x;

        if(moveRotator){
            rotator.setPosition(posR += .05);
        }
        else if(reverseRotator) {
            rotator.setPosition(posR -= .05);
        }
        else if(reset){
            rotator.setPosition(0.5);
            posR = 0;
        }

        if(moveWrist){
            wrist.setPosition(posW += .05);
        }
        else if(reverseWrist){
            wrist.setPosition(posW -= .05);
        }
        else if(reset){
            wrist.setPosition(0.5);
            posW = 0;
        }

        if(moveClaw){
            claw.setPosition(.2);
        }
        else if(stopClaw){
            claw.setPosition(.75);
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////
        if(turnBaseLeft){
            bmotor.setPower(-.5);
        }
        else if(turnBaseRight){
            bmotor.setPower(.5);
        }
        else{
            bmotor.setPower(0);
        }

        if(leftY > .1){
            lsmotor.setPower(-leftY*.5);
            rsmotor.setPower(-leftY*.5);
        }
        else if(leftY <-.3){
            lsmotor.setPower(-leftY*.5);
            rsmotor.setPower(-leftY*.5);
        }
        else{
            lsmotor.setPower(0);
            rsmotor.setPower(0);
        }

        if(rightY > .3){
            emotor.setPower(-rightY*.5);
        }
        else if(rightY <-.3){
            emotor.setPower(-rightY*.5);
        }
        else {
            emotor.setPower(0);
        }
    }


}


