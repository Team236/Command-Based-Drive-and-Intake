// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Intake;
import frc.robot.subsystems.Intake;
import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class IntakeFeed extends CommandBase {
  
  private Intake intake;
  /** Creates a new IntakeExtend. */
  public IntakeFeed(Intake intake) {

    this.intake = intake;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(intake);
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    intake.setIntakeSpeed(Constants.FORWARD_SPEED);
  }



  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    intake.stopIntake();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
