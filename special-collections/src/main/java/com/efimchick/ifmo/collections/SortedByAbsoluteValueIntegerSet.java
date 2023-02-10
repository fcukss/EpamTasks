package com.efimchick.ifmo.collections;

import java.util.*;

class SortedByAbsoluteValueIntegerSet extends HashSet {
    public SortedByAbsoluteValueIntegerSet() {
        super();
    }

    @Override
    public Iterator iterator() {
        return super.iterator();
    }


    public boolean contains(Integer o) {
        return super.contains(o);
    }


    public boolean add(Integer i) {
        return super.add(i);
    }


    public boolean remove(Integer i) {
        return super.remove(i);
    }

    @Override
    public boolean addAll(Collection c) {

        for (Object o : c) {
        super.add(Integer.parseInt(o.toString()));
        }
        return true;
    }
}