// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Intake extends SubsystemBase {
  /** Creates a new ExampleSubsystem. */
  CANSparkMax intakeMotor;
  public Intake() {
    intakeMotor = new CANSparkMax(Constants.IntakeConstants.intakeMotorID, MotorType.kBrushless);
    intakeMotor.setInverted(false);
    intakeMotor.setIdleMode(IdleMode.kCoast);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void In(){
    intakeMotor.set(Constants.IntakeConstants.intakeMotorSpeed);
  }

  public void Out(){
    intakeMotor.set(-Constants.IntakeConstants.intakeMotorSpeed);
  }

  public void Stop(){
    intakeMotor.set(0);
  }

  public void Spin(double speed){
    intakeMotor.set(speed);
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
