package lab1;

import java.util.ArrayList;
import java.util.List;

//  Клас Date
public class Date {
   private int day;
   private int month;
   private int year;

    public Date() {
        this.day = 1;
        this.year = 2000;
        this.month = 1;
    }

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    // Getter і Setter методи
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

    public void displayDate() {
        System.out.printf("%02d.%02d.%04d%n", day, month, year);
    }

    @Override
    public String toString() {
        return String.format("%02d.%02d.%04d", day, month, year);
    }
}

// Enum MovieGenre
enum MovieGenre {
    COMEDY,
    DRAMA,
    ACTION
}

// Director
class Director {
    private String name;
    private String surname;
    private Date birthdate;

    public Director() {
        this.name = "Unknown";
        this.surname = "Unknown";
        this.birthdate = new Date();
    }

    public Director(String name, String surname, Date birthdate) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    // Getter і Setter методи
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

    public void displayInfo() {
        System.out.println("Director: " + name + " " + surname + ", Birthdate: " + birthdate);
    }

    @Override
    public String toString() {
        return name + " " + surname + " (" + birthdate + ")";
    }
}

// Screening
class Screening {
    private String screeningName;
    private double profit;
    private Date screeningDate;

    public Screening() {
        this.screeningName = "Unknown";
        this.profit = 0.0;
        this.screeningDate = new Date();
    }

    public Screening(String screeningName, double profit, Date screeningDate) {
        this.screeningName = screeningName;
        this.profit = profit;
        this.screeningDate = screeningDate;
    }

    // Getter і Setter методи
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

    public void displayInfo() {
        System.out.println("Screening: " + screeningName + ", Profit: " + profit + ", Date: " + screeningDate);
    }

    @Override
    public String toString() {
        return "Screening: " + screeningName + ", Profit: " + profit + ", Date: " + screeningDate;
    }
}

// Клас Movie
class Movie {
    private String title;
    private MovieGenre genre;
    private Director director;
    private List<Screening> screenings;

    // Конструктор за замовчуванням
    public Movie() {
        this.title = "Untitled";
        this.genre = MovieGenre.DRAMA;
        this.director = new Director();
        this.screenings = new ArrayList<>();
    }

    public Movie(String title, MovieGenre genre, Director director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
        this.screenings = new ArrayList<>();
    }

    // Getter і Setter методи
    public String getTitle() {
        return title; }
    public void setTitle(String title) {
        this.title = title; }

    public MovieGenre getGenre() {
        return genre; }
    public void setGenre(MovieGenre genre) {
        this.genre = genre; }

    public Director getDirector() {
        return director; }
    public void setDirector(Director director) {
        this.director = director; }

    public List<Screening> getScreenings() {
        return screenings; }
    public void setScreenings(List<Screening> screenings) {
        this.screenings = screenings; }

    public void addScreening(Screening screening) {
        screenings.add(screening);
    }

    public void displayFullInfo() {
        System.out.println("=== Movie Info ===");
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Director: " + director);
        System.out.println("Screenings:");
        for (Screening s : screenings) {
            System.out.println("  " + s);
        }
        System.out.println();
    }

    // Метод для короткої інформації (середній прибуток)
    public void displayShortInfo() {
        double avgProfit = screenings.stream().mapToDouble(Screening::getProfit).average().orElse(0);
        System.out.println("Movie: " + title + ", Director: " + director.getName() + " " + director.getSurname()
                + ", Average Profit: " + avgProfit);
    }

    // Метод для скороченої інформації (кількість показів)
    public void displayShortSummary() {
        System.out.println("Movie: " + title + ", Director: " + director.getName() + " " + director.getSurname()
                + ", Number of screenings: " + screenings.size());
    }
}

// Головний клас Main
class Main {
    public static void main(String[] args) {
        // Створюємо режисерів
        Director d1 = new Director("Christopher", "Nolan", new Date(30, 7, 1970));
        Director d2 = new Director("Greta", "Gerwig", new Date(4, 8, 1983));

        Movie m1 = new Movie("Inception", MovieGenre.ACTION, d1);
        Movie m2 = new Movie("Barbie", MovieGenre.COMEDY, d2);

        m1.addScreening(new Screening("IMAX Premiere", 100000.0, new Date(16, 7, 2024)));
        m1.addScreening(new Screening("Local Theater", 45000.0, new Date(20, 7, 2024)));

        m2.addScreening(new Screening("World Premiere", 90000.0, new Date(21, 7, 2023)));
        m2.addScreening(new Screening("Cinema Park", 30000.0, new Date(5, 8, 2023)));
        m2.addScreening(new Screening("Festival", 15000.0, new Date(1, 9, 2023)));

        // Повна інформація
        m1.displayFullInfo();
        m2.displayFullInfo();

        // Середній прибуток
        System.out.println("=== Average Profit ===");
        m1.displayShortInfo();
        m2.displayShortInfo();

        System.out.println("\n=== Summary ===");
        m1.displayShortSummary();
        m2.displayShortSummary();
    }
}

