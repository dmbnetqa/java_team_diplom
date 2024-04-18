package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() { //меньше максимального баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() { // больше мах баланса
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddEqualThanMaxBalance() { // равный мах балансу
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(8_000);

        int expected = 10_000;
        int actual = account.getBalance();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWriteOffFromBalance() { // списание с баланса
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                5
        );
        account.pay(2_000);

        int expected = 3_000;
        int actual = account.balance;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWriteOffBelowMinBalance() { // списание с баланса меньше минимального
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(3_000);

        int expected = 2_000;
        int actual = account.balance;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldCalculationOfInterestAccountBalance() { // расчет суммы процента
        SavingAccount account = new SavingAccount(
                8_000,
                1_000,
                10_000,
                10
        );

        int expected = 800;
        int actual = account.yearChange();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNegativeRate() { // проверка отрицательной ставки
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    2_000,
                    1_000,
                    10_000,
                    -5);
        });
    }
}