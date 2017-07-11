package org.firstinspires.ftc.teamcode;

/**
 * Created by UDRI1 on 2/25/2017.
 */

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.ftccommon.DbgLog;

@Autonomous(name="Output Timer", group = "test")
public class OutputTimeTest extends LinearOpMode{

    @Override
    public void runOpMode() throws InterruptedException{

        DbgLog.msg("Starting timer");

        double startTime = getRuntime();
        double elapsedTime, currentTime;

        waitForStart();

        while(opModeIsActive()){

            currentTime = getRuntime();
            elapsedTime = currentTime - startTime;
            telemetry.addData("1. elapse", String.format("%.03f", elapsedTime));
            DbgLog.msg(String.format("Elapsed time: %.03f"), elapsedTime);
            this.sleep(250);
        }

    }

}
