package domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Nastya Dubovik
 */
public class News implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotNull
    @Size(min=1, max=30)
    private String title;

    @NotNull
    @Size(min=1, max=100)
    private String shortText;

    @NotNull
    @Size(min=1, max=2000)
    private String fullText;

    private LocalDateTime creationDate;
    private LocalDate modificationDate;

    private Set<Author> authors = new HashSet<Author>();

    public News() {
        this.id = null;
        this.title = new String();
        this.shortText = new String();
        this.fullText = new String();
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDate.now();
    }

    public News(String title, String shortText, String fullText) {
        this.id = null;
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.creationDate = LocalDateTime.now();
        this.modificationDate = LocalDate.now();
    }

    public News(String title, String shortText, String fullText, LocalDateTime creationDate) {
        this.id = null;
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.creationDate = creationDate;
        this.modificationDate = creationDate.toLocalDate();
    }

    public News(String title, String shortText, String fullText, LocalDateTime creationDate, LocalDate modificationDate) {
        this.id = null;
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public News(Long id, String title, String shortText, String fullText, LocalDateTime creationDate, LocalDate modificationDate) {
        this.id = id;
        this.title = title;
        this.shortText = shortText;
        this.fullText = fullText;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortText() {
        return shortText;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public String getFullText() {
        return fullText;
    }

    public void setFullText(String fullText) {
        this.fullText = fullText;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public void setCreationDate(String creationDate) {
        CharSequence chSeq = creationDate.subSequence(0, creationDate.length());
        this.creationDate = LocalDateTime.parse(chSeq);
    }

    public LocalDate getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDate modificationDate) {
        this.modificationDate = modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        CharSequence chSeq = modificationDate.subSequence(0, 10);
        this.modificationDate = LocalDate.parse(chSeq);
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
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
        News o = (News)obj;
        if(! this.title.equals(o.title)){
            return false;
        }
        if(! this.shortText.equals(o.shortText)){
            return false;
        }
        if(! this.fullText.equals(o.fullText)){
            return false;
        }
        if(! this.creationDate.equals(o.creationDate)){
            return false;
        }
        if(! this.modificationDate.equals(o.modificationDate)){
            return false;
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
        sb.append(", title = " + title);
        sb.append(", shortText = " + shortText);
        sb.append(", fullText = " + fullText);
        sb.append(", creationDate = " + creationDate);
        sb.append(", modificationDate = " + modificationDate);
        return sb.toString();
    }

    /**
     * Depending on main fields creat a hash code
     * @return hash code
     */
    @Override
    public int hashCode(){
        int hash = title.hashCode()*31 + shortText.hashCode()*31 + fullText.hashCode()*31 + creationDate.hashCode()*31 + modificationDate.hashCode()*31 ;
        return hash;
    }
}
