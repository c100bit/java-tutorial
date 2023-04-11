package org.example.part1;

public enum MyEnum {
    GREEN("green"), YELLOW("yellow");

    private String tr;

    MyEnum(String tr) {
        this.tr = tr;
    }

    public String getName() {
        return tr;
    }
}

class TestEnum {
    void test() {
        MyEnum green = MyEnum.GREEN;
        green.getName();
    }
}
