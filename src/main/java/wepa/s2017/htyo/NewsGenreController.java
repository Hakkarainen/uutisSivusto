package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import wepa.s2017.htyo.domain.NewsGenre;

/**
 *
 * @author THyyppä
 */
@Controller
public class NewsGenreController {

    @Autowired
    private NewsGenreService newsGenreService;
    @Autowired
    private NewsLiService newsLiService;

    public NewsGenreController() {
    }
    
    // Tämä POST luo ja tallettaa uuden uutisaihepiirin
    @RequestMapping(value = "/crtGenreForPieceOfNews", method = RequestMethod.POST)
    public String createGenreForPieceOfNews(Model model, @RequestParam Long startedBy, @RequestParam Long genre, @RequestParam String header) {
        newsGenreService.createPieceOfNewsHeader(model, startedBy, genre, header);
        return "/newsGenre";
    }

    // Tämä POST luo ja tallettaa uuden uutisaihepiirin
    @RequestMapping(value = "/crtNewsGenre", method = RequestMethod.GET)
    public String createNewsGenre(Model model, @RequestParam Integer genre, @RequestParam Long editor, @RequestParam String header) {
        newsGenreService.createNewsGenre(model, genre, editor, header);
        return "/newsGenre";
    }
    
    // Tämä POST poistaa uutisaihepiirin
    @RequestMapping(value = "/delNewsGenre", method = RequestMethod.GET)
    public String deleteNewsGenre(@RequestParam Long newsGenreId) {
        newsGenreService.deleteNewsGenre(newsGenreId);
        return "/newsGenre";
    }
    
    // Tämä GET näyttää tietyn uutisaihepiirin tiedot
    @RequestMapping("/oneNewsGenre")
    public String getOneNewsGenre(Model model, @RequestParam Long newsGenreId) {
       NewsGenre genre = newsGenreService.getOneNewsGenre(model, newsGenreId);
        getAllNewsHeadersPerGenre(model, genre);
        return "/newsPerGenre";
    }
    
    // Tämä GET näyttää kaikki genret
    @RequestMapping("/allNewsGenres")
    public String getAllNewsGenres(Model model) {
        newsGenreService.getAllNewsGenres(model);
        return "/newsGenres";
    }

    // Tämä GET näyttää kaikki tietyn uutisaihepiirin uutiset
    @RequestMapping("/newsHeadersPerGenre")
    public String getAllNewsHeadersPerGenre(Model model, NewsGenre newsGenre) {
        newsGenreService.findPieceOfNewsHeadersPerGenre(model, newsGenre);      
        return "/newsPerGenre";
    }   
}