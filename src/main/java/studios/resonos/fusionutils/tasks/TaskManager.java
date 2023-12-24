package studios.resonos.fusionutils.tasks;


import studios.resonos.fusionutils.FusionUtils;

public class TaskManager {

    public static void init() {
        new ArenaResetTask().runTaskTimer(FusionUtils.getPlugin(FusionUtils.class), 8400, 8400);
        new ArenaWeakenResetTask().runTaskTimer(FusionUtils.getPlugin(FusionUtils.class), 18000, 18000);
    }
}
