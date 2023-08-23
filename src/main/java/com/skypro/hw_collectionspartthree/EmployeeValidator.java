package com.skypro.hw_collectionspartthree;

import com.skypro.hw_collectionspartthree.exceptions.WrongNameException;
import org.apache.commons.lang3.StringUtils;

public class EmployeeValidator {
    public static void checkName(String... names) {
        for (String name : names) {
            if (!StringUtils.isAlpha(name)) {
                throw new WrongNameException();
            }

        }
    }
}
