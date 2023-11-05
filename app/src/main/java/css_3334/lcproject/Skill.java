package css_3334.lcproject;

public class Skill {

    public String name;
    public int coinNumber;
    public int skillCopies;
    public int baseCoinPower;
    public int coinPower;

    public String attackType;
    public String sinAffinity;

    final String[] ATTACK_TYPE = {"Slash", "Blunt", "Pierce"};
    final String[] SIN_AFFINITY = {"Wrath", "Lust", "Sloth", "Gluttony", "Gloom", "Pride", "Envy"};

    public Skill(String name, int coinNumber, int skillCopies, int baseCoinPower, int coinPower, int attack, int sin)
    {
        this.name = name;
        this.coinNumber = coinNumber;
        this.skillCopies = skillCopies;
        this.baseCoinPower = baseCoinPower;
        this.coinPower = coinPower;
        attackType = ATTACK_TYPE[attack];
        sinAffinity = SIN_AFFINITY[sin];
    }

    public String getName() {
        return name;
    }

    public int getCoinNumber() {
        return coinNumber;
    }

    public int getSkillCopies() {
        return skillCopies;
    }

    public int getBaseCoinPower() {
        return baseCoinPower;
    }

    public int getCoinPower() {
        return coinPower;
    }

    public String getAttackType() {
        return attackType;
    }

    public String getSinAffinity() {
        return sinAffinity;
    }
}
