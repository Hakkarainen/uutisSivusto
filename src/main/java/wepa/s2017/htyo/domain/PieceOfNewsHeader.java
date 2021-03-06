package wepa.s2017.htyo.domain;

/**
 *
 * @author THyyppä
 */
import java.sql.Timestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PieceOfNewsHeader")
public class PieceOfNewsHeader extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
//    @Column(name = "startedBy")
//    private Long startedBy;
    @Column(name = "header")
    private String header;
    @Column(name = "numberOfPieceOfNewsContent")
    private int numberOfPieceOfNewsContent;
    @Column(name = "started")
    private Timestamp started;
    
    @ManyToOne
    @JoinColumn(name = "startedBy")
    private EditorUser startedBy;
    
    @ManyToOne
    @JoinColumn(name = "genre")
    private NewsGenre genre;
    
    @OneToMany(mappedBy = "newsHeader")
    private List<PieceOfNewsContent> pieceOfNewsContents;

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
    
    public PieceOfNewsHeader() {
    }

    public PieceOfNewsHeader(EditorUser startedBy, NewsGenre genre, String header) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContent = 0;
    }    

    public PieceOfNewsHeader(EditorUser startedBy, NewsGenre genre, String header, Integer numberOfPieceOfNewsContent, Timestamp started) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContent = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EditorUser getStartedBy() {
        return startedBy;
    }

    public void setStartedBy(EditorUser startedBy) {
        this.startedBy = startedBy;
    }
//    
//    public EditorUser getInitiator() {
//        return startedBy;
//    }
//
//    public void setInitiator(EditorUser startedBy) {
//        this.startedBy = startedBy;
//    }

    public NewsGenre getGenre() {
        return genre;
    }

    public void setGenre(NewsGenre genre) {
        this.genre = genre;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    public Timestamp getStarted() {
        return this.started;
    }
    public void setStarted(Timestamp started) {
        this.started = started;
    }
    
    public int getNumberOfPieceOfNewsContent() {
        return numberOfPieceOfNewsContent;
    }

    public void setNumberOfPieceOfNewsContent(Integer numberOfPieceOfNewsContent) {
        this.numberOfPieceOfNewsContent = numberOfPieceOfNewsContent;
    }
}
