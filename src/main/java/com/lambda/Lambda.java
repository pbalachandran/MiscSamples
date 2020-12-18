package com.lambda;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;


public class Lambda {

    public enum LEVEL {
        JUNIOR,
        SENIOR,
        EXPERT
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Team {
        private List<Developer> developers;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Developer {
        private String name;
        private LEVEL level;
        private List<Language> languages;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Language {
        private String name;
    }

    public Team buildTeam() {
        Developer dev1
                = Developer.builder()
                .name("Developer-1")
                .level(LEVEL.EXPERT)
                .languages(asList(Language.builder().name("Java").build(),
                        Language.builder().name("Pascal").build(),
                        Language.builder().name("Kotlin").build(),
                        Language.builder().name("Fortran").build(),
                        Language.builder().name("SQL").build()))
                .build();

        Developer dev2 = Developer.builder()
                .name("Developer-2")
                .level(LEVEL.SENIOR)
                .languages(asList(Language.builder().name("Java").build(),
                        Language.builder().name("Kotlin").build(),
                        Language.builder().name("SQL").build()))
                .build();

        Developer dev3 = Developer.builder()
                .name("Developer-3")
                .level(LEVEL.JUNIOR)
                .languages(asList(Language.builder().name("Java").build()))
                .build();

        Developer dev4 = Developer.builder()
                .name("Developer-4")
                .level(LEVEL.JUNIOR)
                .languages(asList(Language.builder().name("Java").build(),
                        Language.builder().name("Kotlin").build(),
                        Language.builder().name("SQL").build()))
                .build();

        Developer dev5 = Developer.builder()
                .name("Developer-5")
                .level(LEVEL.JUNIOR)
                .languages(asList(Language.builder().name("Java").build(),
                        Language.builder().name("R").build()))
                .build();

        Developer dev6 = Developer.builder()
                .name("Developer-6")
                .level(LEVEL.JUNIOR)
                .languages(asList(Language.builder().name("Java").build(),
                        Language.builder().name("Kotlin").build(),
                        Language.builder().name("Python").build()))
                .build();

        Team team = Team.builder()
                .developers(asList(dev1, dev2, dev3, dev4, dev5, dev6))
                .build();

        return team;
    }

    private void addToList(Map<Language, List<Developer>> theMap, Developer developer) {
        developer.getLanguages().stream().forEach(language -> {
            List<Developer> developers = theMap.get(language);
            if (developers == null) {
                developers = new ArrayList<>();
                theMap.put(language, developers);
            }
            developers.add(developer);
        });
    }

    public Set<Language> getLanguages(Team team) {
        return team.getDevelopers().stream().flatMap(
                developer -> developer.getLanguages().stream()).collect(toSet());
    }

    public List<Developer> getDevelopersForLanguage(Team team, String targetLanguage) {
        return team.developers.stream()
                .filter(developer -> developer.languages.stream()
                        .filter(language -> language.getName().equals(targetLanguage))
                        .collect(toList()).size() > 0)
                .collect(toList());
    }

    public Map<Language, List<Developer>> getDevelopersGroupedByLanguage(Team team) {
         Map<Language, List<Developer>> theMap = new LinkedHashMap<>();

         team.developers.stream().forEach(developer -> addToList(theMap, developer));

         return theMap;
    }

    public Map<LEVEL, List<Developer>> getDevelopersGroupedByLevel(Team team) {
        return team.developers.stream().collect(groupingBy(Developer::getLevel, LinkedHashMap::new, toList()));
    }
    
    public static void main(String[] args) {
        Lambda lambda = new Lambda();
        Team team = lambda.buildTeam();

        lambda.getLanguages(team).forEach(language -> System.out.println(language.name));

        System.out.println("---------------------------------------------");

        lambda.getDevelopersForLanguage(team, "R").forEach(developer -> System.out.println(developer.name));

        System.out.println("---------------------------------------------");

        Map<Language, List<Developer>> theMap = lambda.getDevelopersGroupedByLanguage(team);

        theMap.keySet().stream().forEach(language ->
                theMap.get(language).forEach(developer ->
                        System.out.println(language.getName() + " - " + developer.getName())));
    }
}