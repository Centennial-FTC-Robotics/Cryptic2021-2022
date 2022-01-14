package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="First OpMode")
public class OpModes extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException{
        Robot robot = new Robot();
        robot.initialize(this);
        waitForStart();
        double forward, turn = 1;
        double factor = 0.85;
        boolean px = false;
        boolean toggle = false;
        int duck = 1;
        double up = 0;
        double spinny = 1;
        while(opModeIsActive()){

            forward = gamepad1.left_trigger - gamepad1.right_trigger -gamepad1.left_stick_y;
            //cause why not
            turn = gamepad1.right_stick_x * 0.9;
            //turning is too sensitive''
            if(gamepad1.y){
                duck+=1;
                if(duck > 3){
                    duck -= 3;
                }
            }

            if(duck == 1){
                robot.duckWheel.setPower(0);
            }

            if(duck == 2){
                robot.duckWheel.setPower(0.5);
            }

            if(duck == 3){
                robot.duckWheel.setPower(-0.5);
            }

            if(gamepad1.right_bumper){
                factor = 0.3;
            }

            else{
                factor = 0.85;
            }

            forward*=factor;
            turn*=factor;

            if(gamepad2.left_stick_y > 0){
                robot.intakeMotor.setPower(-1);
                robot.intakeServo.setPosition(0.10000001);
            }

            else if(gamepad2.left_stick_y < 0){
                robot.intakeMotor.setPower(1);
                robot.intakeServo.setPosition(0.7);
            }

            else{
                robot.intakeMotor.setPower(0);
                robot.intakeServo.setPosition(0.4);
            }


            if (gamepad2.b){
                robot.intakeServo.setPosition(0.9);
            }

//            if(up < 0){
//                up = 0.125;
//            }
//
//            if(up > 1){
//                up = 0.875;
//            }
//
//            if(gamepad2.right_stick_x >= 0.75){
//                up+=0.05;
//            }
//
//            else if(gamepad2.right_stick_x <= -0.75){
//                up-=0.05;
//            }
//
//            robot.Outake.outakeServo.setPosition(up);
//            robot.Outake.outakeServo2.setPosition(1-up);
//
//            if(gamepad2.b){
//                spinny+=1;
//                if(spinny>2){
//                    spinny = 1;
//                }
//            }
//
//            if(spinny == 1){
//                robot.Outake.outakeServo3.setPosition(0);
//                robot.Outake.outakeServo4.setPosition(0);
//            }
//
//            if(spinny == 2){
//                robot.Outake.outakeServo3.setPosition(0.722);
//                robot.Outake.outakeServo4.setPosition(0.722);
//            }


            double leftPower = (forward + turn);
            double rightPower = (forward - turn);
            double denominator = Math.max(Math.max(Math.abs(leftPower), Math.abs(rightPower)), 1);
            leftPower /= denominator;
            rightPower /= denominator;
            //proper scaling for motor powers in case it exceeds 1

            robot.rightFront.setPower(rightPower);
            robot.rightBack.setPower(rightPower);
            robot.leftBack.setPower(leftPower);
            robot.leftFront.setPower(leftPower);

        }
    }
}
