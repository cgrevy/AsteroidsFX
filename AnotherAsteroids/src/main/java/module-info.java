import dk.sdu.cbse.asteroids.AsteroidPlugin;
import dk.sdu.cbse.common.services.IGamePluginService;

module AnotherAsteroids {
    requires Common;
    requires CommonAsteroids;
    provides IGamePluginService with AsteroidPlugin;
}