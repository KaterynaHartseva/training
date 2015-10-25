package com.epam.hartseva.task1;
public class Task1 {

    public static void main(String[] args) {
        System.out.println(getLuckyCount(10, 99));
    }

    private static int getLuckyCount(int leftBorder, int rightBorder) {
        assertLeftBorderIsLessThanRightBorder(leftBorder, rightBorder);
        int count = 0;
        for (; leftBorder <= rightBorder; leftBorder++) {
            if (isLuckyTicket(leftBorder)) {
                count++;
            }
        }
        return count;
    }

    private static boolean isLuckyTicket(int number) {
        int[] array = toArray(number);
        assertEvenNumber(array.length);
        int left = 0;
        int right = 0;
        int separator = array.length / 2;
        for (int i = 0; i < separator; i++) {
            left += array[i];
            right += array[separator + i];
        }
        return left == right;
    }

    private static int[] toArray(int number) {
        int count = getDigitsCount(number);
        int[] digit = new int[count];
        for (int i = 0; i < count && number > 0; i++, number /= 10) {
            digit[i] = number % 10;
        }
        return digit;
    }

    private static int getDigitsCount(int number) {
        int count = 0;
        for (int copy = number; copy > 0; copy /= 10) {
            count++;
        }
        return count;
    }

    private static void assertEvenNumber(int number) {
        if (number % 2 != 0) {
            throw new IllegalStateException("Invalid ticket length.");
        }
    }

    private static void assertLeftBorderIsLessThanRightBorder(int left,
            int right) {
        if (left > right) {
            throw new IllegalStateException(
                    "Left border must be less than right border.");
        }
    }
}
