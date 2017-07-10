package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cCompassSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CompassSensor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import java.sql.Timestamp;

/**
 * Created by UDRI1 on 1/24/2017.
 */

@Autonomous(name = "Time Test", group = "Sensor")
public class TimestampTest extends LinearOpMode{

    ModernRoboticsI2cCompassSensor compass;

    double xBias;
    double yBias;
    double zBias;
    double velocity;
    double distance;

    @Override
    public void runOpMode(){

        compass = hardwareMap.get(ModernRoboticsI2cCompassSensor.class, "compass");
        long previousMillis=0;

        long elapsedtime=0;
        long currentMillis;
        double totalDistance = 0;
        double distance = 0;
        double deltavelocity = 0.0;
        double velocity = 0.0;
        double Ax=0.0;
        int count = 0;

        while (count < 1000) {
            Acceleration startAccel = compass.getAcceleration();
            xBias += startAccel.xAccel;
            yBias += startAccel.yAccel;
            zBias += startAccel.zAccel;
            count += 1;
        }

        xBias = xBias / count;
        yBias = yBias / count;
        zBias = zBias / count;
        count = 0;

        waitForStart();

        long starttime = System.currentTimeMillis();

        while(opModeIsActive()) {

            currentMillis = System.currentTimeMillis();
            elapsedtime =  (currentMillis - starttime);
            Acceleration accel = compass.getAcceleration();
            Ax += accel.xAccel;
            count += 1;
            telemetry.addData("current:", currentMillis);
            telemetry.addData("count:", count);
            telemetry.addData("Elapsed time:", elapsedtime);
            telemetry.addData("Ax:", Ax);
            telemetry.addData("Current Ax:", accel.xAccel);
            telemetry.addData("Current Ay:", accel.yAccel);
            telemetry.addData("Current Az:", accel.zAccel);
            telemetry.addData("xBias:", xBias);
 //           telemetry.addData("previous:", previousMillis);

            if(elapsedtime > 100) {
                Ax = Ax/count;
                deltavelocity = getDistance(elapsedtime, Ax);
                velocity += deltavelocity;
                distance += velocity*elapsedtime/1000;
                elapsedtime = 0;
                Ax = 0.0;
                count = 0;
                starttime = currentMillis;

 //               totalDistance += distance;
            }


            telemetry.addData("Distance:", distance);
            telemetry.addData("Velocity:", velocity);
            telemetry.addData("Delta Velocity:", deltavelocity);
            telemetry.addData("Count: ", count);
            telemetry.update();

        }
    }

    //Calculates and returns the distance traveled in one tick.
    public double getDistance(long deltatime, double Ax){

        //time in seconds since last tick
        double timePassed = (deltatime)/1000.;

       Acceleration accel = compass.getAcceleration();
        double deltavelocity = (Ax-xBias) * timePassed;
 //       velocity +=deltavelocity;
        telemetry.addData("X Acceleration: ", (accel.xAccel-xBias)) ;
        telemetry.addData("Y Acceleration: ", (accel.yAccel-yBias)) ;
        telemetry.addData("Z Acceleration: ", (accel.zAccel-zBias)) ;
        telemetry.addData("X Acceleration NB: ", (accel.xAccel)) ;
        telemetry.addData("Y Acceleration nb: ", (accel.yAccel)) ;
//        double deltadistance = velocity * timePassed;
//        distance+=deltadistance;
        telemetry.addData("Z Acceleration nb: ", (accel.zAccel)) ;
        telemetry.addData("Time passed:", timePassed);
        return deltavelocity;

    }

}
