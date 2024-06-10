package common;

public interface EventListener<E extends Event> {

    void handle(E event);
}
