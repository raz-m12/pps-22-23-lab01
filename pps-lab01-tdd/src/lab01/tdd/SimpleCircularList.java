package lab01.tdd;

import java.util.Optional;


public class SimpleCircularList implements CircularList{
    private int size;

    @Override
    public void add(int element) {
        this.size++;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return true;
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
}
