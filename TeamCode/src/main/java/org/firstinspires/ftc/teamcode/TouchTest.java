package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
/**
 * Created by UDRI1 on 1/19/2017.
 */
@TeleOp(name = "TouchTest", group = "test")
public class TouchTest extends OpMode{

    TouchSensor touch;

    @Override
    public void init(){

        touch = hardwareMap.touchSensor.get("touch");

    }

    @Override
    public void loop(){

        //if button is pressed, sets isPressed to true
        boolean isPressed;

        if(touch.isPressed())
            isPressed = true;
        else
            isPressed = false;

        telemetry.addData("Touch: ", isPressed);
    }

}
