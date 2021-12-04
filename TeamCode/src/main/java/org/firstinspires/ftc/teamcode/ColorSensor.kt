package org.firstinspires.ftc.teamcode

import android.app.Activity
import android.graphics.Color
import android.view.View
import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cColorSensor
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.ColorSensor
import org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap

class ColorSensor{
    var colorSensor // Hardware Device Object
            : ColorSensor? = null
    fun init(){
    colorSensor = hardwareMap.get(ColorSensor::class.java, "sensor_color")
}
}
