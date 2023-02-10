package com.efimchick.ifmo.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class PairStringList extends ArrayList {

    @Override
    public Object get(int index) {
        return super.get(index);
    }

    @Override
    public Object set(int index, Object element) {
        if (index == 0) {
            super.set(index, element);
            super.set(index + 1, element);
        }
        if (super.size() - index == 3) {
            super.set(index - 1, element);
            super.set(index, element);
        } else {
            super.set(index, element);
            super.set(index + 1, element);
        }
            return super.toString();
        }


        @Override
        public boolean add (Object o){
            super.add(o);
            super.add(o);
            return true;
        }

        @Override
        public void add ( int index, Object element){
            if (index % 2 != 0)
                index++;
            super.add(index, element);
            super.add(index++, element);
        }


        @Override
        public Object remove ( int index){

            while (index < super.size() - 1) {
                if (super.get(index).equals(super.get(index + 1))) {
                    super.remove(index);
                    super.remove(index);

                    index = Math.max(0, (index - 1));
                } else {
                    super.remove(index - 1);
                    super.remove(index - 1);

                }
            }
            return super.toString();

        }

        @Override
        public boolean remove (Object o){
            super.remove(o);
            return super.remove(o);
        }

        @Override
        public boolean addAll (Collection c){
        for(Object o:c){
            super.add(o);
            super.add(o);
        }
            return true;
        }

        @Override
        public boolean addAll ( int index, Collection c){
            for(Object o:c){
                if (index % 2 != 0)
                    index++;
                super.add(index, o);
                super.add(index++, o);
            }
        return true;
        }

        @Override
        public Iterator iterator () {
            return super.iterator();
        }
    }
