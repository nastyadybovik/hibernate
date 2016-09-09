package domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Nastya Dubovik
 */
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @Size(min=1, max=30)
    private String name;

    private Timestamp expired;

    private Set<News> news = new HashSet<News>();

    public Author() {
        this.id = null;
        this.name = null;
        this.expired = null;
    }

    public Author(String name) {
        this.id = null;
        this.name = name;
        this.expired = null;
    }

    public Author(Long id, String name) {
        this.id = id;
        this.name = name;
        this.expired = new Timestamp(System.currentTimeMillis());
    }

    public Author(String name, Timestamp expired) {
        this.name = name;
        this.expired = expired;
    }

    public Author(Long id, String name, Timestamp expired) {
        this.id = id;
        this.name = name;
        this.expired = expired;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getExpired() {
        return expired;
    }

    public void setExpired(Timestamp expired) {
        this.expired = expired;
    }

    public void setExpired() {
        this.expired = new Timestamp(System.currentTimeMillis());
    }

    public void returnToWork(){
        this.expired = null;
    }

    public Set<News> getNews() {
        return news;
    }

    public void setNews(Set<News> news) {
        this.news = news;
    }

    /**
     * Compare this object with object that are sent
     * @param obj
     * @return true if this object equals to obj, false if this object doesn't equal to obj
     */
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(obj == null){
            return false;
        }
        if(this.getClass() != obj.getClass()){
            return false;
        }
        Author o = (Author) obj;
        if(! this.name.equals(o.name)){
            return false;
        }
        if(( this.expired != null && o.expired == null) || (this.expired == null && o.expired != null)){
            return false;
        }
        if(this.expired != null && o.expired != null) {
            if (!this.expired.equals(o.expired)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Create a string that contains all information about the object
     * @return string with full information
     */
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(": id = " + id);
        sb.append(", name = " + name);
        sb.append(", expired = " + expired);
        return sb.toString();
    }

    /**
     * Depending on main fields creat a hash code
     * @return hash code
     */
    @Override
    public int hashCode(){

        int hash = name.hashCode()*31 + ((expired != null)?(expired.hashCode()*31):0);
        return hash;
    }
}