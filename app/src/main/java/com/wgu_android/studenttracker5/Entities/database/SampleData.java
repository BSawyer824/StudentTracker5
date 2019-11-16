package com.wgu_android.studenttracker5.Entities.database;

import com.wgu_android.studenttracker5.Entities.TermsEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleData {

    private static final String SAMPLE_TEXT_1 = "Term 1";
    private static final String SAMPLE_TEXT_2 = "Term 2";
    private static final String SAMPLE_TEXT_3 = "Possible Term 3";

    private static Date getDate(int diff) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.add(Calendar.MINUTE, diff);
        return cal.getTime();
    }

    public static List<TermsEntity> getTerms() {
        List<TermsEntity> term = new ArrayList<>();
        term.add(new TermsEntity(SAMPLE_TEXT_1, getDate(500), getDate(2500)));
        term.add(new TermsEntity(SAMPLE_TEXT_2, getDate(5000), getDate(25000)));
        term.add(new TermsEntity(SAMPLE_TEXT_3, getDate(15000), getDate(250000)));
        return term;
    }

}
