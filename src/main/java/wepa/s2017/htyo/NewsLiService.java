package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.NewsGenre;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.NewsGenreList;

/**
 *
 * @author THyyppä
 */
@Service
public class NewsLiService {

    @Autowired
    private NewsLiRepository newsLiRepository;

    private PieceOfNewsHeader pieceOfNewsHeader;
    private NewsGenreList newsGenreList;

    public void createPieceOfNewsHeader(Model model, Long startedBy, NewsGenre  genre, String header) {
        pieceOfNewsHeader = new PieceOfNewsHeader(startedBy, genre, header); 
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
