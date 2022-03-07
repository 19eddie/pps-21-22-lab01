package lab01.tdd;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CircularListImpl implements CircularList{

    private final List<Integer> list;
    private int actualIndex;

    public CircularListImpl() {
        this.list = new LinkedList<>();
        this.actualIndex=0;
    }

    @Override
    public void add(int element) {
        this.list.add(element);
    }

    @Override
    public int size() {
        return this.list.size();
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        Optional<Integer> element = Optional.empty();
        if(list.listIterator(actualIndex).hasNext()){
            element = Optional.of(list.listIterator(actualIndex).next());
        }
        actualIndex++;
        if(actualIndex>=this.list.size()){
            actualIndex=0;
        }
        return element;
    }

    @Override
    public Optional<Integer> previous() {
        Optional<Integer> element = Optional.empty();
        if(list.listIterator(actualIndex).hasPrevious()){
            element = Optional.of(list.listIterator(actualIndex).previous());
        }
        actualIndex--;
        if(actualIndex<0){
            if(list.size()>0){
                actualIndex=list.size();
                element = Optional.of(list.listIterator(actualIndex).previous());
            }
            else {
                actualIndex=0;
            }
        }
        return element;
    }

    @Override
    public void reset() {
        this.list.clear();
        this.actualIndex=0;
    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
