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
public class NewsAdminController {
    
    @Autowired
    private NewsAdminService newsAdminService;

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String initDiscussionDB(Model model) {
        newsAdminService = new NewsAdminService();
//        newsAdminService.initNewsDB(model);
        return "/home";
    }
}
