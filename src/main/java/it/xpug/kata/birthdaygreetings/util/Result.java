package it.xpug.kata.birthdaygreetings.util;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class Result<V,F> {

    public abstract Optional<V> getValue();
    public abstract Optional<F> getFailure();

    public abstract boolean isSuccess();

    public abstract <U> Result<U, F> map(Function<V,U> mapper);
    public abstract void handle(Consumer<? super V> valueConsumer, Consumer<? super F> failureConsumer);
    public abstract void ifSuccess(Consumer<? super V> consumer);
    public abstract void ifFailure(Consumer<? super F> consumer);
    public abstract <X extends Throwable> V ifFailureThrow(Supplier<? extends X> exceptionSupplier) throws X;

    abstract Optional<V> recover(Consumer<F> recover);

    public static <S,F> Result<S,F> success(S value) {
        return new Success<>(value);
    }

    public static <S,F> Result<S,F> failure(F error) {
        return new Failure<>(error);
    }


    private static class Success<V,F> extends Result<V,F> {

        private V value;

        Success(V value) {
            this.value = value;
        }

        @Override
        public Optional<V> getValue() {
            return Optional.of(value);
        }

        @Override
        public Optional<F> getFailure() {
            return Optional.empty();
        }

        @Override
        public boolean isSuccess() {
            return true;
        }

        @Override
        public <U> Result<U, F> map(Function<V, U> mapper) {
            return Result.success(mapper.apply(value));
        }

        @Override
        public void handle(Consumer<? super V> valueConsumer, Consumer<? super F> failureConsumer) {
            valueConsumer.accept(value);
        }

        @Override
        public void ifSuccess(Consumer<? super V> consumer) {
            consumer.accept(value);
        }

        @Override
        public void ifFailure(Consumer<? super F> consumer) {
            // Success
        }

        @Override
        public <X extends Throwable> V ifFailureThrow(Supplier<? extends X> exceptionSupplier) throws X {
            return value;
        }

        @Override
        Optional<V> recover(Consumer<F> recover) {
            return Optional.of(value);
        }
    }

    private static class Failure<V,F> extends Result<V,F> {

        private F failure;

        Failure(F failure) {
            this.failure = failure;
        }

        @Override
        public Optional<V> getValue() {
            return Optional.empty();
        }

        @Override
        public Optional<F> getFailure() {
            return Optional.of(failure);
        }

        @Override
        public boolean isSuccess() {
            return false;
        }

        @Override
        public <U> Result<U, F> map(Function<V, U> mapper) {
            Objects.requireNonNull(mapper);
            return Result.failure(failure);
        }

        @Override
        public void handle(Consumer<? super V> valueConsumer, Consumer<? super F> failureConsumer) {
            failureConsumer.accept(failure);
        }

        @Override
        public void ifSuccess(Consumer<? super V> consumer) {
            // Error
        }

        @Override
        public void ifFailure(Consumer<? super F> consumer) {
            consumer.accept(failure);
        }

        @Override
        public <X extends Throwable> V ifFailureThrow(Supplier<? extends X> exceptionSupplier) throws X {
            return null;
        }

        @Override
        Optional<V> recover(Consumer<F> recover) {
            recover.accept(failure);
            return Optional.empty();
        }
    }

}
