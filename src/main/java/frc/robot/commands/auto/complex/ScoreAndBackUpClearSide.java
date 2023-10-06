package frc.robot.commands.auto.complex;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.arm.ArmHomeCMD;
import frc.robot.commands.auto.Initialize;
import frc.robot.commands.auto.Score;
import frc.robot.commands.auto.StraightDriveToPose;
import frc.robot.subsystems.arm.Arm;
import frc.robot.subsystems.drive.Drive;
import frc.robot.subsystems.effector.Effector;

public class ScoreAndBackUpClearSide extends SequentialCommandGroup {

  public ScoreAndBackUpClearSide(
      int aprilTag,
      String relativePosition,
      String gamePieceType,
      String location,
      Drive drive,
      Arm arm,
      Effector effector) {
    addCommands(
        new Initialize(aprilTag, relativePosition, drive, arm),
        new Score(gamePieceType, location, arm, effector),
        Commands.parallel(
            new StraightDriveToPose(Units.inchesToMeters(160.0), 0.0, 0.0, drive),
            new ArmHomeCMD(arm, effector::wantsCone)));
  }
}
