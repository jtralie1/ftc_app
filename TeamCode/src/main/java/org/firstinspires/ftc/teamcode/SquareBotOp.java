package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by UDRI1 on 2/8/2017.
 */

@TeleOp(name = "SquareBotOp", group = "test")
public class SquareBotOp extends OpMode{

    DcMotor br;
    DcMotor fr;
    DcMotor bl;
    DcMotor fl;

    public void init(){

        br = hardwareMap.dcMotor.get("back_right");
        fr = hardwareMap.dcMotor.get("front_right");
        fl = hardwareMap.dcMotor.get("front_left");
        bl = hardwareMap.dcMotor.get("back_left");
        br.setDirection(br.getDirection().REVERSE);
        fr.setDirection(fr.getDirection().REVERSE);

    }

    public void loop(){

        float leftY = gamepad1.left_stick_y;
        float rightY = gamepad1.right_stick_y;

        if(leftY > .3){
            fl.setPower(1);
            bl.setPower(1);
        }
        else if(leftY < -.3) {
            fl.setPower(-1);
            bl.setPower(-1);
        }
        else{
            fl.setPower(0);
            bl.setPower(0);
        }

        if(rightY > .3){
            fr.setPower(1);
            br.setPower(1);
        }
        else if(rightY < -.3) {
            fr.setPower(-1);
            br.setPower(-1);
        }
        else{
            fr.setPower(0);
            br.setPower(0);
        }

    }

}
