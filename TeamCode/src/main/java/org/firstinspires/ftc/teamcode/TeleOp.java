package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by UDRI1 on 7/28/2016.
 *  Simple Tank Drive Program*/
@com.qualcomm.robotcore.eventloop.opmode.TeleOp(name = "TeleOp", group = "test")
public class TeleOp extends OpMode {
    // Declare Motor Variables

    DcMotor lfmotor;
    DcMotor rfmotor;
    DcMotor lbmotor;
    DcMotor rbmotor;

    DcMotor intakeMotor;
    DcMotor shooterLeft;
    DcMotor shooterRight;

    Servo door;
    Servo lift;

    double power;
    //double powerMult;
    @Override
    public void init() {
        // Map Motor Variables to Hardware on robot using Hardware Map
        lfmotor = hardwareMap.dcMotor.get("left_front_motor");
        rfmotor = hardwareMap.dcMotor.get("right_front_motor");
        rbmotor = hardwareMap.dcMotor.get("right_back_motor");
        lbmotor = hardwareMap.dcMotor.get("left_back_motor");
        intakeMotor = hardwareMap.dcMotor.get("intake");
        shooterLeft = hardwareMap.dcMotor.get("intake_l");
        shooterRight = hardwareMap.dcMotor.get("intake_r");
        door = hardwareMap.servo.get("door");
        lift = hardwareMap.servo.get("lift");



// Right motor is mounted backwards from left motor so reverse its direction
        rfmotor.setDirection(DcMotor.Direction.REVERSE);
        rbmotor.setDirection(DcMotor.Direction.REVERSE);


    }
    //2 = intake motor, rotates on press
    // 1 = 2 motors = 100% power
    @Override
    public void loop() {
        // Read gamepad values and set motor power to them (negative sign is used since pushing forward
        //   on stick gives a negative value
        // power = gamepad1.left_trigger;
        // boolean shoot = gamepad1.x;
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;
        float leftY2 = -gamepad2.left_stick_y;
        float rightY2 = -gamepad2.right_stick_y;

        //Trying to configure how to turn left and right

        boolean shoot = gamepad2.right_bumper;
        boolean strafeRight = gamepad1.right_bumper;
        boolean strafeLeft = gamepad1.left_bumper;
        boolean closeDoor = gamepad2.left_bumper;


      /* if(-0.3 < rightY && rightY < 0.3)
       {
           rightY = 0;
       }

       if(-0.3 < leftY && leftY< 0.3)
       {
           leftY = 0;
       }*/


        if(strafeLeft) {
            lbmotor.setPower(1);
            lfmotor.setPower(1);
        }


        else if(strafeRight){

            lbmotor.setPower(-1);
            lfmotor.setPower(1);

        }




        else if(leftY > .3){

            lfmotor.setPower(-1);
            lbmotor.setPower(-1);

        }

        else if(leftY < -.3) {

            lfmotor.setPower(1);
            lbmotor.setPower(1);

        }

        else{

            lfmotor.setPower(0);
            lbmotor.setPower(0);

        }

        if(strafeLeft){
            rbmotor.setPower(1);
            rfmotor.setPower(-1);
        }

        else if(strafeRight){
            rbmotor.setPower(-1);
            rfmotor.setPower(1);
        }


        else if(rightY > .3){
            rfmotor.setPower(-1);
            rbmotor.setPower(-1);

        }

        else if(rightY < -.3){

            rfmotor.setPower(1);
            rbmotor.setPower(1);

        }

        else{

            rfmotor.setPower(0);
            rbmotor.setPower(0);

        }


        if(shoot){
            shooterLeft.setPower(-1);
            shooterRight.setPower(1);
        }
        else {
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
        }


        telemetry.addData("leftY: ", leftY);
        telemetry.addData("rightY: ", rightY);

        if(leftY2 > .3){
            lift.setPosition(.95);
        }
        else {
            lift.setPosition(.05);
        }

        if(closeDoor){
            door.setPosition(.55);
            telemetry.addData("closeDoor", closeDoor);
            telemetry.update();
        }
        else {
            door.setPosition(1);
            telemetry.addData("closeDoor", closeDoor);
            telemetry.update();
        }


        if(rightY2 < -.3){
            //rotate intake motor
            intakeMotor.setPower(-1);
            //telemetry.addData("rotateIntake", rotateIntake);
            //telemetry.update();
        }

        else if(rightY2 > .3){

            intakeMotor.setPower(1);

        }

        else {
            intakeMotor.setPower(0);
            // telemetry.addData("rotateIntake", rotateIntake);
            //telemetry.update();
        }

    }

}

