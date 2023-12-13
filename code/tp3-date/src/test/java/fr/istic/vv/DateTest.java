package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateTest {
    @Test
    void invalidDate() {
        assertThrows(IllegalArgumentException.class, () -> new Date(45,1,54));
    }

    /* isLeapYear */

    @Test
    void isLeapYear_Leap() {
        assertTrue(Date.isLeapYear(2024));
    }

    @Test
    void isLeapYear_Common() {
        assertFalse(Date.isLeapYear(2023));
    }

    @Test
    void isLeapYear_CommonInf0() {
        assertFalse(Date.isLeapYear(-1));
    }

    @Test
    void isLeapYear_0() {
        assertTrue(Date.isLeapYear(0));
    }

    /* isValidDate */
    @Test
    void isValidDate_29DaysFebCommonYear() {
        assertFalse(Date.isValidDate(29,2,2019));
    }

    @Test
    void isValidDate_29DaysFebLeapYear() {
        assertTrue(Date.isValidDate(29,2,2024));
    }

    @Test
    void isValidDate_NegativeMonthValue() {
        assertFalse(Date.isValidDate(2,-4,1920));
    }

    @Test
    void isValidDate_NegativeDayValue() {
        assertFalse(Date.isValidDate(-2,4,1920));
    }

    @Test
    void isValidDate_ValidDate() {
        assertTrue(Date.isValidDate(13,12,2023));
    }

    @Test
    void isValidDate_MonthSup12(){
        assertFalse(Date.isValidDate(13,24,2023));
    }

    @Test
    void isValidDate_DaySupMaxDays(){
        assertFalse(Date.isValidDate(41,1,2023));
    }

    /* nextDate */
    @Test
    void nextDate_LastDayOfMonth(){
        Date date = new Date(30,11,2023);
        Date nextDate = date.nextDate();
        Date expectedNextDate = new Date(1,12,2023);

        assertEquals(expectedNextDate.day, nextDate.day);
        assertEquals(expectedNextDate.month, nextDate.month);
        assertEquals(expectedNextDate.year, nextDate.year);
    }

    @Test
    void nextDate_LastDayOfYear(){
        Date date = new Date(31,12,2023);
        Date nextDate = date.nextDate();
        Date expectedNextDate = new Date(1,1,2024);

        assertEquals(expectedNextDate.day, nextDate.day);
        assertEquals(expectedNextDate.month, nextDate.month);
        assertEquals(expectedNextDate.year, nextDate.year);
    }

    @Test
    void nextDate_basic() {
        Date date = new Date(24,12,2023);
        Date nextDate = date.nextDate();
        Date expectedNextDate = new Date(25,12,2023);

        assertEquals(expectedNextDate.day, nextDate.day);
        assertEquals(expectedNextDate.month, nextDate.month);
        assertEquals(expectedNextDate.year, nextDate.year);
    }

    @Test
    void nextDate_febLeap(){
        Date date = new Date(28,2,2024);
        Date nextDate = date.nextDate();
        Date expectedNextDate = new Date(29,2,2024);

        assertEquals(expectedNextDate.day, nextDate.day);
        assertEquals(expectedNextDate.month, nextDate.month);
        assertEquals(expectedNextDate.year, nextDate.year);
    }

    @Test
    void nextDate_febCommon(){
        Date date = new Date(28,2,2023);
        Date nextDate = date.nextDate();
        Date expectedNextDate = new Date(1,3,2023);

        assertEquals(expectedNextDate.day, nextDate.day);
        assertEquals(expectedNextDate.month, nextDate.month);
        assertEquals(expectedNextDate.year, nextDate.year);
    }

    /* previousDate */

    @Test
    void previousDate_FirstDayOfMonth(){
        Date expectedPreviousDate = new Date(30,11,2023);
        Date date = new Date(1,12,2023);
        Date previousDate = date.previousDate();

        assertEquals(expectedPreviousDate.day, previousDate.day);
        assertEquals(expectedPreviousDate.month, previousDate.month);
        assertEquals(expectedPreviousDate.year, previousDate.year);
    }

    @Test
    void previousDate_FirstDayOfYear(){
        Date expectedPreviousDate = new Date(31,12,2023);
        Date date = new Date(1,1,2024);
        Date previousDate = date.previousDate();


        assertEquals(expectedPreviousDate.day, previousDate.day);
        assertEquals(expectedPreviousDate.month, previousDate.month);
        assertEquals(expectedPreviousDate.year, previousDate.year);
    }

    @Test
    void previousDate_basic() {
        Date expectedPreviousDate = new Date(24,11,2023);
        Date date = new Date(25,11,2023);
        Date previousDate = date.previousDate();

        assertEquals(expectedPreviousDate.day, previousDate.day);
        assertEquals(expectedPreviousDate.month, previousDate.month);
        assertEquals(expectedPreviousDate.year, previousDate.year);
    }

    @Test
    void previousDate_FebLeap(){
        Date expectedPreviousDate = new Date(29,2,2024);
        Date date = new Date(1,3,2024);
        Date previousDate = date.previousDate();

        assertEquals(expectedPreviousDate.day, previousDate.day);
        assertEquals(expectedPreviousDate.month, previousDate.month);
        assertEquals(expectedPreviousDate.year, previousDate.year);
    }

    @Test
    void previousDate_FebCommon(){
        Date expectedPreviousDate = new Date(28,2,2023);
        Date date = new Date(1,3,2023);
        Date previousDate = date.previousDate();

        assertEquals(expectedPreviousDate.day, previousDate.day);
        assertEquals(expectedPreviousDate.month, previousDate.month);
        assertEquals(expectedPreviousDate.year, previousDate.year);
    }

    /* compareToDate */
    @Test
    void compareToDate_nullDate(){
        Date date = new Date(13,12,2023);

        assertThrows(NullPointerException.class, () -> date.compareTo(null));
    }

    @Test
    void compareToDate_sameDate() {
        Date date1 = new Date(13,12,2023);
        Date date2 = new Date(13,12,2023);

        assertEquals(0, date1.compareTo(date2));
    }

    @Test
    void compareToDate_otherBefore() {
        Date date1 = new Date(13,12,2023);
        Date date2 = new Date(11,12,2023);

        assertEquals(1, date1.compareTo(date2));
    }

    @Test
    void compareToDate_otherAfter() {
        Date date1 = new Date(13,12,2023);
        Date date2 = new Date(15,12,2023);

        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    void compareToDate_otherAfterDiffMonth() {
        Date date1 = new Date(13,11,2023);
        Date date2 = new Date(15,12,2023);

        assertEquals(-1, date1.compareTo(date2));
    }

    @Test
    void compareToDate_otherAfterDiffYear() {
        Date date1 = new Date(13,11,2022);
        Date date2 = new Date(15,12,2023);

        assertEquals(-1, date1.compareTo(date2));
    }
}