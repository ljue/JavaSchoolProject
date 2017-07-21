package com.jvschool.view;

import com.jvschool.util.SessionUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Created by Людмила on 19.07.2017.
 */
@Controller
@SessionAttributes("user")
public class RoomController {



    @RequestMapping(value = {"/adress"}, method = RequestMethod.GET)
    public String goAddressInfo(@ModelAttribute("user") SessionUser user) {
        return "adress";
    }

    @RequestMapping(value = {"/history"}, method = RequestMethod.GET)
    public String goOrdershistoryInfo(@ModelAttribute("user") SessionUser user) {
        return "history";
    }

    @RequestMapping(value = {"/room"}, method = RequestMethod.GET)
    public String goRoom(@ModelAttribute("user") SessionUser user) {
        return "room";
    }

}
