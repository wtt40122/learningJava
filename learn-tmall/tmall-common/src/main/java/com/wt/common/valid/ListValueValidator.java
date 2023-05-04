package com.wt.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: wtt
 * @Date: 2021/1/16 16:05
 * @Description:
 */
public class ListValueValidator implements ConstraintValidator<ListValue, Integer> {
    private Set<Integer> setValue = new HashSet<Integer>();

    @Override
    public void initialize(ListValue listValue) {
        Arrays.stream(listValue.values()).forEach(value -> {
            setValue.add(value);
        });
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return setValue.contains(value);
    }
}
