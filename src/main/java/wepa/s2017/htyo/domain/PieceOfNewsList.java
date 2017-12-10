package wepa.s2017.htyo.domain;

import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author THyyppä
 */
@Entity
//@NamedNativeQuery(name = "findPieceOfNewsContentsInOrder",
//        query = "SELECT * FROM PieceOfNewsContentList ORDER BY latest DESC",
//        resultClass = PieceOfNewsList.class)

@Table(name = "PieceOfNewsList")
public class PieceOfNewsList extends AbstractPersistable<Long> {

    @Column(name = "editorID")
    private Integer editorID;
    @Column(name = "pieceOfNewsHeader")
    private int pieceOfNewsHeader;
    @Column(name = "editor")
    private String editor;
    @Column(name = "content")
    private String content;
    @Column(name = "sendTime")
    private Timestamp sendTime;

    public void PieceOfNewsContent() {
        //this.msgId = -1;
        this.editorID = -1;
        this.editor = "Toimittaja";
        this.pieceOfNewsHeader = -1;
        Date date = new Date();
        this.sendTime = new Timestamp(date.getTime());
        this.content = "Uutinen";
    }

    public void PieceOfNewsContent(int rowi, String editor, String content) {
        this.editorID = 1;
        this.editor = editor;
        this.pieceOfNewsHeader = 1;
        Date date = new Date();
        this.sendTime = new Timestamp(date.getTime());
        this.content = content;
    }

    public void PieceOfNewsContent(int rowi, int editorID, int pieceOfNewsHeader, String editor, String content, Timestamp sendTime) {
        this.editorID = editorID;
        this.editor = editor;
        this.pieceOfNewsHeader = pieceOfNewsHeader;
        this.sendTime = sendTime;
        this.content = content;
    }

    public int getEditorID() {
        return editorID;
    }

    public int getPieceOfNewsHeader() {
        return pieceOfNewsHeader;
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
