package org.firstinspires.ftc.teamcode;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.AccelerationSensor;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.GyroSensor;
import java.sql.Timestamp;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.util.BatteryChecker;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.RUN_TO_POSITION;
import static com.qualcomm.robotcore.hardware.DcMotor.RunMode.STOP_AND_RESET_ENCODER;
import static com.qualcomm.robotcore.hardware.DcMotorController.*;

/**
 * Created by UDRI1 on 11/16/2016.
 */

@Autonomous (name = "Simple Auto", group = "Test")
public class SimpleAuto extends LinearOpMode {

    // 7 declare motors, 3 servos, 1 gyro, 2 color sensors
    DcMotor lfmotor;
    DcMotor rfmotor;
    DcMotor lbmotor;
    DcMotor rbmotor;
    DcMotor shooterLeft;
    DcMotor shooterRight;
    DcMotor intakeMotor;
    Servo door;
    Servo lift;
    Servo buttonPusher;
    ColorSensor wallCS;


    //Used to get voltage from battery - changes power of shoot moters


    //use to convert RGB to HSV
    float hsvValues[] = {0F, 0F, 0F};
    final float values[] = hsvValues;

    //ourColor will be set by user input
    static boolean colorSet, buttonHit;
    static String ourColor;


    public void runOpMode() throws InterruptedException {
        //initialize parts:
        //test = hardwareMap.servo.get("dsad");
        //gyro = hardwareMap.gyroSensor.get("gyro");
        wallCS = hardwareMap.colorSensor.get("csWall");
        //floorCS = hardwareMap.colorSensor.get("csFloor");


        lfmotor = hardwareMap.dcMotor.get("left_front_motor");
        rfmotor = hardwareMap.dcMotor.get("right_front_motor");
        rbmotor = hardwareMap.dcMotor.get("right_back_motor");
        lbmotor = hardwareMap.dcMotor.get("left_back_motor");
        shooterLeft = hardwareMap.dcMotor.get("intake_l");
        shooterRight = hardwareMap.dcMotor.get("intake_r");
        door = hardwareMap.servo.get("door");
        lift = hardwareMap.servo.get("lift");
        intakeMotor = hardwareMap.dcMotor.get("intake");
        buttonPusher = hardwareMap.servo.get("bp");
        buttonPusher.setPosition(0);
        telemetry.addData("Waiting", 1);
        telemetry.update();

        //user input color: dpad down = red, dpad up = blue
        ourColor = "blue";
        sleep(15000);
        //prep: brake, callibrate, close door
        for (int i = 0; i < 1000; i++) {
            //gyro.calibrate();
            door.setPosition(.25);
            lift.setPosition(.85);
        }
        //user presses start (make sure 2 balls are loaded)
        waitForStart();
       /* for (int i = 0; i < 12000; i++)
            goForwardSlowly(0);*/
        for (int i = 0; i < 2000; i++) {
            brake(0);
        }

        for (int i = 0; i < 50000; i++) {
            goForward(0);
        }

        for (int i = 0; i < 70000; i++) {
            brake(0);
        }
        //shoot ball 2: break motors, turn on shooting motors, raise lift
        for (int i = 0; i <35000; i++) {
            brake(0);
            shooterLeft.setPower(1);
            shooterRight.setPower(-1);
            if (i > 15000)
                lift.setPosition(.15);
            telemetry.addData("Shooting", i);
            telemetry.update();
        }

        //reset: turn off shooting motors, set lift back to 0, open door
        for (int i = 0; i < 20000; i++) {
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
            lift.setPosition(.85);
            door.setPosition(1);
            telemetry.addData("Resetting", i);
            telemetry.update();
        }

        //turn on intake to scoop next ball into shooting position
        for (int i = 0; i < 20000; i++) {
            intakeMotor.setPower(-1);
            telemetry.addData("Intake", i);
            telemetry.update();
        }

        //Prep: close door
        for (int i = 0; i < 60000; i++) {
            if (i>40000)
                door.setPosition(.25);
            telemetry.addData("Close Door", i);
            telemetry.update();
        }

        //shoot ball 2: break motors, turn on shooting motors, raise lift
        for (int i = 0; i < 35000; i++) {
            brake(0);
            shooterLeft.setPower(1);
            shooterRight.setPower(-1);
            if (i > 20000)
                lift.setPosition(.15);
            telemetry.addData("Shooting", i);
            telemetry.update();
        }


        //reset: turn off shooting motors, set lift back to 0, open door
        for (int i = 0; i < 20000; i++) {
            shooterLeft.setPower(0);
            shooterRight.setPower(0);
            lift.setPosition(.85);
            door.setPosition(1);
            telemetry.addData("Resetting", i);
            telemetry.update();
            intakeMotor.setPower(1);
        }
        //intakeMotor.setPower(0);


        for (int i = 0; i < 120000; i++) {
            goForward(0);
        }

        for (int i = 0; i < 70000; i++) {
            brake(0);
        }

    }


