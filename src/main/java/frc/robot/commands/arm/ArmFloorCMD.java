package frc.robot.commands.arm;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.intakerelease.IntakeCMD;
import frc.robot.subsystems.arm.Arm;
import frc.robot.subsystems.arm.ArmPositionConstants;
import frc.robot.subsystems.intakerelease.IntakeRelease;

public class ArmFloorCMD extends SequentialCommandGroup {

  public ArmFloorCMD(Arm arm, IntakeRelease intakeRelease) {
    addCommands(
        new ArmSetPosition(
            arm,
            intakeRelease,
            arm.getExtention(),
            intakeRelease.wantsCone()
                ? ArmPositionConstants.CONE_FLOOR.rotateSetpoint
                : ArmPositionConstants.CUBE_FLOOR.rotateSetpoint),
        Commands.parallel(
            new ArmPositionCMD(
                arm,
                () ->
                    intakeRelease.wantsCone()
                        ? ArmPositionConstants.CONE_FLOOR
                        : ArmPositionConstants.CUBE_FLOOR),
            new IntakeCMD(intakeRelease)),
        new RaiseArm(arm).unless(() -> !arm.shouldRaise()));
  }
}
