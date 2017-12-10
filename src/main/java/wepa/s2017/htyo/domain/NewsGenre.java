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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "NewsGenre")
public class NewsGenre extends AbstractPersistable<Long> {
    
    @Column(name = "genre")
    private Integer genre;
    @Column(name = "editor")
    private Long editor;
    @Column(name = "header")
    private String header;
    
    @OneToMany(mappedBy = "genre", fetch = FetchType.EAGER)
    private List<PieceOfNewsHeader> pieceOfNewsHeaders;
    
    public NewsGenre() {
    }

    public NewsGenre(Integer genre, Long editor, String header) {
        this.genre = genre;
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

    public Integer getGenre() {
        return this.genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }
    
    public Long getEditor() {
        return this.editor;
    }

    public void setEditor(Long editor) {
        this.editor = editor;
    }
    
    public String getHeader() {
        return this.header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
}

