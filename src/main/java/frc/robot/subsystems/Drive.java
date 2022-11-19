// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
//add libraries AND the Constants folder so you can call robot elements like motors
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
    /** Creates a new Drive. */

  // Declare drive motor controllers
  private CANSparkMax leftFront, leftRear, rightFront, rightRear;
  public Drive() {
    //this is the same as the Drive Only Program// 

    // Initialize motor controllers using ID's stored in Constants
    leftFront = new CANSparkMax(Constants.ID_LEFT_FRONT, MotorType.kBrushless);
    rightFront = new CANSparkMax(Constants.ID_RIGHT_FRONT, MotorType.kBrushless);
    leftRear = new CANSparkMax(Constants.ID_LEFT_REAR, MotorType.kBrushless);
    rightRear = new CANSparkMax(Constants.ID_RIGHT_REAR, MotorType.kBrushless);

 // Set right front controller to be inverted
     leftFront.setInverted(false);
     rightFront.setInverted(true);
    
 // Set rear controllers to follow front
     leftRear.follow(leftFront, false);
     rightRear.follow(rightFront, false);
  }

  // Create methods to set speed of left and right motor controllers
  public void setLeftSpeed(double speed) {
    leftFront.set(speed);
  }

  public void setRightSpeed(double speed) {
    rightFront.set(speed);
  }

  // Set left and right drive speeds to zero (stop)
  public void stop() {
    setLeftSpeed(0);
    setRightSpeed(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }
}
