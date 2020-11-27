package com.javarush.task.task39.task3909;

import org.junit.Assert;
import org.junit.Test;

public class UserTest {
    @Test
    public void isOneEditAwayTest() {
        Solution solution = new Solution();
        Assert.assertTrue(Solution.isOneEditAway("letter", "letter"));
        Assert.assertFalse(Solution.isOneEditAway("leTTer", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("leter", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("letterA", "letterB"));
        Assert.assertTrue(Solution.isOneEditAway("letterA", "letter"));
        Assert.assertTrue(Solution.isOneEditAway("letter", "letterB"));
        Assert.assertFalse(Solution.isOneEditAway("letter", "letterBB"));
        Assert.assertFalse(Solution.isOneEditAway("leTter", "letterB"));
        Assert.assertTrue(Solution.isOneEditAway("A", "B"));
        Assert.assertTrue(Solution.isOneEditAway("A", ""));
        Assert.assertTrue(Solution.isOneEditAway("", ""));
    }
}
