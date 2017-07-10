package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by UDRI1 on 2/16/2017.
 */

@TeleOp(name = "ElectricVehicle", group = "test")
public class ElectricVehicleOp extends OpMode{

    DcMotor br;
    DcMotor fr;
    DcMotor bl;
    DcMotor fl;

    //Objective distance needed
    double distance = 9;
    int encoderTicks = 0;

    //Circumference in meters
    final double WHEEL_CIRCUMFERENCE = 0.303227;

    public void init(){

        boolean upOneMeter = gamepad1.right_bumper;
        boolean downOneMeter = gamepad1.left_bumper;
        boolean upOneTenth = gamepad1.b;
        boolean downOneTenth = gamepad1.a;
        boolean upOneHundreth = gamepad1.y;
        boolean downOneHundreth = gamepad1.x;
        boolean stopIncrease = gamepad1.dpad_down;

        br = hardwareMap.dcMotor.get("back_right");
        fr = hardwareMap.dcMotor.get("front_right");
        fl = hardwareMap.dcMotor.get("front_left");
        bl = hardwareMap.dcMotor.get("back_left");
        br.setDirection(br.getDirection().REVERSE);
        fr.setDirection(fr.getDirection().REVERSE);
        br.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fr.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        fl.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        bl.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        //Used to set the objective distance
        while(!stopIncrease) {

            if (upOneMeter)
                distance++;
            if (downOneMeter)
                distance--;
            if (upOneTenth)
                distance += 0.1;
            if (downOneTenth)
                distance -= 0.1;
            if (upOneHundreth)
                distance += 0.01;
            if (downOneHundreth)
                distance -= 0.01;

        }
        //encoderTicks is calculated using inverse rotations of the wheel in degrees * distance in meters
        encoderTicks = (int)((360 / WHEEL_CIRCUMFERENCE) * distance);
    }

    public void loop(){

        //Sets encoder target positions and sets a low power
        br.setTargetPosition(encoderTicks);
        br.setPower(.5);

        bl.setTargetPosition(encoderTicks);
        bl.setPower(.5);

        fr.setTargetPosition(encoderTicks);
        fr.setPower(.5);

        fl.setTargetPosition(encoderTicks);
        fl.setPower(.5);

    }

}
