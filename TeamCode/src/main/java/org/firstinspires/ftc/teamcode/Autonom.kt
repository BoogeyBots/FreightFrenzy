package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap

@Autonomous(name = "Autonom aruncat", group = "Sensor")
class Autonom : LinearOpMode(){
    private  var servoImpins: Servo? = null
    private var dcAruncat: DcMotor? = null
   override fun runOpMode() {

        servoImpins = hardwareMap.get(Servo::class.java, "servo_impins")
        dcAruncat = hardwareMap.get(DcMotor::class.java, "dc_aruncat")

       servoImpins?.position = 0.5

        waitForStart()
        Thread.sleep(1000)
        dcAruncat?.power = 0.65
        for(i in 1..3) {

           Thread.sleep(3000)
           servoImpins?.position = 0.0
           Thread.sleep(1000)
           servoImpins?.position = 0.5
       }
       dcAruncat?.power = 0.0
    }


}