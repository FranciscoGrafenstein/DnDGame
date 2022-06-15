package Interactions;

import Entities.*;
import Items.*;
import Magic.Magic;
import Magic.Spells;
import Utilities.Delays;
import Utilities.Dice;

import java.util.Objects;
import java.util.Scanner;

import static Magic.Spells.*;

public class Combat {

    // Method that adds experiences, gold and in the case that you have enough exp, it levels ou up
    public static void enemyKilled(Player character, Creature enemy){
        System.out.println("You killed the beast!\n");
        System.out.println("Experience gained: " + enemy.getExperience());
        System.out.println("Gold gained: " + enemy.getGold());
        enemy.drop(enemy, character);
        character.setGold(character.getGold() + enemy.getGold());
        character.setExperience(character.getExperience() + enemy.getExperience());
        character.levelUpSystem();
        if (character.expEnough()) {
            character.levelUpSystem();
        }
    }

    // player physical damage
    public static void damage(Player character, Creature enemy, int faces){
        int totalDamage = (character.getStrength() + Dice.DiceFunction(faces));
        System.out.println("You dealt: " + totalDamage + " damage");
        int result = enemy.getHp() - totalDamage;
        if (result <= 0) {
            enemy.setHp(result);
            enemyKilled(character, enemy);
        } else {
            System.out.println(enemy.getCreatureClass().getType() + " has " + result + " health left");
            enemy.setHp(result);
        }
    }

    // player magical damage
    public static void damage(Player character, Creature enemy, int faces, Spells spell){
        Magic.useSpell(character, spell, spell.getManaCost());
        int totalDamage = (character.getMagicalMight() + spell.getDamage() + Dice.DiceFunction(faces));
        System.out.println("You dealt: " + totalDamage + " magic damage");
        int result = enemy.getHp() - totalDamage;
        if (result <= 0) {
            enemy.setHp(result);
            enemyKilled(character, enemy);
        } else {
            System.out.println(enemy.getCreatureClass().getType() + " has " + result + " health left");
            enemy.setHp(result);
        }
    }

    // -------------------------------------------PLAYER INTERACTIONS------------------------------------------------

    // Player attacks enemy with physical damage
    public static void PlayerAttack(Player character, Creature enemy, int faces) {
        System.out.println("------------------------------Combat-------------------------------\n");
        Delays.timeDelay(1000);
        damage(character, enemy, faces);
    }

    // Player attacks enemy with magical damage
    public static void PlayerMagicAttack(Player character, Creature enemy, Spells spell, int faces) {
        if (character.getMp() > spell.getManaCost()) {
            System.out.println("------------------------------Combat-------------------------------\n");
            Delays.timeDelay(1000);
            damage(character, enemy, faces, spell);
        } else {
            System.out.println("You don't have enough mana");
        }

    }

    // Player defends himself
    public static void PlayerDefense(Player character, Creature enemy, int faces) {
        System.out.println("------------------------------Combat-------------------------------\n");
        Delays.timeDelay(1000);
        int totalDamage = (enemy.getStrength() - (character.getDefense() + Dice.DiceFunction(faces)));
        if (totalDamage > 0) {
            int result = character.getHp() - totalDamage;
            character.setHp(result);
            System.out.println("You only received : " + totalDamage + " damage");
            if (character.getHp() >= 0) {
                System.out.println("Your current health is: " + character.getHp());
                System.out.println("Health Bar [" + "-".repeat(character.getHp()) + "]");
            } else if (character.getHp() < 0) {
                System.out.println("Your current health is: 0");
            }
            System.out.println("\n");
        } else {
            System.out.println("You received no damage");
        }

    }

    // Player tries to escape from enemy
    // System works with dices, if player rolls a die with a smaller number than the enemy, the escape fails
    public static void EscapeChance(Player character, Creature enemy, int faces) {
        System.out.println("---------------------------------Escape---------------------------------\n");
        int playerEscape = character.setEscapeChance(Dice.DiceFunction(faces));
        if (playerEscape > enemy.getEscapeChance()) {
            System.out.println("You escaped!");
            System.out.println("You rolled: " + playerEscape);
            System.out.println("Required escape: " + enemy.getEscapeChance());
            enemy.setIsDead();
        } else {
            System.out.println("Escape failed");
            System.out.println("You rolled: " + playerEscape);
            System.out.println("Required escape: " + enemy.getEscapeChance());
            Combat.EnemyAttack(character, enemy, faces);
        }
    }

    // -------------------------------------------ENEMY INTERACTIONS--------------------------------------------------

    // Enemy attack player with physical damage
    public static void EnemyAttack(Player character, Creature enemy, int faces) {
        System.out.println("---------------------------------Combat---------------------------------\n");
        int totalDamage = (enemy.getStrength() + Dice.DiceFunction(faces) - character.getDefense());
        int result = (character.getHp() - totalDamage);
        Delays.timeDelay(1000);
        System.out.println("You have been attacked by:  " + enemy.getCreatureClass().getType());
        System.out.println(enemy.getCreatureClass().getType() + " dealt: " + totalDamage + " damage");
        if (result <= 0) {
            character.setHp(result);
        } else {
            character.setHp(result);
            System.out.println("You have " + character.getHp() + " health left");
            System.out.println("Health Bar [" + "-".repeat(character.getHp()) + "]");
            System.out.println("\n");
        }
    }

