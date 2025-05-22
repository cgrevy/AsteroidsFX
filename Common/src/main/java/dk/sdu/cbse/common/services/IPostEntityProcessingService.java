package dk.sdu.cbse.common.services;

import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;

public interface IPostEntityProcessingService {
    /**
     * Is called after the entities have completed their process during a game tick.
     * It is intended for logic that depends on the final state of entities post-movement,
     * post-input or post-action.
     * Preconditions: All entities must have been processed in the current game tick.
     * Postconditions: All processing that has to do with entities have been completed. World may be modified,
     * in terms of new entities, removed entities or modified entities.
     * @param gameData stores all the data currently about the game that might be relevant for each entity
     * @param world has all the entities and relevant methods for accessing entities
     */

    void process(GameData gameData, World world);
}
