// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
//make sure to import ALL NECESSARY libraries to make life easier and avoid code errors
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
//Import constants folder to call constants values
import frc.robot.Constants.ControllerConstants;
import frc.robot.Constants;
//Import commands for button bindings
import frc.robot.commands.Drive_With_Joysticks;
import frc.robot.commands.Intake.IntakeRetract;
import frc.robot.commands.Intake.IntakeExtend;
import frc.robot.commands.Intake.IntakeFeed;
//import subsystems
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Intake;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

   // **JOYSTICKS**
   Joystick controller = new Joystick(Constants.USB_CONTROLLER);
   Joystick leftStick = new Joystick(Constants.USB_LEFT_STICK);
   Joystick rightStick = new Joystick(Constants.USB_RIGHT_STICK);
  // **SUBSYTEMS **
  private final Drive drive = new Drive();
  private final Intake intake = new Intake();
  //**COMMANDS */
  private final Drive_With_Joysticks driveWithJoysticks = new Drive_With_Joysticks(drive, leftStick, rightStick);
  private final IntakeFeed intakeFeed = new IntakeFeed(intake);
  private final IntakeRetract intakeRetract = new IntakeRetract(intake);
  private final IntakeExtend intakeExtend = new IntakeExtend(intake);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drive.setDefaultCommand(driveWithJoysticks);

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

    //CREATE BUTTON INSTANCES
    //IntakeFeed will be mapped here
    JoystickButton leftTrigger = new JoystickButton(leftStick, ControllerConstants.Thrustmaster.TRIGGER);
    //IntakeExtend will be mapped here
    JoystickButton leftStickLeft = new JoystickButton(leftStick, ControllerConstants.Thrustmaster.BUTTON_LEFT);
    //IntakeRetract will be mapped here
    JoystickButton rightStickRight = new JoystickButton(rightStick, ControllerConstants.Thrustmaster.BUTTON_RIGHT);


    //ASSIGN BUTTONS TO COMMANDS
    leftTrigger.whileActiveOnce(intakeFeed);
    leftStickLeft.whenPressed(intakeExtend);
    rightStickRight.whenPressed(intakeRetract);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public boolean getAutonomousCommand() {
    return false;
    // An ExampleCommand will run in autonomous
  
  }
}
