package lab2;
import java.util.ArrayList;
import java.util.List;

class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this.day = 1;
        this.month = 1;
        this.year = 2000;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day; }
    public void setDay(int day) {
        this.day = day; }
    public int getMonth() {
        return month; }
    public void setMonth(int month) {
        this.month = month; }
    public int getYear() {
        return year; }
    public void setYear(int year) {
        this.year = year; }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}

enum MovieGenre {
    COMEDY, DRAMA, ACTION
}

class Director {
    private String name;
    private String surname;
    private Date birthdate;

    public Director() {
        this.name = "Unknown";
        this.surname = "Director";
        this.birthdate = new Date();
    }

    public Director(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name; }
    public String getSurname() {
        return surname; }
    public void setSurname(String surname) {
        this.surname = surname; }
    public Date getBirthdate() {
        return birthdate; }
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate; }

    @Override
    public String toString() {
        return "Director: " + name + " " + surname + " (born " + birthdate + ")";
    }
}

class FilmDirector extends Director {
    private int numberOfAwards;
    private String famousMovie;

    public FilmDirector(String name, String surname, Date birthdate, int numberOfAwards, String famousMovie) {
        super(name, surname, birthdate);
        this.numberOfAwards = numberOfAwards;
        this.famousMovie = famousMovie;
    }

    public int getNumberOfAwards() {
        return numberOfAwards; }
    public void setNumberOfAwards(int numberOfAwards) {
        this.numberOfAwards = numberOfAwards; }
    public String getFamousMovie() {
        return famousMovie; }
    public void setFamousMovie(String famousMovie) {
        this.famousMovie = famousMovie; }

    @Override
    public String toString() {
        return super.toString() + ", Awards: " + numberOfAwards + ", Famous Movie: \"" + famousMovie + "\"";
    }
}

class DocumentaryDirector extends Director {
    private int numberOfDocumentaries;
    private String specializationTopic;

    public DocumentaryDirector(String name, String surname, Date birthdate, int numberOfDocumentaries, String specializationTopic) {
        super(name, surname, birthdate);
        this.numberOfDocumentaries = numberOfDocumentaries;
        this.specializationTopic = specializationTopic;
    }

    public int getNumberOfDocumentaries() {
        return numberOfDocumentaries; }
    public void setNumberOfDocumentaries(int numberOfDocumentaries) {
        this.numberOfDocumentaries = numberOfDocumentaries; }
    public String getSpecializationTopic() {
        return specializationTopic; }
    public void setSpecializationTopic(String specializationTopic) {
        this.specializationTopic = specializationTopic; }

    @Override
    public String toString() {
        return super.toString() + ", Documentaries: " + numberOfDocumentaries + ", Topic: \"" + specializationTopic + "\"";
    }
}

class Screening {
    private String screeningName;
    private double profit;
    private Date screeningDate;

    public Screening(String screeningName, double profit, Date screeningDate) {
        this.screeningName = screeningName;
        this.profit = profit;
        this.screeningDate = screeningDate;
    }

    public String getScreeningName() {
        return screeningName; }
    public void setScreeningName(String screeningName) {
        this.screeningName = screeningName; }
    public double getProfit() {
        return profit; }
    public void setProfit(double profit) {
        this.profit = profit; }
    public Date getScreeningDate() {
        return screeningDate; }
    public void setScreeningDate(Date screeningDate) {
        this.screeningDate = screeningDate; }

    @Override
    public String toString() {
        return screeningName + " ($" + profit + ", " + screeningDate + ")";
    }
}

class Movie {
    private String title;
    private MovieGenre genre;
    private Director director;
    private List<Screening> screenings;

    public Movie(String title, MovieGenre genre, Director director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.screenings = new ArrayList<>();
    }

    public void addScreening(Screening s) {
        screenings.add(s); }

    public double getAverageProfit() {
        if (screenings.isEmpty()) return 0;
        double total = 0;
        for (Screening s : screenings) total += s.getProfit();
        return total / screenings.size();
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("🎬 Movie: ").append(title)
                .append("\nGenre: ").append(genre)
                .append("\n").append(director)
                .append("\nScreenings:\n");
        for (Screening s : screenings)
            info.append("  - ").append(s).append("\n");
        info.append(String.format("Average profit: $%.2f", getAverageProfit()));
        return info.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Director d1 = new Director("Greta", "Gerwig", new Date(4, 8, 1983));
        FilmDirector d2 = new FilmDirector("Christopher", "Nolan", new Date(30, 7, 1970), 15, "Inception");
        DocumentaryDirector d3 = new DocumentaryDirector("David", "Attenborough", new Date(8, 5, 1926), 42, "Nature and Wildlife");

        Movie m1 = new Movie("Barbie", MovieGenre.COMEDY, d1);
        Movie m2 = new Movie("Inception", MovieGenre.ACTION, d2);
        Movie m3 = new Movie("Planet Earth", MovieGenre.DRAMA, d3);

        m1.addScreening(new Screening("Premier", 8000, new Date(21, 7, 2023)));
        m1.addScreening(new Screening("Week 2", 6000, new Date(28, 7, 2023)));

        m2.addScreening(new Screening("Opening", 12000, new Date(16, 7, 2010)));
        m2.addScreening(new Screening("Week 2", 10000, new Date(23, 7, 2010)));

        m3.addScreening(new Screening("BBC Broadcast", 15000, new Date(5, 3, 2006)));
        m3.addScreening(new Screening("Re-release", 9000, new Date(10, 4, 2009)));

        System.out.println(m1 + "\n--------------------------------------");
        System.out.println(m2 + "\n--------------------------------------");
        System.out.println(m3 + "\n--------------------------------------");

        System.out.println("\n📊 Порівняння середніх прибутків:");
        System.out.printf("%s: $%.2f%n", m1.toString().split("\n")[0], m1.getAverageProfit());
        System.out.printf("%s: $%.2f%n", m2.toString().split("\n")[0], m2.getAverageProfit());
        System.out.printf("%s: $%.2f%n", m3.toString().split("\n")[0], m3.getAverageProfit());

        Movie maxMovie = m1;
        if (m2.getAverageProfit() > maxMovie.getAverageProfit()) maxMovie = m2;
        if (m3.getAverageProfit() > maxMovie.getAverageProfit()) maxMovie = m3;

        System.out.println("\n🏆 Найприбутковіший фільм: " + maxMovie.toString().split("\n")[0]);
    }
}
