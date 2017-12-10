package wepa.s2017.htyo.domain;

/**
 *
 * @author THyyppä
 */
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "PieceOfNewsContent")
public class PieceOfNewsContent extends AbstractPersistable<Long> {

    @Column(name = "editorID")
    private Long editorID;
    @Column(name = "newsHeader")
    private Long newsHeader;
    @Column(name = "editor")
    private String editor;
    @Column(name = "content")
    private String content;
    @Column(name = "sendTime")
    private Timestamp sendTime;

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

    public PieceOfNewsContent(Long editorID, Long newsHeader, String editor, String content, Timestamp sendTime) {
        this.editorID = editorID;
        this.editor = editor;
        this.newsHeader = newsHeader;
        this.sendTime = sendTime;
        this.content = content;
    }

    public Long getEditorID() {
        return editorID;
    }

    public Long getDiscussion() {
        return newsHeader;
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
