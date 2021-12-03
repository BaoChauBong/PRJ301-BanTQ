/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author ADMIN
 */
public class RandomGenerator {

    public String randomName() {
        int i, x;
        char ch;
        String str = "";
        Random random = new Random();

        for (i = 0; i < 6; ++i) {
            x = random.nextInt(57) + 65;
            if (x >= 91 && x <= 96)
                x += 7;
            ch = (char) x;
            str += ch;
        }
        return str;
    }

    public boolean randomGender() {
        return new Random().nextBoolean();
        
    }

    public Date randomDOB() {
        return java.sql.Date.valueOf(LocalDate.now().minus(Period.ofDays((new Random().nextInt(365 * 70)))));

    }
}
