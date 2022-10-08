package kai;

public class Domain {
	private int id;
    private String url;
  
    // Constructor
    public Domain(int id, String url)
    {
        this.id = id;
        this.url = url;
    }
  
    public Integer getId() { return Integer.valueOf(id); }
    public String getURL() { return url; }
}
