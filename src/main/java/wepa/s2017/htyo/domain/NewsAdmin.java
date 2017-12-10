
package wepa.s2017.htyo.domain;

import java.sql.Timestamp;
import org.springframework.data.jpa.domain.AbstractPersistable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author THyyppä
 */
@Entity
@Table(name = "NewsAdmin")
public class NewsAdmin extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "startedBy")
    private Integer startedBy;
    @Column(name = "genre")
    private Integer genre;
    @Column(name = "header")
    private String header;
    @Column(name = "numberOfPieceOfNewsContent")
    private int numberOfPieceOfNewsContents;
    @Column(name = "started")
    private Timestamp started;
    
    public NewsAdmin() {
    }

    public NewsAdmin(Integer startedBy, Integer genre, String header) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContents = 3;
        //this.started = null;
    }    

    public NewsAdmin(Integer startedBy, Integer genre, String header, Integer numberOfPieceOfNewsContents, Timestamp started) {
        this.startedBy = startedBy;
        this.genre = genre;
        this.header = header;
        this.numberOfPieceOfNewsContents = numberOfPieceOfNewsContents;
        this.started = started;
    }

    public Integer getInitiator() {
        return startedBy;
    }

    public void setInitiator(Integer startedBy) {
        this.startedBy = startedBy;
    }

    public Integer getGenre() {
        return genre;
    }

    public void setGenre(Integer genre) {
        this.genre = genre;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }
    
    public int getNumberOfPieceOfNewsContents() {
        return numberOfPieceOfNewsContents;
    }

    public void setNumberOfPieceOfNewsContents(Integer numberOfPieceOfNewsContents) {
        this.numberOfPieceOfNewsContents = numberOfPieceOfNewsContents;
    }
}
