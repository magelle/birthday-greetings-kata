package it.xpug.kata.birthdaygreetings.failure;

import it.xpug.kata.birthdaygreetings.birthday.Failure;

/**
 * Created by gelle on 01/12/2016.
 */
public interface FailureHandler {
    void handleFailure(Failure failure);
}
