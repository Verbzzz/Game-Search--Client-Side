package com.hit.driver;

import com.hit.client.Game;
import com.hit.controller.MyController;
import com.hit.model.MyModel;

import com.hit.view.View;

import java.util.List;

public class MVCDriver {

    public static void main(String [] args)
    {
        View view = new View();
        MyModel myModel = new MyModel(3000);

        new MyController(view, myModel);

    }

}
