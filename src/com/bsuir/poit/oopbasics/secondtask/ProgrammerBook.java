package com.bsuir.poit.oopbasics.secondtask;


import java.util.Objects;

public class ProgrammerBook extends Book{
    private String language;
    private int level;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o == null
            || o.getClass() != this.getClass()
            || !super.equals(o)) {
            return false;
        }

        ProgrammerBook temp = (ProgrammerBook) o;

        return Objects.equals(language, temp.language)
            && level == temp.level;
    }

    @Override
    public int hashCode() {
        int temp = super.hashCode();
        temp = (43 * temp + (language == null ? 215 : language.hashCode())) % Integer.MAX_VALUE;
        temp = (43 * temp + level) % Integer.MAX_VALUE;
        return temp;
    }
}
