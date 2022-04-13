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


    // PLAYER INTERACTIONS
    public static void PlayerAttack(Player character, Creature enemy, int faces) {
        System.out.println("------------------------------Combat-------------------------------\n");
        Delays.timeDelay(1000);
        int totalDamage = (character.getStrength() + Dice.DiceFunction(faces));
        System.out.println("You dealt: " + totalDamage + " damage");
        int result = enemy.getHp() - totalDamage;
        if (result <= 0) {
            enemy.setHp(result);
            System.out.println("You killed the beast!\n");
            System.out.println("Experience gained: " + enemy.getExperience());
            character.setExperience(character.getExperience() + enemy.getExperience());
            character.levelUpSystem();
            if (character.expEnough()){
                character.levelUpSystem();
            }
        } else {
            System.out.println(enemy.getCreatureClass().getType() + " has " + result + " health left");
            enemy.setHp(result);
        }
    }

    public static void PlayerMagicAttack(Player character, Creature enemy, Spells spell, int faces) {
        if (character.getMp() > spell.getManaCost()) {
            System.out.println("------------------------------Combat-------------------------------\n");
            Delays.timeDelay(1000);
            Magic.useSpell(character, spell, spell.getManaCost());
            int totalDamage = (character.getMagicalMight() + spell.getDamage() + Dice.DiceFunction(faces));
            System.out.println("You dealt: " + totalDamage + " damage");
            int result = enemy.getHp() - totalDamage;
            if (result <= 0) {
                enemy.setHp(result);
                System.out.println("You killed the beast!\n");
                System.out.println("Experience gained: " + enemy.getExperience());
                character.setExperience(character.getExperience() + enemy.getExperience());
                character.levelUpSystem();
                if (character.expEnough()){
                    character.levelUpSystem();
                }

            } else {
                System.out.println(enemy.getCreatureClass().getType() + " has " + result + " health left");
                enemy.setHp(result);
            }
        } else {
            System.out.println("You don't have enough mana");
        }

    }


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
            } else if (character.getHp() < 0) {
                System.out.println("Your current health is: 0");
            }
            System.out.println("\n");
        } else {
            System.out.println("You received no damage");
        }

    }


    // ENEMY INTERACTIONS

    public static void EnemyAttack(Player character, Creature enemy, int faces) {
        System.out.println("---------------------------------Combat---------------------------------\n");
        int totalDamage = (enemy.getStrength() + Dice.DiceFunction(faces));
        int result = (character.getHp() - totalDamage);
        Delays.timeDelay(1000);
        System.out.println("You have been attacked by:  " + enemy.getCreatureClass().getType());
        System.out.println(enemy.getCreatureClass().getType() + " dealt: " + totalDamage + " damage");
        if (result <= 0) {
            character.setHp(result);
        } else {
            character.setHp(result);
            System.out.println("You have " + character.getHp() + " health left");
            System.out.println("\n");
        }
    }


    public static void Encounter(Creature enemy, Player character) {
        System.out.println("-------------------------New Encounter------------------------------------\n");
        Delays.timeDelay(1000);
        System.out.println("You have encountered: " + enemy.getCreatureClass().getType());
        System.out.println("Level: " + enemy.getLevel().getLvlName());
        System.out.println("Enemy stats: HP" +
                "\t Strength");
        System.out.println("\t" + "\t" + "\t " + enemy.getHp() + "\t " + enemy.getStrength());

        while (!character.isDead() && !enemy.isDead()) {
            switch (Choices.choice()) {
                case ATTACK:
                    System.out.println(" 1- Physical Attack 2- Magical Attack");
                    Scanner in2 = new Scanner(System.in);
                    String playerChoice2 = in2.nextLine();
                    if (Objects.equals(Integer.parseInt(playerChoice2), 1)) {
                        Combat.PlayerAttack(character, enemy, 12);
                        if (enemy.getHp() > 0) {
                            Combat.EnemyAttack(character, enemy, 20);
                        }
                        break;
                    }
                    if (Objects.equals(Integer.parseInt(playerChoice2), 2)) {
                        System.out.println("Choose your spell");
                        System.out.println(character.getSpells());
                        Scanner in3 = new Scanner(System.in);
                        String playerChoice3 = in3.nextLine();
                        if (Objects.equals(Integer.parseInt(playerChoice3), 1)) {
                            Combat.PlayerMagicAttack(character, enemy, FIRE_BALL, 20);
                            if (enemy.getHp() > 0) {
                                Combat.EnemyAttack(character, enemy, 20);
                            }
                        }
                        if (Objects.equals(Integer.parseInt(playerChoice3), 2)) {
                            Combat.PlayerMagicAttack(character, enemy, ICE_BALL, 20);
                            if (enemy.getHp() > 0) {
                                Combat.EnemyAttack(character, enemy, 20);
                            }
                        }
                    }   else {
                            System.out.println("You didn't select a valid option");
                        }
                    break;

                case DEFEND:
                    Combat.PlayerDefense(character, enemy, 20);

                    break;

                case ESCAPE:
                    break;

                case STATS:
                    character.characterCreationSystem();
                    break;

                case ITEMS:
                    switch (Choices.BagChoice(character)) {
                        case USE_ITEM: {
                            if (character.getItemBag().isEmpty()) {
                                System.out.println("You have no items");
                                break;
                            } else {
                                System.out.println("1- Health potion \t 2- Mana potion");
                                Scanner in = new Scanner(System.in);
                                String playerChoice = in.nextLine();
                                if (Objects.equals(Integer.parseInt(playerChoice), 1)) {
                                    if (character.getItemBag().containsKey(ItemList.HP_POTY)) {
                                        Items.useItemBag(character, ItemList.HP_POTY, 1);
                                        character.setHp(character.getHp() + ItemList.HP_POTY.getRestore());
                                        System.out.println("Current health: " + character.getHp());
                                    } else {
                                        System.out.println("You don't have any health potions");
                                    }

                                }
                                else if (Objects.equals(Integer.parseInt(playerChoice), 2)) {
                                    if (character.getItemBag().containsKey(ItemList.MP_POTY)) {
                                        Items.useItemBag(character, ItemList.MP_POTY, 1);
                                        character.setMp(character.getMp() + ItemList.MP_POTY.getRestore());
                                        System.out.println("Current Mana: " + character.getMp());
                                    } else {
                                        System.out.println("You don't have any mana potions");
                                    }

                                }
                                else {
                                    System.out.println("You didn't select a valid option");
                                }
                                break;
                            }
                        }
                        case GO_BACK:
                            break;

                    }
            }
        }
    }
}

