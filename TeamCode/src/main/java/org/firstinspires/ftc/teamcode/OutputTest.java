package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by UDRI1 on 2/15/2017.
 */

@Autonomous(name= "OutputTester", group = "test")
public class OutputTest extends LinearOpMode{


    @Override
    public void runOpMode(){

        int counter = 0;
        PrintWriter output=null;

        String test = "test";

        try {
            output = new PrintWriter("Phone/Documents/Text_Editor/log.txt");
            output.println(test);
        }catch(FileNotFoundException e){
            telemetry.addData("File not found", null);
        }

        waitForStart();


        counter++;
        if(counter % 1000 == 0)
            output.println(counter);

    }





}