            /*for (int i = 0; i < 20000; i++) {
                brake(0);
                //intakeMotor.setPower(0);
            }
                for (int i = 0; i < 200000; i++) {
                    strafeLeft();
                    //intakeMotor.setPower(0);
                }
                for (int i = 0; i < 20000; i++) {
                    brake(0);
                    //intakeMotor.setPower(0);
                }}*/




    public void goForward (int wantedInt){
        lfmotor.setPower(1);
        rfmotor.setPower(-1);
        lbmotor.setPower(1);
        rbmotor.setPower(-1);
        // telemetry.addData("Going Backward, Heading:", gyro.getHeading());
        telemetry.update();
    }
    public void goForwardSlowly (int wantedInt){
        lfmotor.setPower(.5);
        rfmotor.setPower(-.5);
        lbmotor.setPower(.5);
        rbmotor.setPower(-.5);
        // telemetry.addData("Going Backward, Heading:", gyro.getHeading());
        telemetry.update();
    }
    public void goBackward(int wantedAngle){
        lfmotor.setPower(-1);
        rfmotor.setPower(1);
        lbmotor.setPower(-1);
        rbmotor.setPower(1);

        // telemetry.addData("Going Forward, Heading:", gyro.getHeading());
        telemetry.update();
          /*  if(gyro.getHeading()>wantedAngle) {
                lfmotor.setPower(-.99);
                lbmotor.setPower(-.99);
            }
            if(gyro.getHeading()<wantedAngle) {
                rfmotor.setPower(.99);
                rbmotor.setPower(.99);*/
    }

    public void goBackwardSlowly(int wantedAngle){
        lfmotor.setPower(-.5);
        rfmotor.setPower(.5);
        lbmotor.setPower(-.5);
        rbmotor.setPower(.5);

        telemetry.update();
    }

    public void turnRight(){
        lfmotor.setPower(-1);
        rfmotor.setPower(-1);
        lbmotor.setPower(-1);
        rbmotor.setPower(-1);
    }

    public void turnLeft(){
        int k=1;
        telemetry.addData ("Programming turning left:",k);
        //while(gyro.getHeading()<5 || gyro.getHeading()> 360-angle) {

        lfmotor.setPower(0.5);
        rfmotor.setPower(0.5);
        lbmotor.setPower(0.5);
        rbmotor.setPower(0.5);
        //telemetry.addData("Heading:", gyro.getHeading());

        //}
    }

    public void strafeRight(){

        lbmotor.setPower(-1);
        lfmotor.setPower(1);
        rbmotor.setPower(1);
        rfmotor.setPower(-1);
    }

    public void strafeLeft(){

        rfmotor.setPower(1);
        rbmotor.setPower(-1);
        lfmotor.setPower(-1);
        lbmotor.setPower(1);
    }

    public void brake(int wantedInt){
        lfmotor.setPower(0);
        rfmotor.setPower(0);
        lbmotor.setPower(0);
        rbmotor.setPower(0);
    }

    public void setShooterMode(int shoot)
    {
        shooterRight.setPower(shoot);
        shooterLeft.setPower(shoot);
    }
}

