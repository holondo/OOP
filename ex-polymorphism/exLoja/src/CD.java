public class CD extends Product{
    String author, genre, releaseDate;

    public CD(String name, double price, String barCode, String author, String genre, String releaseDate)
    {
        super(name, price, barCode);
        setAuthor(author);
        setGenre(genre);
        setReleaseDate(releaseDate);
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setReleaseDate(String releaseDate)
    {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre)
    {
        this.genre = genre;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public String getGenre()
    {
        return this.genre;
    }
    
    public String getReleaseDate()
    {
        return this.releaseDate;
    }

    @Override
    public String toString()
    {
        String toReturn = "\nNome: " + this.getName();
        toReturn += "\nCódigo de barras: " + this.getBarCode();
        toReturn += "\nAutor: " + this.getAuthor();
        toReturn += "\nGênero: " + this.getGenre();
        toReturn += "\nLançamento: " + this.getReleaseDate();
        toReturn += "\n\t===\n";
        return toReturn;
    }
}