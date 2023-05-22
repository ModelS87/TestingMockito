package pro.sky.skypro.testingMockito.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import pro.sky.skypro.testingMockito.exception.IncorrectNameException;
import pro.sky.skypro.testingMockito.exception.IncorrectSurnameException;

@Service
public class ValidatorService {
    public String validateName(String name) {
        if (!org.apache.commons.lang3.StringUtils.isAlpha(name)) {
            throw new IncorrectNameException();
        }
        return StringUtils.capitalize(name.toLowerCase());
    }

    public String validateSurname(String surname) {
        String[] surnames = surname.split("-");
        for (int i = 0; i < surnames.length; i++) {
            if (!org.apache.commons.lang3.StringUtils.isAlpha(surnames[i])){
                throw new IncorrectSurnameException();
            }
            surnames[i] = StringUtils.capitalize(surnames[i].toLowerCase());
        }
        return String.join("-", surnames);
    }

}

