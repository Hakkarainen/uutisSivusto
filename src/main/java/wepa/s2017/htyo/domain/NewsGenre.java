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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "NewsGenre")
public class NewsGenre extends AbstractPersistable<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "newsGenre")
    private Long newsGenre;
    @Column(name = "header")
    private String header;

    @ManyToOne
    @JoinColumn(name = "editor")
    private EditorUser editor;

    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private List<PieceOfNewsHeader> pieceOfNewsHeaders;

    public NewsGenre() {
    }

    public NewsGenre(Long newsGenre, EditorUser editor, String header) {
        this.newsGenre = newsGenre;
        this.editor = editor;
        this.header = header;
    }

    public void setPieceOfNewsHeaders(List<PieceOfNewsHeader> pieceOfNewsHeaders) {
        this.pieceOfNewsHeaders = pieceOfNewsHeaders;
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

@Override
    public Long getId() {
        return id;
    }
@Override
    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getNewsGenre() {
        return newsGenre;
    }

    public void setNewsGenre(Long newsGenre) {
        this.newsGenre = newsGenre;
    }

    public EditorUser getEditor() {
        return this.editor;
    }

    public void setEditor(EditorUser editor) {
        this.editor = editor;
    }

    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}
