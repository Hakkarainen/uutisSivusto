package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author THyyppä
 */
@Controller
public class NewsController {
    
    @Autowired
    private UserService userService;
        @Autowired
    private NewsGenreService newsGenreService;

    public NewsController(){
    }
    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String Home(Model model) {
        newsGenreService.getAllNewsGenres(model);
        userService.getAllUsers(model);
        return "/index";
    }
}
