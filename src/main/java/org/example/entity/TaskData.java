package org.example.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskData {
    private Set<Task> annsTasks;
    private Set<Task> bobsTasks;
    private Set<Task> carolsTasks;
    private Set<Task> unassignedTasks;

    public TaskData(Set<Task> annsTasks, Set<Task> bobsTasks, Set<Task> carolsTasks, Set<Task> unassignedTasks) {
        this.annsTasks = annsTasks;
        this.bobsTasks = bobsTasks;
        this.carolsTasks = carolsTasks;
        this.unassignedTasks = unassignedTasks;
    }

    public Set<Task> getTasks(String assignee) {
        return switch (assignee.toLowerCase()) {
            case "ann" -> annsTasks;
            case "bob" -> bobsTasks;
            case "carol" -> carolsTasks;
            case "all" -> getUnion(List.of(annsTasks, bobsTasks, carolsTasks, unassignedTasks));
            default -> new HashSet<>();
        };
    }

    public Set<Task> getUnion(List<Set<Task>> sets) {
        Set<Task> unionSet = new HashSet<>();
        for (Set<Task> set : sets) {
            unionSet.addAll(set);
        }
        return unionSet;
    }

    // Overload (Test’te bu versiyon çağrılıyor)
    public Set<Task> getUnion(Set<Task> set1, Set<Task> set2) {
        return getUnion(List.of(set1, set2));
    }

    public Set<Task> getIntersection(Set<Task> set1, Set<Task> set2) {
        Set<Task> intersection = new HashSet<>(set1);
        intersection.retainAll(set2);
        return intersection;
    }

    // Eski isim de desteklensin
    public Set<Task> getIntersect(Set<Task> set1, Set<Task> set2) {
        return getIntersection(set1, set2);
    }

    public Set<Task> getDifference(Set<Task> set1, Set<Task> set2) {
        Set<Task> difference = new HashSet<>(set1);
        difference.removeAll(set2);
        return difference;
    }

    public Set<Task> getDifferences(Set<Task> taskSet, Set<Task> taskSet2) {
        return getDifference(taskSet, taskSet2);
    }

    public Set<Task> getTasksByUnion() {
        return getUnion(List.of(annsTasks, bobsTasks, carolsTasks));
    }

    public Set<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public Set<Task> getOverlappingTasks() {
        Set<Task> annAndBob = getIntersection(annsTasks, bobsTasks);
        Set<Task> annAndCarol = getIntersection(annsTasks, carolsTasks);
        Set<Task> bobAndCarol = getIntersection(bobsTasks, carolsTasks);

        return getUnion(List.of(annAndBob, annAndCarol, bobAndCarol));
    }
}
