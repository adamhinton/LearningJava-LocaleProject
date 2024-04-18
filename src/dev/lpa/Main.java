package dev.lpa;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        System.out.println("Default Locale = "+Locale.getDefault());


        Locale en = new Locale("en");
        Locale enAU = new Locale("en", "AU");
        Locale enCA = new Locale("en", "CA");

        // new locale with region and lang
        Locale enIN = new Locale.Builder().setLanguage("en").setRegion("IN").build();
        Locale enNZ = new Locale.Builder().setLanguage("en").setRegion("NZ").build();

        // DateTimeFormatter
        var dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

        System.out.println("-------------");
        for (var locale : List.of(
                Locale.getDefault(), Locale.US, en, enAU, enCA, Locale.UK, enNZ, enIN
        )){
            System.out.println(locale.getDisplayName() + "= " + LocalDateTime.now().format(dtf.withLocale(locale)));
        }

        DateTimeFormatter wDayMonth = DateTimeFormatter.ofPattern(
                // Four capital letters prints full item
                // so EEEE is full day name, MMMM Is full month name
                "EEEE, MMMM d, yyyy");


    }
}