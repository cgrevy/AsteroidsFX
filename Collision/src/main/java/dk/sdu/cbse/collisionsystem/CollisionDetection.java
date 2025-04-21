package dk.sdu.cbse.collisionsystem;

import dk.sdu.cbse.common.data.Entity;
import dk.sdu.cbse.common.data.GameData;
import dk.sdu.cbse.common.data.World;
import dk.sdu.cbse.common.services.IPostEntityProcessingService;

import java.util.Objects;

public class CollisionDetection implements IPostEntityProcessingService {

    public CollisionDetection(){
    }

    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()){
            for (Entity entity2 : world.getEntities()){
                if (Objects.equals(entity2.getID(), entity1.getID())){
                    continue;
                }
                if (this.collides(entity1, entity2)){
                    world.removeEntity(entity1);
                    world.removeEntity(entity2);
                }
            }
        }

    }

    public Boolean collides(Entity entity1, Entity entity2) {
        float dx = (float) entity1.getX() - (float) entity2.getX();
        float dy = (float) entity1.getY() - (float) entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }
}
