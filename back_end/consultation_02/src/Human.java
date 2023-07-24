/**
 * 7/24/2023
 * cohort23
 *
 * @author Marsel Sidikov (AIT TR)
 */
public class Human {
    private String name;
    private boolean isWork;

    public Human(String name, boolean isWork) {
        this.name = name;
        this.isWork = isWork;
    }

    public String getName() {
        return name;
    }

    public boolean isWork() {
        return isWork;
    }

    public void setWork(boolean work) {
        isWork = work;
    }
}
