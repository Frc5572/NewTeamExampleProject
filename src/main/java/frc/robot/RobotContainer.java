// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.autos.MoveOutBox;
import frc.robot.autos.SpitBallBackUp;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final XboxController driver = new XboxController(0);
  private final XboxController operator = new XboxController(1);
  private final Drivetrain drivetrain = new Drivetrain();
  private final Arm arm = new Arm();
  private final Intake intake = new Intake();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // default command constantly runs unless interrupted by another command.
    drivetrain.setDefaultCommand(new TeleopDrivetrain(drivetrain, driver));
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // While Y is pressed, create a new start end command that moves the arm up when initialized and 
    // stops the motor when the command ends (button is no longer pressed).
    new JoystickButton(operator, XboxController.Button.kY.value).whileHeld(new StartEndCommand(() -> arm.Up(), () -> arm.Stop(), arm));
    // same thing except with button X and will move the arm down instead of up.
    new JoystickButton(operator, XboxController.Button.kX.value).whileHeld(new StartEndCommand(() -> arm.Down(), () -> arm.Stop(), arm));

    // While A is pressed, create a new start end command that moves the intake in when initialized and 
    // stops the motor when the command ends (button is no longer pressed).
    new JoystickButton(operator, XboxController.Button.kA.value).whileHeld(new StartEndCommand(() -> intake.In(), () -> intake.Stop(), intake));
    // same thing except with button b and will move the intake out instead of in.
    new JoystickButton(operator, XboxController.Button.kB.value).whileHeld(new StartEndCommand(() -> intake.Out(), () -> intake.Stop(), intake));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return new SpitBallBackUp(drivetrain, intake, arm);
    // return new MoveOutBox(drivetrain);
  }
}
