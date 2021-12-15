package xyz;

import java.util.Objects;
import java.util.function.Function;

public interface OrderProcessor<T,R> extends Function<T,R> {

    default <V> OrderProcessor<T, V> andThen(Function<? super R, ? extends V> after) {
        Objects.requireNonNull(after);
        return (T t) -> after.apply(apply(t));
    }
}
