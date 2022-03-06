package lab01.tdd;

import java.util.LinkedList;
import java.util.Optional;

public class SimpleCircularList implements CircularList{

    private final LinkedList<Integer> list;

    public SimpleCircularList() {
        this.list = new LinkedList<>();
    }

    @Override
    public void add(int element) {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        return Optional.empty();
    }

    @Override
    public Optional<Integer> previous() {
        return Optional.empty();
    }

    @Override
    public void reset() {

    }

    @Override
    public Optional<Integer> next(SelectStrategy strategy) {
        return Optional.empty();
    }
}
