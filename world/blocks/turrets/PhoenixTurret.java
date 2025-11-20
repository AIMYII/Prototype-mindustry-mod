package prototypemod.world.blocks.turrets;

import mindustry.entities.bullet.*;
import mindustry.gen.*;
import mindustry.world.blocks.defense.turrets.ItemTurret;
import mindustry.type.*;
import arc.util.*;
import arc.math.*;
import java.util.*;

public class PhoenixTurret extends ItemTurret {

    // List your custom bullet types here
    public BulletType[] customBullets;

    public PhoenixTurret(String name) {
        super(name);

        customBullets = new BulletType[] {
            // Breach → red spark
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.sparkShoot;
                hitColor = Pal.redLight;
                frontColor = Pal.redLight;
                backColor = Pal.redder;
                trailColor = Pal.redder;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
                // Red spark glow
            }},
            // Sublimate → yellow ember trail
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.smoke;
                hitColor = Pal.lightYellow;
                frontColor = Pal.yellowLight;
                backColor = Pal.yellowDust;
                trailColor = Pal.yellowLight;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
                // Yellow ember glow
            }},
            // Afflict → purple haze
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.hitBulletSmoke;
                hitColor = Pal.lancerLaser;
                frontColor = Pal.lancerLaser;
                backColor = Pal.lancerLaser;
                trailColor = Pal.lancerLaser;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Smite → fiery orange flash
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.flameSmall;
                hitColor = Pal.lightOrange;
                frontColor = Pal.lightOrange;
                backColor = Pal.orangeLight;
                trailColor = Pal.orangeLight;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Scathe → green spark
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.hitBulletSmoke;
                hitColor = Pal.heal;
                frontColor = Pal.heal;
                backColor = Pal.heal;
                trailColor = Pal.heal;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Foreshadow → blue flash
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.hitBulletSmoke;
                hitColor = Pal.sap;
                frontColor = Pal.sap;
                backColor = Pal.sap;
                trailColor = Pal.sap;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Malign → dark ember
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.smoke;
                hitColor = Pal.darkMetal;
                frontColor = Pal.darkMetal;
                backColor = Pal.darkMetal;
                trailColor = Pal.darkMetal;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Conquer → gold spark
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.hitBulletSmoke;
                hitColor = Pal.accent;
                frontColor = Pal.accent;
                backColor = Pal.accent;
                trailColor = Pal.accent;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }},
            // Collaris → molten white core
            new BasicBulletType(5f, 32.5f) {{
                trailEffect = Fx.hitBulletSmoke;
                hitColor = Pal.lightPyraFlame;
                frontColor = Pal.lightPyraFlame;
                backColor = Pal.lightPyraFlame;
                trailColor = Pal.lightPyraFlame;
                sprite = "large-orb";
                despawnEffect = Fx.smoke;
                shootEffect = Fx.shootSmall;
            }}
        };
    }

    // Override shoot logic to pick a random bullet type for each shot
    @Override
    public void shoot(ItemTurretBuild build, Item ammo) {
        int shots = Mathf.round(recoilAmount);
        for(int i = 0; i < shots; i++){
            BulletType chosenType = customBullets[Mathf.random(customBullets.length - 1)];
            // Create the bullet with chosen type
            chosenType.create(build, build.team, build.x + Angles.trnsx(build.rotation, shootLength), build.y + Angles.trnsy(build.rotation, shootLength), build.rotation, 1f, 1f);
        }
    }
}