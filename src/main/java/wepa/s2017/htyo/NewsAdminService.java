
package wepa.s2017.htyo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.NewsGenre;
import wepa.s2017.htyo.domain.PieceOfNewsContent;
import wepa.s2017.htyo.domain.User;

/**
 *
 * @author THyyppä
 */
@Service
public class NewsAdminService {
//        
//    @Autowired
//    private NewsAdminRepository newsAdminRepository;
//    @Autowired
//    private NewsLiRepository newsLiRepository;
//    @Autowired
//    private NewsGenreRepository newsGenreRepository;
//    @Autowired
//    private NewsHeaderRepository newsHeaderRepository;
//    @Autowired
//    private NewsContentRepository newsContentRepository;
//    @Autowired
//    private UserRepository userRepository;
//
//    // käytetyt oliot
//    private PieceOfNewsHeader pieceOfNewsHeader;
//    private NewsGenre newsGenre;
//    private PieceOfNewsContent pieceOfNewsContent;
//    private User user;
//   
//    Integer numberOfpieceOfNews;
//    Integer numberOfNewsGenres;
//    Integer numberOfPieceOfNewsContents;
//    Integer numberOfUsers;
//
//    public String initNewsDB(Model model) {
//
//        this.getAllPieceOfNewsLiItems(model);
//        this.getAllNewsGenres(model);
//        this.getAllPieceOfNewsContents(model);
//        this.getAllUsers(model);
//        return "adminsIndex";
//    }
//    
//    //News
//    public void createPieceOfNewsHeader(Model model, Long startedBy, Long genre, String header) {
//        PieceOfNewsHeader pieceOfNewsHeader = new PieceOfNewsHeader(startedBy, genre, header); //CREATE
//        newsLiRepository.save(pieceOfNewsHeader);
//        model.addAttribute("pieceOfNewsHeader", pieceOfNewsHeader);
//    }
//
//    public void deletePieceOfNewsLiItem(Long newsId) {
//        newsLiRepository.delete(newsId);
//    }
//
//    public void getOnePieceOfNewsLiItem(Model model, Long newsId) {
//        //PieceOfNewsLiItem pieceOfNewsLiItem = newsLiRepository.findOne(newsId);
//        //Do update here !
//        //newsLiRepository.save(pieceOfNewsLiItem); //UPDATE/WRITE
//        model.addAttribute("onePieceOfNewsLiItem", newsLiRepository.findOne(newsId));
//    }
//
//    public void getAllPieceOfNewsLiItems(Model model) {
//        model.addAttribute("allPieceOfNewsLiItems", newsLiRepository.findAll());
//    }
//
//    //Dicussion Topic
//    public void createNewsGenre(Model model, Integer genre, Long editor, String header) {
//        newsGenre = new NewsGenre(genre, editor, header); //CREATE
//        newsGenreRepository.save(newsGenre);
//        model.addAttribute("newsGenre", newsGenre);
//    }
//
//    public void deleteNewsGenre(Long newsGenreId) {
//        newsGenreRepository.delete(newsGenreId);
//    }
//
//    public void getOneNewsGenre(Model model, Long newsGenreId) {
//        //newsGenre = newsGenreRepository.findOne(newsGenreId);
//        //Do update here !
//        //newsGenreRepository.save(newsGenre); //UPDATE/WRITE
//        model.addAttribute("newsGenre", newsGenreRepository.findOne(newsGenreId));
//    }
//
//    public void getAllNewsGenres(Model model) {
//        model.addAttribute("newsGenres", newsGenreRepository.findAll());
//    }
//
//    //PieceOfNewsContents
//    public void createPieceOfNewsContent(Model model, String writer, String content) {
//        pieceOfNewsContent = new PieceOfNewsContent(writer, content); //CREATE
//        newsContentRepository.save(pieceOfNewsContent);
//        model.addAttribute("pieceOfNewsContent", pieceOfNewsContent);
//    }
//
//    public void deletePieceOfNewsContent(Long pieceOfNewsContentId) {
//        newsContentRepository.delete(pieceOfNewsContentId);
//    }
//
//    public void getOnePieceOfNewsContent(Model model, Long pieceOfNewsContentId) {
//        //pieceOfNewsContent = PieceOfNewsContentRepository.findOne(pieceOfNewsContentId);
//        //Do update here !
//        //newsRepository.save(pieceOfNewsContent); //UPDATE/WRITE
//        model.addAttribute("onePieceOfNewsContent", newsContentRepository.findOne(pieceOfNewsContentId));
//    }
//
//    public void getAllPieceOfNewsContents(Model model) {
//        model.addAttribute("allPieceOfNewsContents", newsContentRepository.findAll());
//    }
//    
//    //Users
//    public void createUser(Model model, String name) {
//       user = new User(name); //CREATE
//       userRepository.save(user);
//       model.addAttribute("user", user);
//    }
//
//    public void deleteUser(Long userId) {
//        userRepository.delete(userId);
//    }
//
//    public void getOneUser(Model model, Long userId) {
//       //user = userRepository.findOne(userId);
//        //Do update here !
//        //newsRepository.save(user); //UPDATE/WRITE
//        model.addAttribute("user", userRepository.findOne(userId));
//    }
//
//    public void getAllUsers(Model model) {
//        model.addAttribute("users", userRepository.findAll());
//    }
}
