package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by UDRI1 on 1/10/2017.
 */
@TeleOp(name = "MotorThingy", group = "test")

public class MotorThingy extends OpMode
{
    DcMotor left;
    DcMotor right;

    public void init()
    {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");
        left.setDirection(DcMotor.Direction.REVERSE);
    }

    public void loop()
    {
        boolean shoot = gamepad1.dpad_up;
        if(shoot)
        {
            left.setPower(1);
            right.setPower(1);
        }
        else
        {
            //get rekt skrub
            left.setPower(0);right.setPower(0);
        }

    }
}
