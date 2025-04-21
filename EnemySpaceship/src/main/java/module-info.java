import dk.sdu.cbse.common.services.IEntityProcessingService;
import dk.sdu.cbse.common.services.IGamePluginService;

module EnemySpaceship {
    requires Common;
    requires CommonEnemy;
    requires CommonBullet;
    uses dk.sdu.cbse.common.bullet.BulletSPI;
    provides IGamePluginService with dk.sdu.cbse.enemyspaceship.EnemyPlugin;
    provides IEntityProcessingService with dk.sdu.cbse.enemyspaceship.EnemyProcessor;
}