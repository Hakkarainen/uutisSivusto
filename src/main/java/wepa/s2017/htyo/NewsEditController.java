package wepa.s2017.htyo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.User;

/**
 *
 * @author THyyppä
 */
@Controller
public class NewsEditController {

    @Autowired
    private NewsEditService newsEditService;
    @Autowired
    private NewsContentRepository newsContentRepository;
    @Autowired
    private NewsHeaderRepository newsHeaderRepository;
    @Autowired
    private UserRepository userRepository;

    private List<User> users;
    private User user;
    private PieceOfNewsHeader PieceOfNewsHeader;
    
    public NewsEditController() {
    }

    // Tämä POST luo ja tallettaa uuden uutisen 
    @RequestMapping(value = "/crtPieceOfNewsContent", method = RequestMethod.GET)
    public String createPieceOfNewsContent(Model model, @RequestParam String editor, @RequestParam String content) {
        newsEditService.createPieceOfNewsContent(model, editor, content);
        return "manageNews";
    }

    // Tämä POST poistaa uutisen, "${'/uutiset/' + uutinen.id}"
    @RequestMapping(value = "/delPieceOfNewsContent", method = RequestMethod.GET)
    public String deletePieceOfNewsContent(@RequestParam Long pieceOfNewsContentId) {
        newsEditService.deletePieceOfNewsContent(pieceOfNewsContentId);
        return "redirect:/manageNews";
    }

    // Tämä GET näyttää tietyn uutisen tiedot
    @RequestMapping("/onePieceOfNewsContent")
    public String getOnePieceOfNewsContent(Model model, @RequestParam Long pieceOfNewsContentId) {
        newsEditService.getOnePieceOfNewsContent(model, pieceOfNewsContentId);
        return "/manageNews";
    }

    // Tämä GET näyttää kaikkien uutisten tiedot
    @RequestMapping("/allPieceOfNewsContents")
    public String getAllPieceOfNewsContents(Model model) {
        newsEditService.getAllPieceOfNewsContents(model);
        return "/manageNews";
    }
}
