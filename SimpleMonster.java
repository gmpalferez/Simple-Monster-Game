import java.util.ArrayList;

public class SimpleMonster {
    private String name;
    private String type;
    private String strongAgainst;
    private String weakAgainst;
    private int maxHP, hp, xp, lvl;
    private double atk, def;
    private static ArrayList<SimpleMonster> monsterList = new ArrayList<>();

    public SimpleMonster(String name, String type, String strongAgainst, String weakAgainst, int xp, int lvl,
                         double atk, double def, int maxHP, int hp) {
        this.name = name;
        this.type = type;
        this.strongAgainst = strongAgainst;
        this.weakAgainst = weakAgainst;
        this.xp = xp;
        this.lvl = lvl;
        this.atk = atk;
        this.def = def;
        this.maxHP = maxHP;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
    public int getMaxHP() {
        return maxHP;
    }
    public int getHP() {
        return hp;
    }
    public double getAtk() {
        return atk;
    }
    public double getDef() {
        return def;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setAtk(double atk) {
        this.atk = atk;
    }

    public void setDef(double def) {
        this.def = def;
    }

    public static ArrayList<SimpleMonster> getMonsterList() {
        return monsterList;
    }

    public void attack(SimpleMonster m){
        int damage = (int) ((atk*atk)/(double)(atk+m.getDef()));    // damage is calculated as  double, then cast as int
        boolean strong = false, weak = false;
        if(strongAgainst.equals(m.type)){
            damage *= 2;
            strong = true;
        }
        if(weakAgainst.equals(m.type)){
            damage *= 0.5;
            weak = true;
        }
        m.hp -= damage;
        if(m.hp < 0) m.hp = 0;
        System.out.println(name  + " attacked " + m.getName() +
            " and dealt " + damage + " damage, reducing it to " + m.getHP() + "HP.");
        if(strong) System.out.println("It was super effective!");
        if(weak) System.out.println("It wasn't very effective...");

        if(m.hp <= 0){
            m.hp = 0;
            System.out.println(m.getName() + " fainted.");
        }
    }

    public void restoreHealth(){
        hp = maxHP;
    }

    static class fireMonster extends SimpleMonster {

        public fireMonster(String name, String type, String strongAgainst, String weakAgainst, int xp, int lvl,
                           double atk, double def, int maxHP, int hp) {
            super(name, type, strongAgainst, weakAgainst, xp, lvl, atk, def, maxHP, hp);
        }

        public void specialSkill() {
            setAtk(getAtk() + 2);
            setHp((int) (getHP() - getMaxHP() * 0.1));
            System.out.println(getName() + " did a pose.");
        }
    }

    static class grassMonster extends SimpleMonster {

        public grassMonster(String name, String type, String strongAgainst, String weakAgainst, int xp, int lvl,
                            double atk, double def, int maxHP, int hp) {
            super(name, type, strongAgainst, weakAgainst, xp, lvl, atk, def, maxHP, hp);
        }

        public void specialSkill() { // rest()
            setHp((int) (getHP() + (getMaxHP() * 0.2)));
            System.out.println(getName() + " did a pose.");
            System.out.println(getName() + "'s hp increased to " + getHP());
        }
    }

    static class waterMonster extends SimpleMonster {

        public waterMonster(String name, String type, String strongAgainst, String weakAgainst, int xp, int lvl,
                            double atk, double def, int maxHP, int hp) {
            super(name, type, strongAgainst, weakAgainst, xp, lvl, atk, def, maxHP, hp);
        }

        public void specialSkill() {
            setDef(getDef() + 2);
            setHp((int) (getHP() - (getMaxHP() * 0.1)));
            System.out.println(getName() + " did a pose.");
            System.out.println(getName() + "'s def increased to " + (int) getDef());
            System.out.println(getName() + "'s hp decreased to " + getHP());
        }
    }
}
