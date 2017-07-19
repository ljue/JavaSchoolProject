package com.jvschool.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Людмила on 19.07.2017.
 */
@Controller
public class RoomController {



    @RequestMapping(value = {"/user"}, method = RequestMethod.GET)
    public String goUserInfo(Model model) {
        return "user";
    }

    @RequestMapping(value = {"/adress"}, method = RequestMethod.GET)
    public String goAdressInfo(Model model) {
        return "adress";
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String goOrdershistoryInfo(Model model) {
        return "history";
    }

    @RequestMapping(value = {"/room"}, method = RequestMethod.GET)
    public String goRoom(Model model) {
        return "room";
    }

}
