package frc.robot.commands;

import frc.robot.subsystems.Arm;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveArm extends CommandBase {
    Arm marm;
    double speed;

    public MoveArm(Arm a, double s){
        marm = a;
        speed = s;
        super.addRequirements(marm);
    }
    public void execute(){
        marm.moveArm(speed);
    }

    public void initialize(){
        marm.stop();
    }

    public boolean isFinished(){
        return false;
    }

    public void end(boolean stop){
        marm.stop();
    }
}
