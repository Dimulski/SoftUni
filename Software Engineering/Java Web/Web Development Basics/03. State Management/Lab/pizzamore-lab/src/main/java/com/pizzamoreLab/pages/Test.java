package com.pizzamoreLab.pages;

import com.pizzamoreLab.utils.WebUtils;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by teodo on 08/02/2017.
 */
public class Test {

    public static void main(String[] args) {
        String parameter = args[0];
        String[] newArgs = Arrays.copyOfRange(args,1,args.length);
        switch (parameter){
            case "home":
                Home.main(newArgs);
                break;
            case "signin":
                SignIn.main(newArgs);
                break;
            case "signup":
                SignUp.main(newArgs);
                break;
        }
    }
}
