package wepa.s2017.htyo.domain;

/**
 *
 * @author THyyppä
 */
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "PieceOfNewsContent")
public class PieceOfNewsContent extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "editor")
    private String editor;
    @Column(name = "content")
    private String content;
    @Column(name = "sendTime")
    private Timestamp sendTime;
    
    @ManyToOne
    @JoinColumn(name = "newsHeader")
    private PieceOfNewsHeader newsHeader;
    
    @ManyToOne
    @JoinColumn(name = "user")
    private EditorUser user;
    
    public PieceOfNewsContent() {
        this.editor = "Toimittaja";
        Date date = new Date();
        this.sendTime = new Timestamp(date.getTime());
        this.content = "Uutinen";
    }

    public PieceOfNewsContent(String editor, String content) {
        this.editor = editor;
        Date date = new Date();
        this.sendTime = new Timestamp(date.getTime());
        this.content = content;
    }

    public PieceOfNewsContent(EditorUser user, PieceOfNewsHeader newsHeader, String editor, String content) {
        this.user = user;
        this.editor = editor;
        this.newsHeader = newsHeader;
        Date date = new Date();
        this.sendTime = new Timestamp(date.getTime());
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PieceOfNewsHeader getNewsHeader() {
        return newsHeader;
    }

    public void setNewsHeader(PieceOfNewsHeader newsHeader) {
        this.newsHeader = newsHeader;
    }
    
    public EditorUser getUser() {
        return user;
    }

    public String getEditor() {
        return editor;
    }

    public Timestamp getSendTime() {
        return sendTime;
    }

    public String getContent() {
        return content;
    }
    
}
