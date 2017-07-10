package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareDevice;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.VoltageSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotorController;

/**
 * Created by UDRI-2 on 2/14/2017.
 */
import com.qualcomm.hardware.modernrobotics.ModernRoboticsUsbDcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorController;

@TeleOp (name = "VoltTest", group = "Test")
public class VoltageTester extends OpMode{

    double voltage;
    private ModernRoboticsUsbDcMotorController MC;

    DcMotor a;
    public void init (){
        //VoltageSensor VS = new VoltageSensor();
       // motor = hardwareMap.dcMotor.get("motor");
       // dc = hardwareMap.dcMotorController.get("controller");
        //VoltageSensor VS = hardwareMap.voltageSensor.get("vS");
        MC = (ModernRoboticsUsbDcMotorController) hardwareMap.dcMotorController.get("dcM");
    }
    public void loop(){
        //voltage = hardwareMap.voltageSensor.get("volt").getVoltage();
        //voltage = hardwareMap.getAll(VoltageSensor.class).get(0).getVoltage();
        voltage = MC.getVoltage();
        telemetry.addData("Voltage: ", voltage);
        telemetry.update();
    }
}
