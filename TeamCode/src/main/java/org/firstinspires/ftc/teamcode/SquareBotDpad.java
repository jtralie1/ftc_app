package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
/**
 * Created by UDRI1 on 2/8/2017.
 */

@TeleOp(name = "SquareBotDPad", group = "test")
public class SquareBotDpad extends OpMode{

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

        boolean forward = gamepad1.dpad_up;
        boolean backward = gamepad1.dpad_down;
        boolean left = gamepad1.dpad_left;
        boolean right = gamepad1.dpad_right;

        if(forward){
            fl.setPower(-1);
            fr.setPower(-1);
            br.setPower(-1);
            bl.setPower(-1);
        }

        else if(backward){

            fl.setPower(1);
            fr.setPower(1);
            br.setPower(1);
            bl.setPower(1);

        }

        else if(left){

            fl.setPower(1);
            fr.setPower(-1);
            br.setPower(-1);
            bl.setPower(1);

        }

        else if(right){

            fl.setPower(-1);
            fr.setPower(1);
            br.setPower(1);
            bl.setPower(-1);

        }

        else{

            fl.setPower(0);
            fr.setPower(0);
            br.setPower(0);
            bl.setPower(0);

        }

    }

}
