import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;


module Asteroids {
    uses dk.sdu.cbse.common.scoring.IScoringSPI;
    requires Common;
    requires CommonAsteroids;
    requires CommonScoring;
    provides IGamePluginService with dk.sdu.cbse.asteroids.AsteroidPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.asteroids.AsteroidProcessor;
}