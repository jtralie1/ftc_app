package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.DcMotor;

/**
 * Created by UDRI1 on 7/28/2016.
  Simple Tank Drive Program
 */
public class SimpleDrive extends OpMode{
    // Declare Motor Variables
    DcMotor leftmotor;
    DcMotor rightmotor;

    @Override
    public void init() {
        // Map Motor Variables to Hardware on robot using Hardware Map
        leftmotor = hardwareMap.dcMotor.get("left_motor");
        rightmotor = hardwareMap.dcMotor.get("right_motor");
// Right motor is mounted backwards from left motor so reverse its direction
        rightmotor.setDirection(DcMotor.Direction.REVERSE);


    }

    @Override
    public void loop() {
        // Read gamepad values and set motor power to them (negative sign is used since pushing forward
        //   on stick gives a negative value
        float leftY = -gamepad1.left_stick_y;
        float rightY = -gamepad1.right_stick_y;

        leftmotor.setPower(leftY);
        rightmotor.setPower(rightY);
        telemetry.addData
                ( "01"
                        , "Left Drive: "
                                + leftY);

        telemetry.addData
                ("02"
                        , "Right Drive: "
                                + rightY
                );
    }
}
