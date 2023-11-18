package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AutoDrive;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.Drive;
import frc.robot.commands.MoveArm;

public class RobotContainer {
  Joystick leftJoystick = new Joystick(0);
  Joystick rightJoystick = new Joystick(1);
  JoystickButton raiseArm = new JoystickButton(leftJoystick, 2);
  JoystickButton lowerArm = new JoystickButton(rightJoystick, 2);

  Drivetrain drivetrain = new Drivetrain();
  Arm arm = new Arm();
  Drive drive = new Drive(drivetrain, leftJoystick, rightJoystick);
  MoveArm marm = new MoveArm(arm, 0);

  public RobotContainer() {
    drivetrain.setDefaultCommand(drive);
    configureButtonBindings();
  }

  private void configureButtonBindings() {
    raiseArm.whileTrue(new MoveArm(arm, 0.1));
    lowerArm.whileTrue(new MoveArm(arm, -0.1));
  }

  public Command getAutonomousCommand() {
    return new AutoDrive(drivetrain, 0.5, 0.5, 2);
  }
}
