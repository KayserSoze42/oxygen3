package ink.oxiemoron.chemistry.law.structure.base;

import ink.oxiemoron.chemistry.law.roles.Bondable;

public abstract class Bit implements Bondable {

    private int valency; // 14.02.yeyeyeye
    private static String name;

    public Bit(String name) {
        Bit.name = name;
    }

    @Override
    public void bond() {
        // Bond..
    }




}
