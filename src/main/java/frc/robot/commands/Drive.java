package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends CommandBase {
    Drivetrain drivetrain;
    Joystick ljoystick;
    Joystick rjoystick;

    public Drive(Drivetrain dt, Joystick lj, Joystick rj){
        drivetrain = dt;
        ljoystick = lj;
        rjoystick = rj;
        super.addRequirements(drivetrain);
        drivetrain.setDefaultCommand(this);

    }
    public void execute(){
        drivetrain.drive(ljoystick.getY(), rjoystick.getY());
    }

    public void intitialize(){
        drivetrain.stop();
    }

    public boolean isFinished(){
        return false;
    }
        
    public void end(boolean stop){
        drivetrain.stop();
    }
}
