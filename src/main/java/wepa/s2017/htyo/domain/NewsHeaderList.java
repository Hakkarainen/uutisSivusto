
package wepa.s2017.htyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author THyyppä
 */
@Entity
//@NamedNativeQuery(name = "findNewsInOrder", 
//        query = "SELECT * FROM NewsHeaderList ORDER BY latest DESC", 
//        resultClass = NewsHeaderList.class)

@Table(name = "NewsHeaderList")
public class NewsHeaderList extends AbstractPersistable<Long> {

    @Column(name = "genre")
    private int genre;
    @Column(name = "header")
    private String header;
    @Column(name = "amount")
    private int amount;
    @Column(name = "latest")
    private String latest;
    
    public NewsHeaderList() {
    }
    
    public NewsHeaderList(int genre, String header, int amount, String latest) {
        this.genre = genre;
        this.header = header;
        this.amount = amount;
        this.latest = latest;
    }
    
    public String getHeader() {
        return this.getHeader();
    }

    public int getAmount() {
        
        return this.amount;
    }    

    public int getPieceOfNewsGenre() {    
        return this.genre;
    }
    
    public String getLatest() {
        
        return this.latest;
    }
}
