
package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.NewsGenre;
import wepa.s2017.htyo.domain.User;

/**
 *
 * @author THyyppä
 */
@Service
public class NewsGenreService {

    @Autowired
    private NewsGenreRepository newsGenreRepository;
    @Autowired
    private NewsLiRepository newsLiRepository;
    @Autowired
    private UserRepository userRepository;
    
    private NewsGenre newsGenre;
    private PieceOfNewsHeader pieceOfNewsHeader;

    //PieceOfNewsHeader of the Genre
    public void createPieceOfNewsHeader(Model model, Long startedBy, Long genre, String header) {
        pieceOfNewsHeader = new PieceOfNewsHeader(startedBy, newsGenre, header); 
        addPieceOfNewsHeaderToGenre(model, pieceOfNewsHeader);
    }      
    public void addPieceOfNewsHeaderToGenre(Model model, PieceOfNewsHeader pieceOfNewsHeader) {
        newsGenre.addPieceOfNewsHeader(pieceOfNewsHeader);
        newsGenreRepository.save(newsGenre);
        model.addAttribute("newsPerGenre", newsGenre.getPieceOfNewsHeaders());
    }
    public void delPieceOfNewsHeaderfromGenre(Model model, PieceOfNewsHeader discussion) {
        newsGenre.delPieceOfNewsHeader(discussion);
        newsGenreRepository.save(newsGenre);
        model.addAttribute("newsPerGenre", newsGenre.getPieceOfNewsHeaders());
    }
    public void findPieceOfNewsHeadersPerGenre(Model model, NewsGenre newsGenre) {
        model.addAttribute("newsPerGenre", newsGenre.getPieceOfNewsHeaders());
    }

    public void createNewsGenre(Model model, Integer genre, Long editor, String header) {
        User user = userRepository.findOne(editor);
        newsGenre = new NewsGenre();
        newsGenre.setNewsGenre(genre);
        newsGenre.setHeader(header);
        newsGenreRepository.save(newsGenre);
        newsGenre = newsGenreRepository.findOne(newsGenre.getId());

        //For testing
        System.out.println();
        System.out.println("Id: " + newsGenre.getId());
        System.out.println("genre: " + newsGenre.getNewsGenre());
        System.out.println("editor: " + newsGenre.getEditor());
        System.out.println("header: " + newsGenre.getHeader());
        System.out.println();
        //user.getNewsGenres();
        user.addNewsGenres(newsGenre);
        userRepository.save(user);
        model.addAttribute("newsGenre", newsGenre);
    }
    
    public void deleteNewsGenre(Long newsGenreId) {
        newsGenreRepository.delete(newsGenreId);
    }

    public NewsGenre getOneNewsGenre(Model model, Long newsGenreId) {
        NewsGenre newsGenre = newsGenreRepository.findOne(newsGenreId);
        //Do update here !
        //newsGenreRepository.save(newsGenre); //UPDATE/WRITE
        model.addAttribute("newsGenre", newsGenreRepository.findOne(newsGenreId));
        return newsGenre;
    }   

    public void getAllNewsGenres(Model model) {
        model.addAttribute("newsGenres", newsGenreRepository.findAll());
    }
}
