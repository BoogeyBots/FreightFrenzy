package org.firstinspires.ftc.teamcode

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive
import com.qualcomm.robotcore.hardware.ColorSensor


/*
*
* This is an example LinearOpMode that shows how to use
* a Modern Robotics Color Sensor.
*
* The op mode assumes that the color sensor
* is configured with a name of "sensor_color".
*
* You can use the X button on gamepad1 to toggle the LED on and off.
*
* Use Android Studio to Copy this Class, and Paste it into your team's code folder with a new name.
* Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
*/
@Autonomous(name = "Autonom detectare obiect", group = "Sensor")
class Autonom_ColorSensor : LinearOpMode() {
    var colorSensor // Hardware Device Object
            : com.qualcomm.robotcore.hardware.ColorSensor? = null
    fun colors(): Int {
        return colorSensor!!.red()
    }
    fun red(): Boolean{
        if (colors() < 20) return true
        else return false
    }
    override fun runOpMode() {
        colorSensor = hardwareMap.get(ColorSensor::class.java, "sensor_color")
        val drive = SampleMecanumDrive(hardwareMap)
        var position: Int
        waitForStart()
        if (isStopRequested) return
        val traj: Trajectory = drive.trajectoryBuilder(Pose2d(-36.0, 60.0))
            .splineTo(Vector2d(-45.0, 47.0), 0.0)
            .build()
        drive.followTrajectory(traj)
        if(red()) position = 1
        val traj1: Trajectory = drive.trajectoryBuilder(traj.end())
            .splineTo(Vector2d(-37.0, 47.0), 0.0)
            .build()
        drive.followTrajectory(traj1)
        if(red()) position = 2
        val traj2: Trajectory = drive.trajectoryBuilder(traj1.end())
            .splineTo(Vector2d(-29.0, 47.0), 0.0)
            .build()
        drive.followTrajectory(traj2)
        if(red()) position = 3
        sleep(2000)
        drive.followTrajectory(
            drive.trajectoryBuilder(traj.end(), true)
                .splineTo(Vector2d(0.0, 0.0), Math.toRadians(180.0))
                .build()
        )
    }
}