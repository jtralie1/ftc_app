package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;


/**
 * Created by UDRI1 on 7/28/2016.
  Used to check the functionality of the GamePad
 */
@TeleOp(name = "GamePadTlm1", group = "Test")
public class GamePadTlm1 extends OpMode{

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
                        , "Button a: "
                                + gamepad1.a
                );
        telemetry.addData
                ( "02"
                        , "Button b: "
                                + gamepad1.b
                );
        telemetry.addData
                ( "03"
                        , "Button back: " + gamepad1.back
                );
        telemetry.addData
                ( "04"
                        , "Dpad_down: " + gamepad1.dpad_down
                );
        telemetry.addData
                ( "05"
                        , "Dpad_up: " + gamepad1.dpad_up
                );
        telemetry.addData
                ( "06"
                        , "Dpad_left: " + gamepad1.dpad_left
                );
        telemetry.addData
                ( "07"
                        , "Dpad_right: " + gamepad1.dpad_right
                );
        telemetry.addData
                ( "08"
                        , "Button x: "
                                + gamepad1.x
                );
        telemetry.addData
                ( "09"
                        , "Button y: "
                                + gamepad1.y
                );
        telemetry.addData
                ( "10"
                        , "Button start: "
                                + gamepad1.start
                );

    }
}