package org.firstinspires.ftc.robotcontroller.internal;

import android.graphics.Color;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

//Program that makes servo move when detects corect color
/**
 * Created by UDRI-2 on 1/11/2017.
 */
@Autonomous(name = "Light sensor to servo", group = "Sensor")
public class LightSensorRobotixs extends LinearOpMode{

    ColorSensor colorSensor;    // Hardware Device Object
    //ColorSensor floorSensor;
   //
    // DcMotor wheel;
    Servo servo;

    float hsvValues[] = {0F,0F,0F};
    final float values[] = hsvValues;
    static boolean colorSet, buttonHit;
    static String ourColor;

    public void runOpMode(){
        colorSensor = hardwareMap.colorSensor.get("csWall");
       // floorSensor = hardwareMap.colorSensor.get("floorCS");
        servo = hardwareMap.servo.get("bp");
       // wheel = hardwareMap.dcMotor.get("wheel");

        servo.setPosition(0);
        //floorSensor.enableLed(true);
        ourColor = null;
        colorSet = false;
        while (colorSet == false){

            if(gamepad1.dpad_down == true){
                ourColor = "red";
                colorSet = true;
            }
            if (gamepad1.dpad_up == true){
                ourColor = "blue";
                colorSet = true;
            }

            telemetry.addData("Searching for color... red status -- down)", gamepad1.dpad_down);
            telemetry.addData("blue status -- up", gamepad1.dpad_up);
            telemetry.update();
        }

        waitForStart();

        boolean linedUp = false;
      //  while (floorSensor.alpha()== 0){
      //      wheel.setPower(1);
      //  }
      //  wheel.setPower(0);
        buttonHit = false;
        while (!buttonHit) {

            // convert the RGB values to HSV values.
            Color.RGBToHSV(colorSensor.red() * 8, colorSensor.green() * 8, colorSensor.blue() * 8, hsvValues);

            // send the info back to driver station using telemetry function.
            telemetry.addData("Clear", colorSensor.alpha());
            telemetry.addData("Red  ", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue ", colorSensor.blue());
            telemetry.addData("Hue", hsvValues[0]);

            telemetry.update();

            if (ourColor.equals("red") && colorSensor.red() >2){
                servo.setPosition(1);
                buttonHit = true;
            }
            else if (ourColor.equals("blue") && colorSensor.blue()>2){
                servo.setPosition (1);
                buttonHit = true;
            }
        }

        sleep(1000000);
    }
}
