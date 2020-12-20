package com.javarush.task.task21.task2104;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* 
Equals and HashCode
*/

public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    public boolean equals(Object n) {
        if (n == this) {
            return true;
        }
        if (n == null) {
            return false;
        }
        if (n.getClass() != this.getClass()) {
            return false;
        }

        Solution solution = (Solution) n;
        return Objects.equals(first, solution.first) &&
                Objects.equals(last, solution.last);
    }

    public int hashCode() {
        if (this.first == null || this.last == null)
            return 0;

        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }
}
