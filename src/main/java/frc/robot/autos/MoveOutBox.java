package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.ParallelDeadlineGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.StartEndCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Drivetrain;
import frc.robot.Constants;

public class MoveOutBox extends SequentialCommandGroup {
    Drivetrain drivetrain;
    public MoveOutBox(Drivetrain drivetrain){
        this.drivetrain = drivetrain;
        addRequirements(drivetrain);
        // command that creates a parralel deadline group that starts a WaitCommand and StartEndCommand at the same time. The StartEndCommand will set the drivetrain to go forward at the speed set in constants. When the WaitCommand reaches its time and ends, it will end the StartEndCommand that will run the code associated with the end value of the command which is to set the drivetrain to zero.
        ParallelDeadlineGroup driveForwardOneSecond = new ParallelDeadlineGroup(new WaitCommand(1), new StartEndCommand(() -> drivetrain.drive(Constants.AutoConstants.driveSpeed, Constants.AutoConstants.driveSpeed), () -> drivetrain.drive(0, 0)));
        // puts all of the commands declared above and puts them in a SequentialCommandGroup which runs each command in sequence. Waits until last command has finished before moving on to the next. Ends when final command has ended.
        addCommands(new SequentialCommandGroup(driveForwardOneSecond));
    }
    
    
}
