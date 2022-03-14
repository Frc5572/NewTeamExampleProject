// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Arm extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  CANSparkMax armMotor;
  public Arm() {
    armMotor = new CANSparkMax(Constants.ArmConstants.armMotorID, MotorType.kBrushless);
    armMotor.setInverted(false);
    armMotor.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void Up(){
    armMotor.set(Constants.ArmConstants.armMotorSpeed);
  }

  public void Down(){
    armMotor.set(-Constants.ArmConstants.armMotorSpeed);
  }

  public void Stop(){
    armMotor.set(0);
  }

  public void Move(double speed){
    armMotor.set(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
