package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;

/**
 *
 * @author THyyppä
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public UserController() {
    }

    // Tämä POST luo ja tallettaa uuden käyttäjän
    @RequestMapping(value = "/crtUser", method = RequestMethod.GET)
    public String createUser(Model model, @RequestParam String userName, @RequestParam String password) {
        userService.createUser(model, userName, password);
        return "/user";
    }

    // Tämä POST poistaa käyttäjän
    @RequestMapping(value = "/delUser", method = RequestMethod.GET)
    public String deleteUser(@RequestParam Long userId) {
        this.userService.deleteUser(userId);
        return "/users";
    }

    // Tämä GET näyttää tietyn käyttäjän tiedot
    @RequestMapping("/oneUser")
    public String getOneUser(Model model, @RequestParam Long userId) {
        userService.getOneUser(model, userId);
        return "/user";
    }

    // Tämä GET näyttää kaikkien käyttäjien tiedot
    @RequestMapping("/allUsers")
    public String getAllUsers(Model model) {
        userService.getAllUsers(model);
        return "/users";
    }
    
    @PostMapping("/user/pieceOfNewsHeaders/{pieceOfNewsHeaderId}")
    public String assignUserToNewsHeader(@RequestParam String userId, @PathVariable Long pieceOfNewsHeaderId) {
        if (pieceOfNewsHeaderId == null || userId == null) {
            return "redirect:/user";
        }
        userService.assignNewsHeaderToUser(userId, pieceOfNewsHeaderId);
        return "redirect:/users";
    }
    
     @PostMapping("/user/newsGenres/{newsGenreId}")
    public String assignUserToNewsGenre(@RequestParam String userId, @PathVariable Long newsGenreId) {
        if (newsGenreId == null || userId == null) {
            return "redirect:/user";
        }
        userService.assignNewsGenreToUser(userId, newsGenreId);
        return "redirect:/users";
    }
}
