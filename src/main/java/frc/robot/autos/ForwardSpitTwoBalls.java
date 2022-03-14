package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Drivetrain;

public class ForwardSpitTwoBalls extends SequentialCommandGroup {
    Drivetrain drivetrain;
    public ForwardSpitTwoBalls(Drivetrain drivetrain){
        this.drivetrain = drivetrain;
    }
}
