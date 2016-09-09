import org.hibernate.SessionFactory;

/**
 * Created by Nastassia_Dubovik on 07-Sep-16.
 */
public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    }
}
