package dk.sdu.cbse.asteroids;

import dk.sdu.cbse.common.asteroids.Asteroid;
import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.scoring.IScoringSPI;
import dk.sdu.cbse.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static dk.sdu.cbse.asteroids.AsteroidPlugin.createAsteroid;
import static java.util.stream.Collectors.toList;

public class AsteroidProcessor implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            double changeX = Math.cos(Math.toRadians(asteroid.getRotation()));
            double changeY = Math.sin(Math.toRadians(asteroid.getRotation()));

            if (asteroid.getHealth()<1){
                splitAsteroid(gameData, world, (Asteroid) asteroid);
            }

            asteroid.setX(asteroid.getX() + changeX * 0.5);
            asteroid.setY(asteroid.getY() + changeY * 0.5);

            if (asteroid.getX() < 0) {
                asteroid.setX(asteroid.getX() - gameData.getDisplayWidth());
            }

            if (asteroid.getX() > gameData.getDisplayWidth()) {
                asteroid.setX(asteroid.getX() % gameData.getDisplayWidth());
            }

            if (asteroid.getY() < 0) {
                asteroid.setY(asteroid.getY() - gameData.getDisplayHeight());
            }

            if (asteroid.getY() > gameData.getDisplayHeight()) {
                asteroid.setY(asteroid.getY() % gameData.getDisplayHeight());
            }

        }
    }

    public void splitAsteroid(GameData gameData, World world, Asteroid asteroid){
        getScoringSPI().stream().findFirst().ifPresent(iScoringSPI -> gameData.setScore(iScoringSPI.updateScore(1)));
        float radius = asteroid.getRadius();
        if (radius > 8){
            float newRadius = radius/2;
            Asteroid a1 = (Asteroid) createAsteroid(gameData);
            Asteroid a2 = (Asteroid) createAsteroid(gameData);
            a1.setHealth((int) newRadius);
            a2.setHealth((int) newRadius);
            a1.setRadius(newRadius);
            a2.setRadius(newRadius);
            a1.setPolygonCoordinates(newRadius, -newRadius, -newRadius, -newRadius, -newRadius, newRadius, newRadius, newRadius);
            a2.setPolygonCoordinates(newRadius, -newRadius, -newRadius, -newRadius, -newRadius, newRadius, newRadius, newRadius);
            a1.setX(asteroid.getX());
            a2.setX(asteroid.getX());
            a1.setY(asteroid.getY());
            a2.setY(asteroid.getY());
            a1.setColor(asteroid.getColor());
            a2.setColor(asteroid.getColor());
            world.addEntity(a1);
            world.addEntity(a2);
        }
        world.removeEntity(asteroid);
    }

    private Collection<? extends IScoringSPI> getScoringSPI() {
        return ServiceLoader.load(IScoringSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}

