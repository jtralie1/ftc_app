package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by UDRI1 on 7/28/2016.
 */ Used to check the functionality of the GamePad
public class GamePadTlm2 extends OpMode {

    @Override
    public void init() {


    }

    @Override
    public void loop() {
        //
        // Send telemetry data to the driver station.
        //
        telemetry.addData
                ( "01"
                        , "left_bumper: "
                                + gamepad1.left_bumper
                );
        telemetry.addData
                ( "02"
                        , "left_stick_button: "
                                + gamepad1.left_stick_button
                );
        telemetry.addData
                ( "03"
                        , "left_stick_x: " + gamepad1.left_stick_x
                );
        telemetry.addData
                ( "04"
                        , "left_stick_y: " + gamepad1.left_stick_y
                );
        telemetry.addData
                ( "05"
                        , "left_trigger: " + gamepad1.left_trigger
                );
        telemetry.addData
                ( "06"
                        , "right_bumper: "
                                + gamepad1.right_bumper
                );
        telemetry.addData
                ( "07"
                        , "right_stick_button: "
                                + gamepad1.right_stick_button
                );
        telemetry.addData
                ( "08"
                        , "right_stick_x: " + gamepad1.right_stick_x
                );
        telemetry.addData
                ( "09"
                        , "right_stick_y: " + gamepad1.right_stick_y
                );
        telemetry.addData
                ( "10"
                        , "right_trigger: " + gamepad1.right_trigger
                );

    }
}