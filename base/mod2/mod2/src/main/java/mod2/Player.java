package mod2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Scanner;

public class Player {

    private String name;
    private VARIANTS variant;

    public Player() {
        this.name = "bot";
        this.variant = getRandomVariant();
    }

    public Player(VARIANTS variant, String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Let's start play, u need to write ROCK, PAPER or SCISSORS");
        this.variant = VARIANTS.valueOf(scanner.nextLine());
        System.out.println("Write your name my dear friend");
        this.name = scanner.nextLine();
    }

    private VARIANTS getRandomVariant() {
        //Генерирует случайное целое число от 0 до 3 не включая 3
        int x = (int) (Math.random() * 3);
        switch (x) {
            case 0:
                return VARIANTS.ROCK;
            case 1:
                return VARIANTS.PAPER;
            default:
                return VARIANTS.SCISSORS;
        }
    }

    public String whoWins(Player bot, Player human) {

        //System.out.println(bot.name + " choose " + bot.variant);
        //System.out.println(human.name + " choose " + human.variant);
        //Создали список где камень под индексом 0, бумага - 1, ножницы - 2
        ArrayList<VARIANTS> variantslist = new ArrayList<VARIANTS>(EnumSet.allOf(VARIANTS.class));
        variantslist.add(VARIANTS.ROCK);
        variantslist.add(VARIANTS.PAPER);
        variantslist.add(VARIANTS.SCISSORS);

        int indexbot = variantslist.indexOf(bot.variant);
        int humanindex = variantslist.indexOf(human.variant);
        //System.out.println(indexbot);
        //System.out.println(humanindex);

        if (indexbot == humanindex) {
            return "The draw!";
        }
        if ((indexbot - humanindex) == 1 || (indexbot - humanindex) == -2) {
            return "The winner was: " + bot.name;
        } else {
            return "The winner was: " + human.name;
        }
    }
}
