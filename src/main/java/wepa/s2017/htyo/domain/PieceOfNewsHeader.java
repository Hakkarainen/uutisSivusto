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
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PieceOfNewsHeader")
public class PieceOfNewsHeader extends AbstractPersistable<Long> {

    @Column(name = "startedBy")
    private Long startedBy;
    @Column(name = "genre")
    private Long genre;
    @Column(name = "header")
    private String header;
    @Column(name = "numberOfPieceOfNewsContent")
    private int numberOfPieceOfNewsContent;
    @Column(name = "started")
    private Timestamp started;
    
    @OneToMany(mappedBy = "genre")
    private List<PieceOfNewsHeader> pieceOfNewsHeaders;
    
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

    public PieceOfNewsHeader(Long startedBy, Long genre, String header) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContent = 0;
    }    

    public PieceOfNewsHeader(Long startedBy, Long genre, String header, Integer numberOfPieceOfNewsContent, Timestamp started) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContent = 0;
    }

    public Long getInitiator() {
        return startedBy;
    }

    public void setInitiator(Long startedBy) {
        this.startedBy = startedBy;
    }

    public Long getGenre() {
        return genre;
    }

    public void setGenre(Long genre) {
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
