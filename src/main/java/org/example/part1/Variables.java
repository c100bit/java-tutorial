package org.example.part1;

public class Variables {
    byte a = -128; // 1b -128..127
    short b = -32768; // 2b -32768..32767
    int c = -2_147_483_648; // 4b -2147483648..2147483647
    long d = -9_223_372_036_854_775_808l; // 8b -9_223_372_036_854_775_808..9_223_372_036_854_775_807

    float e = -3.4f; // 4b - 3.4*10^38
    double f = 3.3; // 8b

    char g = '2'; // 2b (utf-16)

    boolean h = true;

    String str = "str";
}
