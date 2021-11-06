package org.firstinspires.ftc.teamcode.drive.opmode

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive

/*
* This is an example of a more complex path to really test the tuning.
*/
@Autonomous(group = "drive")
class testautonom : LinearOpMode() {
    @Throws(InterruptedException::class)
    override fun runOpMode() {
        val startPose= Pose2d(12.0,17.5)
        val drive = SampleMecanumDrive(hardwareMap)
        waitForStart()
        if (isStopRequested) return
        val traj1 = drive.trajectoryBuilder(startPose)
                .splineTo(Vector2d(30.0, 30.0), 0.0)
                .build()
        drive.followTrajectory(traj1)
        val traj2 = drive.trajectoryBuilder(Pose2d(30.0 ,30.0))
                .splineTo(Vector2d(48.0, 16.0), 0.0)
                .build()
        drive.followTrajectory(traj2)
        val traj3 = drive.trajectoryBuilder(Pose2d(48.0 ,16.0))
                .splineTo(Vector2d(26.0, 5.0), 0.0)
                .build()
        drive.followTrajectory(traj3)
        val traj4 = drive.trajectoryBuilder(Pose2d(26.0 ,5.0))
                .splineTo(Vector2d(0.0, 0.0), 0.0)
                .build()
        drive.followTrajectory(traj4)

    }
}