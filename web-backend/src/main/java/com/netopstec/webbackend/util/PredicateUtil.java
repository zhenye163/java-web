package com.netopstec.webbackend.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhenye 2020/5/8
 */
public class PredicateUtil {

    public static Predicate toPredicate(CriteriaBuilder cb, List<Predicate> andCasePredicateList, List<Predicate> orCasePredicateList) {
        Predicate andCasePredicate = null;
        if (andCasePredicateList != null) {
            andCasePredicateList = andCasePredicateList.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            for (Predicate predicate : andCasePredicateList) {
                andCasePredicate = cb.and(andCasePredicate, predicate);
            }
        }
        Predicate orCasePredicate = null;
        if (orCasePredicateList != null) {
            orCasePredicateList = orCasePredicateList.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
            for (Predicate predicate : orCasePredicateList) {
                orCasePredicate = cb.or(orCasePredicate, predicate);
            }
        }
        if (andCasePredicate != null && orCasePredicate != null) {
            return cb.and(andCasePredicate, orCasePredicate);
        }
        if (andCasePredicate != null) {
            return andCasePredicate;
        }
        return orCasePredicate;
    }
}
