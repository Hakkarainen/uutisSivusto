
package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.PieceOfNewsContent;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.EditorUser;
    
/**
 *
 * @author THyyppä
 */
@Service
public class NewsEditService {

    @Autowired
    private NewsContentRepository newsContentRepository;
    @Autowired
    private NewsHeaderRepository newsHeaderRepository;
    @Autowired
    private UserRepository userRepository;

    EditorUser user;
    PieceOfNewsHeader pieceOfNewsHeader;
//    private List<User> users;
//    private List<NewsHeader> newsHeaders;
//    private EditorUser user;
//    private NewsHeader newsHeader;
    
    private PieceOfNewsContent pieceOfNewsContent;

    public void createPieceOfNewsContent(Model model, Long pieceOfNewsHeaderId, String editor, String content) {
        user = userRepository.findByUserName(editor);
        pieceOfNewsHeader = newsHeaderRepository.findOne(pieceOfNewsHeaderId);
        pieceOfNewsContent = new PieceOfNewsContent(user, pieceOfNewsHeader, editor, content); //CREATE
        //PieceOfNewsContent(int editorID, int newsHeader, String editor, String content, Timestamp sendTime)
        
        //For testing
        System.out.println("pieceOfNewsContent");
        System.out.println("        Id: " + pieceOfNewsContent.getId());
        System.out.println("      user: " + pieceOfNewsContent.getUser());
        System.out.println("newsHeader: " + pieceOfNewsContent.getNewsHeader());
        System.out.println("    editor: " + pieceOfNewsContent.getEditor());
        System.out.println("   content: " + pieceOfNewsContent.getContent());
        System.out.println("  sendTime: " + pieceOfNewsContent.getSendTime());
        System.out.println();
        
        pieceOfNewsHeader.addPieceOfNewsContent(pieceOfNewsContent);
        user.addPieceOfNewsContent(pieceOfNewsContent);
        userRepository.save(user);
        newsHeaderRepository.save(pieceOfNewsHeader);
        newsContentRepository.save(pieceOfNewsContent);
        model.addAttribute("pieceOfContent", pieceOfNewsContent);
    }

    public void deletePieceOfNewsContent(Long pieceOfNewsContentId) {
        newsContentRepository.delete(pieceOfNewsContentId);
    }

    public void getOnePieceOfNewsContent(Model model, Long pieceOfNewsContentId) {
        //pieceOfContent = newsContentRepository.findOne(pieceOfNewsContentId);
        //Do update here !
        //newsContentRepository.save(pieceOfContent); //UPDATE/WRITE
        model.addAttribute("pieceOfContent", newsContentRepository.findOne(pieceOfNewsContentId));
    }

    public void getAllPieceOfNewsContents(Model model) {
        model.addAttribute("pieceOfContents", newsContentRepository.findAll());
    } 
}
