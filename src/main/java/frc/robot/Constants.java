// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // constants for drivetrain
    public static final class DrivetrainConstants {
        public static final int frontLeftMotorID = 1;
        public static final int frontRightMotorID = 1;
        public static final int backLeftMotorID = 1;
        public static final int backRightMotorID = 1;
    }
    // constants for the arm
    public static final class ArmConstants {
        public static final int armMotorID = 1;
        public static final double armMotorSpeed = .5;
    }
    // constants for the intake
    public static final class IntakeConstants {
        public static final int intakeMotorID = 1;
        public static final double intakeMotorSpeed = .5;
    }
}
