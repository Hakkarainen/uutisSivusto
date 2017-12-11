package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.NewsGenre;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.NewsGenreList;
import wepa.s2017.htyo.domain.EditorUser;

/**
 *
 * @author THy
 */
@Service
public class NewsLiService {

    @Autowired
    private NewsLiRepository newsLiRepository;
    @Autowired
    private NewsGenreRepository newsGenreRepository;
    @Autowired
    private UserRepository userRepository;

    private EditorUser user;
    private PieceOfNewsHeader pieceOfNewsHeader;
    private NewsGenre newsGenre;
    private NewsGenreList newsGenreList;

    public void createPieceOfNewsHeader(Model model, EditorUser startedBy, Long genreId, String header) {
        user = userRepository.findOne(startedBy.getId());
        newsGenre = newsGenreRepository.findOne(genreId);
        pieceOfNewsHeader = new PieceOfNewsHeader(user, newsGenre, header);
        
        //For testing
        System.out.println("pieceOfNewsHeader");
        System.out.println("        Id: " + pieceOfNewsHeader.getId());
        System.out.println(" startedBy: " + pieceOfNewsHeader.getStartedBy());
        System.out.println("    header: " + pieceOfNewsHeader.getHeader());
        System.out.println("numberOfPieceOfNewsContent: " + pieceOfNewsHeader.getNumberOfPieceOfNewsContent());
        System.out.println("   started: " + pieceOfNewsHeader.getStarted());
        System.out.println();

        user.addPieceOfNewsHeader(pieceOfNewsHeader);
        userRepository.save(user);
        
        newsGenre.addPieceOfNewsHeader(pieceOfNewsHeader);
        newsGenreRepository.save(newsGenre);

        newsLiRepository.save(pieceOfNewsHeader);
        model.addAttribute("pieceOfNewsHeader", pieceOfNewsHeader);
    }

    public void deletePieceOfNewsHeader(Long pieceOfNewsHeaderId) {
        newsLiRepository.delete(pieceOfNewsHeaderId);
    }

    public void getOnePieceOfNewsHeader(Model model, Long pieceOfNewsHeaderId) {
        //pieceOfNewsHeader = newsLiRepository.findOne(pieceOfNewsHeaderId);
        //Do update here !
        //pieceOfNewsHeaderRepository.save(pieceOfNewsHeader); //UPDATE/WRITE
        model.addAttribute("pieceOfNewsHeader", newsLiRepository.findOne(pieceOfNewsHeaderId));
    }

    public void getAllPieceOfNewsHeaders(Model model) {
        model.addAttribute("pieceOfNewsHeaders", newsLiRepository.findAll());
    }

    public void findContentsPerPieceOfNewsHeader(Model model) {
        model.addAttribute("contentsPerPieceOfNewsHeader", pieceOfNewsHeader.getPieceOfNewsContents());
    }
}
