package wepa.s2017.htyo.domain;

/**
 *
 * @author THyyppä
 */
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "User")
public class User extends AbstractPersistable<Long> {

    @Column(name = "userName")
    private String userName;
    @Column(name = "password")
    private String password;

    @OneToMany(mappedBy = "editor", fetch = FetchType.EAGER)
    private List<NewsGenre> newsGenres;

    @OneToMany(mappedBy = "startedBy")
    private List<PieceOfNewsHeader> pieceOfNewsHeaders;

    @OneToMany(mappedBy = "editorID")
    private List<PieceOfNewsContent> pieceOfNewsContents;

    public List<NewsGenre> getNewsGenres() {
        if (this.newsGenres == null) {
            this.newsGenres = new ArrayList<>();
        }
        return this.newsGenres;
    }

    public List<NewsGenre> addNewsGenres(NewsGenre newsGenre) {
        if (this.newsGenres == null) {
            this.newsGenres = new ArrayList<>();
        }
        this.newsGenres.add(newsGenre);
        return this.newsGenres;
    }

    public void delPieceOfNewsHeader(NewsGenre newsGenre) {
        if (this.newsGenres == null) {
            return;
        }
        this.newsGenres.remove(newsGenre);
    }

    public List<PieceOfNewsHeader> getPieceOfNewsHeaders() {
        if (this.pieceOfNewsHeaders == null) {
            this.pieceOfNewsHeaders = new ArrayList<>();
        }
        return this.pieceOfNewsHeaders;
    }

    public List<PieceOfNewsHeader> addPieceOfNewsHeader(PieceOfNewsHeader pieceOfNewsHeader) {
        if (this.pieceOfNewsHeaders == null) {
            this.pieceOfNewsHeaders = new ArrayList<>();
        }
        this.pieceOfNewsHeaders.add(pieceOfNewsHeader);
        return this.pieceOfNewsHeaders;
    }

    public void delPieceOfNewsHeader(PieceOfNewsHeader pieceOfNewsHeader) {
        if (this.pieceOfNewsHeaders == null) {
            return;
        }
        this.pieceOfNewsHeaders.remove(pieceOfNewsHeader);
    }

    public List<PieceOfNewsContent> getPieceOfNewsContents() {
        if (this.pieceOfNewsContents == null) {
            this.pieceOfNewsContents = new ArrayList<>();
        }
        return this.pieceOfNewsContents;
    }

    public List<PieceOfNewsContent> addPieceOfNewsContent(PieceOfNewsContent pieceOfNewsContent) {
        if (this.pieceOfNewsContents == null) {
            this.pieceOfNewsContents = new ArrayList<>();
        }
        this.pieceOfNewsContents.add(pieceOfNewsContent);
        return this.pieceOfNewsContents;
    }

    public void delPieceOfNewsContent(PieceOfNewsContent pieceOfNewsContent) {
        if (this.pieceOfNewsContents == null) {
            return;
        }
        this.pieceOfNewsContents.remove(pieceOfNewsContent);
    }

    public User() {
    }

    public User(String userName) {
        this.userName = userName;
        this.password = "";

        List<NewsGenre> newsGenres = new ArrayList<>();
        List<PieceOfNewsHeader> pieceOfNewsHeaders = new ArrayList<>();
        List<PieceOfNewsContent> pieceOfNewsContents = new ArrayList<>();
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;

        List<NewsGenre> newsGenres = new ArrayList<>();
        List<PieceOfNewsHeader> pieceOfNewsHeaders = new ArrayList<>();
        List<PieceOfNewsContent> pieceOfNewsContents = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

//    public List<NewsGenre> getNewsGenres() {
//        if (this.newsGenres == null) {
//            this.newsGenres = new ArrayList<>();
//        }
//        return this.newsGenres;
//    }
//    public List<PieceOfNewsContent> getPieceOfNewsContents() {
//        if (this.pieceOfNewsContents == null) {
//            this.pieceOfNewsContents = new ArrayList<>();
//        }
//
//        return this.pieceOfNewsContents;
//    }
}
