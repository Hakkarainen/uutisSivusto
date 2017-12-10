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
public class NewsLiController {
    
    @Autowired
    private NewsLiService newsLiService;

    public NewsLiController() {
    }

    // Tämä POST luo ja tallettaa uuden uutisen otsikkotiedot
    @RequestMapping(value = "/crtPieceOfNewsHeader", method = RequestMethod.GET)
    public String createPieceOfNewsHeader(Model model, @RequestParam Long startedBy, @RequestParam Long genreId, @RequestParam String header) {
        this.newsLiService.createPieceOfNewsHeader(model, startedBy, genreId, header);
        return "/manageNews";
    }
    
    // Tämä POST poistaa uutisen otsikkotiedot
    @RequestMapping(value = "/delPieceOfNewsHeader", method = RequestMethod.GET)
    public String deletePieceOfNewsHeader(@RequestParam Long pieceOfNewsHeaderId) {
        this.newsLiService.deletePieceOfNewsHeader(pieceOfNewsHeaderId);
        return "/manageNews";
    }

    // Tämä GET näyttää tietyn uutisen otsikkotiedot
    @RequestMapping("/onePieceOfNewsHeader")
    public String getOnePieceOfNewsHeader(Model model, @RequestParam Long pieceOfNewsHeaderId) {
        this.newsLiService.getOnePieceOfNewsHeader(model, pieceOfNewsHeaderId);
        return "/manageNews";
    }

    // Tämä GET näyttää kaikki uutiset
    @RequestMapping("/allPieceOfNewsHeaders")
    public String getAllPieceOfNewsHeaders(Model model) {
        this.newsLiService.getAllPieceOfNewsHeaders(model);
        return "/manageNews";   
    }
     // Tämä GET näyttää kaikki tietyn uutisen sisällöt
    @RequestMapping("/contentPerPieceOfNewsHeader")
    public String getAllContentPerPieceOfNewsHeader(Model model) {
        this.newsLiService.findContentsPerPieceOfNewsHeader(model);
        return "/pieceOfNewsContent";
    }
}


