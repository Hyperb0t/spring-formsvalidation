package ru.kpfu.formsvalidation.model;

import ru.kpfu.formsvalidation.model.validation.NotEmptyCollections;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@NotEmptyCollections
public class CollectionTestModel {
    private List<String> stringList;
    private Set<String> stringSet;

    public CollectionTestModel() {
    }

    public CollectionTestModel(List<String> stringList, Set<String> stringSet) {
        this.stringList = stringList;
        this.stringSet = stringSet;
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public Set<String> getStringSet() {
        return stringSet;
    }

    public void setStringSet(Set<String> stringSet) {
        this.stringSet = stringSet;
    }

    @Override
    public String toString() {
        return "CollectionTestModel{" +
                "stringList=" + stringList +
                ", stringSet=" + stringSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CollectionTestModel that = (CollectionTestModel) o;
        return Objects.equals(stringList, that.stringList) &&
                Objects.equals(stringSet, that.stringSet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stringList, stringSet);
    }
}
