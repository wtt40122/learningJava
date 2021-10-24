package com.wt.test;

/**
 * @Auther: wtt
 * @Date: 2021/4/14 14:42
 * @Description:
 */
public enum CountryEnum {
    one(1, "齐"), two(2, "楚"),

    three(3, "燕"), four(4, "赵"),

    five(5, "魏"), six(6, "韩");

    private Integer retCode;
    private String retMessage;

    CountryEnum(Integer retCode, String retMessage) {
        this.retCode = retCode;
        this.retMessage = retMessage;
    }

    public static CountryEnum getCountryEnum(Integer index) {
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (countryEnum.getRetCode() == index) {
                return countryEnum;
            }
        }
        return null;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public String getRetMessage() {
        return retMessage;
    }
}
