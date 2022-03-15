package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

public class SpitBallBackUp extends SequentialCommandGroup {
    Drivetrain drivetrain;
    Intake intake;
    Arm arm;
    public SpitBallBackUp(Drivetrain drivetrain, Intake intake, Arm arm){
        this.drivetrain = drivetrain;
        this.intake = intake;
        this.arm = arm;
        addRequirements(drivetrain, intake, arm);
        // command that creates a parralel deadline group that starts a WaitCommand and StartEndCommand at the same time. The StartEndCommand will set the drivetrain to go forward at the speed set in constants. When the WaitCommand reaches its time and ends, it will end the StartEndCommand that will run the code associated with the end value of the command which is to set the drivetrain to zero.
        ParallelDeadlineGroup driveForwardOneSecond = new ParallelDeadlineGroup(new WaitCommand(1), new StartEndCommand(() -> drivetrain.drive(Constants.AutoConstants.driveSpeed, Constants.AutoConstants.driveSpeed), () -> drivetrain.drive(0, 0)));
        // command that creates a parralel deadline group that starts a WaitCommand and StartEndCommand at the same time. The StartEndCommand will set the intake to go in at the speed set in the subsystem. When the WaitCommand reaches its time and ends, it will end the StartEndCommand that will run the code associated with the end value of the command which is to set the intake to zero.
        ParallelDeadlineGroup intakeOutHalfSecond = new ParallelDeadlineGroup(new WaitCommand(.5), new StartEndCommand(() -> intake.In(), () -> intake.Stop()));
        // command that creates a parralel deadline group that starts a WaitCommand and StartEndCommand at the same time. The StartEndCommand will set the drivetrain to go backward at negative the speed set in constants. When the WaitCommand reaches its time and ends, it will end the StartEndCommand that will run the code associated with the end value of the command which is to set the drivetrain to zero.
        ParallelDeadlineGroup driveBackwardOneSecond = new ParallelDeadlineGroup(new WaitCommand(2), new StartEndCommand(() -> drivetrain.drive(-Constants.AutoConstants.driveSpeed, -Constants.AutoConstants.driveSpeed), () -> drivetrain.drive(0, 0)));
        // puts all of the commands declared above and puts them in a SequentialCommandGroup which runs each command in sequence. Waits until last command has finished before moving on to the next. Ends when final command has ended.
        addCommands(new SequentialCommandGroup(driveForwardOneSecond, intakeOutHalfSecond, driveBackwardOneSecond));
    }
    
    
}
