package com.wt.spring.test17.bean;

import java.time.LocalDate;

/**
 * @author wtt
 * @version 1.0
 * @description
 * @date 2022/9/23 10:27
 */
public class Husband {
    private String wifeName;

    public String getWifeName() {
        return wifeName;
    }

    public void setWifeName(String wifeName) {
        this.wifeName = wifeName;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    @Override
    public String toString() {
        return "Husband{" +
                "wifeName='" + wifeName + '\'' +
                ", marriageDate=" + marriageDate +
                '}';
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

    private LocalDate marriageDate;
}
