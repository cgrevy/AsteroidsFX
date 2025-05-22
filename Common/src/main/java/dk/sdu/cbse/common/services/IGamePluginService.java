package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IGamePluginService {
    /**
     *Method for when the plug-ins need to be initialized at the start of the game.
     * The initial settings for the plugin need to be set in this method.
     * Preconditions: The plug-in must not already be started
     * Postconditions: The plug-in must be started
     *
     * @param gameData stores information about the game (screen size and input keys)
     *                 that might be relevant when needing to initialize the plugins.
     * @param world stores all the entities in the game
     */
    void start(GameData gameData, World world);

    /**
     * Called when the plug-ins need to be stopped. This method needs to ensure that the plug-in is stopped.
     *Preconditions: The plugin must be started
     * Postconditions: The plugin must be stopped
     * @param gameData stores information about the game (screen size and input keys)
     * @param world stores all the entities in the game
     */

    void stop(GameData gameData, World world);
}
