package dk.sdu.cbse.common.bullet;

import dk.sdu.cbse.common.data.Entity;

public interface BulletSPI {
    /**
     * Is used when an entity shoots a bullet
     * Preconditions: None
     * Postconditions: The method returns a Bullet object, which is ready to be placed as an entity in the World.
     * @param entity: the entity shooting the bullet
     */
    Entity createBullet(Entity entity);
}
