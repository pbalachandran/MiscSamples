package com.lambda;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class LambdaTest {

    private Lambda subject;

    private Lambda.Team team;
    private Lambda.Developer dev1, dev2, dev3, dev4, dev5, dev6;
    private Lambda.Language java, pascal, kotlin, fortran, sql, r, python;
    private List<Lambda.Developer> juniorDevelopers;
    private List<Lambda.Developer> seniorDevelopers;
    private List<Lambda.Developer> expertDevelopers;

    @Before
    public void setUp() {
        subject = new Lambda();
        team = subject.buildTeam();

        dev1 = Lambda.Developer.builder()
                .name("Developer-1")
                .level(Lambda.LEVEL.EXPERT)
                .languages(asList(Lambda.Language.builder().name("Java").build(),
                        Lambda.Language.builder().name("Pascal").build(),
                        Lambda.Language.builder().name("Kotlin").build(),
                        Lambda.Language.builder().name("Fortran").build(),
                        Lambda.Language.builder().name("SQL").build()))
                .build();

        dev2 = Lambda.Developer.builder()
                .name("Developer-2")
                .level(Lambda.LEVEL.SENIOR)
                .languages(asList(Lambda.Language.builder().name("Java").build(),
                        Lambda.Language.builder().name("Kotlin").build(),
                        Lambda.Language.builder().name("SQL").build()))
                .build();

        dev3 = Lambda.Developer.builder()
                .name("Developer-3")
                .level(Lambda.LEVEL.JUNIOR)
                .languages(asList(Lambda.Language.builder().name("Java").build()))
                .build();

        dev4 = Lambda.Developer.builder()
                .name("Developer-4")
                .level(Lambda.LEVEL.JUNIOR)
                .languages(asList(Lambda.Language.builder().name("Java").build(),
                        Lambda.Language.builder().name("Kotlin").build(),
                        Lambda.Language.builder().name("SQL").build()))
                .build();

        dev5 = Lambda.Developer.builder()
                .name("Developer-5")
                .level(Lambda.LEVEL.JUNIOR)
                .languages(asList(Lambda.Language.builder().name("Java").build(),
                        Lambda.Language.builder().name("R").build()))
                .build();

        dev6 = Lambda.Developer.builder()
                .name("Developer-6")
                .level(Lambda.LEVEL.JUNIOR)
                .languages(asList(Lambda.Language.builder().name("Java").build(),
                        Lambda.Language.builder().name("Kotlin").build(),
                        Lambda.Language.builder().name("Python").build()))
                .build();

        java = Lambda.Language.builder().name("Java").build();
        pascal = Lambda.Language.builder().name("Pascal").build();
        kotlin = Lambda.Language.builder().name("Kotlin").build();
        fortran = Lambda.Language.builder().name("Fortran").build();
        sql = Lambda.Language.builder().name("SQL").build();
        r = Lambda.Language.builder().name("R").build();
        python = Lambda.Language.builder().name("Python").build();

        juniorDevelopers = asList(dev3, dev4, dev5, dev6);
        seniorDevelopers = asList(dev2);
        expertDevelopers = asList(dev1);
    }

    @Test
    public void getLanguages_returnsLanguages() {
        Set<Lambda.Language> actual = subject.getLanguages(team);

        Set<Lambda.Language> expected = new HashSet<>(asList(java, pascal, kotlin, fortran, sql, r, python));

        assertEquals(expected, actual);
    }

    @Test
    public void getDevelopersForLanguage_returnsDevelopersForTargetLanguage() {
        List<Lambda.Developer> actual = subject.getDevelopersForLanguage(team, "Java");

        List<Lambda.Developer> expected = asList(dev1, dev2, dev3, dev4, dev5, dev6);

        assertEquals(expected, actual);

        actual = subject.getDevelopersForLanguage(team, "R");

        expected = asList(dev5);

        assertEquals(expected, actual);
    }

    @Test
    public void getDevelopersGroupedByLanguage_returnsDevelopersGroupedByLanguage() {
        Map<Lambda.Language, List<Lambda.Developer>> actual = subject.getDevelopersGroupedByLanguage(team);

        Map<Lambda.Language, List<Lambda.Developer>> expected = new HashMap<>();

        expected.put(java, asList(dev1, dev2, dev3, dev4, dev5, dev6));
        expected.put(pascal, asList(dev1));
        expected.put(kotlin, asList(dev1, dev2, dev4, dev6));
        expected.put(fortran, asList(dev1));
        expected.put(sql, asList(dev1, dev2, dev4));
        expected.put(r, asList(dev5));
        expected.put(python, asList(dev6));

        assertEquals(expected, actual);
    }

    @Test
    public void getDevelopersGropuedByLevel_returnsDevelopersGroupedByLevel() {
        Map<Lambda.LEVEL, List<Lambda.Developer>> actual = subject.getDevelopersGroupedByLevel(team);

        Map<Lambda.LEVEL, List<Lambda.Developer>> expected = new HashMap<>();

        expected.put(Lambda.LEVEL.JUNIOR, juniorDevelopers);
        expected.put(Lambda.LEVEL.SENIOR, seniorDevelopers);
        expected.put(Lambda.LEVEL.EXPERT, expertDevelopers);

        assertEquals(expected, actual);
    }
}