public class Land{

    private String holder;

    public void setLand(String input)
    {
        holder = input;
    }

    public String getLand()
    {
        return holder;
    }

    public Land()
    {
        setLand("L");
    }

    public String toString()
    {
        return "L";
    }

    public Land(String input)
    {
        setLand(input);
    }
}
