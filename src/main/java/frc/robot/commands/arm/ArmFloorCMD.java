package frc.robot.commands.arm;

import frc.robot.subsystems.arm.Arm;
import frc.robot.subsystems.arm.ArmPositionConstants;
import frc.robot.subsystems.led.Led2023;
import frc.robot.subsystems.led.Led2023.ColorScheme;

public class ArmFloorCMD extends ArmPositionCMD {

  public ArmFloorCMD(Arm arm, Led2023 ledStrip) {
    super(arm, ArmPositionConstants.FLOOR, ledStrip);
    ledStrip.setCmdColorScheme(ColorScheme.FLOOR);
  }
}
