package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IEntityProcessingService {

    /**
     *
     *Called when the state of the entity needs to be processed
     *Preconditions: Graphics must be rendered
     * Postconditions: Entity must have been processed such that all its data is updated
     * @param gameData stores information about the game (screen size and input keys)
     * @param world stores all the entities in the game
     */
    void process(GameData gameData, World world);
}
