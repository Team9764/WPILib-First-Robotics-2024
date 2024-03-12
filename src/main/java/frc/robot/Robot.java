// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Timer;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private static final XboxController xbox1 = new XboxController(0);
  private static final Drive m_drive = new Drive();
  private static final Shooter m_shooter = new Shooter();
  //private static final autonomousTest m_autoTest = new autonomousTest();



  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
 
  private Timer autoTimer = new Timer();        // makes timer named autoTimer
  @Override
  public void autonomousInit() {
    autoTimer.reset();
    autoTimer.start();
  }

  /** This function is called periodically during autonomous. */
  
    @Override
    public void autonomousPeriodic() {
      if (autoTimer.get() < 5.0) {
        m_drive.drive.arcadeDrive(-0.5, 0); // for first five seconds go forward at half speed
      }
      else if (autoTimer.get() < 7.0) {
        m_drive.drive.arcadeDrive(0, -0.5); // for next two seconds turn right at half speed (just cause it can)
      }
      else if (autoTimer.get() < 9.0) {
        m_drive.drive.arcadeDrive(0, 0.5); // for nest two seconds turn left at half speed
      }
      else {
        m_drive.drive.arcadeDrive(0, 0); // if nothing requires the timer then stop
      }
  } 



  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {}

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    m_drive.drive(xbox1.getLeftY(), xbox1.getRightX());
    m_shooter.shooterOn(xbox1.getAButtonPressed());
    m_shooter.shooterOnHalf(xbox1.getXButtonPressed());
   // m_autoTest.autoTest(xbox1.getXButtonPressed());
      //lets xbox controller be used left sick up and down right for turning and A for shoot
  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {}

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {}

  /** This function is  called once when test mode is enabled. */
  @Override
  public void testInit() {}

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}
