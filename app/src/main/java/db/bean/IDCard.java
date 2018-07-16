package db.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class IDCard {
    @Id(autoincrement = true)
    private Long id;
    private String cardName;
    @Generated(hash = 1233603903)
    public IDCard(Long id, String cardName) {
        this.id = id;
        this.cardName = cardName;
    }
    @Generated(hash = 1276747893)
    public IDCard() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCardName() {
        return this.cardName;
    }
    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

}
