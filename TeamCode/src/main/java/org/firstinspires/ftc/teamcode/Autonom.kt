package org.firstinspires.ftc.teamcode.drive.opmode

import com.acmerobotics.roadrunner.geometry.Pose2d
import com.acmerobotics.roadrunner.geometry.Vector2d
import com.acmerobotics.roadrunner.trajectory.Trajectory
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive

/*
* This is an example of a more complex path to really test the tuning.
*/
@Autonomous(group = "drive")
class SplineTest : LinearOpMode() {
    @Throws(InterruptedException::class)
    override fun runOpMode() {
        val drive = SampleMecanumDrive(hardwareMap)
        drive.poseEstimate = Pose2d(10.0, 60.0, Math.toRadians(90.0))
        waitForStart()
        if (isStopRequested) return
        val traj = drive.trajectoryBuilder(drive.poseEstimate)
            .lineTo(Vector2d(-36.0, 60.0))
            .build()
        drive.followTrajectory(traj)
        val traj1 = drive.trajectoryBuilder(traj.end())
            .lineTo(Vector2d(-45.0, 47.0))
            .build()
        drive.followTrajectory(traj1)
        val traj2 = drive.trajectoryBuilder(traj1.end())
            .lineTo(Vector2d(-37.0, 47.0))
            .build()
        drive.followTrajectory(traj2)
        val traj3 = drive.trajectoryBuilder(traj2.end())
            .lineTo(Vector2d(-29.0, 47.0))
            .build()
        drive.followTrajectory(traj3)
        val traj4 = drive.trajectoryBuilder(drive.poseEstimate)
            .lineTo(Vector2d(-12.0, 42.0))
            .build()
        val traj5 = drive.trajectoryBuilder(drive.poseEstimate)
            .lineTo(Vector2d(45.0, 38.0))
            .build()
    }
}