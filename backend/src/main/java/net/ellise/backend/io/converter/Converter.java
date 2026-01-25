package net.ellise.backend.io.converter;

public interface Converter <T, V> {
    V convert(T input);
}
