package lab01.tdd;

import java.util.LinkedList;
import java.util.Optional;

public class SimpleCircularList implements CircularList{

    private final LinkedList<Integer> list;
    private int actualIndex;

    public SimpleCircularList() {
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
        int indexToReturn = this.actualIndex;
        actualIndex++;
        if(actualIndex>=this.list.size()){
            actualIndex=0;
        }
        return Optional.of(list.get(indexToReturn));
    }

    @Override
    public Optional<Integer> previous() {
        this.actualIndex--;
        if (this.actualIndex<0){
            this.actualIndex=this.list.size()-1;
        }
        return Optional.of(list.get(this.actualIndex));
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
