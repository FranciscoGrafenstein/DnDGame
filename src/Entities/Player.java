package Entities;

import java.util.*;

import Items.ItemList;
import Utilities.Delays;

public class Player {

    private String name;
    private PlayerClasses playerClass;
    private int experience;
    private Levels level;
    private int gold;
    private int hp;
    private int mp;
    private int strength;
    private int defense;
    private int magicalMight;

    static Map<ItemList, Integer> itemBag = new HashMap<>();
    static List<String> spells = new ArrayList<>();

    public Player(String name, PlayerClasses playerClass) {
        this.name = name;
        this.playerClass = playerClass;
        this.experience = 0;
        this.level = Levels.LEVEL_1;
        this.gold = 0;
        this.hp = 100 + this.getPlayerClass().getHp();
        this.mp = 80 + this.getPlayerClass().getMP();
        this.strength = 15 + this.getPlayerClass().getStrength();
        this.defense = 2 + this.getPlayerClass().getDefense();
        this.magicalMight = 15 + this.getPlayerClass().getMagicalMight();
    }

    public Player(int experience, Levels level, int hp, int mp, int strength) {
        this.experience = experience;
        this.level = level;
        this.hp = hp;
        this.mp = mp;
        this.strength = strength;
    }
    // ---------------------------------------------Getters and Setters-----------------------------------------

    public Map<ItemList, Integer> getItemBag() {
        return itemBag;
    }

    public void setItemBag(Map<ItemList, Integer> itemBag) {
        Player.itemBag = itemBag;
    }

    public List<String> getSpells() {
        return spells;
    }

    public void setSpells(List<String> spells) {
        Player.spells = spells;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public PlayerClasses getPlayerClass() {
        return playerClass;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getHp() {
        return hp;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Levels getLevel() {
        return level;
    }

    public void setLevel(Levels level) {
        this.level = level;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public boolean isDead() {
        return this.getHp() <= 0;
    }

    public int getMagicalMight() {
        return magicalMight;
    }

    public void setMagicalMight(int magicalMight) {
        this.magicalMight = magicalMight;
    }

// ------------------------------------------End of Getters and Setters-----------------------------------------

    public void characterCreationSystem() {
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------- Character Page -------------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|-----------------------" + "Name: " + name + "-----------------------|");
        System.out.println("|-----------------------" + "Class: " + getPlayerClass().getType() + "---------------------|");
        System.out.println("|-----------------------" + "Level: " + this.getLevel().getLvlName() + "---------------------------|");
        System.out.println("|-----------------------" + "Experience: " + this.getExperience() + "----------------------|");
        System.out.println("|-----------------------" + "Life Points: " + hp + "--------------------|");
        System.out.println("|-----------------------" + "Strength: " + strength + "-----------------------|");
        System.out.println("|-----------------------" + "Mana: " + mp + "---------------------------|");
        System.out.println("|-----------------------" + "Magic Might: " + magicalMight + "--------------------|");
        System.out.println("|-----------------------" + "Gold: " + gold + "----------------------------|");
        System.out.println("|-----------" + "Experience needed to level up: " + Levels.getNextLvl(this.getLevel()).getExpNeeded() + "--------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------------------------------------------|");
    }

    public void characterCreationSystemLeveling() {
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------- New Level ------------------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|-----------------------" + "Name: " + name + "-----------------------|");
        System.out.println("|-----------------------" + "Class: " + getPlayerClass().getType() + "---------------------|");
        System.out.println("|-----------------------" + "Level: " + this.getLevel().getLvlName() + "---------------------------|");
        System.out.println("|-----------------------" + "Experience: " + experience + "---------------------|");
        System.out.println("|-----------------------" + "Life Points: " + hp + "--------------------|");
        System.out.println("|-----------------------" + "Strength: " + strength + "-----------------------|");
        System.out.println("|-----------------------" + "Mana: " + mp + "--------------------------|");
        System.out.println("|-----------------------" + "Magic Might: " + magicalMight + "--------------------|");
        System.out.println("|-----------------------" + "Gold: " + gold + "----------------------------|");
        System.out.println("|-----------" + "Experience needed to level up: " + Levels.getNextLvl(this.getLevel()).getExpNeeded() + "--------------|");
        System.out.println("|----------------------------------------------------------|");
        System.out.println("|----------------------------------------------------------|");
    }

    public void levelUp() {
        this.setHp(this.getHp() + 10);
        this.setStrength(this.getStrength() + 15);
        this.setMp(this.getHp() + 10);
        this.setGold(this.getGold() + 5);

    }

    public void levelUpSystem(){
        if (this.getExperience() > (Levels.getNextLvl(this.getLevel()).getExpNeeded())) {
            Delays.timeDelay(1000);
            this.setLevel(Levels.getNextLvl(this.getLevel()));
            System.out.println("You leveled up!\n");
            this.levelUp();
            this.characterCreationSystemLeveling();
        }
    }

}
