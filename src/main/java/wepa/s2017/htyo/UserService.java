package wepa.s2017.htyo;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import wepa.s2017.htyo.domain.NewsGenre;
import wepa.s2017.htyo.domain.PieceOfNewsHeader;
import wepa.s2017.htyo.domain.User;

/**
 *
 * @author THyyppä
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NewsHeaderRepository newsHeaderRepository;
    @Autowired
    private NewsHeaderRepository newsContentRepository;
    @Autowired
    private NewsGenreRepository newsGenreRepository;

    private User user;

    public void createUser(Model model, String userName, String password) {
        this.user = new User(userName, password);
        //initialize OneToMany relations
        this.user.getPieceOfNewsHeaders();
        this.user.getPieceOfNewsContents();
        this.user.getNewsGenres();
        
        //For testing
        System.out.println("user");
        System.out.println("      Id: " + user.getId());
        System.out.println("userName: " + user.getUserName());
        System.out.println("password: " + user.getPassword());
        System.out.println();
        
        userRepository.save(user);
        model.addAttribute("user", user);
    }

    public void deleteUser(Long userId) {
        userRepository.delete(userId);
    }

    public void getOneUser(Model model, Long userId) {
        //User user = userRepository.findOne(userId);
        //Do update here !
        //userRepository.save(user); //UPDATE/WRITE
        model.addAttribute("user", userRepository.findOne(userId));
    }

    public void getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
    }

    public void assignNewsHeaderToUser(String userId, Long pieceOfNewsHeaderId) {
        PieceOfNewsHeader pieceOfNewsHeader = newsHeaderRepository.getOne(pieceOfNewsHeaderId);
        user = userRepository.getOne(Long.parseLong(userId));
        user.getPieceOfNewsHeaders().add(pieceOfNewsHeader);
        pieceOfNewsHeader.setInitiator(Long.parseLong(userId));

        userRepository.save(user);
        newsHeaderRepository.save(pieceOfNewsHeader);
    }
    
        public void assignNewsGenreToUser(String userId, Long newsGenreId) {
        NewsGenre newsGenre = newsGenreRepository.getOne(newsGenreId);
        user = userRepository.getOne(Long.parseLong(userId));
        user.getNewsGenres().add(newsGenre);
        newsGenre.setEditor(user);

        userRepository.save(user);
        newsGenreRepository.save(newsGenre);
    }
}
