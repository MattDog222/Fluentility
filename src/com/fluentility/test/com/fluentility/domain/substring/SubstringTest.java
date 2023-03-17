package com.fluentility.domain.substring;


import static com.fluentility.domain.substring.FluentSubstring.fluentSubstring;

public class SubstringTest {

    private static final String TEST = "abcdefghijklmnopqrstuvwxyz";

    public static void main(String[] args) {
//        System.out.println(fluentSubstring().of("Pokemon").from(1).to(5).get());
//        System.out.println(fluentSubstring().of("Pokemon").from(1).get());
//        System.out.println(fluentSubstring().of("Pokemon").to(5).get());
//        System.out.println(fluentSubstring().of("Pokemon").from(-1).get());
//        System.out.println(fluentSubstring().of("Pokemon").to(-1).get());
//        System.out.println(fluentSubstring().of("Pokemon").from(-3).to(-1).get());

//        System.out.println(fluentSubstring().of("Pokemon").fromExclusive(1).to(5).get());
//        System.out.println(fluentSubstring().of("Pokemon").fromExclusive(1).get());
//        System.out.println(fluentSubstring().of("Pokemon").fromExclusive(-3).get());
//        System.out.println(fluentSubstring().of("Pokemon").fromExclusive(-3).to(-1).get());
//        System.out.println(fluentSubstring().of("Pokemon").toInclusive(1).get());
//        System.out.println(fluentSubstring().of("Pokemon").to(1).get());
        assert 1 ==2;
        onlyTo();
        onlyToInclusive();
        onlyFrom();
        onlyFromExclusive();
        fromToEqual();
        fromToLength1();
    }




    public static void onlyTo() {
        assert fluentSubstring().of(TEST).to(0).get().isEmpty();
        assert fluentSubstring().of(TEST).to(1).get().equals("a");
        assert fluentSubstring().of(TEST).to(2).get().equals("ab");
        assert fluentSubstring().of(TEST).to(3).get().equals("abc");
        assert fluentSubstring().of(TEST).to(-1).get().equals("abcdefghijklmnopqrstuvwxy");
        assert fluentSubstring().of(TEST).to(-2).get().equals("abcdefghijklmnopqrstuvwx");
        assert fluentSubstring().of(TEST).to(-3).get().equals("abcdefghijklmnopqrstuvw");
    }

    public static void onlyToInclusive() {
        assert fluentSubstring().of(TEST).toInclusive(0).get().equals("a");
        assert fluentSubstring().of(TEST).toInclusive(1).get().equals("ab");
        assert fluentSubstring().of(TEST).toInclusive(2).get().equals("abc");
        assert fluentSubstring().of(TEST).toInclusive(3).get().equals("abcd");
        assert fluentSubstring().of(TEST).toInclusive(-1).get().equals("abcdefghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).toInclusive(-2).get().equals("abcdefghijklmnopqrstuvwxy");
        assert fluentSubstring().of(TEST).toInclusive(-3).get().equals("abcdefghijklmnopqrstuvwx");
    }

    public static void onlyFromExclusive() {
        assert fluentSubstring().of(TEST).fromExclusive(0).get().equals("bcdefghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).fromExclusive(1).get().equals("cdefghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).fromExclusive(2).get().equals("defghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).fromExclusive(3).get().equals("efghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).fromExclusive(-1).get().isEmpty();
        assert fluentSubstring().of(TEST).fromExclusive(-2).get().equals("z");
        assert fluentSubstring().of(TEST).fromExclusive(-3).get().equals("yz");
    }

    public static void onlyFrom() {
        assert fluentSubstring().of(TEST).from(0).get().equals(TEST);
        assert fluentSubstring().of(TEST).from(1).get().equals("bcdefghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).from(2).get().equals("cdefghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).from(3).get().equals("defghijklmnopqrstuvwxyz");
        assert fluentSubstring().of(TEST).from(-1).get().equals("z");
        assert fluentSubstring().of(TEST).from(-2).get().equals("yz");
        assert fluentSubstring().of(TEST).from(-3).get().equals("xyz");
    }

    public static void fromToEqual() {
        for (int i = -26; i <= 26; ++i) {
            assert fluentSubstring().of(TEST).from(i).to(i).get().isEmpty();
        }
    }

    public static void fromToLength1() {
        for (int i = -27; i <= 27; ++i) {
            boolean x = fluentSubstring().of(TEST).from(i).to(i+1).get().length() == 1;

        }
    }
}
