package com.dz3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class PuttingIntoPractice {

    public static void main(String... args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

/*        1. Найти все транзакции за 2011 год и отсортировать их по сумме (от меньшей
        к большей).*/

        System.out.print("Транзакции за 2011 год: ");
        transactions.stream().filter(filter -> filter.getYear() == 2011).sorted(Comparator.comparing(Transaction::getValue)).forEach(System.out::println);

        /*2. Вывести список неповторяющихся городов, в которых работают трейдеры.*/

        System.out.print("Список городов: ");
        transactions.stream().map(m -> m.getTrader().getCity()).distinct().forEach(System.out::println);

        /*3. Найти всех трейдеров из Кембриджа и отсортировать их по именам.*/
        System.out.print("Трейдеры из Кембриджа: ");
        transactions.stream().filter(f->f.getTrader().getCity().equals("Cambridge")).map(m->m.getTrader().getName()).distinct().sorted().forEach(System.out::println);

/*        4. Вернуть строку со всеми именами трейдеров, отсортированными в алфавитном
        порядке.*/
        System.out.print("Трейдеры из Милана: ");
        String str = transactions.stream().map(m->m.getTrader().getName()).distinct().sorted().collect(Collectors.joining(" "));
        System.out.println(str);

        /*5. Выяснить, существует ли хоть один трейдер из Милана.*/
        System.out.print("Существует трейдер из Милана? ");
        boolean boll = transactions.stream().filter(f -> f.getTrader().getCity().equals("Milan")).count() >= 1;
        System.out.println(boll);

        /*6. Вывести суммы всех транзакций трейдеров из Кембриджа.*/
        System.out.print("Сумма всех транзакция трейдеров из Кэмбриджа: ");
        System.out.println(transactions.stream().filter(f->f.getTrader().getCity().equals("Cambridge")).mapToInt(m->m.getValue()).sum());

        /*7. Какова максимальная сумма среди всех транзакций?*/

        System.out.print("Максимальная сумма: ");
        System.out.println(transactions.stream().max(Comparator.comparing(Transaction::getValue)).map(Transaction::getValue).get());

        /*8. Найти транзакцию с минимальной суммой.*/
        System.out.print("Минимальная сумма: ");
        System.out.println(transactions.stream().min(Comparator.comparing(Transaction::getValue)).map(Transaction::getValue).get());
    }
}