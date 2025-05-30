package dk.sdu.cbse.collisionsystem;

import dk.sdu.cbse.bulletsystem.BulletControlSystem;
import dk.sdu.cbse.bulletsystem.BulletPlugin;
import dk.sdu.cbse.common.data.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class CollisionDetectionTest {
    private static GameData gameData;
    private static World world;
    private static CollisionDetection collisionDetection;

    @BeforeAll
    public static void setup() {
        gameData = new GameData();
        world = new World();
        collisionDetection = new CollisionDetection();
    }

    @AfterEach
    public void removeEntities() {
        for (Entity e : world.getEntities()) {
            world.removeEntity(e);
        }
    }


    @Test
    public void testCollisionRemovesBullet() {
        BulletControlSystem bulletControlSystem = new BulletControlSystem();
        BulletPlugin bulletPlugin = new BulletPlugin();
        Entity shooter = new Entity();
        Entity bullet = bulletPlugin.createBullet(shooter);
        Entity entity = new Entity();
        entity.setHealth(10);
        bullet.setX(0);
        bullet.setY(0);
        entity.setX(0);
        entity.setY(0);

        world.addEntity(bullet);
        world.addEntity(entity);

        assertTrue(world.getEntities().contains(bullet));
        collisionDetection.process(gameData, world);
        bulletControlSystem.process(gameData, world);
        assertFalse(world.getEntities().contains(bullet));
    }

    @Test
    public void testCollisionDecreasesHealth(){
        BulletControlSystem bulletControlSystem = new BulletControlSystem();
        BulletPlugin bulletPlugin = new BulletPlugin();
        Entity shooter = new Entity();
        Entity bullet = bulletPlugin.createBullet(shooter);
        Entity entity = new Entity();
        entity.setHealth(10);
        assertEquals(10, entity.getHealth());
        bullet.setX(0);
        bullet.setY(0);
        entity.setX(0);
        entity.setY(0);

        world.addEntity(bullet);
        world.addEntity(entity);
        collisionDetection.process(gameData, world);
        assertEquals(9,entity.getHealth());
    }
}