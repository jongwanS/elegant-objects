package ch02.sealed;

public sealed interface Exchange permits NYSE {
    int rate();
}
