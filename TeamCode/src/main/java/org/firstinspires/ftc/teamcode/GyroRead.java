package com.qualcomm.ftcrobotcontroller.opmode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cGyro;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.GyroSensor;

//WORK ON LINEAR OPMODE ABSTRACT PROBLEM

/**
 * Created by UDRI1 on 9/27/2016.
 */
@TeleOp(name = "GyroRead", group = "test")
public abstract class GyroRead extends LinearOpMode {


    public void main() throws InterruptedException {
        int zAccumulated;
        int heading;
        int xVal, yVal, zVal;

        GyroSensor sensorGyro;
        ModernRoboticsI2cGyro mrGyro;

        sensorGyro = hardwareMap.gyroSensor.get("gryo");
        mrGyro = (ModernRoboticsI2cGyro) sensorGyro;

        mrGyro.calibrate();

        waitForStart();

        while (mrGyro.isCalibrating()) {
        }

        while (opModeIsActive()){
            zAccumulated = mrGyro.getIntegratedZValue();
            heading = mrGyro.getHeading();

            xVal= mrGyro.rawX();
            yVal= mrGyro.rawY();
            zVal= mrGyro.rawZ();

            telemetry.addData("1. headding", String.format("%03", heading));
            telemetry.addData("2. accu", String.format("%03d", zAccumulated));
            telemetry.addData("3. X", String.format("%03d", xVal));
            telemetry.addData("3. Y", String.format("%03d", yVal));
            telemetry.addData("3. Z", String.format("%03d", zVal));


        }
    }
}