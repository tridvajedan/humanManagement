import java.util.ArrayList;

public class Human {
    public String name;
    public ArrayList<String> jobs = new ArrayList<>();

    public Human(String name)
    {
        this.name = name;
    }

    public ArrayList<String> getJobs()
    {
        return jobs;
    }

    public void addJob(String job)
    {
        jobs.add(job);
    }
}
