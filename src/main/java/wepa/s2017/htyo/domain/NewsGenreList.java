package wepa.s2017.htyo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.AbstractPersistable;

/**
 *
 * @author THyyppä
 */
@Entity
//@NamedNativeQuery(name = "newsPerGenre", 
//        query = "SELECT * FROM NewsGenreList ORDER BY latest DESC", 
//        resultClass = NewsGenreList.class)

@Table(name = "NewsGenreList")
public class NewsGenreList extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "header")
    private String header;
    @Column(name = "amount")
    private int amount;
    @Column(name = "latest")
    private String latest;

    public NewsGenreList() {
    }

    public NewsGenreList(String header, int amount, String latest) {
        this.header = header;
        this.amount = amount;
        this.latest = latest;
    }

    public String getHeader() {
        return this.header;
    }

    public int getAmount() {

        return this.amount;
    }

    public String getLatest() {

        return this.latest;
    }
}
