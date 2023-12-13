package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    @Test
    public void isBalancedTest1() {
        assertTrue(isBalanced(""));
    }

    @Test
    public void isBalancedTest2() {
        assertTrue(isBalanced(null));
    }

    @Test
    public void isBalancedTest3() {
        assertTrue(isBalanced("()"));
    }

    @Test
    public void isBalancedTest4() {
        assertFalse(isBalanced("}"));
    }

    @Test
    public void isBalancedTest5() {
        assertFalse(isBalanced("{[}]"));
    }

    @Test
    public void isBalancedTest6() {
        assertTrue(isBalanced("testing"));
    }

    @Test
    public void isBalancedTest7() {
        assertTrue(isBalanced("{}"));
    }

    @Test
    public void isBalancedTest8() {
        assertTrue(isBalanced("[]"));
    }

    @Test
    public void isBalancedTest9() {
        String str = "{[]}";
        assertTrue(isBalanced(str + "{()}"));
    }

    @Test
    public void isBalancedTest10() {
        String str = "][";
        assertFalse(isBalanced(str + "()"));
    }
}