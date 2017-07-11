package org.firstinspires.ftc.robotcontroller.internal;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.Auto2;

/**
 * Created by UDRI-2 on 2/24/2017.
 */
@Autonomous(name = "Lit", group = "test")
public class LightSensorTest extends LinearOpMode {

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


    public void runOpMode() {
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

        Color.RGBToHSV(wallCS.red() * 8, wallCS.green() * 8, wallCS.blue() * 8, hsvValues);

        // send the info back to driver station using telemetry function.
        while (true){
        telemetry.addData("Clear", wallCS.alpha());
        telemetry.addData("Red  ", wallCS.red());
        telemetry.addData("Green", wallCS.green());
        telemetry.addData("Blue ", wallCS.blue());
        telemetry.addData("Hue", hsvValues[0]);

        telemetry.update();}
       /* if (wallCS.blue() > 2 && wallCS.red()<2) {
            for (int i = 0; i < 20000; i++) {
                strafeRight();
            }
            for (int i = 0; i < 20000; i++) {
                strafeLeft();
            }
        } else {
            boolean button1 = false;
            for (int j = 0; j<10;j++){
                for (int i = 0; i <8000; i++)
                    goForwardSlowly(0);
                for (int i = 0; i <8000; i++)
                    brake(0);
                if (wallCS.blue() > 2 && wallCS.red()<2 && button1 == false) {
                    for (int i = 0; i < 20000; i++) {
                        strafeRight();
                    }
                    for (int i = 0; i < 20000; i++) {
                        brake(0);
                    }
                    for (int i = 0; i < 20000; i++) {
                        strafeLeft();
                    }
                    for (int i = 0; i < 20000; i++) {
                        brake(0);
                    }
                    button1 = true;}
            }}

        for (int i = 0; i < 30000; i++){
            goForward(0);
        }

        if (wallCS.blue() > 2 && wallCS.red()<2) {
            for (int i = 0; i < 20000; i++) {
                strafeRight();
            }
            for (int i = 0; i < 20000; i++) {
                strafeLeft();
            }
        } else {
            boolean button2 = false;
            for (int j = 0; j<10;j++){
                for (int i = 0; i <8000; i++)
                    goForwardSlowly(0);
                for (int i = 0; i <8000; i++)
                    brake(0);
                if (wallCS.blue() > 2 && wallCS.red()<2 && button2 == false) {
                    for (int i = 0; i < 20000; i++) {
                        strafeRight();
                    }
                    for (int i = 0; i < 20000; i++) {
                        brake(0);
                    }
                    for (int i = 0; i < 20000; i++) {
                        strafeLeft();
                    }
                    for (int i = 0; i < 20000; i++) {
                        brake(0);
                    }
                    button2 = true;}
            }}*/
    }
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

        //  telemetry.addData("In strafe, Heading:", gyro.getHeading());
        telemetry.update();

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
