// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/** Add your docs here. */
public class Drive {
    // //Rev motor powered by SparkMax
    // private final CANSparkMax testMotor = new CANSparkMax(1, MotorType.kBrushless);

    // //CTRE motor powered by TalonSRX
    // private final Talon testMotor2 = new Talon(2);

    // //Rev motor powered by SparkFlex
    // private final CANSparkFlex testMotor3 = new CANSparkFlex(1, MotorType.kBrushless);

    // //CTRE motor powered by TalonFX
    // private final TalonFX testMotor4 = new TalonFX(5);

    private final CANSparkMax lF = new CANSparkMax(Constants.lFMotor, MotorType.kBrushed); //left front motor
    private final CANSparkMax lR = new CANSparkMax(Constants.lRMotor, MotorType.kBrushed); //left rear motor
    private final CANSparkMax rF = new CANSparkMax(Constants.rFMotor, MotorType.kBrushed); //right front motor
    private final CANSparkMax rR = new CANSparkMax(Constants.rRMotor, MotorType.kBrushed); //right rear motor
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public final DifferentialDrive drive = new DifferentialDrive(lR, rR);

    void drive(double throttle, double rotation) {
        lF.follow(lR);
        rF.follow(rR);
        drive.arcadeDrive(-throttle, rotation);
    }
}
