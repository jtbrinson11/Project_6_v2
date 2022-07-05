public class Items{
    private String weapon;
    private int weaponID;
    private int weaponPower;
    private int healingAmount;

    public void setWeapon(int num)
    {
        switch (num)
        {
            case 0:
                weapon = "Axe";
                weaponID = 0;
                break;
            case 1:
                weapon = "Sword";
                weaponID = 1;
                break;
            case 2:
                weapon = "Crossbow";
                weaponID = 2;
                break;
            case 3:
                weapon = "Healing Mushroom";
                weaponID = 3;
                break;
            case 4:
                weapon = "Bomb";
                weaponID = 4;
                break;
            case 5:
                weapon = "Potion";
                weaponID = 5;
                break;
            default:
                weapon = "Empty";
                weaponID = 6;
                break;
        }
    }

    public String getWeapon()
    {
        return weapon;
    }

    public void setWeaponPower(int num)
    {
        switch (num)
        {
            case 0:
                weaponPower = 50;
                break;
            case 1:
                weaponPower = 35;
                break;
            case 2:
                weaponPower = 20;
                break;
            case 4:
                weaponPower = 100;
                break;
            case 5:
                weaponPower = 25;
                break;
            default:
                weaponPower = 0;
                break;
        }
    }

    public int getWeaponPower()
    {
        return weaponPower;
    }

    public void setHealingAmount(int num)
    {
        switch (num)
        {
            case 3:
                healingAmount = 50;
                break;
            case 5:
                healingAmount = 25;
                break;
            default:
                healingAmount = 0;
                break;
        }
    }

    public int getHealingAmount()
    {
        return healingAmount;
    }

    public int getWeaponID() {return weaponID;}

    public Items(int num)
    {
        setWeapon(num);
        setWeaponPower(num);
        setHealingAmount(num);
    }
}
