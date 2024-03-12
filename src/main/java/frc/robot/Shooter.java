// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
//import edu.wpi.first.wpilibj.XboxController;



/** Add your docs here. */
public class Shooter {
    private final CANSparkMax shooterMotor = new CANSparkMax(Constants.shoot, MotorType.kBrushless);

   public void shooterOnHalf(boolean getXButtonPressed) {
      if (getXButtonPressed) {
         shooterMotor.set(0.5);
      }
      else {
         shooterMotor.set(0);
      }
   }

   public void shooterOn(boolean getAButtonPressed) {
      if (getAButtonPressed ) {
         shooterMotor.set(1);//sets shooter to full speed
      } else {
         shooterMotor.set(0);//sets shooter to no speed
      }
      
   }
}
