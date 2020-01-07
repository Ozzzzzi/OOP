package ru.nsu.fit.g18213.tromenshleger;

import ru.nsu.fit.g18213.tromenshleger.Abstract.Operation;
import ru.nsu.fit.g18213.tromenshleger.Operations.*;

import java.util.HashMap;

/**
 * The class provides all available operations for the calculator.
 * It allows to modify, remove and add functions to the math easily.
 */
public class Mathem {

    private static HashMap<String, Operation> mathem = new HashMap<>();

    static {
        mathem.put(Div.sign, new Div());
        mathem.put(Minus.sign, new Minus());
        mathem.put(Mult.sign, new Mult());
        mathem.put(Plus.sign, new Plus());
        mathem.put(Pow.sign, new Pow());
        mathem.put(Cos.sign, new Cos());
        mathem.put(Log.sign, new Log());
        mathem.put(Sin.sign, new Sin());
        mathem.put(Sqrt.sign, new Sqrt());
    }

    /**
     * Gets the <code>HashMap</code> of all
     * available operations. The key is the sign of operations,
     * and the value is the operation itself.
     */
    public static HashMap<String, Operation> getMathem() {
        return mathem;
    }
}