    /*
    This method takes an enemy, and a player, and sets up the encounter, making the player take action
    It has the whole combat and item system integrated
     */
    public static void Encounter(Creature enemy, Player character) {
        System.out.println("-------------------------New Encounter------------------------------------\n");
        Delays.timeDelay(1000);
        System.out.println("You have encountered: " + enemy.getCreatureClass().getType());
        System.out.println("Level: " + enemy.getCreatureLevel().getLvlName());
        System.out.println("Enemy stats: HP" +
                "\t Strength");
        System.out.println("\t" + "\t" + "\t " + enemy.getHp() + "\t " + enemy.getStrength());

        while (!character.isDead() && !enemy.isDead()) {
            switch (Choices.choice()) {
                case ATTACK:
                    System.out.println(" 1- Physical Attack 2- Magical Attack");
                    int playerAttackChoice = Choices.getUserInput(" 1- Physical Attack 2- Magical Attack");
                    if (Objects.equals(playerAttackChoice, 1)) {
                        Combat.PlayerAttack(character, enemy, 12);
                        if (!enemy.isDead()) {
                            Combat.EnemyAttack(character, enemy, 20);
                        }
                        break;
                    }
                    if (Objects.equals(playerAttackChoice, 2)) {
                        System.out.println("Choose your spell");
                        System.out.println(character.getSpells());
                        int playerSpellChoice = Choices.getUserInput();
                        Spells currentSpell = null;
                        if (Objects.equals(playerSpellChoice, 1)) {
                            currentSpell = FIRE_BALL;
                        } else if (Objects.equals(playerSpellChoice, 2)) {
                            currentSpell = ICE_BALL;
                        }
                        assert currentSpell != null;
                        Combat.PlayerMagicAttack(character, enemy, currentSpell, 20);
                        if (enemy.getHp() > 0) {
                            Combat.EnemyAttack(character, enemy, 20);
                        }
                    }
                    break;

                case DEFEND:
                    Combat.PlayerDefense(character, enemy, 20);
                    break;

                case ESCAPE:
                    Combat.EscapeChance(character, enemy, 20);
                    break;

                case STATS:
                    character.playerStats();
                    break;

                case EQUIPMENT:
                    System.out.println("Equipment");
                    ArmorItems.showEquipment(character);
                    break;

                case ITEMS:
                    switch (Choices.BagChoice(character)) {
                        case USE_ITEM: {
                            if (character.getItemBag().isEmpty()) {
                                System.out.println("You have no items");
                            } else {
                                System.out.println("Type the name of the item from your bag: ");
                                System.out.println("Type 'help' for advice");
                                Scanner in = new Scanner(System.in);
                                String playerItemChoice = in.nextLine();
                                if (Objects.equals(playerItemChoice, "hp")) {
                                    Items.useConsumable(character, ConsumableItemList.HP_POTY);
                                } else if (Objects.equals(playerItemChoice, "mp")) {
                                    Items.useConsumable(character, ConsumableItemList.MP_POTY);
                                } else if (Objects.equals(playerItemChoice, "super hp")) {
                                    Items.useConsumable(character, ConsumableItemList.HP_SUPER_POTY);
                                } else if (Objects.equals(playerItemChoice, "super mp")) {
                                    Items.useConsumable(character, ConsumableItemList.MP_SUPER_POTY);
                                } else if (Objects.equals(playerItemChoice, "help")){
                                    System.out.println("Health potions are 'hp'");
                                    System.out.println("Mana potions are 'mp'");
                                    System.out.println("For super potions use 'super' before");
                                } else {
                                    System.out.println("You didn't type a valid option");
                                }
                            }
                            break;
                        }
                        case DROP:
                            if (character.getItemBag().isEmpty()) {
                                System.out.println("You have no items");
                            } else {
                                System.out.println("Type the name of the item from your bag: ");
                                System.out.println("Type 'help' for advice");
                                Scanner in = new Scanner(System.in);
                                String playerItemChoice = in.nextLine();
                                if (Objects.equals(playerItemChoice, "hp")) {
                                    Items.useItemBag(character, ConsumableItemList.HP_POTY, 1);
                                } else if (Objects.equals(playerItemChoice, "mp")) {
                                    Items.useItemBag(character, ConsumableItemList.MP_POTY, 1);
                                } else if (Objects.equals(playerItemChoice, "super hp")) {
                                    Items.useItemBag(character, ConsumableItemList.HP_SUPER_POTY, 1);
                                } else if (Objects.equals(playerItemChoice, "super mp")) {
                                    Items.useItemBag(character, ConsumableItemList.MP_SUPER_POTY, 1);
                                } else if (Objects.equals(playerItemChoice, "help")){
                                    System.out.println("Health potions are 'hp'");
                                    System.out.println("Mana potions are 'mp'");
                                    System.out.println("For super potions use 'super' before");
                                } else {
                                    System.out.println("You didn't type a valid option");
                                }
                            }
                        case GO_BACK:
                            break;
                    }
            }
        }
    }
}
