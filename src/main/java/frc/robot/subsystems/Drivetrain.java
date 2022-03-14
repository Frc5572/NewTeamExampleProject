// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Drivetrain extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  MotorController m_frontLeft;
  MotorController m_rearLeft;
  MotorControllerGroup m_left;
  MotorController m_frontRight;
  MotorController m_rearRight;
  MotorControllerGroup m_right;
  DifferentialDrive m_drive;
  XboxController driver;
  public Drivetrain(XboxController driver) {
    this.driver = driver;
    m_frontLeft = new CANSparkMax(Constants.DrivetrainConstants.frontLeftMotorID, MotorType.kBrushless);
    m_rearLeft = new CANSparkMax(Constants.DrivetrainConstants.backLeftMotorID, MotorType.kBrushless);
    m_left = new MotorControllerGroup(m_frontLeft, m_rearLeft);

    m_frontRight = new CANSparkMax(Constants.DrivetrainConstants.frontRightMotorID, MotorType.kBrushless);
    m_rearRight = new CANSparkMax(Constants.DrivetrainConstants.backRightMotorID, MotorType.kBrushless);
    m_right = new MotorControllerGroup(m_frontRight, m_rearRight);

    m_drive = new DifferentialDrive(m_left, m_right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void joystickInput(double left, double right){
    m_drive.tankDrive(left, right);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
