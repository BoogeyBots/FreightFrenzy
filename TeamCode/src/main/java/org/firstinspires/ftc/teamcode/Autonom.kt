package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo
import com.qualcomm.robotcore.util.ElapsedTime
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
        wait(1000.0)
        dcAruncat?.power = 0.65
        for(i in 1..3) {

           wait(3000.0)
           servoImpins?.position = 0.0
           wait(1000.0)
           servoImpins?.position = 0.5
       }
       dcAruncat?.power = 0.0
    }

    fun wait(mil: Double){
        val time = ElapsedTime()
        while(opModeIsActive() && time.milliseconds() < mil){
        }
    }

}