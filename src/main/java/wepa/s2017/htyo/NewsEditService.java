
package wepa.s2017.htyo;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.PieceOfNewsContent;
    
/**
 *
 * @author THyyppä
 */
@Service
public class NewsEditService {

    @Autowired
    private NewsContentRepository newsContentRepository;
//    @Autowired
//    private NewsHeaderRepository newsHeaderRepository;
    @Autowired
    private UserRepository userRepository;

//    private List<User> users;
//    private List<NewsHeader> newsHeaders;
//    private User user;
//    private NewsHeader newsHeader;
    
    private PieceOfNewsContent pieceOfNewsContent;

    public void createPieceOfNewsContent(Model model, String editor, String content) {
        pieceOfNewsContent = new PieceOfNewsContent(editor, content); //CREATE
        //PieceOfNewsContent(int editorID, int newsHeader, String editor, String content, Timestamp sendTime)
        newsContentRepository.save(pieceOfNewsContent);
        model.addAttribute("pieceOfContent", pieceOfNewsContent);
    }

    public void deletePieceOfNewsContent(Long messageId) {
        newsContentRepository.delete(messageId);
    }

    public void getOnePieceOfNewsContent(Model model, Long messageId) {
        //pieceOfContent = newsContentRepository.findOne(messageId);
        //Do update here !
        //newsContentRepository.save(pieceOfContent); //UPDATE/WRITE
        model.addAttribute("pieceOfContent", newsContentRepository.findOne(messageId));
    }

    public void getAllPieceOfNewsContents(Model model) {
        model.addAttribute("pieceOfContents", newsContentRepository.findAll());
    } 
}
