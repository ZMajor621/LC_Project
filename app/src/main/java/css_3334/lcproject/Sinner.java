package css_3334.lcproject;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class Sinner implements Serializable {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String name;
    public String rarity;
    public int health;
    public int speedLow;
    public int speedHigh;

    //public Skill skills[] = new Skill[3];

    @Ignore
    final String RARITY[] = {"0", "00", "000"};
    @Ignore
    final String RESISTANCES[] = {"Fatal [x2]", "Normal [x1]", "Ineff. [x0.5]"};

    public String blunt;
    public String pierce;
    public String slash;

    public String attack1;
    public String attack2;
    public String attack3;

    public String sin1;
    public String sin2;
    public String sin3;


    public Sinner (String name, String rarity, int health, int speedLow, int speedHigh, String blunt, String pierce, String slash, String attack1, String attack2, String attack3, String sin1, String sin2, String sin3)
    {
        this.name = name;
        this.rarity = rarity;
        this.health = health;
        this.speedLow = speedLow;
        this.speedHigh = speedHigh;
        this.blunt = blunt;
        this.pierce = pierce;
        this.slash = slash;
        this.attack1 = attack1;
        this.attack2 = attack2;
        this.attack3 = attack3;
        this.sin1 = sin1;
        this.sin2 = sin2;
        this.sin3 = sin3;
    }

    public String getName() {
        return name;
    }

    public String getRarity() {
        return rarity;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeedLow() {
        return speedLow;
    }

    public int getSpeedHigh() {
        return speedHigh;
    }

    public String getBlunt() {
        return blunt;
    }

    public String getPierce() {
        return pierce;
    }

    public String getSlash() {
        return slash;
    }

    public String getAttack1() {
        return attack1;
    }

    public String getAttack2() {
        return attack2;
    }

    public String getAttack3() {
        return attack3;
    }

    public String getSin1() {
        return sin1;
    }

    public String getSin2() {
        return sin2;
    }

    public String getSin3() {
        return sin3;
    }
}
