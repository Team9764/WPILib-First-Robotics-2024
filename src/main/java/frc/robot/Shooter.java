// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import com.revrobotics.CANSparkMax;

public class Shooter extends Command{
   
    final CANSparkMax shooterMotor = new CANSparkMax(Constants.shootOne, MotorType.kBrushed);
    final CANSparkMax shooterMotor2 = new CANSparkMax(Constants.shootTwo, MotorType.kBrushed);
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void shooterOn(double power) {
      shooterMotor.set(power);
      shooterMotor2.set(power);
   }
   public void rampUp(boolean state){
      if (state == true){
         shooterMotor.set(-1);
      }
   }
   public void indexUp(  boolean state2){
      if (state2 == true){
         shooterMotor2.set(-1);
      }
   }
}

