package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-12, 66, Math.toRadians(90)))
                                .lineTo(new Vector2d(-12, 36))
                                .waitSeconds(3)
                                .addDisplacementMarker(() -> {
                                })
                                .waitSeconds(3)
                                .addDisplacementMarker(() -> {
                                })
                                .waitSeconds(3)
                                .lineTo(new Vector2d(-12, 52))
                                .splineTo(new Vector2d(10, 66), Math.toRadians(0))
                                .lineTo(new Vector2d(55, 66))
                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_FREIGHTFRENZY_ADI_DARK)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}